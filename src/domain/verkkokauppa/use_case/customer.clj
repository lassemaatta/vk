(ns domain.verkkokauppa.use-case.customer
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.common-attributes :as common]
   [domain.verkkokauppa.port.http :as http-port]))

(defn body->customer-exists?
  [body]
  (true? (:ok body)))

(defn check-customer-exists
  [ctx url email]
  (->> {:method :post
        :url    url
        :body   {:email email}}
      (http-port/do-http! ctx)
      (body->customer-exists?)))

(s/def ::context ::http-port/ctx)

(s/fdef check-customer-exists
  :args (s/cat :ctx ::context
               :url string?
               :email ::common/email)
  :ret boolean?)
