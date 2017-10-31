package com.iterror.libu.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RequestUtil {

    private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    public static String getContent(HttpServletRequest request) {
        StringBuffer buffer = new StringBuffer();
        InputStream is = null;
        try {
            is = request.getInputStream();
            String content = "";
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((content = reader.readLine()) != null) {
                    buffer.append(content);
                }
            }
        } catch (IOException e) {

        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    // do noting
                }
            }
        }

        String jsonData = (String) request.getAttribute("json_data");
        if (StringUtils.isNotBlank(jsonData)) {
            return jsonData;
        }
        return buffer.toString();
    }

    public static JSONObject getJSONContent(HttpServletRequest request) {
        String content = getContent(request);
        JSONObject json = new JSONObject();
        if (StringUtils.isNotBlank(content)) {
            try {
                json = JSONObject.parseObject(content);
            } catch (Exception e) {
                logger.error("parse json error:", e);
            }

        }
        return json;
    }
}
