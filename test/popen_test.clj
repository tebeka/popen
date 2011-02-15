(ns popen-test
  (:use [popen] :reload-all)
  (:use [clojure.test]))

(deftest popen-test
  (let [p (popen/popen ["ls" "/tmp"])]
    (is (instance? Process p))
    (is (not (nil? (popen/stdout p))))
    (is (not (nil? (popen/stderr p))))
    (is (zero? (popen/join p)))
    (is (zero? (popen/exit-code p)))
    (is (nil? (popen/kill p)))))

