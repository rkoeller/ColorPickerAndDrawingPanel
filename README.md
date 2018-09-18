# Color Picker and Drawing Panel
<p>ColorPickerAndDrawingPanel is an app developed for Android 8.0 Oreo. It allows the user to change text color in a text box randomly and draw to the screen with a selected color and the ability to save the drawing.</p>
## Installation Requirements
* Android 8.0 device
## Usage
<p>Once started the app will open the ColorPicker activity where the user can type text into a EditText object and/or press the "tap me" button to change the text color of the EditText object randomly. The "tap me" button will also display a TextView object with information about the random color picked by the app such as, rgb values and HTML color code.</p>
<p>A second button in the lower right-hand corner of the screen is used to changed to the DrawingPanel activity. The DrawingPanel activity will display a white screen where the user may touch with their finger and draw colored lines on the screen. In the upper right-hand corner of the screen is an options menu where the user can change the color of the next line drawn, save the drawing as a PNG or JPG, or clear the screen. Saving the drawing will save to the devices internal memory at location "/Pictures/" as "drawing.png" or "drawing.jpg". To return to the ColorPicker activity the user must press the back button on their device.</p>
## Build
Built with Android Studio 3.1.4; no external libraries should be needed.
### Contributors
* Ryan Koeller