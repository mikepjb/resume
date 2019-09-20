(ns resume.svg)

(def mail
  [:svg
   {:class "icon-mail", :viewBox "0 0 24 24", :xmlns "http://www.w3.org/2000/svg"}
   [:path
    {:class "primary",
     :d
     "M22 8.62V18a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8.62l9.55 4.77a1 1 0 0 0 .9 0L22 8.62z"}]
   [:path
    {:class "secondary",
     :d "M12 11.38l-10-5V6c0-1.1.9-2 2-2h16a2 2 0 0 1 2 2v.38l-10 5z"}]])

(def id
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

(def phone
  [:svg
   {:class "icon-phone-ring",
    :viewBox "0 0 24 24",
    :xmlns "http://www.w3.org/2000/svg"}
   [:path
    {:class "primary",
     :d
     "M4 2h4a1 1 0 0 1 .98.8l1 5a1 1 0 0 1-.27.9l-2.52 2.52a12.05 12.05 0 0 0 5.59 5.59l2.51-2.52a1 1 0 0 1 .9-.27l5 1c.47.1.81.5.81.98v4a2 2 0 0 1-2 2h-2A16 16 0 0 1 2 6V4c0-1.1.9-2 2-2z"}]
   [:path
    {:class "secondary",
     :d
     "M22 10a1 1 0 0 1-2 0 6 6 0 0 0-6-6 1 1 0 0 1 0-2 8 8 0 0 1 8 8zm-4 0a1 1 0 0 1-2 0 2 2 0 0 0-2-2 1 1 0 0 1 0-2 4 4 0 0 1 4 4z"}]])

(def location
  [:svg
   {:class "icon-location-pin",
    :viewBox "0 0 24 24",
    :xmlns "http://www.w3.org/2000/svg"}
   [:path
    {:class "primary",
     :d
     "M5.64 16.36a9 9 0 1 1 12.72 0l-5.65 5.66a1 1 0 0 1-1.42 0l-5.65-5.66zM12 13a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"}]
   [:path
    {:class "secondary",
     :d
     "M12 1a9 9 0 0 1 6.36 15.36l-5.65 5.66a1 1 0 0 1-.71.3V13a3 3 0 0 0 0-6V1z"}]])

