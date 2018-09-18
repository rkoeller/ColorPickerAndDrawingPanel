# Color Picker and Drawing Panel
ColorPickerAndDrawingPanel is an app developed for Android 8.0 Oreo. It allows the user to change text color in a text box randomly and draw to the screen with a selected color and the ability to save the drawing.
## Installation Requirements
* Android 8.0 device
## Usage
Once started the app will open the ColorPicker activity where the user can type text into a EditText object and/or press the "tap me" button.
![Alt text](/gitImages/colorPicker1.jpg?raw=true "Color Picker Activity")

The "tap me" button will change the text color of the EditText object randomly and display a TextView object with information about the random color picked by the app such as, RGB values and HTML color code.

![Alt text](/gitImages/colorPicker2.jpg?raw=true "Color Picker Button Pressed")

A second button in the lower right-hand corner of the screen is used to changed to the DrawingPanel activity.

![Alt text](/gitImages/drawingActivityButton.jpg?raw=true "Drawing Panel Button")

The DrawingPanel activity will display a white screen where the user may touch with their finger and draw colored lines on the screen.

![Alt text](/gitImages/drawingPanel1.jpg?raw=true "Drawing Panel Activity")

In the upper right-hand corner of the screen is an options menu where the user can change the color of the next line drawn, save the drawing as a PNG or JPG, or clear the screen.

![Alt text](/gitImages/drawingPanel2.jpg?raw=true "Drawing Panel Menu Button")
![Alt text](/gitImages/drawingMenu.jpg?raw=true "Drawing Panel Menu")
![Alt text](/gitImages/drawingColor.jpg?raw=true "Color Options")
![Alt text](/gitImages/drawing1.jpg?raw=true "Drawing Example")

Saving the drawing will save to the devices internal memory at location "/Pictures/" as "drawing.png" or "drawing.jpg". To return to the ColorPicker activity the user must press the back button on their device.

![Alt text](/gitImages/drawingSave.jpg?raw=true "Save Options")
## Build
Built with Android Studio 3.1.4; no external libraries should be needed.
## Author
* Ryan Koeller
