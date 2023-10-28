(ns domain.verkkokauppa.spec
  (:require
   [clojure.spec.alpha :as s]
   [clojure.spec.gen.alpha :as gen]
   [domain.app.entity.common-attributes :as common-spec]))

(s/def ::timestamp ::common-spec/timestamp-str)

(comment
  (gen/generate (s/gen ::product)))


;; The following specs are generated with spec-provider

(s/def ::type (s/nilable string?))
(s/def ::href (s/or :map ::bulletPoints
                    :simple string?))
(s/def ::name (s/or :map ::bulletPoints
                    :simple string?))
(s/def ::links (s/coll-of (s/keys :req-un [::href ::name]
                                  :opt-un [::type])))
(s/def ::recommendedCount integer?)
(s/def ::reviewCount integer?)
(s/def ::averageOverallRating (s/or :double double?
                                    :integer integer?))
(s/def ::other (s/nilable (s/map-of keyword? number?)))
                          
(s/def ::rating (s/keys :req-un [::averageOverallRating
                                 ::other
                                 ::recommendedCount
                                 ::reviewCount]))
(s/def ::fi (s/or :collection ::tooltip
                  :simple string?))
(s/def ::updateCount integer?)
(s/def ::endAt (s/nilable string?))
(s/def ::id (s/or :integer integer?
                  :string string?))
(s/def ::discountType integer?)
(s/def ::beginAt ::timestamp)
(s/def ::discount (s/nilable (s/keys :req-un [::beginAt
                                              ::discountType
                                              ::endAt
                                              ::id
                                              ::name])))
(s/def ::discountAmount (s/nilable integer?))
(s/def ::deposit nil?)
(s/def ::currentFormatted string?)
(s/def ::current number?)
(s/def ::taxRate integer?)
(s/def ::currentTaxless double?)
(s/def ::original number?)
(s/def ::originalFormatted string?)
(s/def ::value double?)
(s/def ::symbol string?)
(s/def ::taxless double?)
(s/def ::unit (s/nilable (s/keys :req-un [::symbol
                                          ::taxless
                                          ::value])))
(s/def ::originalTaxless double?)
(s/def ::discountPercentage (s/nilable integer?))
(s/def ::price (s/or :map (s/keys :req-un [::current
                                           ::currentFormatted
                                           ::currentTaxless
                                           ::deposit
                                           ::discount
                                           ::discountAmount
                                           ::discountPercentage
                                           ::original
                                           ::originalFormatted
                                           ::originalTaxless
                                           ::taxRate
                                           ::unit])
                     :simple ::monthlySum))
(s/def ::pickup (s/or :map (s/keys :req-un [::pak])
                      :simple ::isIntraCommunitySaleBlocked))
(s/def ::shipmentPrices (s/coll-of (s/keys :req-un [::id
                                                    ::name
                                                    ::pickup
                                                    ::price])))
(s/def ::vak boolean?)
(s/def ::visible #{1 true false})
(s/def ::verifiedAt ::timestamp)
(s/def ::ribbons (s/coll-of #{"new"
                              "outlet"
                              "eol"}))
(s/def ::shopAreaName string?)
(s/def ::locationId integer?)
(s/def ::floor integer?)
(s/def ::shopAreas (s/coll-of (s/keys :req-un [::floor
                                               ::locationId
                                               ::shopAreaName])))
(s/def ::ageLimit #{0 7})
(s/def ::hidePriceHistory boolean?)
(s/def ::active boolean?)
(s/def ::demoLocations (s/coll-of string?))
(s/def ::sv (s/nilable string?))
(s/def ::ingredients (s/keys :req-un [::fi
                                      ::sv]))
(s/def ::installation nil?)
(s/def ::categories (s/coll-of string?))
(s/def ::pid integer?)
(s/def ::isSoldOut boolean?)
(s/def ::normalSalesBlocked boolean?)
(s/def ::marketableTo (s/nilable string?))
(s/def ::marketableFrom string?)
(s/def ::activeText string?)
(s/def ::tags (s/coll-of string?)) 
(s/def ::hasDiscount boolean?)
(s/def ::description (s/nilable (s/or :map ::bulletPoints
                                      :simple string?)))
(s/def ::campaigns (s/coll-of (s/keys :req-un [::activeText
                                               ::beginAt
                                               ::description
                                               ::discountType
                                               ::endAt
                                               ::hasDiscount
                                               ::id
                                               ::isSoldOut
                                               ::marketableFrom
                                               ::marketableTo
                                               ::name
                                               ::normalSalesBlocked
                                               ::tags
                                               ::visible])))
(s/def ::warranty #{"3" "60" "18" "36" "12" "24" "6" "0"})
(s/def ::maxAmountPerOrder (s/nilable integer?))
(s/def ::support string?)
(s/def ::url string?)
(s/def ::slug string?)
(s/def ::brand (s/keys :req-un [::id
                                ::name
                                ::slug
                                ::support
                                ::url]))
(s/def ::eans (s/coll-of string?))
(s/def ::descriptionShort (s/or :map ::bulletPoints
                                :simple ::freeShipmentFor))
(s/def ::marketingImages (s/coll-of any?))
(s/def ::bulletPoints (s/keys :req-un [::fi]))
(s/def ::productId string?)
(s/def ::clickURL string?)
(s/def ::freeShipmentFor #{""})
(s/def ::hasDetails boolean?)
(s/def ::createdAt ::timestamp)
(s/def ::isFireSale boolean?)
(s/def ::image-label (s/or :original #{:orig}
                           :number integer?))
(s/def ::images (s/coll-of (s/map-of ::image-label string?)))
(s/def ::extended (s/coll-of any?))
(s/def ::vakType nil?)
(s/def ::releasedAt ::timestamp)
(s/def ::mpns (s/coll-of string?))
(s/def ::bundles (s/coll-of ::pid))
(s/def ::recommended (s/coll-of integer?))
(s/def ::newer (s/coll-of ::pid))
(s/def ::older (s/coll-of ::pid))
(s/def ::relations (s/keys :req-un [::bundles
                                    ::newer
                                    ::older
                                    ::recommended]))
(s/def ::electronic boolean?)
(s/def ::installationAvailable boolean?)
(s/def ::quantity integer?)
(s/def ::bundleProducts (s/coll-of (s/keys :req-un [::pid
                                                    ::quantity])))
(s/def ::time string?)
(s/def ::tooltip (s/coll-of string?))
(s/def ::text string?)
(s/def ::uiLabels (s/nilable (s/keys :req-un [::price
                                              ::text
                                              ::time
                                              ::tooltip])))
(s/def ::totalAmount number?)
(s/def ::monthlyAmount number?)
(s/def ::monthlySum (s/or :number number?
                          :string string?))
(s/def ::months integer?)
(s/def ::fee number?)
(s/def ::arrangementFee number?)
(s/def ::annualInterestRate number?)
(s/def ::interest number?)
(s/def ::installments (s/nilable (s/coll-of (s/keys :req-un [::annualInterestRate
                                                             ::arrangementFee
                                                             ::fee
                                                             ::interest
                                                             ::monthlyAmount
                                                             ::monthlySum
                                                             ::months
                                                             ::totalAmount]
                                                    :opt-un [::provider ::providerId]))))
(s/def ::companyFinancing (s/nilable (s/keys :req-un [::installments
                                                      ::uiLabels])))
(s/def ::provider string?)
(s/def ::providerId integer?)
(s/def ::financing (s/keys :req-un [::installments
                                    ::type
                                    ::uiLabels]
                           :opt-un [::companyFinancing
                                    ::price]))
(s/def ::updatedAt ::timestamp)
(s/def ::addToCartURL string?)
(s/def ::isShippingAllowed boolean?)
(s/def ::minDays (s/nilable integer?))
(s/def ::isAvailable boolean?)
(s/def ::maxDays (s/nilable integer?))
(s/def ::stock integer?)
(s/def ::isPurchasable boolean?)
(s/def ::stockStatus #{"exact" "above" "below"})
(s/def ::pak (s/keys :req-un [::stock
                              ::stockStatus]
                     :opt-un [::isAvailable
                              ::isPurchasable
                              ::maxDays
                              ::minDays]))
(s/def ::vendor (s/keys :req-un [::stock
                                 ::stockStatus]))
(s/def ::js (s/keys :opt-un [::isAvailable
                             ::isPurchasable
                             ::maxDays
                             ::minDays
                             ::stock
                             ::stockStatus]))
(s/def ::warehouses (s/keys :req-un [::js
                                     ::pak]
                            :opt-un [::vendor]))
(s/def ::ranking #{"low" "none" "high" "medium"})
(s/def ::web (s/keys :req-un [::isAvailable
                              ::isPurchasable
                              ::ranking]
                     :opt-un [::maxDays
                              ::minDays
                              ::stock
                              ::stockStatus
                              ::warehouses]))
(s/def ::pir (s/keys :req-un [::isAvailable
                              ::isPurchasable]
                     :opt-un [::maxDays
                              ::minDays
                              ::stock
                              ::stockStatus]))
(s/def ::oul (s/keys :req-un [::isAvailable
                              ::isPurchasable]
                     :opt-un [::maxDays
                              ::minDays
                              ::stock
                              ::stockStatus]))
(s/def ::rai (s/keys :req-un [::isAvailable
                              ::isPurchasable]
                     :opt-un [::maxDays
                              ::minDays
                              ::stock
                              ::stockStatus]))
(s/def ::js_kioski (s/keys :req-un [::isAvailable
                                    ::isPurchasable]
                           :opt-un [::maxDays
                                    ::minDays
                                    ::stock
                                    ::stockStatus]))
(s/def ::stores (s/keys :req-un [::js
                                 ::js_kioski
                                 ::oul
                                 ::pir
                                 ::rai]))
(s/def ::stocks (s/keys :req-un [::stores]
                        :opt-un [::pickup ::web]))
(s/def ::isElectronic boolean?)
(s/def ::isFastDeliveryAvailable boolean?)
(s/def ::isStoreOrderAllowed boolean?)
(s/def ::isInStoresOnly boolean?)
(s/def ::hasStock boolean?)
(s/def ::isEOL boolean?)
(s/def ::isStockVisible boolean?)
(s/def ::isPickupAllowed boolean?)
(s/def ::overrideText (s/nilable string?))
(s/def ::isReleased boolean?)
(s/def ::isVirtual boolean?)
(s/def ::_id string?)
(s/def ::updateStartTime ::timestamp)
(s/def ::availability (s/keys :req-un [::_id
                                       ::hasStock
                                       ::isEOL
                                       ::isElectronic
                                       ::isFastDeliveryAvailable
                                       ::isInStoresOnly
                                       ::isPickupAllowed
                                       ::isPurchasable
                                       ::isReleased
                                       ::isShippingAllowed
                                       ::isSoldOut
                                       ::isStockVisible
                                       ::isStoreOrderAllowed
                                       ::isVirtual
                                       ::overrideText
                                       ::pid
                                       ::stocks
                                       ::tags
                                       ::updateCount
                                       ::updateStartTime
                                       ::updatedAt
                                       ::verifiedAt]))
(s/def ::pickupAllowed (s/coll-of any?))
(s/def ::isRestricted boolean?)
(s/def ::postalCodeAllowed (s/coll-of any?))
(s/def ::restrictions (s/keys :req-un [::description
                                       ::descriptionShort
                                       ::isRestricted
                                       ::pickupAllowed
                                       ::postalCodeAllowed]))
(s/def ::popularity integer?)
(s/def ::weight integer?)
(s/def ::depth integer?)
(s/def ::height integer?)
(s/def ::volume integer?)
(s/def ::width integer?)
(s/def ::package (s/keys :req-un [::depth
                                  ::height
                                  ::volume
                                  ::weight
                                  ::width]))
(s/def ::isIntraCommunitySaleBlocked boolean?)
(s/def ::path (s/coll-of (s/keys :req-un [::id
                                          ::name])))
(s/def ::category (s/keys :req-un [::id
                                   ::name
                                   ::path
                                   ::slug]))
(s/def ::product (s/keys :req-un [::active
                                  ::addToCartURL
                                  ::ageLimit
                                  ::availability
                                  ::brand
                                  ::bulletPoints
                                  ::bundleProducts
                                  ::campaigns
                                  ::categories
                                  ::category
                                  ::clickURL
                                  ::createdAt
                                  ::demoLocations
                                  ::description
                                  ::descriptionShort
                                  ::eans
                                  ::electronic
                                  ::extended
                                  ::financing
                                  ::freeShipmentFor
                                  ::hasDetails
                                  ::hidePriceHistory
                                  ::href
                                  ::images
                                  ::installation
                                  ::installationAvailable
                                  ::isFireSale
                                  ::isIntraCommunitySaleBlocked
                                  ::links
                                  ::marketingImages
                                  ::maxAmountPerOrder
                                  ::mpns
                                  ::name
                                  ::package
                                  ::pid
                                  ::popularity
                                  ::price
                                  ::productId
                                  ::rating
                                  ::relations
                                  ::releasedAt
                                  ::restrictions
                                  ::ribbons
                                  ::shipmentPrices
                                  ::shopAreas
                                  ::updateCount
                                  ::updateStartTime
                                  ::vak
                                  ::vakType
                                  ::verifiedAt
                                  ::visible
                                  ::warranty]
                         :opt-un [::ingredients
                                  ::updatedAt]))

(s/def ::products (s/coll-of ::product))
(s/def ::pageNo nat-int?)
(s/def ::numPages nat-int?)
(s/def ::totalItems nat-int?)

(s/def ::search-response (s/keys :req-un [::products
                                          ::pageNo
                                          ::numPages
                                          ::totalItems]))
