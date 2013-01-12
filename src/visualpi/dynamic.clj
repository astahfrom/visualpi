(ns visualpi.dynamic
  (:use quil.core))

(def points-in-circle 0)
(def points-in-square 0)
(def font-size 20)
(def last-frame 0)

(defn my-width []
  (min (- (height) (* 3 font-size))
       (width)))

(defn in-circle? [point width]
  (let [mid (/ width 2)
        r mid
        dx (- (point :x) mid)
        dy (- (point :y) mid)]
    (if (<= (+ (* dx dx)
               (* dy dy))
            (* r r))
      true
      false)))

(defn setup []
  (smooth)
  (frame-rate 60)
  (background 255)
  (text-size font-size)
  (no-stroke))

(defn draw []
  (while (< (- (millis) last-frame) (/ 1000 60))
    (let [point {:x (random (my-width)) :y (random (my-width))}]
      (if (in-circle? point (my-width))
        (do
          (fill 255 0 0)
          (def points-in-circle (+ points-in-circle 1)))
        (do
          (fill 0 0 255)
          (def points-in-square (+ points-in-square 1))))
      (rect (point :x) (point :y) 1 1)))
  (let [pi (str (* 4 (/ points-in-circle (+ points-in-circle points-in-square 0.0)))) ; 0.0 to get float
        start (my-width)
        circle (str points-in-circle)
        square (str points-in-square)]
    (fill 255)
    (rect 0 start (my-width) (height))
    (fill 0)
    (text pi 0 (+ start font-size))
    (fill 255 0 0)
    (text circle 0 (+ start (* 2 font-size)))
    (fill 0 0 255)
    (text square (- (text-width circle) (text-width square)) (+ start (* 3 font-size))))
  (def last-frame (millis)))
