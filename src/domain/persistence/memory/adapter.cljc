(ns domain.persistence.memory.adapter
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.account :as account]
   [domain.app.port.add-account :as port-add-account]
   [domain.app.port.all-accounts :as port-all-accounts]))

(defn- get-key
  ([db key not-found]
   (-> db
       (deref)
       (get key not-found)))
  ([db key]
   (get-key db key nil)))

(defn- update!
  [db key f]
  (swap! db update key f))

(defn- clear-storage!
  [db]
  (reset! (:storage db) {}))

(defrecord InMemoryDatabase
    [storage]

  port-all-accounts/CanReadAllAccounts
  (-all-accounts [_ _]
    (get-key storage ::accounts {}))

  port-add-account/CanAddNewAccount
  (-add-account [_ _ {::account/keys [id] :as account}]
    (update! storage ::accounts #(assoc % id account))))

(s/def ::impl #(= InMemoryDatabase (type %)))

(defn init
  ([initial-state]
   (map->InMemoryDatabase {:storage (atom initial-state)}))
  ([]
   (init {})))
