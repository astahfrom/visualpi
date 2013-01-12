(ns visualpi.core
  (:gen-class)
  (:use quil.core)
  (:require [visualpi.dynamic :as dynamic]))

(defn -main []
  (defsketch visualpi
    :title "VisualPi by Andreas From"
    :setup dynamic/setup
    :draw dynamic/draw
    :size [400 460]))
