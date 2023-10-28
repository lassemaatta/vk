(ns domain.app.use-case.account-test
  (:require
   [clojure.spec.test.alpha :as s-test]
   [clojure.test :refer [deftest is testing]]
   [domain.app.port.all-accounts :as accounts-port]
   [domain.app.port.verify-remote-account :as verify-remote-port]
   [domain.app.use-case.account :as use-case]
   [domain.persistence.memory.gen :as mock-persistence]
   [domain.verkkokauppa.gen :as vk-gen]))

(deftest account-use-case-test
  (testing "generatively testing check-all-accounts use-case"
    (let [opts         {:gen {::accounts-port/impl (constantly mock-persistence/db-with-random-accounts-gen)
                              ::verify-remote-port/impl (constantly vk-gen/mock-account-verifier)}}
          results      (s-test/check `use-case/check-all-accounts opts)
          first-result (first results)]
      (is (seq results))
      (is (= 1 (count results)))
      (is (true? (get-in first-result [:clojure.spec.test.check/ret :pass?]))))))
