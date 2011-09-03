package com.waheed.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodolistActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ListView listView=(ListView)findViewById(R.id.myListView);
        final EditText editText=(EditText)findViewById(R.id.myEditText);
        
        final ArrayList<String> todoItems=new ArrayList<String>();
        int resID=R.layout.todolist_item;
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,resID,todoItems);
        
        listView.setAdapter(adapter);
        
        editText.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(event.getAction()== KeyEvent.ACTION_DOWN) {
					if(keyCode==KeyEvent.KEYCODE_DPAD_CENTER) {
						todoItems.add(0,editText.getText().toString());
						adapter.notifyDataSetChanged();
						editText.setText("");
						return true;
					}
				}
				return false;
			}
		});
    }
}