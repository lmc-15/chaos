package com.dev.core.constant;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * 全局常量
 *
 * @author liaochunshui<liaochunshui @ cecdat.com>
 * @version v0.1
 * @date 2020/6/23 16:40
 * @see
 * @since JDK1.8
 */
public class GlobalConstants {

    private GlobalConstants() {
    }


    public static final String DEFAULT_CHAR = "UTF-8";
    public static final Charset UTF8 = StandardCharsets.UTF_8;

    public static final Integer DEFAULT_CAPACITY = 16;

    public static final String REDIS_DELIMITER = ":";

    /**
     * 日志追踪id
     */
    public static final String TRACE_ID = "traceId";

    /**
     * id
     */
    public static final String ID = "id";

    /**
     * 父id
     */
    public static final String P_ID = "pid";

    /**
     * 成功返回码
     */
    public static final int SUCCESS = 0;
    /**
     * 默认失败返回码 未知错误
     */
    public static final int FAIL = -1;

    /**
     * HTTP相关定义 BEGIN
     */
    public static final String AUTHORIZATION = "Authorization";
    public static final String URL_DELIMITER_CHAR = "&";
    public static final String URL_BEGIN_CHAR = "\\?";
    public static final String URL_EQUAL_CHAR = "=";
    public static final String URL_SPLIT_CHAR = "/";
    /**
     * 字节类型的报文
     */
    public static final String[] BYTE_MIME_TYPE = {"image", "video", "audio"};
    public static final List<String> BYTE_MIME_TYPE_LIST = Arrays.asList(BYTE_MIME_TYPE);
    /**
     * HTTP相关定义 END
     */

    public static final String SUCCESS_MSG = "SUCCESS";
    public static final String FAILED_MSG = "FAILED";

    /**
     * 执行器
     */
    public static final String GLOBAL_EXECUTOR = "globalExecutor";

    /**
     * 汉字字符
     */
    public static final String CHINESE_CHAR = "[\\u4E00-\\u9FA5]";
    /**
     * URL 参数的前缀分隔符
     */
    public static final char URL_PARAMS_PREFIX = '?';
    /**
     * URL 参数分隔符
     */
    public static final String PARAMS_SPLIT = "&";
    /**
     * URL 参数键值分隔符
     */
    public static final String PARAMS_KV_SPLIT = "=";


}
