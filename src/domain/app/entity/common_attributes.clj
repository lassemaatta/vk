(ns domain.app.entity.common-attributes
  (:require
   [clojure.spec.alpha :as s]
   [clojure.string :as str]))

(s/def ::not-empty-string (s/and string?
                                 (complement str/blank?)))

(s/def ::email ::not-empty-string)
