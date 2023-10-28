(ns domain.persistence.memory.gen
  (:require
   [clojure.spec.alpha :as s]
   [clojure.spec.gen.alpha :as gen]
   [domain.app.entity.account :as account]
   [domain.persistence.memory.adapter :as mem-db]))

(def db-with-random-accounts-gen (gen/fmap (fn [accounts]
                                             (mem-db/init {::mem-db/accounts accounts}))
                                           (s/gen ::account/account-map)))
