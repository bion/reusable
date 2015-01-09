(ns linear_interpolation.core)

(defn linear-interpolate
  "Takes a collection of points as [x y] tuples, returns a function
   that linearly interpolates between the points"
  [input-points]
  (let [results (into (sorted-map) (map vec input-points))]
    (fn [x]
      (let [[xa ya] (first (rsubseq results <= x))
            [xb yb] (first (subseq results > x))]
        (if (and xa xb)
          (/ (+ (* ya (- xb x)) (* yb (- x xa)))
             (- xb xa))
          (or ya yb))))))

(def initial-set (into [] (take 10000 (range 2 8e9 3))))
(def input-set (map (fn [x] [x (/ x 10)]) initial-set))

(let [interpolate (linear-interpolate input-set)]
        (prn (time (interpolate 809))))
