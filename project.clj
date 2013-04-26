(defproject ajax "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.2"][compojure "1.1.5"][cheshire "5.1.1"]]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler ajax.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
