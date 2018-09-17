/**
 * Author: Ryan Koeller
 * Course: CEG-4110-01 Fall 2018
 * Assignment: Homework #1
 * Professor: Dr. Derek Doran
 * Date: 9/8/2018
 */

package com.example.ryankoeller.colorpickeranddrawingpanel;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DrawingActivity extends AppCompatActivity {

	DrawingView drawingView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set activity_drawing.xml to view
		setContentView(R.layout.activity_drawing);

		// Add drawingView to ConstraintLayout and display
		drawingView = new DrawingView(this.getBaseContext());
		ConstraintLayout l = findViewById(R.id.layout);
		l.addView(drawingView);
		ActivityCompat.requestPermissions(DrawingActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
	}

	// Options Menu learned from
	// https://code.tutsplus.com/tutorials/android-sdk-implement-an-options-menu--mobile-9453
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.black:
				drawingView.setSelectedColor(Color.BLACK);
				return true;
			case R.id.red:
				drawingView.setSelectedColor(Color.RED);
				return true;
			case R.id.orange:
				drawingView.setSelectedColor(Color.rgb(255,165,0));
				return true;
			case R.id.yellow:
				drawingView.setSelectedColor(Color.YELLOW);
				return true;
			case R.id.green:
				drawingView.setSelectedColor(Color.GREEN);
				return true;
			case R.id.blue:
				drawingView.setSelectedColor(Color.BLUE);
				return true;
			case R.id.violet:
				drawingView.setSelectedColor(Color.rgb(238,130,238));
				return true;
			case R.id.savePng:
				save("png");
				return true;
			case R.id.saveJPG:
				save("jpg");
				return true;
			case R.id.clear:
				drawingView.clear();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	/* Checks if external storage is available for read and write */
	public boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		}
		Toast.makeText(this, "Storage is non writable.", Toast.LENGTH_SHORT).show();
		return false;
	}


	// Saving to external device learned from
	// https://developer.android.com/training/data-storage/files
	public void save(String fileType) {
		if(isExternalStorageWritable()) {
			// Should save to the external storage device such as a SD card
			// but it saves to internal storage for some reason...
			String path = Environment.getExternalStorageDirectory()+ "/Pictures/";
			File dir = new File(path);
			dir.mkdirs();
			File file = new File(dir, "drawing." + fileType);

			Bitmap bitmap = Bitmap.createBitmap(drawingView.getWidth(), drawingView.getHeight(), Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmap);

			// make the bitmap background white
			canvas.drawColor(Color.WHITE);

			// draw the drawing view to the canvas
			drawingView.draw(canvas);
			try (FileOutputStream out = new FileOutputStream(file)) {
				if(fileType.equals("png"))
				{
					bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
				}
				else
				{
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
				}
				out.flush();
				out.close();
				Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
			}
			catch (IOException e) {
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void changeActivity(View view) {
		// finish() allows android back arrow to work correctly
		finish();
	}

}
