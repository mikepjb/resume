(ns resume.core
  (:require [reagent.core :as reagent]))

(enable-console-print!)

(println "alright!")

(defonce state (reagent/atom {}))

(def mail-icon
  [:svg
   {:class "icon-mail", :viewBox "0 0 24 24", :xmlns "http://www.w3.org/2000/svg"}
   [:path
    {:class "primary",
     :d
     "M22 8.62V18a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8.62l9.55 4.77a1 1 0 0 0 .9 0L22 8.62z"}]
   [:path
    {:class "secondary",
     :d "M12 11.38l-10-5V6c0-1.1.9-2 2-2h16a2 2 0 0 1 2 2v.38l-10 5z"}]])

(def id-icon
  [:svg
   {:class "icon-identification",
    :viewBox "0 0 24 24",
    :xmlns "http://www.w3.org/2000/svg"}
   [:path
    {:class "primary",
     :d
     "M4 4h16a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V6c0-1.1.9-2 2-2zm13 3a1 1 0 0 0 0 2h2a1 1 0 0 0 0-2h-2zm-2 4a1 1 0 0 0 0 2h4a1 1 0 0 0 0-2h-4zm1 4a1 1 0 0 0 0 2h3a1 1 0 0 0 0-2h-3z"}]
   [:path
    {:class "secondary",
     :d
     "M8 12a3 3 0 1 1 0-6 3 3 0 0 1 0 6zm-2 2h4a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1v-1c0-1.1.9-2 2-2z"}]])

(defn title []
  [:div
   [:h3 "Michael Bruce"]
   [:h4 "Software Engineer"]
   [:p "A resourceful software enthusiast with 6 years of experience in software development. Keen to provide business value and deliver things that matter."]])

(defn summary-links
  "tiny links/icons that sit in the top right of my CV."
  []
  [:div
   [:div "me@michaelbruce.co" mail-icon]
   [:div [:a {:href "https://github.com/mikepjb"} "https://github.com/mikepjb"] id-icon]
   ])

;; (defn )

(defn content []
  [:div
   [title]
   [summary-links]
   ])

(reagent/render [content] (.getElementById js/document "app"))
