(ns httpbit.core
    (:require [clj-http.client :as client]
              [clojure.data.json :as json]))

(defn extractJson
  [responseBody]
  (get (json/read-str responseBody) "last"))

(defn getCexCurrency
  [url]
   (:body
    (client/get url)))

(defn outCurrency
  [url]
   (println
    (extractJson
     (getCexCurrency url))))

(defn -main [] (outCurrency "https://cex.io/api/ticker/BTC/USD")
               (outCurrency "https://cex.io/api/ticker/LTC/USD"))
