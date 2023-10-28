(ns domain.verkkokauppa.port.http
  (:require
   [clojure.spec.alpha :as s]
   [domain.app.entity.common-attributes :as common-spec]))

(defprotocol InvokeHttp
  (-do-http [this ctx query]
    "Perform a HTTP operation"))

(s/def ::impl #(satisfies? InvokeHttp %))
(s/def ::ctx (s/keys :req [::impl]))

(s/def ::method #{:get :post :put :delete :patch :options})
(s/def ::url ::common-spec/not-empty-string)
(s/def ::body (s/or :map map?
                    :number number?
                    :string ::common-spec/not-empty-string))
(s/def ::query-params map?)

(s/def ::query (s/keys :req-un [::method
                                ::url]
                       :opt-un [::body
                                ::query-params]))

(defn do-http!
  [{::keys [impl] :as ctx} query]
  (-do-http impl ctx query))

(s/fdef do-http!
  :args (s/cat :ctx ::ctx
               :query ::query))
