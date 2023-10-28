(ns domain.verkkokauppa.gen
  (:require
   [clojure.spec.gen.alpha :as gen]
   [domain.app.port.verify-remote-account :as verify-remote-port]))

(def mock-account-verifier (gen/fmap
                            (fn [result]
                              (reify verify-remote-port/VerifyRemoteAccountExists
                                (-account-exists? [_ _ account]
                                  result)))
                            (gen/boolean)))
