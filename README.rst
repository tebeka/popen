=====
popen
=====

About
=====
popen is a subprocess library for Clojure.

Usage
=====

`(popen ["ls" "-a" "/tmp"] :redirect false :dir nil)`
    Open a child process. Optional parameters are `redirect` to redirect stderr
    to stdout and `dir` to start with a different working directory. Returns the
    process object.

`(popen* ["ls" "-a" "/tmp"] :redirect false :dir nil)`
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
Copyright (C) 2010 Miki Tebeka <miki.tebeka@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure.
