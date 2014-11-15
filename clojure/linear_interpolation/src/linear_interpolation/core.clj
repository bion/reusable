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
