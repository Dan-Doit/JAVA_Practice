package operator;

import javax.naming.spi.DirStateFactory.Result;

public class Operator {
	public Operator() {

	}

	public int Judgment(String[] nums) {

		int[] numbers;

		numbers = convertdata(nums);

		int result = 0;

		switch (numbers[1]) {
		case 1:
			result = plus(numbers);
			break;
		case 2:
			result = minus(numbers);
			break;
		case 3:
			result = product(numbers);
			break;
		case 4:
			result = divide(numbers);
			break;

		default:

			break;
		}
		return result;
	}

	private int[] convertdata(String[] values) {
		int[] numbers = new int[3];
		for (int i = 0; i < values.length; i++) {
			numbers[i] = Integer.parseInt(values[i]);
		}
		return numbers;
	}

	private int plus(int[] numbers) {
		return numbers[0] + numbers[2];
	}

	private int minus(int[] numbers) {
		return numbers[0] - numbers[2];
	}

	private int product(int[] numbers) {
		return numbers[0] * numbers[2];
	}

	private int divide(int[] numbers) {
		return numbers[0] / numbers[2];
	}

}
