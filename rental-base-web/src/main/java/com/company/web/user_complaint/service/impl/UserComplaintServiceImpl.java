package com.company.web.user_complaint.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.web.user_complaint.dao.UserComplaintDao;
import com.company.web.user_complaint.pojo.UserComplaint;
import com.company.web.user_complaint.service.UserComplaintService;
import org.springframework.stereotype.Service;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName UserComplaintServiceImpl
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月04日 04:54:54
 */

@Service
public class UserComplaintServiceImpl extends ServiceImpl<UserComplaintDao,UserComplaint> implements UserComplaintService {
}
