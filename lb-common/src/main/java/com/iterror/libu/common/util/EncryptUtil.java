package com.iterror.libu.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iterror.libu.common.util.constants.CommonConstants;
import com.iterror.libu.common.util.constants.SystemConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class EncryptUtil {
    private static Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static JSONObject getParamJson(String content, boolean checkTime) {
        try {
            if (StringUtils.isBlank(content)) {
                return null;
            }
            JSONObject jsonObj = null;
            try {
                jsonObj = JSONObject.parseObject(content);
                if (jsonObj == null) {
                    return null;
                }
            } catch (Exception ex) {
                return null;
            }
            jsonObj.put("encrypt_rc", CommonConstants.RETURN_RESULT_SUCCESS);
            String paramValue = jsonObj.getString("param");
            if (StringUtils.isBlank(paramValue)) {
                return jsonObj;
            }
            String data = DesUtil.decode(paramValue);
            if (StringUtils.isBlank(data)) {
                jsonObj.put("encrypt_rc", CommonConstants.CODE_SYSTEM_NOSIGN_ERROR);
                return jsonObj;
            }
            JSONObject dataJson = JSONObject.parseObject(data);
            dataJson.put("is_encrypt", true);
            long t = dataJson.getLongValue("t");
            String sign = dataJson.getString("sign");

            if (StringUtils.isBlank(sign)) {
                dataJson.put("encrypt_rc", CommonConstants.CODE_SYSTEM_NOSIGN_ERROR);
                return dataJson;
            }

            // 请求在五分钟以外的不处理
            long nowTime = System.currentTimeMillis();
            long lefTime = nowTime - t;
            boolean check = checkTime && (lefTime > 300000 || lefTime < -300000);
            if (check) {
                dataJson.put("encrypt_rc", CommonConstants.CODE_SYSTEM_TIME_ERROR);
                return dataJson;
            }

            SortedMap<String, Object> packageParams = new TreeMap<String, Object>();

            for (String key : dataJson.keySet()) {
                Object obj = dataJson.get(key);
                if (obj instanceof JSONObject || obj instanceof JSONArray) {
                    continue;
                }
                if (null == obj || "sign".equals(key) || "is_encrypt".equals(key) || "encrypt_rc".equals(key)) {
                    continue;
                }
                packageParams.put(key, obj);
            }
            String newsign = createSign(packageParams, SystemConstants.APP_MD5_KEY);
            if (!newsign.equals(sign)) { // 验证不通过
                dataJson.put("encrypt_rc", CommonConstants.CODE_SYSTEM_SIGN_ERROR);
                return dataJson;
            }
            dataJson.put("encrypt_rc", CommonConstants.RETURN_RESULT_SUCCESS);
            return dataJson;
        } catch (Exception ex) {
            logger.error("EncryptUtil getParamJson", ex);
        }
        return null;
    }

    private static String createSign(SortedMap<String, Object> packageParams, String secret_key) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        sb.append("secret_key=" + secret_key);
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (v instanceof Boolean) {
                sb.append(k + "=" + ((boolean) v ? 1 : 0));
            } else {
                sb.append(k + "=" + v);
            }
        }
        sb.append("secret_key=" + secret_key);
        return MD5.md5Digest(sb.toString());
    }
    
    public static void main(String[] args) {
        //String data = "clcsWKVU1m6MOXJwegajYoGRUAjF6DhTThtA91l3YvFrc6gCxO4bqUnspmBY\\r\\nglxHqypi1GMMnjzr5BvhkbWj5IhF49huIl\\/rCFglFVV\\/38NXqFGzs8AFXaHP\\r\\nS60h8AZye8Nd4cHoF22rUGVKFMwdoc2XwFMZXrNUrgCiuaijg813RIe3D1Gm\\r\\njzyeqjv3A35KSRrz9i7+TvN\\/KGXVM7RBywHdnng5pe+cQ+ZTyvRuFUv+Csz7\\r\\nJNKZy8RP2DzAT8FytNerF63t7A7YTUN2f1JjNG6aDwCY++0538eSGQpQDQC5\\r\\nNCfG4fHUsI1Vur7eNZPX0lsfKlBfCk3hxsVFVf0xCPgDieHZ0IcCxXg1oP\\/m\\r\\nKIAprN66gFM14JvYH6RJjcahNFszYZbfEA\\/WiN+1JeJ8KMD+x+wNiTQnNOyH\\r\\nkAIMVyMD\\/+nB777lKBc1V7lbaQWud7NCvHMF8hg=";
        //String strs = DesUtil.decode(data);
        //System.out.println(strs);
        String jsonStr = "{\"version\":{\"pv\":\"0.0.4\",\"cv\":\"2.5.6\",\"ct\":2,\"channel\":\"ABC\"},\"did\":\"865224039200167_F4:B7:B3:7C:EB:D4_1508225904214\",\"ct\":2,\"act\":\"18956001530\",\"type\":0,\"pwd\":\"323b1c4a3ea721b2d640fc8700db0f56\",\"auto\":false,\"ctime\":1508226114267,\"encrypted_key\":\"b7b08c951d81973356d745472b1bdbf2\",\"t\":1508226114268,\"sign\":\"17f0204649f3fdb4e0496afc5f081adf\"}";
        System.out.println(jsonStr);
        String str = DesUtil.encode(jsonStr);
        System.out.println(str);
        str = DesUtil.decode(str);
        System.out.println(str);
    }
}
