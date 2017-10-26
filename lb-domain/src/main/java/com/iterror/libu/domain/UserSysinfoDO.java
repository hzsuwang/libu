package com.iterror.libu.domain;

import com.iterror.libu.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
@Table("lb_user_sysinfo")
@Comment("用户设备信息表")
public class UserSysinfoDO extends BaseDO {

    @Column("user_id")
    @Comment("用户Id")
    private Long    userId;     // 用户Id

    @Column("client_ver")
    @Comment("客户端版本号")
    private String  clientVer;  // 客户端版本号

    @Column("client_type")
    @Comment("客户端类型:1 iOS 2 Android 3 WinPhone")
    private Integer clientType; // 客户端类型:1 iOS 2 Android 3 WinPhone

    @Column("apns_token")
    @Comment("token值")
    private String  apnsToken;  // token值

    @Column("ip")
    @Comment("ip")
    private String  ip;         // ip

    @Column("channel")
    @Comment("渠道")
    private String  channel;    // 渠道

    @Column("imei")
    @Comment("当前手机设备号")
    private String  imei;       // 当前手机设备号

    @Column("reg_imei")
    @Comment("注册时的设备号")
    private String  regImei;    // 注册时的设备号

    @Column("idfa")
    @Comment("ios独有的")
    private String  idfa;       // ios独有的

    @Column("apns_status")
    @Comment(" apns开关 0开，1是关")
    private int     apnsStatus; // apns开关 0开，1是关

    @Column("os")
    @Comment("否 操作系统版本号")
    private String  os;         // string 否 操作系统版本号

    @Column("operator")
    @Comment("运营商")
    private String  operator;   // string 是 运营商

    @Column("device")
    @Comment("设备型号")
    private String  device;     // string 是 设备型号

    @Column("screen")
    @Comment("屏幕：宽x高")
    private String  screen;     // string 是 屏幕：宽x高

    @Column("net")
    @Comment("网络类型 wift 2g 3g 4g 5g")
    private String  net;        // string 是 网络类型 wift 2g 3g 4g 5g

    @Column("lat")
    @Comment("纬度")
    private double  lat;        // 纬度

    @Column("lng")
    @Comment("经度")
    private double  lng;        // 经度

    @Column("province")
    @Comment("省")
    private String  province;   // 省

    @Column("city")
    @Comment("市")
    private String  city;       // 市

    @Column("active_time")
    @Comment("活跃时间")
    private Date    activeTime; // 活跃时间

    @Column("login_days")
    @Comment("用户连续登陆的天数")
    private int     loginDays;  // 用户连续登陆的天数

    @Column("login_time")
    @Comment("登录时间")
    private Date    loginTime;  // 登录时间
}
