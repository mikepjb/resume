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
   [:div {:style {:text-align "right"}}
    [:div (str from " - " to)]
    [:div location]]])

(defn project-header
  [title]
  [:div [:h5 title]])

(defn detail
  [& pts]
  [:ul
   (map (fn [p] [:li p]) pts)])

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
     [detail
      "Building a data-centric backend system for serving new technology at the company."
      "Designed data models and diagrammed this to communicate progress in the team and wider company."
      "Coordinating a team of 3 to deliver.."]
     [experience-header "Developer" "Strategic Blue" "02/2017" "06/2019" "London Bridge, London"]
     [detail
      "Rallied together with a team of 6 developers to rewrite (and extensively test) our billing engine, to greatly reduce cost of maintenance."
      "Brought a data science project in R to production, wrapped in a yada web server."
      "Improved report generation by using wkhtmltopdf over LaTeX."
      "Responsible for management & maintenance of a set of Ruby microservices."
      "Imp"]
     [experience-header "Developer" "Singletrack" "04/2014" "02/2017" "Old Street, London"]
     [detail
      "Responsible for ensuring portal could be rolled out in China with CI/CD and be accessible across the world."
      "Created a failover utility for changing email marketing networks."
      "Worked directly with vendors to ensure client research could be distributed."
      "Worked directly with clients to ensure their data was correctly loaded."]
     [experience-header "Technical Analyst" "M&C Saatchi Mobile" "09/2013" "02/2014" "Leicester Square, London"]
     [detail
      "Responsible for providing unique tracking IDs for advertisments, collating metrics and reporting back to multiple teams."]
     [experience-header "Android Developer" "Magazine Cloner" "06/2012" "08/2012" "Old Street, London"]
     [detail "Created a recipe app for a client."]
     ]
    [:div.column
     [column-section "Open Source & Projects"]
     [project-header "tpope/fireplace.vim"]
     [project-header "juxt/pack.alpha"]
     [project-header "nutrack"]
     [project-header "go-nutrack"]
     [project-header "sysconf"]
     [project-header "citadel"]
     [column-section "Education"]
     [experience-header "Computer Science BSc, 1st Class" "The University of Hertfordshire" "09/2009" "06/2013" "Hatfield, Hertfordshire"]
     [experience-header "3 A Level, 1 AS Level" "Weald of Kent Grammar School" "09/2007" "06/2009" "Tonbridge, Kent"]
     [column-section "Skills"]
     [detail
      "Ruby 3 years"
      "AWS Cloud Practictioner - used for ages"
      "Postgres"
      "Arch Linux"
      "UX basics (refactoring ui/uxmovement)"]
     ]]
   ])

(reagent/render [content] (.getElementById js/document "app"))
