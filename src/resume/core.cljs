(ns resume.core
  (:require [reagent.core :as reagent]
            [resume.svg :as svg]))

(defonce state (reagent/atom {}))

(defn title []
  [:div {:style {:width "65%"}}
   [:h3 "Michael Bruce"]
   [:h5 "Software Engineer"]
   [:p "A resourceful software enthusiast with 6 years of experience in software development. Keen to provide business value and deliver things that matter."]])

(defn summary-links
  "tiny links/icons that sit in the top right of my CV."
  []
  [:div.summary-links
   [:div "me@michaelbruce.co" svg/mail]
   [:div [:a {:href "https://github.com/mikepjb"} "github.com/mikepjb"] svg/id]
   [:div [:a {:href "07714030087"} "07714030087"] svg/phone]
   [:div [:a {:href "https://www.linkedin.com/in/mikepjb"} "linkedin.com/in/mikepjb"] svg/id]
   [:div "Sevenoaks, England" svg/location]
   [:div [:a {:href "https://michaelbruce.co"} "michaelbruce.co"] svg/globe]
])

(defn column-section
  [title]
  [:div [:h4 title]])

(defn experience-header
  [title company-name from to location]
  [:div.experience-header
   [:div ;; {:style {:margin-right 100}}
    [:h5 title]
    [:h6 company-name]]
   [:div
    [:div (str from " - " to)]
    [:div location]]])

(defn content []
  [:div
   [:div.header
    [title]
    [summary-links]]
   [:hr]
   [:div.columns
    [:div.column
     [column-section "Work Experience"]
     [experience-header "Software Engineer" "Mercury Holidays" "06/2019" "Present" "Sevenoaks, Kent"]
     [experience-header "Developer" "Strategic Blue" "02/2017" "06/2019" "London Bridge, London"]
     [experience-header "Developer" "Singletrack" "04/2014" "02/2017" "Old Street, London"]
     [experience-header "Technical Analyst" "M&C Saatchi Mobile" "09/2013" "02/2014" "Leicester Square, London"]
     [experience-header "Android Developer" "Magazine Cloner" "06/2012" "08/2012" "Old Street, London"]
     ]
    [:div.column
     [column-section "Open Source & Projects"]
     [column-section "Education"]
     [experience-header "Computer Science BSc, 1st Class" "The University of Hertfordshire" "09/2009" "06/2013" "Hatfield, Hertfordshire"]
     [experience-header "3 A Level, 1 AS Level" "Weald of Kent Grammar School" "09/2007" "06/2009" "Tonbridge, Kent"]
     [column-section "Skills"]

     ]]
   ])

(reagent/render [content] (.getElementById js/document "app"))
