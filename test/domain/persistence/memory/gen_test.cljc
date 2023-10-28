(ns domain.persistence.memory.gen-test
  (:require
   [clojure.spec.alpha :as s]
   [clojure.spec.gen.alpha :as gen]
   [clojure.test :refer [deftest is testing]]
   [domain.app.port.add-account :as port]
   [domain.persistence.memory.adapter :as mem-db]
   [domain.persistence.memory.gen :as mem-gen]))

(deftest persistence-gen-test
  (let [instance (gen/generate mem-gen/db-with-random-accounts-gen)]
    (testing "generated instance is a valid in-memory-database"
      (is (s/valid? ::mem-db/impl instance)))
    (testing "generated instance is a valid app.domain.port"
      (is (s/valid? ::port/impl instance)))))
