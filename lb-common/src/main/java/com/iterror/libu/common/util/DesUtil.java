package com.iterror.libu.common.util;

import com.iterror.libu.common.util.constants.SystemConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class DesUtil {

    private static final Logger logger        = LoggerFactory.getLogger("DesUtil");
    private static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static String        iv            = "it@_2017";                        // 向量

    public static String getIv() {
        return iv;
    }

    /**
     * DES算法，加密
     * 
     * @param data 待加密字符串
     */
    public static String encode(String data) {
        if (data == null) {
            data = "";
        }
        return encode(data.getBytes());
    }

    /**
     * DES算法，加密
     * 
     * @param data 待加密字符串
     */
    public static String encode(byte[] data) {
        if (data == null || data.length == 0) {
            return "";
        }
        String result = null;
        try {
            DESKeySpec dks = new DESKeySpec(SystemConstants.APP_MD5_KEY.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(getIv().getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data);
            return Base64.encode(bytes);
        } catch (Exception e) {
            logger.error("加密失败:", e);
        }
        return result;
    }

    /**
     * DES算法，解密
     * 
     * @param data 待解密字符串
     */
    public static String decode(String data) {
        if (StringUtils.isBlank(data)) {
            return "";
        }
        byte[] result = null;
        try {
            result = Base64.decode(data);
            DESKeySpec dks = new DESKeySpec(SystemConstants.APP_MD5_KEY.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(getIv().getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            result = cipher.doFinal(result);
            return new String(result);
        } catch (Exception e) {
            logger.error("加密失败:", e);
        }
        return "";
    }
}
