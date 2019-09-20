(ns resume.core
  (:require [reagent.core :as reagent]
            [resume.svg :as svg]))

(enable-console-print!)

(println "alright!")

(defonce state (reagent/atom {}))

(defn title []
  [:div
   [:h3 "Michael Bruce"]
   [:h4 "Software Engineer"]
   [:p "A resourceful software enthusiast with 6 years of experience in software development. Keen to provide business value and deliver things that matter."]])

(defn summary-links
  "tiny links/icons that sit in the top right of my CV."
  []
  [:div.summary-links
   [:div "me@michaelbruce.co" svg/mail]
   [:div [:a {:href "https://github.com/mikepjb"} "https://github.com/mikepjb"] svg/id]
   [:div [:a {:href "07714030087"} "07714030087"] svg/phone]
   [:div "Sevenoaks, England" svg/location]])

(defn work-experience
  []
  [:div.work-experience
   [:h4 "Work Experience"]])

(defn content []
  [:div
   [:div.header
    [title]
    [summary-links]]
   [:hr]
   [work-experience]
   ])

(reagent/render [content] (.getElementById js/document "app"))
