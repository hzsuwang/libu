package com.iterror.libu.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MailUtil {

    private static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    public static Boolean send(Mail mail) {
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName(mail.getHost());
            // 字符编码集的设置
            email.setCharset(Mail.ENCODEING);
            // 发送人的邮箱
            email.setFrom(mail.getSender(), mail.getName());
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
            email.setAuthentication(mail.getUsername(), mail.getPassword());

            // 设置收件人信息
            setTo(email, mail);
            // 设置抄送人信息
            setCc(email, mail);
            // 设置密送人信息
            setBcc(email, mail);
            // 要发送的邮件主题
            email.setSubject(mail.getSubject());
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setHtmlMsg(mail.getMessage());

            email.setSSLOnConnect(true);

            email.setSmtpPort(465);
            email.setSocketTimeout(120000);
            email.setSocketConnectionTimeout(120000);

            // 发送
            email.send();
            logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver());
            return true;
        } catch (Exception e) {
            logger.error("MailUtil error:", e);
            logger.error(mail.getSender() + " 发送邮件到 " + mail.getReceiver() + " 失败");
            return false;
        }
    }

    /**
     * 设置收件人信息
     * 
     * @param email
     * @param mail
     * @throws EmailException
     */
    private static void setTo(HtmlEmail email, Mail mail) throws EmailException {
        // 收件人不为空
        if (StringUtils.isNotEmpty(mail.getReceiver())) {
            // 收件人名称不为空
            if (StringUtils.isNotEmpty(mail.getReceiverName())) {
                email.addTo(mail.getReceiver(), mail.getReceiverName());
            } else {
                email.addTo(mail.getReceiver());
            }
        }
        // 收件人 Map 不为空
        if (mail.getTo() != null) {
            for (Map.Entry<String, String> entry : mail.getTo().entrySet()) {
                // 收件人名称不为空
                if (StringUtils.isNotEmpty(entry.getValue())) {
                    email.addTo(entry.getKey(), entry.getValue());
                } else {
                    email.addTo(entry.getKey());
                }
            }
        }
    }

    /**
     * 设置抄送人信息
     * 
     * @param email
     * @param mail
     * @throws EmailException
     */
    private static void setCc(HtmlEmail email, Mail mail) throws EmailException {
        // 抄送人 Map 不为空
        if (mail.getCc() != null) {
            for (Map.Entry<String, String> entry : mail.getCc().entrySet()) {
                // 抄送人名称不为空
                if (StringUtils.isNotEmpty(entry.getValue())) {
                    email.addCc(entry.getKey(), entry.getValue());
                } else {
                    email.addCc(entry.getKey());
                }
            }
        }
    }

    /**
     * 设置密送人信息
     * 
     * @param email
     * @param mail
     * @throws EmailException
     */
    private static void setBcc(HtmlEmail email, Mail mail) throws EmailException {
        // 密送人 Map 不为空
        if (mail.getBcc() != null) {
            for (Map.Entry<String, String> entry : mail.getBcc().entrySet()) {
                // 密送人名称不为空
                if (StringUtils.isNotEmpty(entry.getValue())) {
                    email.addBcc(entry.getKey(), entry.getValue());
                } else {
                    email.addBcc(entry.getKey());
                }
            }
        }
    }
}
