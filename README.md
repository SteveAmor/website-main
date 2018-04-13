# Cornwall Tech Jam website static site generator

This project is used to generate the website:

http://www.cornwalltechjam.uk

The live site's repository can be found here:

https://github.com/CornwallTechJam/cornwalltechjam.github.io

## Getting started

The website is built using Stasis, a static site generator written in Clojure:

https://github.com/magnars/stasis

We use Leiningen to automate the build process, install `lein` to begin:

http://leiningen.org/

Clone the repo and then run the following command from the root directory:

~~~~
$ lein build-site
~~~~

The website will be generated in the `build` directory.

Test the website in your browser by running the following command to start a local webserver:

~~~~
$ lein ring server
~~~~

Your browser should automatically open.

If you wish to set the site live the [live site repository](https://github.com/CornwallTechJam/cornwalltechjam.github.io) needs to be updated. For example:

~~~~
$ rsync --dry-run -avc \
/path/to/this/repo/build/ \
/path/to/cornwalltechjam.github.io/
~~~~

(Remove `--dry-run` to update the files.)

## Updating the code

You can edit the code using any text-editor. However, there are syntax-aware editors which make writing and updating Clojure (and Lisp) a joy.

The site was originally developed in Emacs using clojure-mode and cider. Clojure for the Brave is a good reference to get started:

http://www.braveclojure.com/basic-emacs/

There are other editors available which might be a little simpler for those not already using Emacs (although Emacs is well worth trying):

* [Light Table](http://lighttable.com/)
* [Nightcode](https://sekao.net/nightcode/)
