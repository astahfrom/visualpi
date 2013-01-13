(ns visualpi.core
  (:gen-class)
  (:use quil.core)
  (:require [visualpi.dynamic :as dynamic]))

(defn -main []
  (sketch
    :title "VisualPi by Andreas From"
    :setup dynamic/setup
    :draw dynamic/draw
    :key-pressed dynamic/key-pressed
    :mouse-pressed dynamic/mouse-pressed
    :size [400 460]))
