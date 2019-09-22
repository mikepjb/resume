(ns resume.core
  (:require [reagent.core :as reagent]
            [resume.svg :as svg]))

;; talk about what I've done
;; start every bullet point with a verb "doing"

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
   [:div [:a {:href "https://github.com/mikepjb"} "github.com/mikepjb"] svg/github]
   [:div [:a {:href "07714030087"} "07714030087"] svg/phone]
   [:div [:a {:href "https://www.linkedin.com/in/mikepjb"} "linkedin.com/in/mikepjb"] svg/linkedin]
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
     [experience-header "Software Engineer" "Mercury Holidays" "06/2019" "Present" "Sevenoaks, Kent"]
     [detail
      "Building a data-centric backend system for serving new technology at the company."
      "Designed data models and diagrammed this to communicate progress in the team and wider company."
      "Search index in algolia.."
      "Coordinating a team of 3 to deliver.."
      "...led? raising monitoring and visibility on the project with webhooks & dashboards."]
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
      "Responsible for providing unique tracking IDs for advertisments, collating metrics and reporting back to multiple teams."]]
    [:div.column
     [column-section "Open Source & Projects"]
     [project-header "tpope/fireplace.vim" "https://github.com/tpope/vim-fireplace/pull/365"]
     [detail "Made PR (with Dominic) to allow Java source code jumping."]
     [project-header "juxt/pack.alpha" "https://github.com/juxt/pack.alpha/pull/60"]
     [detail "Removed redundant map now provided by tools.deps.alpha."]
     [project-header "nutrack" "https://github.com/mikepjb/nutrack"]
     [detail "Clojure(script) application to improve my stack knowledge in the Clojure world (and to have some fun). Sends metrics to prometheus, from the app and Postgres."]
     [project-header "go-nutrack" "https://github.com/mikepjb/nutrack" "https://nutrack.michaelbruce.co"]
     [detail "A personal project in my spare time to improve my abilities fullstack, including UX and frontend work. The idea is to help people get more visibility on what nutrition they are getting and how expensive it is when food shopping."]
     [project-header "sysconf"]
     [detail "sysconf does 3 things, it can create a personalised live Arch image, it can install Arch linux with a set of configured packages (via json) and keep your setup clean/up to date (again via json)."]
     [project-header "citadel"]
     [detail "A lighter version of sysconf, allowing configuration via edn (I have a system.edn file that syncs packages between machines)."]
     [column-section "Education"]
     [experience-header "Computer Science BSc, 1st Class" "The University of Hertfordshire" "09/2009" "06/2013" "Hatfield, Hertfordshire"]
     [experience-header "3 A Level, 1 AS Level" "Weald of Kent Grammar School" "09/2007" "06/2009" "Tonbridge, Kent"]
     [column-section "Skills"]
     [detail
      "An adept Emacs & Vim user"
      "Used Arch Linux for years (familiar with unix conventions and bash)"
      "Ruby 3 years"
      "Clojure 2.5 years (familiar with which libraries?)"
      "AWS Cloud Practictioner - used for ages"
      "Postgres"
      "UX basics (refactoring ui/uxmovement)"]
     ]]
   ])

(reagent/render [content] (.getElementById js/document "app"))
