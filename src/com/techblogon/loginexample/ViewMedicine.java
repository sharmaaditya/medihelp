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

public class ViewMedicine extends Activity{

	/**
	 * @param args
	 */
	Button btnAddMedicine, btnViewMembers;
	PrescriptionDataBaseAdapter prescDataBaseAdapter;
	String username1;
	String membername;
	TextView message;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.viewmed);
	//     Bundle bundle = getIntent().getExtras();
	    Intent intent=getIntent();
	    String message = intent.getStringExtra("use1");
	 //   String message=bundle.getString("use1");
	     username1=message;
	     membername=intent.getStringExtra("memname");
	     prescDataBaseAdapter=new PrescriptionDataBaseAdapter(this);
		 prescDataBaseAdapter=prescDataBaseAdapter.open();
		 message= "Hi " + message + "!";
		 
		 TextView t=new TextView(this); 

		 t=(TextView)findViewById(R.id.text); 
		 t.setText(message);
		 
		 String memmsg="This is " + membername + "'s MediList!";
		 TextView t2=new TextView(this); 

		 t2=(TextView)findViewById(R.id.text2); 
		 t2.setText(memmsg);
		 
	   
	  
	   
	   
		

  		

		 
		 
/*		 View header = (View)getLayoutInflater().inflate(R.layout.homepage, null);
		 TextView headerValue = (TextView) header.findViewById(R.id.text);
		 headerValue.setText(message);

//		 listView.addHeaderView(header);
//		 listView.setAdapter(adapter); */

		 
		 /*		 TextView t=new TextView(this); 

		 t=(TextView)findViewById(R.id.text); 
		 t.setText(message);
		 */
		 
		 List<String[]> medList = new LinkedList<String[]>();
		 medList=PrescriptionDataBaseAdapter.getMedicines(username1, membername);
	//	 System.out.println(membernames);
		
		 String S="Med Name    Dose per Day    Days remaining";
		 TextView t3=new TextView(this); 

		 t3=(TextView)findViewById(R.id.text3); 
		 t3.setText(S);
		 
		 TextView t1=new TextView(this); 
			//	 System.out.println(Arrays.toString(list.toArray()));
		 
	//	 medList.add(S);
	//	 medList=Collections.reverse(medList.clone());
		 String ans=new String();
		 String f=new String();
		 t1=(TextView)findViewById(R.id.text1);
	//	 t1.setText(username1 + " " + membername);
		 for (String[] strings : medList) {
			 for(String i: strings){
				ans=ans+i+"\t\t\t\t\t\t\t";
				
			 }
			 f=f+ans+"\n";
			 ans="";
		
		 }
		t1.setText(f);  
	//	 username1=message;
		 btnAddMedicine=(Button)findViewById(R.id.buttonAddMedicine);
		 btnAddMedicine.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					/// Create Intent for SignUpActivity  and Start The Activity
			//		String message=userName;
					Intent intentAddMedicine=new Intent(getApplicationContext(),AddMemberMedicine.class);
					intentAddMedicine.putExtra("user1", username1);
					intentAddMedicine.putExtra("mem1", membername);
					startActivity(intentAddMedicine);
					}
				}); 
		 
		 btnViewMembers=(Button)findViewById(R.id.buttonViewMembers);
		 btnViewMembers.setOnClickListener(new View.OnClickListener() {
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
		 	
		 
	//	System.out.println(f);
		 
/*		 this.setListAdapter(new ArrayAdapter<String[]>(this, R.layout.viewmed, R.id.label, medList));
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
	              i.putExtra("username",username1);
	              i.putExtra("memname", product);
	              startActivity(i);
	             
	          }
	        }); */
		 
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

