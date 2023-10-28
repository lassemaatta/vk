(ns domain.context
  (:require
   [clojure.spec.alpha :as s]))

(defn register
  ([key impl]
   (register {} key impl))
  ([ctx key impl]
   (assoc ctx key impl)))

(s/def ::key qualified-keyword?)
(s/def ::impl some?)
(s/def ::ctx (s/map-of ::key ::impl))

(s/fdef register
  :args (s/cat :ctx (s/? ::ctx)
               :key ::key
               :impl ::impl)
  :ret ::ctx)
