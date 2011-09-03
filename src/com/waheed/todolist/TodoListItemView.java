package com.waheed.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class TodoListItemView extends TextView {
	
	private Paint marginPaint;
	private Paint linePaint;
	private int paperColor;
	private float margin;
	
	// Constructor required for inflation from resources file
	public TodoListItemView(Context context,AttributeSet ats, int defaultStyle) {
		super(context,ats,defaultStyle);
		init();
	}
	
	//Constructor required for in-code creation
	public TodoListItemView(Context context) {
		super(context);
		init();
	}
	
	//Constructor required for inflation from resources file
	public TodoListItemView(Context context, AttributeSet ats) {
		super(context,ats);
		init();
	}
	 
	public void init() {
		//Get a reference to your resource table
		Resources resources=getResources();
		
		//create the paint brush
		marginPaint= new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(resources.getColor(R.color.notepad_margin));
		
		//brush for Horizontal line
		linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(resources.getColor(R.color.notepad_lines));
		
		//paper background
		paperColor=resources.getColor(R.color.notepad_paper);
		
		//margin width
		margin=resources.getDimension(R.dimen.notepad_margin);
	}

	/*
	 * Draw your visual interface 
	 */
	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawColor(paperColor);
		
		// Draw Horizontal line
		canvas.drawLine(0, 0, getMeasuredWidth(), 0, linePaint);
		canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);
		
		//Draw Vertical Line
		canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);
		
		canvas.save();
		canvas.translate(margin, 0);
		super.onDraw(canvas);
		canvas.restore();
		
	}
}
