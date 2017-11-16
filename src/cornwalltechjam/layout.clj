(ns cornwalltechjam.layout
  (:require [hiccup.page :refer [html5]]
            [optimus.link :as link]))

(def navigation-items
  [{:title "Home", :path "/index.html"}
   {:title "Photos from April", :path "/photos/20160409.html"}
   {:title "Photos from March", :path "/photos/20160312.html"}
;;   {:title "Finding us", :path "/locations/cornwall-college.html"}
   {:title "Finding us", :path "/locations/bodmin-library.html"}
;;   {:title "Finding us", :path "/locations/penwith-college.html"}
   {:title "Newsletter", :path "/newsletter.html"}
   ;; {:title "Contact us", :path ".html"}
   ])

(defn- nav-props [item path]
  (let [props {}]
    (if (= path (:path item))
      (assoc props :class "active")
      props)))

(defn- navigation [path]
  (map
   (fn [item]
     [:li (nav-props item path)
      [:a {:href (:path item)} (:title item )]
      ])
   navigation-items))

(defn- extra-javascript [javascript]
  (if (= javascript "carousels")
    [:script {:src "/assets/js/carousels.js"}]))


(defn layout-page-simple [request page]
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

(defn
  layout-page-main [request {:keys [title description javascript path content]}]
  (html5
   [:head
    
    [:meta {:charset "UTF-8"}] 
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1"}] 
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"}]
    [:title {} title] 
    [:link {:rel "shortcut icon", :href "/assets/img/favicon.png"}] 
    [:meta {:name "description", :content description}]
    [:link {:href "http://fonts.googleapis.com/css?family=Lato:100,300,400|Open+Sans:400italic,400,600|Muli:300|Indie+Flower:400|Oswald:400,700,300" :rel "stylesheet"}]
    [:link {:href "/assets/css/bootstrap.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/bootstrap-switch.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/font-awesome.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/animate.min.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/slidebars.min.css", :rel "stylesheet"}]
    ;; [:link {:href "/assets/css/lightbox.css", :rel "stylesheet"}]
    ;; [:link {:href "/assets/css/jquery.bxslider.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/buttons.css", :rel "stylesheet"}]    
    [:link {:href "/assets/css/syntaxhighlighter/shCore.css", :rel "stylesheet"}]
    [:link {:href "/assets/css/style-blue.css", :rel "stylesheet", :title "default"}]
    [:link {:href "/assets/css/width-full.css", :rel "stylesheet", :title "default"}]
    [:link {:href "/assets/css/techjam.css", :rel "stylesheet"}] 
    [:meta {:name "twitter:card", :content "summary"}]
    [:meta {:name "twitter:site", :content "@cornwalltechjam"}]
    [:meta {:name "twitter:title", :content title}]
    [:meta {:name "twitter:description", :content description}]
    [:meta {:name "twitter:image", :content "https://avatars1.githubusercontent.com/u/18351576"}]
    "<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->" "\n    " "<!--
[if lt IE 9]>\n        <script src=\"/assets/js/html5shiv.min.js\"></script>\n        <script src=\"/assets/js/respond.min.js\"></script>\n    <!
[endif]-->" "\n"]
   
   [:body {} 
    [:div {:id "sb-site"}
     [:div {:class "boxed"}
      [:header {:id "header-full-top", :class "hidden-xs header-full"} 
       [:div {:class "container"} 
        [:div {:class "header-full-title"} 
         [:h1 {:class "animated fadeInRight"} 
          [:a {:href "/index.html"} "Cornwall " 
           [:span {} "Tech Jam"]]] 
         [:p {:class "animated fadeInRight"} "Raspberry Pi's, Pasties and Programming"]]
        [:nav {:class "top-nav"} 
         [:ul {:class "top-nav-social hidden-sm"} 
          [:li {} 
           [:a {:href "https://twitter.com/cornwalltechjam", :class "animated fadeIn animation-delay-7 twitter"} 
            [:i {:class "fa fa-twitter"}]]] 
          [:li {} 
           [:a {:href "https://www.facebook.com/cornwalltechjam", :class "animated fadeIn animation-delay-8 facebook"} 
            [:i {:class "fa fa-facebook"}]]]
          [:li {} 
           [:a {:href "https://www.meetup.com/Cornwall-Digital/events/244218714/", :class "animated fadeIn animation-delay-9 meetup"}
            [:img {:src "/assets/img/meetup-logo.svg"}]]]] 
         [:div {:class "dropdown animated fadeInDown animation-delay-11"} 
          [:a {:href "/index.html", :class "dropdown-toggle", :data-toggle "dropdown"} 
           [:i {:class "fa fa-bullhorn"}] " Next Tech Jam: 9th Dec"]]]]]

      [:nav {:class "navbar navbar-default navbar-header-full navbar-dark yamm navbar-static-top", :role "navigation", :id "header"}
       [:div {:class "container"}
        "<!-- Brand and toggle get grouped for better mobile display -->"
        [:div {:class "navbar-header"}
         [:button {:type "button", :class "navbar-toggle", :data-toggle "collapse", :data-target "#bs-example-navbar-collapse-1"} 
          [:span {:class "sr-only"} "Toggle navigation"] 
          [:i {:class "fa fa-bars"}]]
         [:a {:id "ar-brand", :class "navbar-brand hidden-lg hidden-md hidden-sm", :href "/index.html"} "Cornwall " 
          [:span {} "Tech Jam"]]]
     
        [:div {:class "collapse navbar-collapse", :id "bs-example-navbar-collapse-1"}
         [:ul {:class "nav navbar-nav"}

          (navigation path)]]]]
      
      content

      [:aside {:id "footer-widgets"}
       [:div {:class "container"}
        [:div {:class "row"}

         [:div {:class "col-md-4"}
          [:div {:class "footer-widget"}
           [:h3 {:class "footer-widget-title"} "Through the keyhole"]
           [:div {:class "row"}
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:div.thumbnail [:img {:alt "The infamous Mission to Mars rover", :class "img-responsive", :src "/assets/img/footer/tj_mission_to_mars_rover.jpg"}]]]
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:div.thumbnail [:img {:alt "Close up of an ESP8266 module connect to a breadboard", :class "img-responsive", :src "/assets/img/footer/eot_esp_8266_close_up.jpg"}]]]
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:div.thumbnail [:img {:alt "Mike Trebilcock interfacing with the Cornish programmer's fuel of choice (a pasty)", :class "img-responsive", :src "/assets/img/footer/tj_mike_pasty.jpg"}]]]
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:div.thumbnail [:img {:alt "Hard at work soldering at the Eden of Things project", :class "img-responsive", :src "/assets/img/footer/eot_soldering.jpg"}]]]]]]
         
         [:div {:class "col-md-4"}
          [:div {:class "footer-widget footer-swcornwall"}
           [:a {:href "http://www.softwarecornwall.org" :title "Proud to be part of Software Cornwall"}
            [:img {:src "/assets/img/software_cornwall_logo_square.png" :alt "Software Cornwall logo"}]]]]
         
         [:div {:class "col-md-4"}
          [:div {:class "footer-widget footer-about"}
           [:h3 {:class "footer-widget-title"} "A little bit about the Tech Jam"]
           [:p "Cornwall's Tech Jams are run by volunteers working in IT and education throughout Cornwall, in association with Software Cornwall and local businesses."]
           [:p "Except where otherwise noted, content on this site is licensed under a " [:a {:href "http://creativecommons.org/licenses/by/4.0/"} "Creative Commons Attribution 4.0 International license"] "."]
           [:p  "Powered by " [:a {:href "https://clojure.org/"} "Clojure"] " and " [:a {:href "https://github.com/magnars/stasis"} "Stasis"] ", created with " [:a {:href "https://www.gnu.org/software/emacs/"} "Emacs"] ", source code on " [:a {:href "https://github.com/CornwallTechJam"} "GitHub"] "."]
           
        ]]
]
        " " "<!-- row -->" ]
       " " "<!-- container -->" ]

      [:footer {:id "footer"}
       [:p "We're hosted on"]
       [:a {:href "https://github.com/CornwallTechJam"} [:img {:src "/assets/img/github_pages.svg"}]]]]

     [:div {:id "back-top"}  [:a {:href "#header"} [:i {:class "fa fa-chevron-up"}]]]

     ;; "\n\n" "<!-- Scripts -->"  "<!-- Compiled in vendors.js -->"  "<!--\n<script src=\"/assets/js/jquery.min.js\"></script>\n<script src=\"/assets/js/jquery.cookie.js\"></script>\n<script src=\"/assets/js/imagesloaded.pkgd.min.js\"></script>\n<script src=\"/assets/js/bootstrap.min.js\"></script>\n<script src=\"/assets/js/bootstrap-switch.min.js\"></script>\n<script src=\"/assets/js/wow.min.js\"></script>\n<script src=\"/assets/js/slidebars.min.js\"></script>\n<script src=\"/assets/js/jquery.bxslider.min.js\"></script>\n<script src=\"/assets/js/holder.js\"></script>\n<script src=\"/assets/js/buttons.js\"></script>\n<script src=\"/assets/js/jquery.mixitup.min.js\"></script>\n<script src=\"/assets/js/circles.min.js\"></script>\n<script src=\"/assets/js/masonry.pkgd.min.js\"></script>\n<script src=\"/assets/js/jquery.matchHeight-min.js\"></script>\n-->" "\n\n"

     [:script {:src "/assets/js/vendors.js"}]

     ;; "\n\n" "<!--<script type=\"text/javascript\" src=\"/assets/js/jquery.themepunch.tools.min.js?rev=5.0\"></script>\n<script type=\"text/javascript\" src=\"/assets/js/jquery.themepunch.revolution.min.js?rev=5.0\"></script>-->" "\n\n\n" "<!-- Syntaxhighlighter -->"

     [:script {:src "/assets/js/syntaxhighlighter/shCore.js"}]
     [:script {:src "/assets/js/syntaxhighlighter/shBrushXml.js"}]
     [:script {:src "/assets/js/syntaxhighlighter/shBrushJScript.js"}]
     "\n\n" [:script {:src "/assets/js/DropdownHover.js"}]
     [:script {:src "/assets/js/app.js"}]
     [:script {:src "/assets/js/holder.js"}]

     (extra-javascript javascript)]]))
