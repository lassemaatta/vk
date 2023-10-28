(ns domain.app.port.all-accounts
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.account :as account]))

(defprotocol CanReadAllAccounts
  (-all-accounts [this ctx]
    "Return all local accounts"))

(s/def ::impl #(satisfies? CanReadAllAccounts %))
(s/def ::ctx (s/keys :req [::impl]))

(defn all-accounts
  [{::keys [impl] :as ctx}]
  (-all-accounts impl ctx))

(s/fdef all-accounts
  :args (s/cat :ctx ::ctx)
  :ret ::account/account-map)
