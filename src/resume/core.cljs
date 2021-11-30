(ns resume.core
  (:require [reagent.core :as reagent]
            [resume.svg :as svg]))

(defonce state (reagent/atom {}))

(defn title []
  [:div {:style {:width "60%"}}
   [:h3 "Michael Bruce"]
   [:h5 "Software Engineer"]
   [:p "A resourceful software enthusiast with 6 years of experience in software development. Keen to provide business value and deliver things that matter."]])

(defn create-links [url & links]
  [:div (map (fn [l] [:a {:href url} l]) links)])

(defn summary-links
  "tiny links/icons that sit in the top right of my CV."
  []
  [:div.summary-links
   [create-links "mailto:me@michaelbruce.co" "me@michaelbruce.co" svg/mail]
   [create-links "https://github.com/mikepjb" "github.com/mikepjb" svg/github]
   [create-links "tel:07714030087" "07714 030087" svg/phone]
   [create-links "https://www.linkedin.com/in/mikepjb" "linkedin.com/in/mikepjb" svg/linkedin]
   [create-links "https://www.google.com/maps/place/Sevenoaks/" "Sevenoaks, England" svg/location]
   [create-links "https://michaelbruce.co" "michaelbruce.co" svg/globe]])

(defn column-section
  [title]
  [:div [:h4 title]])

(defn experience-header
  [title company-name from to location]
  [:div.experience-header
   [:div
    [:h5 title]
    [:h6 company-name]]
   [:div {:style {:text-align "right" :font-size "10px" :color "#555"}}
    [:div (str from " - " to)]
    [:div location]]])

(defn project-header
  [title & src-link site-link]
  [:div {:style {:display "flex" :align-items "center"}} [:h5.inline title]
   (if src-link [:a {:href src-link} svg/github])
   (if site-link [:a {:href site-link} svg/globe])])

(defn detail
  [& pts]
  [:ul
   (map (fn [p] [:li {:key p} p]) pts)])

(defn content []
  [:div
   [:div.header
    [title]
    [summary-links]]
   [:hr]
   [:div.columns
    [:div.column
     [column-section "Work Experience"]
     [detail
      "DUDE GOLDFISH, SKUNK, [hide names for CS/tier1 bank privacy], CONDOR"
      ]
     [experience-header "Software Engineer" "Mercury Holidays" "06/2019" "Present" "Sevenoaks, Kent"]
     [detail
      "Built a backend service to collate and serve information from legacy systems to the frontend."
      "Introduced grpc/swagger documented API to improve service visibility."
      "Designed data models and diagrammed this to aid communication in the team and wider company."
      "Improved reliability for search indexes in Algolia."]
     [experience-header "Developer" "Strategic Blue" "02/2017" "06/2019" "London Bridge"]
     [detail
      "Communicated to keep things running smoothly and provide visibility on how our technology is used."
      "Created a new billing engine (with extensive testing!), to greatly reduce cost of maintenance."
      "Brought a data science project in R to production, wrapped in a Yada-based web server."
      "Improved report generation by using wkhtmltopdf over LaTeX."
      "Responsible for management & maintenance of a set of Ruby microservices."]
     [experience-header "Developer" "Singletrack" "04/2014" "02/2017" "Old Street"]
     [detail
      "Responsible for ensuring portal could be rolled out in China with CI/CD and be accessible across the world."
      "Created a failover utility for changing email marketing networks."
      "Worked directly with vendors to ensure client research could be distributed."
      "Worked directly with clients to ensure their data was correctly loaded."
      "Improved performance of a watermarking microservice to reduce cost."]
     [experience-header "Technical Analyst" "M&C Saatchi Mobile" "09/2013" "02/2014" "Leicester Square"]
     [detail
      "Responsible for providing unique tracking IDs for advertisments, collating metrics and reporting back to multiple teams."]]
    [:div.column
     [column-section "Open Source & Projects"]
     [project-header "tpope/fireplace.vim" "https://github.com/tpope/vim-fireplace/pull/365"]
     [detail "Enabled Java source code jumping."]
     [project-header "juxt/pack.alpha" "https://github.com/juxt/pack.alpha/pull/60"]
     [detail "Removed redundant map now provided by tools.deps.alpha."]
     [project-header "nutrack" "https://github.com/mikepjb/nutrack"]
     [detail "Clojure(script) application to improve my stack knowledge in the Clojure world (and to have some fun)."]
     [project-header "go-nutrack" "https://github.com/mikepjb/nutrack" "https://nutrack.michaelbruce.co"]
     [detail "A personal project in my spare time to improve my abilities fullstack, including UX and frontend work. The idea is to help people get more visibility on what nutrition they are getting and how expensive it is when food shopping."]
     [project-header "sysconf" "https://github.com/mikepjb/sysconf"]
     [detail "Creates a customised boot image, installs fresh Arch Linux (with configurable packages), keeps installation clean and updated."]
     [project-header "citadel" "https://github.com/mikepjb/citadel"]
     [detail "A lighter version of sysconf, allowing configuration via edn."]
     [column-section "Education"]
     [experience-header "Computer Science BSc" "The University of Hertfordshire" "09/2009" "06/2013" "Hertfordshire"]
     [detail "1st Class, also ran the Discussion Society."]
     [experience-header "3 A Levels, 1 AS Level" "Weald of Kent Grammar School" "09/2007" "06/2009" "Tonbridge, Kent"]
     [detail "Maths, Physics, Chemistry, Biology."]
     [column-section "Skills"]
     [detail
      "Adept Emacs & Vim user"
      "Familiar with Clojure(script) (2.5 years), Ruby (5 years), Arch Linux (5+ years), AWS (5+ years), PostgreSQL (5+ years), MongoDB (2.5 years) and Redis (3 years)."
      "UX and usability design basics."]
     ]]
   ])

(reagent/render [content] (.getElementById js/document "app"))
