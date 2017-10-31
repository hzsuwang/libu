package com.iterror.libu.common.bto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * Created by tony.yan on 2017/10/31.
 */
@Data
public class ResultBTO {

    /**
     * 返回的rc
     */
    private int        rc;
    /**
     * 返回的提示文案
     */
    private String     msg;
    /**
     *  
     */
    private JSONObject data;
}
