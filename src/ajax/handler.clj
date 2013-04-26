(ns ajax.handler
  (:use compojure.core
	[hiccup core page element]
	cheshire.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn ajax [o] (javascript-tag (str
"$(document).ready(function() {
    $.post(\"/\", " o ", function(data){$(\"#oke\").text(data);});
});")))

(def sitio (html (include-js "http://code.jquery.com/jquery-2.0.0.min.js")
		 "ola k ase"
		 "<p id=\"oke\"></p>"
		 (ajax "{ola:'k ase?'}")))


(def test-response "{
	\"ajax1\": \"AJAX option 1\",
	\"ajax2\": \"AJAX option 2\",
	\"ajax3\": \"AJAX option 3\"
}")
(def select-box "<select name=\"myselect\" id=\"myselect\">
<option value=\"myselect_1\">#myselect option 1</option>
</select>")

;ejecuta esta fn en la consola de js y luego ve el dropdown! $('#myselect').append( new Option("ola","k ase?"));

(defroutes app-routes
  (GET "/" [] (html sitio select-box))
  (POST "/" {params :params} (println (val (first params))) (generate-string params)) 
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
