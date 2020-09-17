package operator.calculator;

public class Operation {
	
	int number1 , number2;

	public Operation(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}
	public int Hi() {		
		return number1;
	}

	public int plus() {		
		return number1 + number2;
	}

	public int minus() {		
		return number1 - number2;
	}

	public int product() {		
		return number1 * number2;
	}

	public int devide() {		
		return number1 / number2;
	}
	
}
