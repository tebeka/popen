=====
popen
=====

About
=====
popen is a subprocess library for Clojure.

Usage
=====

`(popen ["ls" "-a" "/tmp"] :redirect false :dir nil :env {})`
    Open a child process. Optional parameters are `redirect` to redirect stderr
    to stdout, `dir` to start with a different working directory and `env` to
    pass additional environment variables as a map. Returns the process object.

`(popen* ["ls" "-a" "/tmp"] :redirect false :dir nil :env {})`
    Same as `popen`, returns the process stdout stream.

`(stdout process)`
    Return the standard output of the process (for reading).

`(stderr process)`
    Return the standard error of the process (for reading).

`(stdin process)`
    Return the standard input of the process (for writing).
    
`(join process)`
    Wait for process termination, return exit code.

`(exit-code process)`
    Return the exit code of the process, will wait for termination.

`(running? process)`
    Return true if process still running.

`(kill process)`
    Kills (terminates) the process.
    

License
=======
Copyright (C) 2013 Miki Tebeka <miki.tebeka@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure.
