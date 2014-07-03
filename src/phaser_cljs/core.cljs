(ns phaser_cljs.core
  (:require [phaser.core]))

(defn load-image [state key path]
  (-> state .-load (.image key path)))

(defn load-spritesheet [state key path a b]
  (-> state .-load (.spritesheet key path a b)))

(defn preload [state]
  (load-image state "sky" "assets/sky.png")
  (load-image state "ground" "assets/platform.png")
  (load-image state "star" "assets/star.png")
  (load-spritesheet state "dude" "assets/dude.png" 32 48))

(defn create [state]
  (-> state .-add (.sprite 0 0 "star")))

(defn start []
  (let [width (.-innerWidth js/window)
        height (.-innerHeight js/window)
        state (js/Phaser.Game. width height js/Phaser.AUTO ""
                               (clj->js {:preload preload :create create}))]
    (.log js/console state)))

(start)
