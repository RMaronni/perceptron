#ifndef PERCEPTRON_H_
#define PERCEPTRON_H_

#include <vector>

using namespace std;

class Perceptron
{
private:

	int input_number;
	vector<double> weight_array;
	double activation_threshold;
	double bias;
	double bias_weight;

	int activation_function(double value);


public:

	Perceptron(int input_number, double activation_threshold);

	int get_input_number();
	double get_activation_threshold();
	vector<double> get_weight_array();

	int run(vector<double> input_array);
	void train(vector<double> input_array, int expected_output);
	

};

#endif