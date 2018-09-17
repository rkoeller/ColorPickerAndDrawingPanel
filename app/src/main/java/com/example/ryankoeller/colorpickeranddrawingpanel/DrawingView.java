/**
 * Author: Ryan Koeller
 * Course: CEG-4110-01 Fall 2018
 * Assignment: Homework #1
 * Professor: Dr. Derek Doran
 * Date: 9/8/2018
 */

package com.example.ryankoeller.colorpickeranddrawingpanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
	private Paint myPaint;
	private Path path;
	private ArrayList<Path> myPaths;
	private ArrayList<Paint> myPaints;
	boolean saveNewPath;

	public DrawingView(Context context) {
		super(context);
		path = new Path();
		myPaths = new ArrayList<>();
		myPaint = new Paint();
		myPaints = new ArrayList<>();
		saveNewPath = true;

		// Various paint options
		myPaint.setColor(Color.BLACK);
		myPaint.setAntiAlias(true);
		myPaint.setStrokeWidth(10);
		myPaint.setStyle(Paint.Style.STROKE);
		myPaint.setStrokeJoin(Paint.Join.ROUND);
		myPaint.setStrokeCap(Paint.Cap.ROUND);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawPath(path, myPaint);
		for(int i = 0; i < myPaths.size(); i++)
		{
			canvas.drawPath(myPaths.get(i), myPaints.get(i));
		}
	}

	// Tutorials used for learning and understanding touch drawing
	// * Used to learn how to make a custom view
	// https://www.youtube.com/watch?v=Jzi5utUH-Jg/

	// * Used to learn how to make a path drawn by the user's finger
	// http://valokafor.com/android-drawing-app-tutorial-part-1/

	// * Additional drawing help
	// https://medium.com/@ssaurel/learn-to-create-a-paint-application-for-android-5b16968063f8
	// Comments are mostly here to help myself understand

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// getX and getY return floats
		float x = event.getX();
		float y = event.getY();

		// MotionEvent.ACTION_DOWN is when the user touches the screen for the first time
		// MotionEvent.ACTION_MOVE is when the user slides their finger across the screen
		// MotionEvent.ACTION_UP is when the user removes their finger from the screen
		switch(event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				// Moves the "cursor" to where the user touched
				// Like a mouse click
				if(saveNewPath) {
					myPaths.add(new Path(path));
					myPaints.add(new Paint(myPaint));
				}
				path = new Path();
				path.moveTo(x, y);
				break;
			case MotionEvent.ACTION_MOVE:
				// Drags does the "cursor" to where the user moved
				// Like dragging a mouse
				path.lineTo(x, y);
				break;
			case MotionEvent.ACTION_UP:
				// Drags the "cursor" to where the user last touched before releasing
				// Like releasing a mouse click
				path.lineTo(x, y);
				saveNewPath = true;
				break;
			default:
				return false;
		}

		// Even though we have created part of the path, it has not been drawn yet
		// invalidate() redraws the canvas so we can see the path's new coordinates
		invalidate();

		return true;
	}

	public void setSelectedColor(int color) {
		myPaths.add(new Path(path));
		myPaints.add(new Paint(myPaint));
		saveNewPath = false;
		this.myPaint.setColor(color);
	}

	public void clear() {
		path.reset();
		myPaths.clear();
		myPaints.clear();
		myPaint.setColor(Color.BLACK);
		saveNewPath = true;
		invalidate();
	}
}
