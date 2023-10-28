(ns main
  (:require
   [domain.app.entity.account :as account]
   [domain.app.port.add-account :as add-account]
   [domain.app.port.all-accounts :as all-accounts]
   [domain.app.port.verify-remote-account :as verify-remote-account]
   [domain.app.use-case.account :as account-use-case]
   [domain.context :as ctx]
   [domain.persistence.memory.core :as mem-db]
   [domain.verkkokauppa :as vk]))

(defn build-ctx [db vk]
  (-> (ctx/register ::add-account/impl db)
      (ctx/register ::all-accounts/impl db)
      (ctx/register ::verify-remote-account/impl vk)))

(comment
  (let [account {::account/id    (java.util.UUID/randomUUID)
                 ::account/email "lasse.olavi.maatta@gmail.com"}
        db      (mem-db/init)
        vk      (vk/init)
        ctx     (build-ctx db vk)]
    (add-account/add-account ctx account)
    (account-use-case/check-all-accounts ctx)))

