package test;

public class CalculatorModel {
	private double memory = 0.0;
	public CalculatorModel() {
		
	}

	public double add(double a, double b) {
		return a+b;
	}

	public double subtract(double a, double b) {
		return a-b;
	}

	public double multiply(double a, double b) {
		return a*b;
	}

	public double divide(double a, double b) {
		if(b == 0) throw new ArithmeticException("Error");
		return a/b;
	}

	public double square(double a) {
		return a*a;
	}

	public double sqrt(double a) {
		if (a < 0) throw new ArithmeticException("Negative square root");
        return Math.sqrt(a);
	}
	// Memory functions

    public void addMemory(double value) {
        memory += value;
    }

    public void subtractMemory(double value) {
        memory -= value;
    }

    public double recallMemory() {
        return memory;
    }

    public void clearMemory() {
        memory = 0.0;
    }

}
