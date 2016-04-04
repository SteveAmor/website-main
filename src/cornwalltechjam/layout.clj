(ns cornwalltechjam.layout
  (:require [hiccup.page :refer [html5]]
            [optimus.link :as link]))

(def navigation-items
  [{:title "Home", :path "index.html"}
   {:title "About Us", :path "about.html"}
   {:title "Contact", :path "contact.html"}])

(defn- nav-props [item path]
  (let [props {}]
    (if (= path (str "/" (:path item)))
      (assoc props :class "active")
      props)))

(defn- navigation [path]
  (map
   (fn [item]
     [:li (nav-props item path)
      [:a {:href (:path item)} (:title item )]
      ])
   navigation-items))


(defn layout-page [request page]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:title "Cornwall Tech Jam"]
    [:link {:rel "stylesheet" :href (link/file-path request "/css/style.css")}]]
   [:body
    [:div.logo "cornwalltechjam.uk"]
    [:div.body page]]))



;; Place holder for actual template
(defn
  layout-page-main [request {:keys [title description path content]}]
  (layout-page request content))
