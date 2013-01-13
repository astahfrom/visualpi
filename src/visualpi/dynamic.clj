(ns visualpi.dynamic
  (:use quil.core))

(def font-size 20)
(def running (atom true))

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

(defn pause-play []
  (reset! running (not @running)))

(defn setup []
  (def circle (atom 0))
  (def square (atom 0))
  (def last-frame (atom 0))

  (background 255)
  (smooth)
  (frame-rate 60)
  (text-size font-size)
  (no-stroke))

(defn key-pressed []
  (let [k (str (raw-key))]
    (cond
      (= k "r") (setup)
      (= k "c") (background 255)
      (= k " ") (pause-play))))

(defn mouse-pressed []
  (save-frame "visualpi-####.png"))

(defn draw []
  ; hack around start-loop/no-loop not working
  (if @running
    (do
      (let [pi (str (* 4 (/ @circle (+ @circle @square 0.0)))) ; 0.0 to get float
            start (my-width)
            circle (str @circle)
            square (str @square)]
        (fill 255)
        (rect 0 start (my-width) (height))
        (fill 0)
        (text pi 0 (+ start font-size))
        (fill 255 0 0)
        (text circle 0 (+ start (* 2 font-size)))
        (fill 0 0 255)
        (text square (- (text-width circle) (text-width square)) (+ start (* 3 font-size))))

      (while (< (- (millis) @last-frame) (/ 1000 60))
        (let [point {:x (random (my-width)) :y (random (my-width))}]
          (if (in-circle? point (my-width))
            (do
              (fill 255 0 0)
              (swap! circle inc))
            (do
              (fill 0 0 255)
              (swap! square inc)))
          (rect (point :x) (point :y) 1 1)))))

  (reset! last-frame (millis)))
