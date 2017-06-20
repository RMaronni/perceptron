class Perceptron


	def initialize(input_number, activation_threshold)
		@input_number = input_number
		@weight_array = Array.new(input_number, 0)
		@activation_threshold = activation_threshold

		@bias = 1
		@bias_weight = 0
	end


	def get_input_number
		return @input_number
	end


	def get_activation_threshold
		return @activation_threshold
	end


	def get_weight_array
		return @weight_array
	end


	def run(input_array)

		# input check
		if input_array.length != @input_number then return "error" end

		sum = @bias * @bias_weight
		for i in 0..input_array.length-1
			sum = sum + (input_array[i] * @weight_array[i])
		end

		return activation_function(sum)
	end	


	def train(input_array, expected_output)

		output = run(input_array)

		if expected_output != output
			@bias_weight = @bias_weight + ((expected_output - output) * @bias)

			for i in 0..input_array.length-1
				@weight_array[i] = @weight_array[i] + ((expected_output - output) * input_array[i])
			end
		end
	end			


	def activation_function(value)
		return value <= @activation_threshold ? 0 : 1
	end		

end
