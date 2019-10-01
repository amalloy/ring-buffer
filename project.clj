(defproject amalloy/ring-buffer "1.3.1-SNAPSHOT"
  :description "Persistent bounded-size queue implementation in Clojure"
  :url "https://github.com/clj-commons/ring-buffer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.439"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.11"]]
  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]
  :profiles {:1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}
             :1.10.0 {:dependencies [[org.clojure/clojure "1.10.0"]]}
             :1.10.1 {:dependencies [[org.clojure/clojure "1.10.1"]]}}
  :aliases {"test-all" ["with-profile" "+1.8:+1.9:+1.10.0:+1.10.1" "test"]
            "deps-all" ["with-profile" "+1.8:+1.9:+1.10.0:+1.10.1" "deps"]}
  :cljsbuild {:builds [{:id "node-test"
                        :source-paths ["src" "test"]
                        :compiler     {:output-to     "target/testable.js"
                                       :main          amalloy.runner
                                       :target        :nodejs
                                       :optimizations :none}}]})
