package com.company.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName AddressUtils
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月16日 14:07:07
 */
@Slf4j
@Component
public class AddressUtils {

    @Resource
    private RestTemplate restTemplate;
    /**
     * IP地址查询
     */
    public static final String IP_URL = "http://ip.aliyun.com/service/getIpInfo.php";

    /**
     *  未知地址
     */
    public static final String UNKNOWN = "XX XX";

    public  String getRealAddressByIP(String ip)
    {
        String address = "获取地理信息异常";
        try
        {
            String ipurl = IP_URL+"?ip="+ ip;
            ResponseEntity<String> response = restTemplate.getForEntity(ipurl,String.class);
            String body = response.getBody();
            if (response.getStatusCodeValue() != 200)
            {
                log.error("获取地理位置异常 {}");
                return UNKNOWN;
            }
            JSONObject obj = JSONObject.parseObject(body);
            JSONObject cityData = JSONObject.parseObject(obj.getString("data"));
            String country = cityData.getString("country");
            String region = cityData.getString("region");
            String isp = cityData.getString("isp");
            return String.format("%s %s %s",country, region, isp);
        }
        catch (Exception e)
        {
            log.error("获取地理位置异常 {}");
        }
        return address;
    }
}