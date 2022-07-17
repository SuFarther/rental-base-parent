package com.company.web.user_repair.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.user_repair.dao.UserRepairDao;
import com.company.web.user_repair.pojo.UserRepair;
import com.company.web.user_repair.service.UserRepairService;
import org.springframework.stereotype.Service;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserRepairServiceImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月07日 15:39:39
 */

@Service
public class UserRepairServiceImpl extends ServiceImpl<UserRepairDao, UserRepair>  implements UserRepairService {
}
