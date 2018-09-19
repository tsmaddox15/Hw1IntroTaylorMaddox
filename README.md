Homework 1 Taylor Maddox
========================
__App is designed for min API level of 22 (Android 5.1 Lolipop) and targeted for android 8.0 Oreo.__

To access main java files go to path: Hw1IntroTaylorMaddox/app/src/main/java/com/example/tsmad_000/hw1introtaylormaddox

For XML:
Hw1IntroTaylorMaddox/app/src/main/res/layout/

Main activity
-----------------
When you start up the app it will take you to the main activity which will contain two buttons. These use an onclick() event handler to determine which activity you want to go to.
![Imgur](https://i.imgur.com/GPFJgGq.png)

Part1
----------------
Part 1 has 3 main components. An editText object where the user can type in it. A button that will change the color of the editText, and a textView that displays the current color in rgb and hexadecimal.

![Imgur](https://i.imgur.com/c5Zv5N6.png)

Part 2
----------------
User can draw on canvas with their finger.

The app has an action bar at the top right which gives the user the options to:
* change color
* clear canvas
* save image

![Imgur](https://i.imgur.com/4KQWZzK.png)

The window:

![Imgur](https://i.imgur.com/rV41RF4.png)

#### Change Color

Brings up a pop up screen which lets you input rgb values form 1-256 for the paint you want.

![Imgur](https://i.imgur.com/4Yj0gqI.png)

#### Clear Canvas

Resets the canvas. This also resets the paint back to black.(rgb= 0,0,0)

#### Save Image

Saves an image to the directory /storage/sdcard0/hw/currentTime.png where __currentTime__ is the time the user saved the image.

__Note:__ sdcard0 is NOT an actual sd card. It is actually internal memory. Read [here](https://www.quora.com/Why-is-Androids-internal-memory-called-sdcard0) for why that is.

__Error Found:__ When saving to the directory the bitmap is only receiving the background image and not receiving the paint strokes.

Image of my gallary with save attempts:

![Imgur](https://i.imgur.com/oJCxcj1.png)

Design
----------------
### Part 1
Part one had very little functionality only using one java class which only did anything when the button to change colors was pressed.

### Part 2
Part two had composed of several classes including .java files:
* part2
* touchView
* Stroke
* Pop
* SaveFile

###### part2.java:

Connects to the activity for part2. Used to handle the logic of the activity. Mainly used for handing actions with the action bar using a switch.

###### touchView.java:
Where the actual drawing happens. View of part 2. Has a Canvas where user draws with Path objects. Color of the path is defined by the paint object.

###### Pop.java:
Brings up the pop up screen that's used for color selection. Passes the int values for the colors using Bundle and Intent to the part2.java where it sets the values for 3 int global variables, red, green, blue. Invoked by a switch statement in part2.java.

###### Stroke.java:
Holds Strokes which holds paths and paints. I created this class to handle the color change for painting. It creates a stroke in pointdown() in touchView.java which is stored in an array that is used for drawing. This makes sure that each stroke the user makes has the correct color without affecting any paths already created.

###### SaveFile.java:
Saves the the Bitmap object that was created in touchView to the phone's internal storage. Invoked in a switch statement in part2.java
