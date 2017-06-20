#include "gtest/gtest.h"
#include "gmock/gmock.h"
#include "perceptron.h"
 
using namespace testing;

class PerceptronTest : public testing::Test
{
public: 

	Perceptron *and_network;
	Perceptron *or_network;


	virtual void SetUp()
	{
		this->and_network = new Perceptron(2, 0.5);
		this->or_network  = new Perceptron(2, 0.5);
	}

	virtual void TearDown()
	{
	}
};



TEST_F(PerceptronTest, InputNumber) {
	ASSERT_EQ(2, and_network->get_input_number());
	ASSERT_EQ(2, or_network->get_input_number());
}


TEST_F(PerceptronTest, ActivationThreshold) {
	ASSERT_DOUBLE_EQ(0.5, and_network->get_activation_threshold());
	ASSERT_DOUBLE_EQ(0.5, or_network->get_activation_threshold());
}


TEST_F(PerceptronTest, WeightArray) {
	ASSERT_THAT(and_network->get_weight_array(), ElementsAre(0.0, 0.0));
	ASSERT_THAT(or_network->get_weight_array(),  ElementsAre(0.0, 0.0));
}


 
int main(int argc, char **argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}