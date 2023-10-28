(ns domain.app.entity.common.time.gen
  "Generators for Java time objects"
  (:require
   [clojure.test.check.generators :as gen])
  (:import
   [java.time LocalDateTime ZoneOffset OffsetDateTime]))

(set! *warn-on-reflection* true)

(def datetime-fields-gen (gen/hash-map
                           :year (gen/large-integer* {:min 1980 :max 2050})
                           :month (gen/large-integer* {:min 1 :max 12})
                           :day (gen/large-integer* {:min 1 :max 28})
                           :hour (gen/large-integer* {:min 0 :max 23})
                           :minute (gen/large-integer* {:min 0 :max 59})
                           :second (gen/large-integer* {:min 0 :max 59})
                           :millis (gen/large-integer* {:min 0 :max 999})))

(def local-datetime-gen (gen/fmap (fn [{:keys [^long year
                                               ^long month
                                               ^long day
                                               ^long hour
                                               ^long minute
                                               ^long second
                                               ^long millis]}]
                                    (LocalDateTime/of year month day hour minute second (* 1000000 millis)))
                                  datetime-fields-gen))

(def zone-gen (gen/elements [ZoneOffset/UTC
                             (ZoneOffset/ofHours 1)
                             (ZoneOffset/ofHours 2)
                             (ZoneOffset/ofHours 3)]))

(def offset-datetime-gen (gen/fmap (fn [[datetime offset]]
                                     (OffsetDateTime/of datetime offset))
                                   (gen/tuple local-datetime-gen zone-gen)))

(def instant-gen (gen/fmap (fn [^LocalDateTime datetime]
                             (.toInstant datetime ZoneOffset/UTC))
                           local-datetime-gen))

(comment
  (gen/generate local-datetime-gen)
  (gen/generate instant-gen)
  (gen/generate offset-datetime-gen))
