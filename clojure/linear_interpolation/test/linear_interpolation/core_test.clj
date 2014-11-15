(ns linear_interpolation.core-test
  (:use midje.sweet)
  (:use [linear_interpolation.core]))

(let [
      data-set [[0 0] [10 10] [15 5]]
      interpolate (linear-interpolate data-set)
      ]
  (fact "it should interpolate linearly"
        (interpolate 12) => 8
        (interpolate 10) => 10
        (interpolate 1) => 1))
