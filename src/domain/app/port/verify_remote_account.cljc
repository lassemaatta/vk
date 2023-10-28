(ns domain.app.port.verify-remote-account
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.account :as account]))

(defprotocol VerifyRemoteAccountExists
  (-account-exists? [this ctx account]
    "Check if a local account exists on the remote store"))

(s/def ::impl #(satisfies? VerifyRemoteAccountExists %))
(s/def ::ctx (s/keys :req [::impl]))

(defn account-exists?
  [{::keys [impl] :as ctx} account]
  (-account-exists? impl ctx account))

(s/fdef account-exists?
  :args (s/cat :ctx ::ctx
               :account ::account/account))
