/**
 * Author: Ryan Koeller
 * Course: CEG-4110-01 Fall 2018
 * Assignment: Homework #1
 * Professor: Dr. Derek Doran
 * Date: 9/8/2018
 */

package com.example.ryankoeller.colorpickeranddrawingpanel;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void changeActivity(View view)
	{
		startActivity(new Intent(MainActivity.this, DrawingActivity.class));
	}

	public void changeColor(View view)
	{
		EditText txtColorText = findViewById(R.id.txtColorText);
		Random rand = new Random();

		// Generate random ints 0 - 255
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);

		// Convert random ints into hex strings
		String hexR = Integer.toHexString(r);
		String hexG = Integer.toHexString(g);
		String hexB = Integer.toHexString(b);

		// If an int <= 15 was generated then concatenate a 0 to the beginning of the String
		if(hexR.length() == 1)
		{
			hexR = "0" + hexR;
		}
		if(hexG.length() == 1)
		{
			hexG = "0" + hexG;
		}
		if(hexB.length() == 1)
		{
			hexB = "0" + hexB;
		}

		// Colors take the format alpha,red,green,blue
		// #ff alpha is 100% opaque
		String aarrggbb = "#ff" + hexR +hexG + hexB;

		try {
			txtColorText.setTextColor(Color.parseColor(aarrggbb));
		}
		catch(IllegalArgumentException  e) {
			txtColorText.setText(e.getMessage());
		}

		// Change aarrggbb into HTML color hex
		String html = "#" + aarrggbb.substring(3).toUpperCase();
		TextView txtRgbValues = findViewById(R.id.txtRbgValues);
		txtRgbValues.setText("COLOR: " + r + "r, " + g + "g, " + b + "b, " + html);
		txtRgbValues.setVisibility(View.VISIBLE);
	}
}
