(ns domain.app.use-case.account
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.account :as account]
   [domain.app.port.all-accounts :as account-port]
   [domain.app.port.verify-remote-account :as remote-port]))

(defn check-all-accounts
  [ctx]
  (let [accounts (account-port/all-accounts ctx)]
    (reduce-kv
     (fn [accounts id account]
       (assoc accounts id (remote-port/account-exists? ctx account)))
     {}
     accounts)))

(s/def ::context (s/merge ::account-port/ctx
                          ::remote-port/ctx))

(s/def ::ret (s/map-of ::account/id boolean?))

(s/fdef check-all-accounts
  :args (s/cat :ctx ::context)
  :ret ::ret)
