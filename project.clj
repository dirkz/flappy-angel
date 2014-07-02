(defproject phaser_cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :source-paths ["src"]

  :cljsbuild { 
              :builds [{:id "phaser_cljs"
                        :source-paths ["src"]
                        :compiler {
                                   :output-to "app/out/phaser_cljs.js"
                                   :output-dir "app/out"
                                   :optimizations :none
                                   :source-map true
                                   :foreign-libs [{:file "app/js/phaser.js"
                                                   :provides ["phaser.core"]}]}}]})
