package com.techblogon.loginexample;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import android.app.ListActivity;
//import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
//import android.widget.LinearLayout;
//import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class HomePage extends ListActivity{

	/**
	 * @param args
	 */
	Button btnAddMember;
	PrescriptionDataBaseAdapter prescDataBaseAdapter;
	String username1;
	TextView message;
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     Bundle bundle = getIntent().getExtras();
	     String message = bundle.getString("message");
	     username1=message;
	     prescDataBaseAdapter=new PrescriptionDataBaseAdapter(this);
		 prescDataBaseAdapter=prescDataBaseAdapter.open();
		 message= "Hi " + message + "!";
	   //  setContentView(R.layout.homepage);
	     
		 

		 
		 
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
/*		 btnAddMember=(Button)findViewById(R.id.buttonAddMember);
		 btnAddMember.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					/// Create Intent for SignUpActivity  and Start The Activity
			//		String message=userName;
					Intent intentAddMember=new Intent(getApplicationContext(),AddMemberActivity.class);
					intentAddMember.putExtra("mes", username1);
					startActivity(intentAddMember);
					}
				});
		 	*/
	
		 List<String> membernames = new LinkedList<String>();
		 membernames=PrescriptionDataBaseAdapter.getMembers(username1);
	//	 System.out.println(membernames);
		
		 this.setListAdapter(new ArrayAdapter<String>(this, R.layout.homepage, R.id.label, membernames));
		 ListView lv = getListView();
		 
	        // listening to single list item on click
	        lv.setOnItemClickListener(new OnItemClickListener() {
	          public void onItemClick(AdapterView<?> parent, View view,
	              int position, long id) {
	               
	              // selected item 
	              String product = ((TextView) view).getText().toString();
	               
	              // Launching new Activity on selecting single List Item
	              Intent i = new Intent(getApplicationContext(), ViewMedicine.class);
	              // sending data to new activity
	              i.putExtra("use1", username1);
	              i.putExtra("memname", product);
	              startActivity(i);
	             
	          }
	        });
	        TextView textView = new TextView(this);
			 textView.setTextSize(20);
			 textView.setText(message);//

	  		
	        
		 /*	 TextView t1=new TextView(this); 
	//	 System.out.println(Arrays.toString(list.toArray()));
		 String ans=new String();
		 t1=(TextView)findViewById(R.id.text1);
		 for (String strings : membernames) {
			    ans=ans+strings + "\n";
			}
		 t1.setText(ans); */ 
		 
	/*	 String[] textArray={"one","two","asdasasdf asdf dsdaa"};
		 int length=textArray.length;
		 LinearLayout layout = new LinearLayout(this);
		 setContentView(layout);
		 layout.setOrientation(LinearLayout.VERTICAL);        
		 for(int i=0;i<length;i++)
		 {
		     TextView tv=new TextView(getApplicationContext());
		     tv.setText(textArray[i]);
		     layout.addView(tv);
		 } */
		 

		    // Set the text view as the activity layout
	//	 setContentView(textView);
	     
	}
}

