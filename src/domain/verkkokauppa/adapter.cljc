(ns domain.verkkokauppa.adapter
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.account :as account]
   [domain.app.port.search-items :as port-search]
   [domain.app.port.verify-remote-account :as port-account]
   [domain.verkkokauppa.use-case.customer :as customer]
   [domain.verkkokauppa.use-case.item :as item]))

(defrecord VerkkokauppaApi
    [customer-url
     availability-url
     search-url]

  port-search/SearchRemoteItems
  (-search [_ ctx query]
    (item/search ctx search-url query))

  port-account/VerifyRemoteAccountExists
  (-account-exists? [_ ctx {::account/keys [email]}]
    (customer/check-customer-exists ctx customer-url email)))

(s/def ::impl #(= VerkkokauppaApi (type %)))

(defn init
  []
  (map->VerkkokauppaApi {:customer-url     "https://api.verkkokauppa.com/api/v1/customer/check"
                         :availability-url "https://api.verkkokauppa.com/api/v4/availability"
                         :search-url       "https://web-api.service.verkkokauppa.com/search"}))
