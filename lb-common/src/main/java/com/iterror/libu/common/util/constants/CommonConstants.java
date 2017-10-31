package com.iterror.libu.common.util.constants;

/**
 * Created by tony.yan on 2017/10/31.
 */
public class CommonConstants {

    /**
     * 返回值 成功：1
     */
    public static final int    RETURN_RESULT_SUCCESS     = 1;
    public static final String RETURN_RESULT_SUCCESS_MSG = "success";

    /**
     * 返回值 失败：-999
     */
    public static final int    RETURN_RESULT_FAILE       = -999;
    public static final String RETURN_RESULT_FAILE_MSG   = "请求参数有误,请重试！";

    public static final int    CODE_SYSTEM_NOSIGN_ERROR  = -100;
    public static final int    CODE_SYSTEM_TIME_ERROR    = -101;
    public static final int    CODE_SYSTEM_SIGN_ERROR    = -102;

    /**
     * 默认返回的pageSize
     */
    public static final int    DEFAULT_PAGE_SIZE         = 20;

    /**
     * 公共正确，成功状态
     */
    public static final int    COMMON_STATUS_OK          = 1;
}
