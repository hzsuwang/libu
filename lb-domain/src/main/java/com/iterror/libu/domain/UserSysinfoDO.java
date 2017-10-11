package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
public class UserSysinfoDO extends BaseDO {

    private Long    userId;     // 用户Id
    private String  clientVer;  // 客户端版本号
    private Integer clientType; // 客户端类型:1 iOS 2 Android 3 WinPhone
    private String  apnsToken;  // token值
    private String  ip;         // ip
    private String  channel;    // 渠道
    private String  imei;       // 当前手机设备号
    private String  regImei;    // 注册时的设备号
    private String  idfa;       // ios独有的
    private Integer apnsStatus; // apns开关 0开，1是关
    private String  os;         // string 否 操作系统版本号
    private String  operator;   // string 是 运营商
    private String  device;     // string 是 设备型号
    private String  screen;     // string 是 屏幕：宽x高
    private String  net;        // string 是 网络类型 wift 2g 3g 4g 5g
    private Double  lat;        // 纬度
    private Double  lng;        // 经度
    private String  province;   // 省
    private String  city;       // 市
    private Date    activeTime; // 活跃时间
    private Integer loginDays;  // 用户连续登陆的天数
}
