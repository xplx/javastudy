package pers.wxp.interview;

/**
 * @author wxp
 * @date 2017年9月14日 下午3:37:54
 * @Description: TODO(可变参数允许调用参数数量不同的方法。请看下面例子中的求和方法。此方法可以调用1个int参数，或2个int参数，
 *               或多个int参数。)
 */
public class VariableArgument {
	// int(type) followed ... (three dot's) is syntax of a variable argument.
	/** 
	* @Description: TODO(使用参数是可变) 
	* @param: @param numbers
	* @param: @return    
	* @return int     
	*/
	public int sum(int... numbers) {
		// inside the method a variable argument is similar to an array.
		// number can be treated as if it is declared as int[] numbers;
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	public static void main(String[] args) {
		VariableArgument example = new VariableArgument();
		// 3 Arguments
		System.out.println(example.sum(1, 4, 5));// 10
		// 4 Arguments
		System.out.println(example.sum(1, 4, 5, 20));// 30
		// 0 Arguments
		System.out.println(example.sum());// 0
	}
}
