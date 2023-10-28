(ns domain.app.entity.common.time.instant
  "Specs for timestamp strings in the form 2021-07-28T04:18:24.299Z"
  (:require
   [clojure.spec.alpha :as s]
   [clojure.spec.gen.alpha :as gen]
   [domain.app.entity.common.time.gen :as time-gen])
  (:import
   [java.time Instant]
   [java.time.format DateTimeFormatter DateTimeParseException]))

(set! *warn-on-reflection* true)

(def ^DateTimeFormatter FORMAT DateTimeFormatter/ISO_INSTANT)

(defn utc-str->instant
  [s]
  (when (seq s)
    (try
      (Instant/parse s)
      (catch DateTimeParseException _
        nil))))

(s/def ::-instant-str (s/and string?
                             utc-str->instant))

(def instant-str-gen (gen/fmap (fn [i]
                                 (.format FORMAT i))
                               time-gen/instant-gen))

(s/def ::instant-str (s/with-gen ::-instant-str
                       (constantly instant-str-gen)))

(comment
  (gen/generate instant-str-gen))
