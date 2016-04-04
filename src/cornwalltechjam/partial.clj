(ns cornwalltechjam.partial
  (:require [clojure.string :as str]))

(defn- remove-meta [page]
  (str/replace page #"(?is)^<!--(.*?)-->" ""))

(defn- extract-meta-block [page]
  (->> page (re-seq #"(?is)^<!--(.*?)-->") first second))


;; Without let causes NullPointerException
;; TODO: Investigate
(defn- extract-title [meta]
  (let [meta2 (or meta "")]
    (->> meta2 (re-seq #"title\s*:\s*(.*)") first second)))

(defn- extract-description [meta]
  (let [meta2 (or meta "")]
    (->> meta2 (re-seq #"description\s*:\s*(.*)") first second)))


(defn- prepare-path [path]
  path)



(defn create-partial [[raw-path raw-content]]
  (let [meta-section (extract-meta-block raw-content)
        content (remove-meta raw-content)
        path (prepare-path raw-path)]
    {
     :title (or (extract-title meta-section) "Random Thought")
     :description (or (extract-description meta-section) "")
     :path path
     :content content
     ;; :content meta-section
     }))
