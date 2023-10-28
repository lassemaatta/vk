(ns domain.verkkokauppa.use-case.item
  (:require
   [clojure.spec.alpha :as s]
   [clojure.string :as str]
   [domain.verkkokauppa.port.http :as http-port])
  (:import
   java.util.UUID))

(s/def ::ctx ::http-port/ctx)

(defn item-availability
  [ctx url pids]
  (->> {:method       :get
        :url          url
        :query-params {:pids (str/join "," pids)}}
      (http-port/do-http! ctx)))

(s/fdef item-availability
  :args (s/cat :ctx ::ctx
               :url string?
               :pids (s/coll-of number?)))

(defn search
  [ctx url query]
  (->> {:method :get
        :url url
        :query-params {:query query
                       :pageSize 2
                       :sessionId (UUID/randomUUID)}}
       (http-port/do-http! ctx)))

(s/fdef search
  :args (s/cat :ctx ::ctx
               :url string?
               :query string?))

