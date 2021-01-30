(ns re-demo.simple-v-table
  (:require
    [reagent.core          :as reagent]
    [re-com.core           :refer [h-box gap v-box v-table hyperlink-href p line]]
    [re-com.simple-v-table :refer [simple-v-table simple-v-table-args-desc]]
    [re-demo.utils         :refer [panel-title title2 args-table github-hyperlink status-text]]
    [re-demo.simple-v-table-sales :as simple-v-table-sales]
    [re-demo.simple-v-table-periodic-table :as simple-v-table-periodic-table]
    [re-com.util           :refer [px]]))

(defn panel
  []
  [v-box
   :size     "auto"
   :gap      "10px"
   :children [[panel-title "[simple-v-table ... ]"
                            "src/re_com/simple_v_table.cljs"
                            "src/re_demo/simple_v_table.cljs"]
              [h-box
               :gap      "106px"
               :children [[v-box

                           :width    "450px"
                           :children [[title2 "Notes"]
                                      [line]
                                      [gap :size (px 15)]
                                      [status-text "Alpha" {:color "red" :font-weight "bold"}]
                                      [gap :size (px 15)]
                                      [p "This component provides a table which virtualises row rendering. You can have 1M rows but only those currently viewable will be in the DOM."]
                                      [p [:code "simple-v-table"] " is built on " [:code "v-table"] " and it exists because " [:code "v-table"] " is too low level and complicated for everyday use."]
                                      [p "Features:"]
                                      [:ul
                                       [:li "Unlimited columns with a fixed column header at the top"]
                                       [:li "Unlimited (virtualised) rows with an ()optional) fixed row header at the left by simply specifying the number of columns to fix"]
                                       [:li "Most aspects of the table are stylable using the " [:code ":parts"] " argument that can set " [:code ":class"] " or " [:code ":style"] " attributes"]
                                       [:li "Individual rows can be dynamically styled based on row data"]
                                       [:li "Individual cells can be dynamically styled based on row data"]]
                                      [args-table simple-v-table-args-desc]]]
                          [v-box

                           :children [[title2 "Demos"]
                                      [line]
                                      [gap :size (px 15)]
                                      [simple-v-table-sales/demo]
                                      [gap :size "40px"]
                                      [line]
                                      [simple-v-table-periodic-table/demo]]]]]]])
