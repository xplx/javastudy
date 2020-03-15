package pers.wxp.util;

public class Constants {

    /** 请求参数名_请求参数 */
    public static final String POST_PARM = "parm";
    /** 请求参数名_parm长度 */
    public static final String POST_LENTH = "lenth";
    /** 请求参数名_请求时间 */
    public static final String POST_TIME = "time";
    /** 请求参数名_用户id */
    public static final String POST_USERID = "userId";
    /** 请求参数名_认证标识 */
    public static final String POST_TOKEN = "token";
    /** 请求参数名_imei */
    public static final String POST_IMEI = "imei";
    /** 请求参数名_数字签名 */
    public static final String POST_SIGN = "sign";
    /** 请求固定key值 */
    public static final String POST_KEY = "";

    // 返回参数名
    /** 请求返回参数名_状态值 */
    public static final String WEB_STATE = "state";
    /** 请求返回参数名_状态含义 */
    public static final String WEB_MSG = "msg";
    /** 请求返回参数名_状态含义 */
    public static final String RET_MSG = "msg";


    // MD5加密相关
    /** md5加密key */
    public static final String MD5_KEY = "MD5";
    /** md5加密字符串字符类型 */
    public static final String MD5_TYPE = "utf-8";
    /** md5加密字符串字符类型 */
    public static final int SALT_LENGTH = 12;

    // 3des加密相关
    /** 加密密钥 */
    public final static String DES3_KEY = "busgpstcps";

    /** 字符集 */
    public static final String ENCODING = "UTF-8";

    /** MediaId_首次关注 */
    public static final int MEDIA_ID_TYPE_SUBSCRIBE = 1;

    /*网络请求配置*/
    /**网络协议*/
    public static final String HTTP = "http://";
    /**域名*/
    public static final String DOMAIN_NAME  = "localhost:";
    /**端口号*/
    public static final String PORT  = "8081/";

    /** 验证码状态_正常 **/
    public static final int CORD_STATE_OK = 1;
    /** 验证码状态_失效 **/
    public static final int CORD_STATE_NG = 0;

    // 一级平台接口方法
    /** 操作员签到申请 **/
    public static final String METHOD_0010 = "0010";
    /** 操作员签到确认 **/
    public static final String METHOD_0011 = "0011";
    /** 开卡/二次开卡接口 **/
    public static final String METHOD_7002 = "7002";
    /** 个人消费记录详细查询 **/
    public static final String METHOD_7012 = "7012";
    /** 订单生成 **/
    public static final String METHOD_7021 = "7021";
    /** 订单查询接口  **/
    public static final String METHOD_7022 = "7022";
    /** 获取卡状态 **/
    public static final String METHOD_7006 = "7006";
    /** 获取自有码数据 **/
    public static final String METHOD_7009 = "7009";
    /** 发起销户 **/
    public static final String METHOD_7031 = "7031";
    /** 销户退款进度查询 **/
    public static final String METHOD_7032 = "7032";
    /** 撤销销户申请 **/
    public static final String METHOD_7033 = "7033";
    /** 挂失（预留接口） **/
    public static final String METHOD_7041 = "7041";
    /** 激活 **/
    public static final String METHOD_7042 = "7042";

    /** 一级平台返回状态 **/
    public static final String RET_RESULT = "RESULT";
    /** 一级平台返回正常 **/
    public static final String RET_9000 = "9000";
    /** 一级平台返回余额不足 */
    public static final String RET_4988 = "4988";
    /** 一级平台秘钥加解密key **/
    public static final String RSA_PRODECTED_KEY = "BBAAABBBBBCCCCCDDDDDEEEEEFFFFFEE";

    /** 订单付款状态_未付款 **/
    public static final int ORDER_ISOK_0 = 0;
    /** 订单付款状态_已付款 **/
    public static final int ORDER_ISOK_1 = 1;
    /** 订单付款状态_已完成充值 **/
    public static final int ORDER_ISOK_2 = 2;
    /** 订单付款状态_优惠金额充值失败 **/
    public static final int ORDER_ISOK_3 = 3;
    /** 订单付款状态_退款中 **/
    public static final int ORDER_ISOK_5 = 5;
    /** 订单付款状态_已退款 **/
    public static final int ORDER_ISOK_7 = 7;
    /** 订单付款状态_退款失败 **/
    public static final int ORDER_ISOK_8 = 8;
    /** 订单付款状态_订单取消 **/
    public static final int ORDER_ISOK_9 = 9;
    /** 订单付款状态_已销账 **/
    public static final int ORDER_ISOK_10 = 10;


    /** 订单状态_已圈存 **/
    public static final int ORDER_STATE_1 = 1;
}
