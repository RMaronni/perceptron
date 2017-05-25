import unittest
from perceptron import Perceptron

class PerceptronTest(unittest.TestCase):

    def setUp(self):
        self.and_network = Perceptron(2, 0.5)
        self.or_network = Perceptron(2, 0.5)


    def test_get_input_number(self):
        self.assertEqual(self.and_network.get_input_number(), 2)
        self.assertEqual(self.or_network.get_input_number(),  2)


    def test_get_activation_threshold(self):
        self.assertEqual(self.and_network.get_activation_threshold(), 0.5)
        self.assertEqual(self.or_network.get_activation_threshold(),  0.5)


    def test_get_weight_array(self):
        self.assertEqual(self.and_network.get_weight_array(), [0, 0])
        self.assertEqual(self.or_network.get_weight_array(),  [0, 0])


    def test_and_network(self):
        for i in range(100):
            self.and_network.train([0, 0], 0)
            self.and_network.train([0, 1], 0)
            self.and_network.train([1, 0], 0)
            self.and_network.train([1, 1], 1)

        self.assertEqual(self.and_network.run([0, 0]), 0)
        self.assertEqual(self.and_network.run([0, 1]), 0)
        self.assertEqual(self.and_network.run([1, 0]), 0)
        self.assertEqual(self.and_network.run([1, 1]), 1)


    def test_or_network(self):
        for i in range(100):
            self.or_network.train([0, 0], 0)
            self.or_network.train([0, 1], 1)
            self.or_network.train([1, 0], 1)
            self.or_network.train([1, 1], 1)

        self.assertEqual(self.or_network.run([0, 0]), 0)
        self.assertEqual(self.or_network.run([0, 1]), 1)
        self.assertEqual(self.or_network.run([1, 0]), 1)
        self.assertEqual(self.or_network.run([1, 1]), 1)



    def tearDown(self):
        pass


if __name__ == '__main__':
    unittest.main()