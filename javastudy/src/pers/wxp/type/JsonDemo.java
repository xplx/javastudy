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
 * @date 2017��9��5�� ����4:29:31
 * @Description: TODO(���ڲ���json�ַ�������������ת��)
 */
public class JsonDemo {

	/**
	 * @Description: TODO(JSON�������������ת��)
	 * @param:
	 * @return void
	 * @exception:org.apache.commons.lang.exception. NestableRuntimeException,
	 *                                                   �������������صİ�ȫ��
	 *    1��JSONObject
	 * 
	 *   json���󣬾���һ�����Ӧһ��ֵ��
	 *   ʹ�õ��Ǵ�����{
	 *    }���磺{key:value}
	 * 
	 *                                                   2��JSONArray
	 *                                                   json���飬ʹ��������[
	 *                                                   ],ֻ���������������Ҳ��json��ֵ�Ը�ʽ��
	 * 
	 *                                                   Json��������ӵ��Ǽ�ֵ�ԣ�
	 *                                                   JSONArray����ӵ���Json����
	 */
	@Test
	public void jsonTrans() {
		/*
		 * // json-lib-2.4-jdk15.jar // commons-beanutils-1.8.0.jar //
		 * ezmorph-1.0.6.jar // commons-lang-2.4.jar // commons-logging-1.1.jar
		 * // commons-collections-3.1.jar������Щ���Ǳ������ġ�
		 */
		// �ַ�תjson���
		String json = "{\"2\":\"efg\",\"1\":\"abc\"}";
		JSONObject json_test = JSONObject.fromObject(json);
		System.out.println("json_test:" + json_test);

		// jsonת�ַ�
		String json1 = json_test.toString();
		System.out.println(json1);

		// ʹ��list����json(listֻ��ʹ��JSONArray)
		List<String> list = new ArrayList<String>();
		list.add("username");
		list.add("age");
		list.add("sex");
		JSONArray array = new JSONArray();
		array.add(list);
		System.out.println(array);

		// ��ʼ��HashMap���ϲ��������(json���������int����)
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "abc");
		map.put("2", "efg");
		JSONArray array_test = new JSONArray();
		array_test.add(map);
		for (int i = 0; i < array_test.size(); i++) {
			// ��ȡjson����
			JSONObject jsonObject = array_test.getJSONObject(i);
			System.out.println(jsonObject);
		}
		System.out.println("array_test:" + array_test);

		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("jsonObject:" + jsonObject);

		// ����json
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
