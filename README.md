# Color Picker and Drawing Panel
ColorPickerAndDrawingPanel is an app developed for Android 8.0 Oreo. It allows the user to change text color in a text box randomly and draw to the screen with a selected color and the ability to save the drawing.
## Installation Requirements
* Android 8.0 device
## Installation
* Store app-release.apk into android device
* Navigate to .apk in your android's file system
* Tap .apk to start installation
* Follow on screen instructions
## Usage
Once started the app will open the ColorPicker activity where the user can type text into a EditText object and/or press the "tap me" button.
<br />
![](/gitImages/colorPicker1.jpg?raw=true "Color Picker Activity")

The "tap me" button will change the text color of the EditText object randomly and display a TextView object with information about the random color picked by the app such as, RGB values and HTML color code.
<br />
![](/gitImages/colorPicker2.jpg?raw=true "Color Picker Button Pressed")

A second button in the lower right-hand corner of the screen is used to changed to the DrawingPanel activity.
<br />
![](/gitImages/drawingActivityButton.jpg?raw=true "Drawing Panel Button")

The DrawingPanel activity will display a white screen where the user may touch with their finger and draw colored lines on the screen.
<br />
![](/gitImages/drawingPanel1.jpg?raw=true "Drawing Panel Activity")

In the upper right-hand corner of the screen is an options menu where the user can change the color of the next line drawn, save the drawing as a PNG or JPG, or clear the screen.
<br />
![](/gitImages/drawingPanel2.jpg?raw=true "Drawing Panel Menu Button")
![](/gitImages/drawingMenu.jpg?raw=true "Drawing Panel Menu")
![](/gitImages/drawingColor.jpg?raw=true "Color Options")
![](/gitImages/drawing1.jpg?raw=true "Drawing Example")

Saving the drawing will save to the devices internal memory at location "/Pictures/" as "drawing.png" or "drawing.jpg". To return to the ColorPicker activity the user must press the back button on their device.
<br />
![](/gitImages/drawingSave.jpg?raw=true "Save Options")
## Build
Built with Android Studio 3.1.4; no external libraries should be needed.
## Author
* Ryan Koeller
## Design Discussion
I basically started this app as an Android beginner; I had a mobile programming class six years prior to this but that is a century in the computer field. I had to do a lot of searches and look up a lot of tutorials to get started in Android Studio and had to apply from what I know from Visual Studio GUI development to it. Android programming seems a little more particular when it comes to grabbing GUI elements and setting element actions than Visual C#.

The color picker activity was not very hard and was a bit of fun trying to organize the data into AARRGGBB hex and HTML color code. When the "tap me" button is pressed a Random object is made and three ints are made with the values 0-255 inclusive. After, these ints are converted into String hex representations. The Strings are then concatenated together and #ff is appended to the beginning of the String to comply with the AARRGGBB format. Then the text color in the text box is changed to the value defined by the AARRGGBB String. To get the hex values back for the HTML code I just removed the "ff" at the beginning of the AARRGGBB String and saved it as another String. (Author's Note, I just realized I could have just done: html = "#" + hexR + hexG + hexB). After that is done then the calculated values are displayed in a TextView.

One problem I had with the color picker activity was sometimes the app would crash, if you hit the button enough eventually the app just crashed. The problem was when a integer <= 15 was converted, it was converted into a single hex character, crashing the app when passed into Color.parseColor(aarrggbb). I had to add a conditional to check the integer size and append a 0 to the hex value when <=15.

The drawing panel activity was a nightmare; learning how to make paths, create a menu, get touches from the menu, seting path colors, and saving were all harder than they should have been. So I'll give the short version of what happens when the user wants to draw. The drawing canvas is actually a separate view that is drawn over the normal view displayed when the drawing panel activity is loaded. Two objects are then made to color the user's movement across the screen, a Path object, and a Paint object. I had made a custom DrawingPath object to contain both the Path and the Paint but that was giving me unexpected error and had to be scrapped. In its place I made two parallel ArrayLists for the Paths and Paints to be stored. When the user touches the screen a new Path./Paint objects are made and then the app follows the users finger until pressure is released. Next time the user touches the screen the Path and Paint are stored in their ArrayLists. The app also tracks when a new Path and Paint object need to be made, when the user releases screen pressure, when a new paint is selected, and when the screen is cleared.

As said everything with the drawing panel was a nightmare; everything except the clear feature, that worked first try. A bug with the save feature is present and I don't know why it's happening. The app is supposed to save to external memory such as an SD card but inexplicably saves to internal memory. The code at line 111 in DrawingActivity.java "Environment.getExternalStorageDirectory()" gets the SD cards root directory but does not when saved. Perhaps its the Bitmap.compress method doing somthing funky. There is even code to ask external saving permissions and making sure external storage is writable. I don't know...

This was a new experience for me developing Android for the first time in years. I didn't think it would be so hard and advice I would give to future students is to remember that Android (and IOS for that matter) requires the user's permission before saving. Remember that and you might save yourself an hour or two.
