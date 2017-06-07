import java.util.List;
import java.util.ArrayList;

public class Perceptron {

	private int inputNumber;
	private List<Double> weightArray;
	private double activationThreshold;
	private double bias;
	private double biasWeight;


	public Perceptron(int inputNumber, double activationThreshold) {
		this.inputNumber = inputNumber;
		this.activationThreshold = activationThreshold;
		this.weightArray = new ArrayList<Double>();

		for (int i = 0; i < inputNumber; i++) {
			this.weightArray.add(0.0);
		}

		this.bias = 1;
		this.biasWeight = 0;
	}


	public int getInputNumber() {
		return this.inputNumber;
	}


	public double getActivationThreshold() {
		return this.activationThreshold;
	}


	public List<Double> getWeightArray() {
		return this.weightArray;
	}


	public int run(List<Double> inputArray) {

		// Input check
		if (inputArray.size() != this.inputNumber) { return -1; }

		double sum = this.bias * this.biasWeight;

		for (int i = 0; i < inputArray.size(); i++) {
			sum += inputArray.get(i) * this.weightArray.get(i);
		}

		return activationFunction(sum);
	}


	public void train(List<Double> inputArray, int expectedOutput) {

		int output = run(inputArray);

		if (expectedOutput != output) {
			this.biasWeight += (expectedOutput - output) * this.bias;

			for (int i = 0; i < inputArray.size(); i++) {
				this.weightArray.set(i, this.weightArray.get(i) + ((expectedOutput - output) * inputArray.get(i)));
			}
		}
	}


	private int activationFunction(double value) {
		if (value <= this.activationThreshold) {
			return 0;
		} else {
			return 1;
		}
	}
}
