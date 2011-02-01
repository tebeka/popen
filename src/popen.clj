(ns popen
  (require [clojure.java.io :as io]))

(defn popen [& args]
  (let [builder (ProcessBuilder. args)]
    (.start builder)))

(defprotocol Popen
  (stdout [this] "Process standard output (read from)")
  (stdin [this] "Process standard input (write to)")
  (stderr [this] "Process standard error (write to)")
  (wait [this] "Wait for process to terminate, return exit code")
  (exit-code [this] "Process exit code (will wait for termination)")
  (running? [this] "Return true if process still running")
  (kill [this] "Kill process"))

(defn- exit-code- [p]
  (try
    (.exitValue p)
    (catch IllegalThreadStateException e)))

(extend-type java.lang.Process
  Popen
  (stdout [this] (io/reader (.getInputStream this)))
  (stdin [this] (io/writer (.getOutputStream this)))
  (stderr [this] (io/reader (.getErrorStream this)))
  (wait [this] (.waitFor this))
  (exit-code [this] (exit-code- this))
  (running? [this] (nil? (exit-code- this)))
  (kill [this] (.destroy this)))
