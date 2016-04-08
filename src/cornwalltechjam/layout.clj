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
  (layout-page request content)
  (html5
   [:head
    
    [:meta {:charset "UTF-8"}] 
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1"}] 
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"}]
    [:title {} "Artificial Reason"] 
    [:link {:rel "shortcut icon", :href "assets/img/favicon.png"}] 
    [:meta {:name "description", :content ""}]
    [:link {:href "assets/css/preload.css", :rel "stylesheet"}] 
    [:link {:href "assets/css/vendors.css", :rel "stylesheet"}]
    [:link {:href "assets/css/syntaxhighlighter/shCore.css", :rel "stylesheet"}]
    [:link {:href "assets/css/style-blue.css", :rel "stylesheet", :title "default"}]
    [:link {:href "assets/css/width-full.css", :rel "stylesheet", :title "default"}]
    [:link {:href "assets/css/techjam.css", :rel "stylesheet"}] 
    "<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->" "\n    " "<!--
[if lt IE 9]>\n        <script src=\"assets/js/html5shiv.min.js\"></script>\n        <script src=\"assets/js/respond.min.js\"></script>\n    <!
[endif]-->" "\n"] "\n\n" "<!-- Preloader -->" "\n" 
   [:body {} 
    [:div {:id "sb-site"}
     [:div {:class "boxed"}
      [:header {:id "header-full-top", :class "hidden-xs header-full"} 
       [:div {:class "container"} 
        [:div {:class "header-full-title"} 
         [:h1 {:class "animated fadeInRight"} 
          [:a {:href "index.html"} "Cornwall " 
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
           [:a {:href "http://www.meetup.com/Cornwall-Digital/events/227903277/", :class "animated fadeIn animation-delay-9 meetup"}
            [:img {:src "assets/img/meetup-logo.svg"}]]]] 
         [:div {:class "dropdown animated fadeInDown animation-delay-11"} 
          [:a {:href "/index.html", :class "dropdown-toggle", :data-toggle "dropdown"} 
           [:i {:class "fa fa-bullhorn"}] " Next Tech Jam: 6th April"] 
      ] 
      ]]]

      [:nav {:class "navbar navbar-default navbar-header-full navbar-dark yamm navbar-static-top", :role "navigation", :id "header"}
       [:div {:class "container"}
        "<!-- Brand and toggle get grouped for better mobile display -->"
        [:div {:class "navbar-header"}
         [:button {:type "button", :class "navbar-toggle", :data-toggle "collapse", :data-target "#bs-example-navbar-collapse-1"} 
          [:span {:class "sr-only"} "Toggle navigation"] 
          [:i {:class "fa fa-bars"}]]
         [:a {:id "ar-brand", :class "navbar-brand hidden-lg hidden-md hidden-sm", :href "index.html"} "Cornwall " 
          [:span {} "Tech Jam"]]]
        "<!-- navbar-header -->"
        "<!-- Collect the nav links, forms, and other content for toggling -->"

        [:div {:class "collapse navbar-collapse", :id "bs-example-navbar-collapse-1"}
         [:ul {:class "nav navbar-nav"}

          [:li {:class "active"}
           [:a {:href "index.html"} "Home"]]

          [:li {:class ""}
           [:a {:href "#"} "Getting there"]]

          [:li {:class ""}
           [:a {:href "#"} "Photo gallery"]]

          [:li {:class ""}
           [:a {:href "#"} "Contact us"]]
          
          ]]]]
      
      content

      [:aside {:id "footer-widgets"}
       [:div {:class "container"}
        [:div {:class "row"}
         [:div {:class "col-md-4"}
          [:h3 {:class "footer-widget-title"} "Sitemap"]
          [:ul {:class "list-unstyled three_cols"}  [:li {} [:a {:href "index.html"} "Home"]                                               ]
           [:li {} [:a {:href "blog.html"} "Blog"]]
           [:li {} [:a {:href "portfolio_sidebar.html"} "Portafolio"]]
           [:li {} [:a {:href "portfolio_topvar.html"} "Works"]]
           [:li {} [:a {:href "page_timeline_left.html"} "Timeline"]]
           [:li {} [:a {:href "page_pricing.html"} "Pricing"]]
           [:li {} [:a {:href "page_about2.html"} "About Us"]]
           [:li {} [:a {:href "page_team.html"} "Our Team"]]
           [:li {} [:a {:href "page_services.html"} "Services"]]
           [:li {} [:a {:href "page_support.html"} "FAQ"]]
           [:li {} [:a {:href "page_login_full.html"} "Login"]]
           [:li {} [:a {:href "page_contact.html"} "Contact"]]]
          [:h3 {:class "footer-widget-title"} "Subscribe"]
          [:p {} "Lorem ipsum Amet fugiat elit nisi anim mollit minim labore ut esse Duis ullamco ad dolor veniam velit."]
          [:div {:class "input-group"}  [:input {:type "text", :placeholder "Email Adress", :class "form-control"}]
           [:span {:class "input-group-btn"}  [:button {:type "button", :class "btn btn-ar btn-primary"} "Subscribe"]]]
          "<!-- /input-group -->" ]
         [:div {:class "col-md-4"}
          [:div {:class "footer-widget"}
           [:h3 {:class "footer-widget-title"} "Recent Post"]
           [:div {:class "media"}
            [:a {:href "#", :class "pull-left"}
             [:img {:height "75", :width "75", :alt "image", :src "assets/img/demo/m2.jpg", :class "media-object"}]                   ]
            [:div {:class "media-body"}
             [:h4 {:class "media-heading"} [:a {:href "#"} "Lorem ipsum Duis quis occaecat minim lorem ipsum tempor officia labor"]]
             [:small {} "August 18, 2013"]       ]      ]
           [:div {:class "media"}
            [:a {:href "#", :class "pull-left"}
             [:img {:height "75", :width "75", :alt "image", :src "assets/img/demo/m11.jpg", :class "media-object"}]]
            [:div {:class "media-body"}
             [:h4 {:class "media-heading"} [:a {:href "#"} "Lorem ipsum dolor excepteur sunt in lorem ipsum cillum tempor"]]
             [:small {} "September 14, 2013"]       ]      ]
           [:div {:class "media"}
            [:a {:href "#", :class "pull-left"}
             [:img {:height "75", :width "75", :alt "image", :src "assets/img/demo/m4.jpg", :class "media-object"}]]
            [:div {:class "media-body"}
             [:h4 {:class "media-heading"}
              [:a {:href "#"} "Lorem ipsum Dolor cupidatat minim adipisicing et fugiat"]                                    ]
             [:small {} "October 9, 2013"]]]]]
         [:div {:class "col-md-4"}
          [:div {:class "footer-widget"}
           [:h3 {:class "footer-widget-title"} "Recent Works"]
           [:div {:class "row"}
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:a {:class "thumbnail", :href "#"} [:img {:alt "Image", :class "img-responsive", :src "assets/img/demo/wf1.jpg"}]]]
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:a {:class "thumbnail", :href "#"} [:img {:alt "Image", :class "img-responsive", :src "assets/img/demo/wf2.jpg"}]]]
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:a {:class "thumbnail", :href "#"} [:img {:alt "Image", :class "img-responsive", :src "assets/img/demo/wf3.jpg"}]]]
            [:div {:class "col-lg-6 col-md-6 col-sm-3 col-xs-6"}
             [:a {:class "thumbnail", :href "#"} [:img {:alt "Image", :class "img-responsive", :src "assets/img/demo/wf4.jpg"}]]]]]]]
        " " "<!-- row -->" ]
       " " "<!-- container -->" ]


      [:footer {:id "footer"}
       [:p {} "© 2014 " [:a {:href "#"} "Cornwall Tech Jam"]", inc. All rights reserved."]]

      


      ]

     



     [:div {:id "back-top"}  [:a {:href "#header"} [:i {:class "fa fa-chevron-up"}]]]

     ;; "\n\n" "<!-- Scripts -->"  "<!-- Compiled in vendors.js -->"  "<!--\n<script src=\"assets/js/jquery.min.js\"></script>\n<script src=\"assets/js/jquery.cookie.js\"></script>\n<script src=\"assets/js/imagesloaded.pkgd.min.js\"></script>\n<script src=\"assets/js/bootstrap.min.js\"></script>\n<script src=\"assets/js/bootstrap-switch.min.js\"></script>\n<script src=\"assets/js/wow.min.js\"></script>\n<script src=\"assets/js/slidebars.min.js\"></script>\n<script src=\"assets/js/jquery.bxslider.min.js\"></script>\n<script src=\"assets/js/holder.js\"></script>\n<script src=\"assets/js/buttons.js\"></script>\n<script src=\"assets/js/jquery.mixitup.min.js\"></script>\n<script src=\"assets/js/circles.min.js\"></script>\n<script src=\"assets/js/masonry.pkgd.min.js\"></script>\n<script src=\"assets/js/jquery.matchHeight-min.js\"></script>\n-->" "\n\n"

     [:script {:src "assets/js/vendors.js"}]

     ;; "\n\n" "<!--<script type=\"text/javascript\" src=\"assets/js/jquery.themepunch.tools.min.js?rev=5.0\"></script>\n<script type=\"text/javascript\" src=\"assets/js/jquery.themepunch.revolution.min.js?rev=5.0\"></script>-->" "\n\n\n" "<!-- Syntaxhighlighter -->"

     [:script {:src "assets/js/syntaxhighlighter/shCore.js"}]
     [:script {:src "assets/js/syntaxhighlighter/shBrushXml.js"}]
     [:script {:src "assets/js/syntaxhighlighter/shBrushJScript.js"}]
     "\n\n" [:script {:src "assets/js/DropdownHover.js"}]
     [:script {:src "assets/js/app.js"}]
     [:script {:src "assets/js/holder.js"}]


     ]]))
