(ns phaser_cljs.core
  (:require [phaser.core :as phaser]))

(defn load-image [game key path]
  (-> game .-load (.image key path)))

(defn load-spritesheet [game key path a b]
  (-> game .-load (.spritesheet key path a b)))

(defn preload [game]
  (load-image game "sky" "assets/sky.png")
  (load-image game "ground" "assets/platform.png")
  (load-image game "star" "assets/star.png")
  (load-spritesheet game "dude" "assets/dude.png" 32 48))

(defn create [game]
  (-> game .-add (.sprite 0 0 "star")))

(defn start []
  (let [width (.-innerWidth js/window)
        height (.-innerHeight js/window)
        game (js/Phaser.Game. width height js/Phaser.AUTO ""
                              (clj->js {:preload preload :create create}))]
    (.log js/console game)))

(start)
