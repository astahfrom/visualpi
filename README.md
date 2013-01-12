# VisualPi

A simulation of the Monte Carlo method of approximating pi.

It uses the brilliant [Quil](https://github.com/quil/quil) library to do the
drawing.
Besides that it's very simple, it supports resizing, but that's about
it.
It just draws a lot of dots.
If they're within radius of the
inscribed circle they're colored red, if not they're colored blue.
Pi is approximate to the ratio between dots in the circle and all the dots.

The current approximation of pi is shown in black.
The number of red dots in red and blue dots in blue.

## Usage

It's a [Leiningen](https://github.com/technomancy/leiningen) project so you can just pull it and run `lein run` or
whatever.
There's also an `uberjar` available.

## License

Copyright © 2013 Andreas From

Distributed under the Eclipse Public License, the same as Clojure.
