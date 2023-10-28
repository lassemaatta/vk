(ns domain.app.port.search-items
  (:require
   [clojure.spec.alpha :as s]))

(defprotocol SearchRemoteItems
  (-search [this ctx query]
    "Find items by query string"))

(s/def ::impl #(satisfies? SearchRemoteItems %))
(s/def ::ctx (s/keys :req [::impl]))

(defn search
  [{::keys [impl] :as ctx} query]
  (-search impl ctx query))

(s/fdef search
  :args (s/cat :ctx ::ctx
               :query string?))
