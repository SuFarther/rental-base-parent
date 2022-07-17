package com.company.web.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.annotation.SysLog;
import com.company.config.jwt.JwtUtils;
import com.company.utils.ResultUtils;
import com.company.utils.ResultVo;
import com.company.web.live_user.pojo.LiveUser;
import com.company.web.live_user.service.LiveUserService;
import com.company.web.menu.pojo.MakeMenuTree;
import com.company.web.menu.pojo.Menu;
import com.company.web.menu.pojo.RouterVO;
import com.company.web.menu.service.MenuService;
import com.company.web.user.pojo.*;
import com.company.web.user.service.UserService;
import com.company.web.user_role.pojo.UserRole;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserController
 * @company 公司
 * @Description 员工管理控制器
 * @createTime 2022年01月12日 16:18:18
 */
@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MenuService menuService;

    @Autowired
    private LiveUserService liveUserService;

    /**
     * 重置密码
     */
     @PostMapping("/resetPassword")
     public ResultVo resetPassword(@RequestBody ChangePassword user,HttpServletRequest request) {
         // 获取token
         String token = request.getHeader("token");
         Claims claims = jwtUtils.getClaimsFromToken(token);
         //判断用户类型
         Object userType = claims.get("userType");
         // 0: 业主
         if(userType.equals("0")){
             LiveUser liveUser = liveUserService.getById(user.getUserId());
             // 原来的密码
             String dataOldPassword = liveUser.getPassword();
             boolean encode = passwordEncoder.matches(user.getOldPassword(),dataOldPassword);
             if(!encode){
                 return ResultUtils.error("旧密码错误!");
             }
             LiveUser liveUser1 = new LiveUser();
             liveUser1.setUserId(user.getUserId());
             liveUser1.setPassword(passwordEncoder.encode(user.getNewPassword()));
             boolean b = liveUserService.updateById(liveUser1);
             if(b){
                 return ResultUtils.success("密码修改成功!");
             }
             return ResultUtils.error("密码修改失败!");
         }else{
             User user1 = userService.getById(user.getUserId());
             // 原来的密码
             String dataOldPassword = user1.getPassword();
             // 第一个是没有加密后的密码 第二个是加密后的旧密码
             boolean encode = passwordEncoder.matches(user.getOldPassword(),dataOldPassword);
             if(!encode){
                 return ResultUtils.error("旧密码错误!");
             }
             User user2 = new User();
             user2.setUserId(user.getUserId());
             user2.setPassword(passwordEncoder.encode(user.getNewPassword()));
             boolean b = userService.updateById(user2);
             if(b){
                 return ResultUtils.success("密码修改成功!");
             }
             return ResultUtils.error("密码修改失败!");
         }
     }

    /**
     * 退出登录
     */
     @PostMapping("/loginOut")
     public  ResultVo loginOut(HttpServletRequest request, HttpServletResponse response){
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if(authentication != null) {
             new SecurityContextLogoutHandler().logout(request, response,authentication);
         }
         return ResultUtils.success("退出登录成功!");
     }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ResultVo login(@RequestBody LoginParm parm)
    {
        if(StringUtils.isEmpty(parm.getUsername()) || StringUtils.isEmpty(parm.getPassword()) || StringUtils.isEmpty(parm.getUserType())){
            return ResultUtils.error("用户名、密码或用户类型不能为空!");
        }
        // 加密后的密码
        String encode = passwordEncoder.encode(parm.getPassword());
        // spring security需要的token
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(parm.getUsername()+":"+parm.getUserType(),parm.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        /**
         * 用户信息
         * 0：业主 1: 物主
         */
        if(parm.getUserType().equals("0")){
            LiveUser liveUser = (LiveUser) authenticate.getPrincipal();
            // 生成token返回给前端
            String liveToken = jwtUtils.generateToken(liveUser.getUsername(),parm.getUserType());
            //获取token过期的时间
            Long time = jwtUtils.getExpireTime(liveToken);
            LoginResult result = new LoginResult();
            result.setUserId(liveUser.getUserId());
            result.setToken(liveToken);
            result.setExpireTime(time);
            return ResultUtils.success("登录成功",result);
        }else if(parm.getUserType().equals("1")){
            User user = (User) authenticate.getPrincipal();
            //生成token返回给前端
            String token = jwtUtils.generateToken(user.getUsername(),parm.getUserType());
            //获取token过期的时间
            Long time = jwtUtils.getExpireTime(token);
            LoginResult result = new LoginResult();
            result.setUserId(user.getUserId());
            result.setToken(token);
            result.setExpireTime(time);
            return ResultUtils.success("登录成功",result);
        }else{
            return ResultUtils.error("您选择的用户类型不存在!");
        }
    }


    /**
     * 用户登录
     */

//    @PostMapping("/login")
//    public ResultVo login(@RequestBody LoginParm parm)
//    {
//        if(StringUtils.isEmpty(parm.getUsername()) || StringUtils.isEmpty(parm.getPassword()) || StringUtils.isEmpty(parm.getUserType())){
//            return ResultUtils.error("用户名、密码或用户类型不能为空!");
//        }
//        //加密前端传来的密码
//        String password = DigestUtils.md5DigestAsHex(parm.getPassword().getBytes());
//        //构造查询条件
//        QueryWrapper<User> query = new QueryWrapper<>();
//        query.lambda().eq(User::getLoginName,parm.getUsername())
//                .eq(User::getPassword,password);
//        //现在用户类型 userType还么有使用到
//        User user = userService.getOne(query);
//        //如果没有查到用户
//        if(user == null){
//            return ResultUtils.error("用户名、密码或者用户类型错误!");
//        }
//        //生成token返回给前端
//        String token = jwtUtils.generateToken(user.getUserName());
//        //获取token过期的时间
//        Long time = jwtUtils.getExpireTime(token);
//        LoginResult result = new LoginResult();
//        result.setUserId(user.getUserId());
//        result.setToken(token);
//        result.setExpireTime(time);
//        return ResultUtils.success("登录成功",result);
//    }

    /**
     * 新增员工
     * @param user
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAuthority('sys:user:add')")
    @SysLog(value = "新增员工")
    public ResultVo addUser(@RequestBody User user){
        // 判断登录名 的唯一性
        if(StringUtils.isNotEmpty(user.getUsername())){
            QueryWrapper<User> query = new QueryWrapper<>();
            query.lambda().eq(User::getUsername,user.getUsername());
            User one = userService.getOne(query);
            if(one != null){
                return ResultUtils.error("登录名已经被占用!",500);
            }
        }
        // 如果密码存在, MD5加密
        if(StringUtils.isNotEmpty(user.getPassword())){
//            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        boolean save = userService.save(user);
        if(save){
            return ResultUtils.success("新增员工成功");
        }
        return ResultUtils.error("新增员工失败");
    }

    /**
     * 编辑员工
     * @param user
     * @return
     */
    @PutMapping
    @PreAuthorize("hasAuthority('sys:user:edit')")
    @SysLog(value = "编辑员工")
    public ResultVo editUser(@RequestBody User user){
        // 判断登录名 的唯一性
        if(StringUtils.isNotEmpty(user.getUsername())){
            QueryWrapper<User> query = new QueryWrapper<>();
            query.lambda().eq(User::getUsername,user.getUsername());
            User one = userService.getOne(query);
            if (one != null && one.getUserId() != user.getUserId()) {
                return ResultUtils.error("登录名已经被占用!", 500);
            }
        }
        // 如果密码存在, MD5加密
        if(StringUtils.isNotEmpty(user.getPassword())){
//            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        boolean b = userService.updateById(user);
        if(b){
            return ResultUtils.success("编辑员工成功");
        }
        return ResultUtils.error("编辑员工失败");
    }

    /**
     *
     * 删除员工
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    @SysLog(value = "删除员工")
    public  ResultVo deleteUser(@PathVariable("userId")  Long userId){
        boolean b = userService.removeById(userId);
        if(b){
            return ResultUtils.success("删除员工成功");
        }
        return ResultUtils.error("删除员工失败");
    }

    /**
     * 查询员工列表
     * @param parm
     * @return
     */
     @GetMapping("/list")
     @SysLog(value = "员工列表")
     public ResultVo list(UserParm parm){
         IPage<User> list = userService.list(parm);
         //前端不展示密码
         list.getRecords().stream().forEach(item -> item.setPassword(""));
         return ResultUtils.success("查询成功",list);
     }


    /**
     * 根据用户id
     * 获取用户信息
     */
    @GetMapping("/getInfo")
    public ResultVo getInfo(User user, HttpServletRequest request){
        //从头部获取token，从JWtUtils类中的generateToken方法中知道有个用户类型generateToken
        String token = request.getHeader("token");
        Claims claims = jwtUtils.getClaimsFromToken(token);
        Object userType = claims.get("userType");
        //0:业主 1:物主
        if(userType.equals("0")){
            LiveUser liveUser = liveUserService.getById(user.getUserId());
            UserInfo userInfo = new UserInfo();
            userInfo.setId(liveUser.getUserId());
            userInfo.setName(liveUser.getUsername());
            userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            // 查询业主的权限信息
            List<Menu> menuList = menuService.getMenuByUserIdForLiveUser(liveUser.getUserId());
            List<String> collect = menuList.stream().filter(item -> item != null).map(item -> item.getMenuCode()).filter(item -> item != null).collect(Collectors.toList());
            // 转成数组
            String[] strings = collect.toArray(new String[collect.size()]);
            userInfo.setRoles(strings);
            return ResultUtils.success("获取业主用户信息成功",userInfo);
        }else {
            // 根据用户id查询,区分查的是哪一个
            User user1 = userService.getById(user.getUserId());
            UserInfo userInfo = new UserInfo();
            userInfo.setId(user1.getUserId());
            userInfo.setName(user1.getUsername());
            userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            // 根据用户id查询权限字段
            // 查询用户权限信息
            List<Menu> menuList = menuService.getMenuByUserId(user.getUserId());
            List<String> collect = menuList.stream().filter(item -> item != null).map(item -> item.getMenuCode()).filter(item -> item != null).collect(Collectors.toList());
            // 转成数组
            String[] strings = collect.toArray(new String[collect.size()]);
            userInfo.setRoles(strings);
            return ResultUtils.success("获取物主用户信息成功",userInfo);
        }
    }

    /**
     * 根据用户id查询角色(分配角色)
     */
    @GetMapping("/getRoleByUserId")
    @PreAuthorize("hasAuthority('sys:user:assignRole')")
    public ResultVo getRoleByUserId(UserRole userRole){
        UserRole userRole1 = userService.getRoleByUserId(userRole);
        return ResultUtils.success("查询成功",userRole1);
    }

    /**
     * 保存用户角色
     */
    @PostMapping("/saveRole")
    public ResultVo saveRole(@RequestBody UserRole userRole){
        userService.saveRole(userRole);
        return ResultUtils.success("分配角色成功!");
    }

    /**
     * 获取菜单列表
     * request 获取token
     * @param request
     * @return
     */
    @GetMapping("/getMenuList")
    public ResultVo getMenuList(HttpServletRequest request){
        //从头部获取token
        String token = request.getHeader("token");
        // 获取用户类型
        Claims claims = jwtUtils.getClaimsFromToken(token);
        // 获取用户名
        String username = jwtUtils.getUsernameFromToken(token);
        Object userType = claims.get("userType");
        //0：业主
        if(userType.equals("0")) {
            //查询业主的权限信息
            LiveUser liveUser = liveUserService.loadUser(username);
            // 查询业主的权限信息
            List<Menu> permissionList = menuService.getMenuByUserIdForLiveUser(liveUser.getUserId());
            //只需要获取目录和菜单
            List<Menu> collect = permissionList.stream().filter(item -> item != null && !item.getType().equals("2")).collect(Collectors.toList());
            // 组装路由数据
            List<RouterVO> routerVOList = MakeMenuTree.makeRouter(collect, 0L);
            return ResultUtils.success("获取成功",routerVOList);
        }else{
            User user = userService.loadUser(username);
            List<Menu> permissionList = menuService.getMenuByUserId(user.getUserId());
            //只需要获取目录和菜单
            List<Menu> collect = permissionList.stream().filter(item -> item != null && !item.getType().equals("2")).collect(Collectors.toList());
            List<RouterVO> routerVOList = MakeMenuTree.makeRouter(collect, 0L);
            return ResultUtils.success("获取成功",routerVOList);
        }
    }
}
