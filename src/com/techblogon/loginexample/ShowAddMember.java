package com.techblogon.loginexample;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
//import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.LinearLayout;
//import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class ShowAddMember extends Activity{

	/**
	 * @param args
	 */
	Button btnAddMember, btnShowMember;
	PrescriptionDataBaseAdapter prescDataBaseAdapter;
	String username1;
	String membername;
	TextView message;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.showaddmem);
	//     Bundle bundle = getIntent().getExtras();
	    Intent intent=getIntent();
	    String message = intent.getStringExtra("message");
	 //   String message=bundle.getString("use1");
	     username1=message;
	//     membername=intent.getStringExtra("memname");
	     prescDataBaseAdapter=new PrescriptionDataBaseAdapter(this);
		 prescDataBaseAdapter=prescDataBaseAdapter.open();
		 message= "Hi " + message + "!";
		 
		 TextView t=new TextView(this); 

		 t=(TextView)findViewById(R.id.text); 
		 t.setText(message);
	/*	 TextView t=new TextView(this); 

		 t=(TextView)findViewById(R.id.text); 
		 t.setText(message); */
	   
	  
	   
	   
		

  		

		 
		 
/*		 View header = (View)getLayoutInflater().inflate(R.layout.homepage, null);
		 TextView headerValue = (TextView) header.findViewById(R.id.text);
		 headerValue.setText(message);

//		 listView.addHeaderView(header);
//		 listView.setAdapter(adapter); */

		 
		 /*		 TextView t=new TextView(this); 

		 t=(TextView)findViewById(R.id.text); 
		 t.setText(message);
		 */
		 
	//	 username1=message;
		 btnAddMember=(Button)findViewById(R.id.buttonAddMember);
		 btnAddMember.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					/// Create Intent for SignUpActivity  and Start The Activity
			//		String message=userName;
					Intent intentAddMedicine=new Intent(getApplicationContext(),AddMemberActivity.class);
					intentAddMedicine.putExtra("mes", username1);
				//	intentAddMedicine.putExtra("mem1", membername);
					startActivity(intentAddMedicine);
					}
				}); 
		 btnShowMember=(Button)findViewById(R.id.buttonShowMember);
		 btnShowMember.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					/// Create Intent for SignUpActivity  and Start The Activity
			//		String message=userName;
					Intent intentAddMedicine=new Intent(getApplicationContext(),HomePage.class);
					intentAddMedicine.putExtra("message", username1);
			//		intentAddMedicine.putExtra("mem1", membername);
					startActivity(intentAddMedicine);
					}
				}); 
		 	
		
	     
	}
}

