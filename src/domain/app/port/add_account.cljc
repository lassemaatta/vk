(ns domain.app.port.add-account
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.account :as account]))

(defprotocol CanAddNewAccount
  (-add-account [this ctx account]
    "Add a new local account"))

(s/def ::impl #(satisfies? CanAddNewAccount %))
(s/def ::ctx (s/keys :req [::impl]))

(defn add-account
  [{::keys [impl] :as ctx} account]
  (-add-account impl ctx account))

(s/fdef add-account
  :args (s/cat :ctx ::ctx
               :account ::account/account))
