package pers.wxp.arrays;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2017年6月15日 下午3:10:22
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @version 1.0
 * @parameter
 */
public class ArraysDemo {

	@Test
	public void ArraysDemo1() {
		int array1[] = { 1, 5, 3 };
		int array2[] = { 1, 2, 3 };
		System.out.println(Arrays.equals(array1, array2));// 判断数组
		//Arrays.fill(array1, 3);// 填充数组
		System.out.println(Arrays.toString(array1));
		Arrays.sort(array1);// 排序
		System.out.print(Arrays.toString(array1));

	}
}
