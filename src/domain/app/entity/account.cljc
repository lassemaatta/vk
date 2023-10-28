(ns domain.app.entity.account
  (:require
   [clojure.spec.alpha :as s]
   [clojure.spec.gen.alpha :as gen]
   [domain.app.entity.common-attributes :as common]))

(s/def ::id uuid?)
(s/def ::email ::common/email)

(s/def ::account (s/keys :req [::id
                               ::email]))

(def account-map-gen (gen/fmap (fn [accounts]
                                 (reduce
                                   (fn [m {::keys [id] :as account}]
                                     (assoc m id account))
                                   {}
                                   accounts))
                               (s/gen (s/coll-of ::account))))

(s/def ::account-map (s/with-gen (s/map-of ::id ::account)
                       (constantly account-map-gen)))
