(ns domain.app.entity.common.time.offset
  "Specs for timestamp strings in the form 2011-12-03T10:15:30+01:00"
  (:require
   [clojure.spec.alpha :as s]
   [clojure.spec.gen.alpha :as gen]
   [domain.app.entity.common.time.gen :as time-gen])
  (:import
   [java.time OffsetDateTime]
   [java.time.format DateTimeFormatter DateTimeParseException]))

(set! *warn-on-reflection* true)

(def ^DateTimeFormatter FORMAT DateTimeFormatter/ISO_OFFSET_DATE_TIME)

(defn offset-str->offset-datetime
  [s]
  (when (seq s)
    (try
      (OffsetDateTime/parse s FORMAT)
      (catch DateTimeParseException _
        nil))))

(s/def ::-offset-str (s/and string?
                            offset-str->offset-datetime))

(def offset-str-gen (gen/fmap (fn [i]
                                (.format FORMAT i))
                              time-gen/offset-datetime-gen))

(s/def ::offset-str (s/with-gen ::-offset-str
                      (constantly offset-str-gen)))

(comment
  (gen/generate offset-str-gen))
