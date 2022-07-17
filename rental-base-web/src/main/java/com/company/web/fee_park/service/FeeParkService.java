package com.company.web.fee_park.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.web.fee_park.pojo.FeePark;
import com.company.web.fee_park.pojo.FeeParkParm;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName FeeParkService
 * @company 公司
 * @Description 车位管理服务层
 * @createTime 2022年07月01日 05:07:07
 */
public interface FeeParkService extends IService<FeePark> {
    /**
     *  列表查询
      * @param feeParkParm
     * @return
     */
   IPage<FeePark> getList(FeeParkParm feeParkParm);
}
