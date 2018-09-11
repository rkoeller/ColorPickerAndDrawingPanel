package com.example.ryankoeller.colorpickeranddrawingpanel;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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
	}

	// Options Menu learned from
	// https://code.tutsplus.com/tutorials/android-sdk-implement-an-options-menu--mobile-9453
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.my_options_menu, menu);
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
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	public void changeActivity(View view)
	{
		// finish() allows android back arrow to work correctly
		finish();
	}

}
