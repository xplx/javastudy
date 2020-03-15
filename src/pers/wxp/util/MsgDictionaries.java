package pers.wxp.util;

import java.util.HashMap;

/**
 * Class description
 * 返回码定义类
 *
 * @version        1.0, 17/07/05
 * @author         zhaohaichao
 */
public class MsgDictionaries {

    /** 返回的数据集合 */
    public static HashMap<String, String> msg = new HashMap<String, String>();

    /** 正常 */
    public static final String MSG_200 = "200";

    /** controller层提示 */
    /** 请填写电话号码名 */
    public static final String MSG_6001 = "6001";
    /** 验证码类型为空 */
    public static final String MSG_6002 = "6002";
    /** 请填写正确的电话号码 */
    public static final String MSG_6003 = "6003";
    /** 验证码类型错误 */
    public static final String MSG_6004 = "6004";
    /** 请输入验证码 */
    public static final String MSG_6005 = "6005";
    /** 请输入密码 */
    public static final String MSG_6006 = "6006";
    /** 请确保密码包含字母、数字且长度大于8位、不超过16位 */
    public static final String MSG_6007 = "6007";
    /** 请输入姓名 */
    public static final String MSG_6008 = "6008";
    /** 请输入身份证号 */
    public static final String MSG_6009 = "6009";
    /** 请确认身份证号输入是否有误 */
    public static final String MSG_6010 = "6010";
    /** 用户id为空 */
    public static final String MSG_6011 = "6011";
    /** 请选择城市 */
    public static final String MSG_6012 = "6012";
    /** 卡id为空 */
    public static final String MSG_6013 = "6013";
    /** 是否分页为空 */
    public static final String MSG_6014 = "6014";
    /** 显示页为空 */
    public static final String MSG_6015 = "6015";
    /** 显示条数为空 */
    public static final String MSG_6016 = "6016";
    /** 请选择支付类型 */
    public static final String MSG_6017 = "6017";
    /** 请选择或输入充值金额 */
    public static final String MSG_6018 = "6018";
    /** 订单来源为空 */
    public static final String MSG_6019 = "6019";
    /** 版本号为空 */
    public static final String MSG_6020 = "6020";
    /** 版本类型为空 */
    public static final String MSG_6021 = "6021";
    /** 订单号为空 */
    public static final String MSG_6022 = "6022";
    /** 卡已欠费，请充值后再退卡 */
    public static final String MSG_3002 = "3002";

    /** service层提示 */
    /** 用户已存在 */
    public static final String MSG_8001 = "8001";
    /** 用户不存在 */
    public static final String MSG_8002 = "8002";
    /** 电话号码或验证码错误 */
    public static final String MSG_8003 = "8003";
    /** 电话号码或密码错 */
    public static final String MSG_8004 = "8004";
    /** 认证初始化失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8005 = "8005";
    /** 认证失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8006 = "8006";
    /** 实名认证唯一标示不一致，请联系官方客服人员 */
    public static final String MSG_8007 = "8007";
    /** 认证查询失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8008 = "8008";
    /** 请先进行实名验证后才可使用本功能 */
    public static final String MSG_8009 = "8009";
    /** 城市id不存在 */
    public static final String MSG_8010 = "8010";
    /** 开卡失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8011 = "8011";
    /** 此用户下没有本卡信息，请联系官方客服人员 */
    public static final String MSG_8012 = "8012";
    /** 获取二维码失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8013 = "8013";
    /** 此卡不存在或已经申请销户，如有疑问请联系官方客服人员 */
    public static final String MSG_8014 = "8014";
    /** 销户失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8015 = "8015";
    /** 消费查询失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8016 = "8016";
    /** 获取卡状态失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8017 = "8017";
    /** 订单生成失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8018 = "8018";
    /** 充值金额必须是10的倍数 */
    public static final String MSG_8019 = "8019";
    /** 充值金额低于最低金额 */
    public static final String MSG_8020 = "8020";
    /** 发送验证码失败 */
    public static final String MSG_8021 = "8021";
    /** 订单号生成失败 */
    public static final String MSG_8022 = "8022";
    /** 无效订单号，请稍后再试或联系官方客服人员 */
    public static final String MSG_8023 = "8023";
    /** 查询支付结果异常，请稍后再试或联系官方客服人员 */
    public static final String MSG_8024 = "8024";
    /** 验证码超时 */
    public static final String MSG_8025 = "8025";
    /** 修改订单状态失败 */
    public static final String MSG_8026 = "8026";
    /** 订单充值失败，请稍后再试或联系官方客服人员 */
    public static final String MSG_8027 = "8027";
    /** 余额不足，请立即充值 */
    public static final String MSG_4988 = "4988";


    /** 数据插入失败 */
    public static final String MSG_8901 = "8901";
    /** 数据删除失败 */
    public static final String MSG_8902 = "8902";
    /** 数据更新失败 */
    public static final String MSG_8903 = "8903";
    /** 数据为空 */
    public static final String MSG_8904 = "8904";

    /** 缺少请求参数 */
    public static final String MSG_9001 = "9001";
	/** 请求参数异常 */
    public static final String MSG_9002 = "9002";
	/** 请求超时 */
    public static final String MSG_9003 = "9003";
    /** 请求重复 */
//    public static final String MSG_9004 = "9004";
    /** 登录状态失效，请重新登录 */
    public static final String MSG_9004 = "9004";
    /** 系统异常，请稍后再试或联系官方客服人员 */
    public static final String MSG_9009 = "9009";

    static {

        // 正常
        msg.put("200", "请求成功");

        // controller层提示
        msg.put("6001", "请输入电话号码");
        msg.put("6002", "验证码类型为空");
        msg.put("6003", "请填写正确的电话号码");
        msg.put("6004", "验证码类型错误");
        msg.put("6005", "请输入验证码");
        msg.put("6006", "请输入密码");
        msg.put("6007", "请确保密码包含字母、数字且长度大于8位、不超过16位");
        msg.put("6008", "请输入姓名");
        msg.put("6009", "请输入身份证号");
        msg.put("6010", "请确认身份证号输入是否有误");
        msg.put("6011", "用户id为空");
        msg.put("6012", "请选择城市");
        msg.put("6013", "卡id为空");
        msg.put("6014", "是否分页为空");
        msg.put("6015", "显示页为空");
        msg.put("6016", "显示条数为空");
        msg.put("6017", "请选择支付类型");
        msg.put("6018", "请选择或输入充值金额");
        msg.put("6019", "订单来源为空");
        msg.put("6020", "版本号为空");
        msg.put("6021", "版本类型为空");
        msg.put("6022", "订单号为空");
        msg.put("3002", "卡已欠费，请充值后再退卡");
        // service层提示
        msg.put("8001", "用户已存在");
        msg.put("8002", "用户不存在");
        msg.put("8003", "电话号码或验证码错误");
        msg.put("8004", "电话号码或密码错误");
        msg.put("8005", "认证初始化失败，请稍后再试或联系官方客服人员");
        msg.put("8006", "认证失败，请稍后再试或联系官方客服人员");
        msg.put("8007", "实名认证唯一标示不一致，请联系官方客服人员");
        msg.put("8008", "认证查询失败，请稍后再试或联系官方客服人员");
        msg.put("8009", "请先进行实名验证后才可使用本功能");
        msg.put("8010", "城市id不存在");
        msg.put("8011", "开卡失败，请稍后再试或联系官方客服人员");
        msg.put("8012", "此用户下没有本卡信息，请联系官方客服人员");
        msg.put("8013", "获取二维码失败，请稍后再试或联系官方客服人员");
        msg.put("8014", "此卡不存在或已经申请销户，如有疑问请联系官方客服人员");
        msg.put("8015", "销户失败，请稍后再试或联系官方客服人员");
        msg.put("8016", "消费查询失败，请稍后再试或联系官方客服人员");
        msg.put("8017", "获取卡状态失败，请稍后再试或联系官方客服人员");
        msg.put("8018", "订单生成失败，请稍后再试或联系官方客服人员");

        msg.put("8019", "订单生成失败，充值金额必须是10的倍数");
        msg.put("8020", "订单生成失败，充值金额低于最小金额");
        msg.put("8021", "发送验证码失败");
        msg.put("8022", "订单号生成失败");
        msg.put("8023", "无效订单号，请稍后再试或联系官方客服人员");
        msg.put("8024", "查询支付结果异常，请稍后再试或联系官方客服人员");
        msg.put("8025", "验证码超时，请重新获取验证码");
        msg.put("8026", "修改订单状态失败");
        msg.put("8027", "订单充值失败，请稍后再试或联系官方客服人员");
        msg.put("4988", "余额不足，请立即充值");

        msg.put("8901", "数据插入失败");
        msg.put("8902", "数据删除失败");
        msg.put("8903", "数据更新失败");
        msg.put("8904", "数据为空");

        // 异常
        msg.put("9001", "缺少请求参数");
        msg.put("9002", "请求参数异常");
        msg.put("9003", "请求超时");
//        msg.put("9004", "请求重复");
        msg.put("9004", "登录状态失效，请重新登录");
        msg.put("9009", "系统异常，请稍后再试或联系官方客服人员");

    }
}
