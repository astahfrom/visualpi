# VisualPi
A simulation of the Monte Carlo method of approximating pi.

It uses the brilliant [Quil](https://github.com/quil/quil) library to do the
drawing.
It just draws a lot of dots.
If they're within radius of the
inscribed circle they're colored red, if not they're colored blue.
Pi is approximate to the ratio between dots in the circle and all dots.

## Screenshot
Below is a screenshot of the application running on Windows.

![VisualPi](https://raw.github.com/andreasfrom/visualpi/master/visualpi.png "VisualPi on Windows")

The current approximation of pi is shown in black.
The number of red dots in red and blue dots in blue.

## Usage
The program supports 4 actions.

* "c" (clear) to clear the screen but preserve dots in memory.
* "r" (reset) to reset everything. That is, both clearing the screen and dot counts.
* \*space\* to start and stop the animation and calculation.
* \*mouse-click\* to save the current frame in the same folder as the program.  It is safe to save multiple images as these do not overwrite the previous.

## Download
There's an `uberjar` [externally available](http://rtgkom.dk/~andreashf11/visualpi.jar).

## Development
It's a [Leiningen](https://github.com/technomancy/leiningen) project and enables the use of both `lein run` and `lein repl`.

## Bugs
The screen clears itself when resizing the window.

## License

Copyright © 2013 Andreas From

Distributed under the Eclipse Public License, the same as Clojure.
