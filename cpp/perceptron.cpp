#include "perceptron.h"

Perceptron::Perceptron(int input_number, double activation_threshold)
{
	this->input_number = input_number;
	this->activation_threshold = activation_threshold;

	vector<double> temp(input_number, 0.0);
	this->weight_array = temp;

	this->bias = 1.0;
	this->bias_weight = 0.0;
}


int Perceptron::get_input_number()
{
	return this->input_number;
}


double Perceptron::get_activation_threshold()
{
	return this->activation_threshold;
}


vector<double> Perceptron::get_weight_array()
{
	return this->weight_array;
}


int Perceptron::run(vector<double> input_array)
{
	// input check
	if (input_array.size() != this->input_number) { return -1; }

	double sum = this->bias + this->bias_weight;
	for (unsigned int i = 0; i < input_array.size(); i++)
	{
		sum += (input_array[i] * this->weight_array[i]);
	}

	return activation_function(sum);
}


void Perceptron::train(vector<double> input_array, int expected_output)
{
	int output = run(input_array);

	if (expected_output != output)
	{
		this->bias_weight = this->bias_weight + ((expected_output - output) * this->bias);
		
		for (unsigned int i = 0; i < input_array.size(); i++)
		{
			this->weight_array[i] += ((expected_output - output) * input_array[i]);
		}
	}
}

int Perceptron::activation_function(double value)
{
	if (value <= this->activation_threshold)
	{
		return 0;
	}
	else
	{
		return 1;
	}
}