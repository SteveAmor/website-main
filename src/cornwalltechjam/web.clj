(ns cornwalltechjam.web
  (:require [optimus.assets :as assets]
            [optimus.export]
            [optimus.link :as link]
            [optimus.optimizations :as optimizations]
            [optimus.prime :as optimus]
            [optimus.strategies :refer [serve-live-assets]]
            [cornwalltechjam.highlight :refer [highlight-code-blocks]]
            [cornwalltechjam.layout :as layout]
            [cornwalltechjam.partial :as partial]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [hiccup.page :refer [html5]]
            [me.raynes.cegdown :as md]
            [stasis.core :as stasis]))

(defn layout-page1 [request page]
  (layout/layout-page-main request page)
  ;; (layout/layout-page-simple request page)
  )

(defn layout-page [page]
  [(:path page) (fn [request] (layout/layout-page-main request page))])

(defn layout-pages [pages]
  (let [page-layouts (map layout-page pages)]
    (into {} page-layouts)))

(def pegdown-options ;; https://github.com/sirthias/pegdown
  [:autolinks :fenced-code-blocks :strikethrough])

(defn render-markdown-page [page]
  (layout-page (md/to-html page pegdown-options)))

;; (defn markdown-pages [pages]
;; (zipmap (map #(str/replace % #"\.md$" ".html") (keys pages))
;; (map #(fn [req] (layout-page req (md/to-html % pegdown-options)))
;; (vals pages))))

(defn slurp-partials []
  (stasis/slurp-directory "resources/partials" #".\.html$"))

(defn get-raw-pages []
  (let [partials (map partial/create-partial (slurp-partials))]
    (stasis/merge-page-sources
     {:public (stasis/slurp-directory "resources/public" #".*\.(html)$")
      :partials (layout-pages partials)
      ;; :markdown (markdown-pages (stasis/slurp-directory "resources/md" #".\.md$"))
      })))

(defn prepare-page [page req]
  (-> (if (string? page) page (page req))
      highlight-code-blocks))

(defn prepare-pages [pages]
  (zipmap (keys pages)
          (map #(partial prepare-page %) (vals pages))))

(defn get-pages []
  (prepare-pages (get-raw-pages)))

(defn get-assets []
  (assets/load-assets "public" [#".*"]))

(def app-optimize-all
  (optimus/wrap (stasis/serve-pages get-pages)
                get-assets
                optimizations/all
                serve-live-assets))
(def app
  (optimus/wrap (stasis/serve-pages get-pages)
                get-assets
                optimizations/none
                serve-live-assets))


;; Export static assets
(def export-dir "build")

(defn export []
  (let [assets (optimizations/all (get-assets) {})]
    (stasis/empty-directory! export-dir)
    (optimus.export/save-assets assets export-dir)
    (stasis/export-pages (get-pages) export-dir {:optimus-assets assets})
    ))
