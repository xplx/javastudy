package pers.wxp.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author wxp
 * @date 2017年9月5日 下午4:29:31
 * @Description: TODO(用于测试json字符串和其他数据类型转换)
 */
public class JsonDemo {

	/**
	 * @Description: TODO(JSON和其他类型数据转换)
	 * @param:
	 * @return void
	 * @exception:org.apache.commons.lang.exception. NestableRuntimeException,
	 *                                                   出现这个情况加载的包不全。
	 *    1，JSONObject
	 * 
	 *   json对象，就是一个键对应一个值，
	 *   使用的是大括号{
	 *    }，如：{key:value}
	 * 
	 *                                                   2，JSONArray
	 *                                                   json数组，使用中括号[
	 *                                                   ],只不过数组里面的项也是json键值对格式的
	 * 
	 *                                                   Json对象中添加的是键值对，
	 *                                                   JSONArray中添加的是Json对象
	 */
	@Test
	public void jsonTrans() {
		/*
		 * // json-lib-2.4-jdk15.jar // commons-beanutils-1.8.0.jar //
		 * ezmorph-1.0.6.jar // commons-lang-2.4.jar // commons-logging-1.1.jar
		 * // commons-collections-3.1.jar其中这些包是必须加入的。
		 */
		// 字符串转json数据
		String json = "{\"2\":\"efg\",\"1\":\"abc\"}";
		JSONObject json_test = JSONObject.fromObject(json);
		System.out.println("json_test:" + json_test);

		// json转字符串
		String json1 = json_test.toString();
		System.out.println(json1);

		// 使用list构筑json(list只能使用JSONArray)
		List<String> list = new ArrayList<String>();
		list.add("username");
		list.add("age");
		list.add("sex");
		JSONArray array = new JSONArray();
		array.add(list);
		System.out.println(array);

		// 初始化HashMap集合并添加数组(json必须键不能是int类型)
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "abc");
		map.put("2", "efg");
		JSONArray array_test = new JSONArray();
		array_test.add(map);
		for (int i = 0; i < array_test.size(); i++) {
			// 获取json对象
			JSONObject jsonObject = array_test.getJSONObject(i);
			System.out.println(jsonObject);
		}
		System.out.println("array_test:" + array_test);

		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("jsonObject:" + jsonObject);

		// 解析json
		String jons1 = "{\"data\": {\"pages\": [ {\"comment\": \"test1\"},{\"comment\": \"test2\"}],\"total_count\": 2 },\"errcode\": 0}";
		JSONObject string_to_json = JSONObject.fromObject(jons1);
		JSONObject json_to_data1 = string_to_json.getJSONObject("data");
		JSONArray json_to_strings_test = json_to_data1.getJSONArray("pages");
		for (int i = 0; i < json_to_strings_test.size(); i++) {
			JSONObject json_to_string1 = json_to_strings_test.getJSONObject(i);
			System.out.println("json_to_string1.get(\"pages\"):" + json_to_string1.get("comment"));
		}
	}
}
