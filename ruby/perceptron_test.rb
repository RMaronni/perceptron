require "test/unit"
require_relative "perceptron"

class PerceptronTest < Test::Unit::TestCase


  def setup
    @and_network = Perceptron.new(2, 0.5)
    @or_network = Perceptron.new(2, 0.5)
  end

  def test_get_input_number
    assert_equal(@and_network.get_input_number, 2)
    assert_equal(@or_network.get_input_number,  2)
  end

  def test_get_activation_threshold
		assert_equal(@and_network.get_activation_threshold, 0.5)
    assert_equal(@or_network.get_activation_threshold,  0.5)
  end

  def test_get_weight_array
  	assert_equal(@and_network.get_weight_array, [0, 0])
    assert_equal(@or_network.get_weight_array,  [0, 0])
  end

  def test_and_network
  	# Train the and network
  	for i in 0..100
      @and_network.train([0, 0], 0)
      @and_network.train([0, 1], 0)
      @and_network.train([1, 0], 0)
      @and_network.train([1, 1], 1)
    end

    # Test
    assert_equal(@and_network.run([0, 0]), 0)
    assert_equal(@and_network.run([0, 1]), 0)
    assert_equal(@and_network.run([1, 0]), 0)
    assert_equal(@and_network.run([1, 1]), 1)
  end


  def test_or_network
  	# Train the or network
  	for i in 0..100
      @or_network.train([0, 0], 0)
      @or_network.train([0, 1], 1)
      @or_network.train([1, 0], 1)
      @or_network.train([1, 1], 1)
    end

    # Test
    assert_equal(@or_network.run([0, 0]), 0)
    assert_equal(@or_network.run([0, 1]), 1)
    assert_equal(@or_network.run([1, 0]), 1)
    assert_equal(@or_network.run([1, 1]), 1)
  end
 
end