class Perceptron:

    def __init__(self, input_number, activation_threshold):

        self.input_number = input_number
        self.weight_array = [0] * input_number
        self.activation_threshold = activation_threshold

        self.bias = 1
        self.bias_weight = 0


    def get_input_number(self):
        return self.input_number


    def get_activation_threshold(self):
        return self.activation_threshold


    def get_weight_array(self):
        return self.weight_array


    def run(self, input_array):

        # input check
        if len(input_array) != self.input_number: return "error"

        sum = self.bias * self.bias_weight

        for i in range(len(input_array)):
            sum = sum + (input_array[i] * self.weight_array[i])


        return self.activation_function(sum)


    def train(self, input_array, expected_output):

        output = self.run(input_array)

        if expected_output != output:

            self.bias_weight = self.bias_weight + ((expected_output - output) * self.bias)

            for i in range(len(input_array)):
                self.weight_array[i] = self.weight_array[i] + ((expected_output - output) * input_array[i])



    def activation_function(self, value):

        if value <= self.activation_threshold:
            return 0
        else:
            return 1
