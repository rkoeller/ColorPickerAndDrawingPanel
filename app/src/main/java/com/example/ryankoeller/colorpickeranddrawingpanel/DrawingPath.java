package com.example.ryankoeller.colorpickeranddrawingpanel;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class DrawingPath extends Path {


	Paint paint;

	public DrawingPath() {
		super();
		paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(10);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);
	}

	public DrawingPath(Paint paint) {
		this.paint = paint;
	}

	public DrawingPath(Path src) {
		super(src);
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaintColor(int color) {
		this.paint.setColor(color);
	}
}
