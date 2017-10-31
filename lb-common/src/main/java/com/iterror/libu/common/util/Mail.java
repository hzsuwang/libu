package com.iterror.libu.common.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class Mail implements Serializable {

    private static final long   serialVersionUID = -6390720891150157552L;
    public static final String  ENCODEING        = "UTF-8";

    // 服务器地址
    private String              host;
    // 发件人的邮箱
    private String              sender;
    // 发件人昵称
    private String              name;
    // 账号
    private String              username;
    // 密码
    private String              password;
    // 收件人的邮箱
    private String              receiver;
    // 收件人的名称
    private String              receiverName;

    private Integer             smtpPort;

    // 收件人的邮箱(key)和名称(value)
    private Map<String, String> to;
    // 抄送人的邮箱(key)和名称(value)
    private Map<String, String> cc;
    // 秘密抄送人的邮箱(key)和名称(value)
    private Map<String, String> bcc;
    // 主题
    private String              subject;
    // 信息(支持HTML)
    private String              message;
}
