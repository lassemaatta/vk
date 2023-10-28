(ns domain.http.adapter
  (:require
   [clojure.data.json :as json]
   [domain.verkkokauppa.port.http :as vk-http]
   [org.httpkit.client :as client]))

(defn- key-fn
  [v]
  (try
    (Long/parseLong v)
    (catch Exception _
      (keyword v))))

(defn- request!
  [{:keys [method url body query-params]}]
  (-> (client/request {:url          url
                       :method       method
                       :query-params query-params
                       :body         (some-> body
                                             (json/write-str))})
      (deref)
      (:body)
      (json/read-str :key-fn key-fn)))

(defrecord HttpAdapter
    []
  vk-http/InvokeHttp
  (-do-http [_ _ query]
    (request! query)))

(defn init
  []
  (map->HttpAdapter {}))
