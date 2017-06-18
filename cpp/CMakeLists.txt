cmake_minimum_required(VERSION 3.0)
project(Perceptron)

enable_testing()

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/googletest-master/googletest/include)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/googletest-master/googlemock/include)

add_executable(perceptron_test perceptron_test perceptron)

target_link_libraries(perceptron_test ${CMAKE_CURRENT_SOURCE_DIR}/googletest-master/build/googlemock/libgmock.a)
target_link_libraries(perceptron_test ${CMAKE_CURRENT_SOURCE_DIR}/googletest-master/build/googlemock/gtest/libgtest.a)

add_test(test perceptron_test)