package pers.wxp.util;

import java.util.Map;

/**
 * Class description
 *    消息工具类
 *
 * @version        1.0, 17/07/03
 * @author         zhaohaichao
 */
public class MsgUtil {

    /**
     * Method description
     *  返回错误信息
     *
     * @param map 返回map
     * @param msgId 错误id
     *
     * @return
     */
    public static Map<String, Object> returnError(Map<String, Object> map, String msgId) {
        map.put(Constants.WEB_STATE, msgId);
        map.put(Constants.WEB_MSG, MsgDictionaries.msg.get(msgId));

        return map;
    }

    /**
     * Method description
     *  返回成功信息
     *
     * @param map 返回map
     *
     * @return
     */
    public static Map<String, Object> returnSuccess(Map<String, Object> map) {
        map.put(Constants.WEB_STATE, MsgDictionaries.MSG_200);
        map.put(Constants.WEB_MSG, MsgDictionaries.msg.get(MsgDictionaries.MSG_200));

        return map;
    }

    /**
     * Method description
     *  返回微信服务器返回的可变错误信息
     *  状态码9002
     * @param map 返回map
     * @param errorMsg 错误信息
     *
     * @return
     */
    public static Map<String, Object> returnWacherError(Map<String, Object> map, String errorMsg) {
        map.put(Constants.WEB_STATE, MsgDictionaries.MSG_9002);
        map.put(Constants.WEB_MSG, errorMsg);
        return map;
    }
}
