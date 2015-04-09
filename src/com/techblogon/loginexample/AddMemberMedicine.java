package com.techblogon.loginexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMemberMedicine extends Activity
{
	EditText editTextMemberName, editTextMedicine,editTextDose, editTextDays;
	Button btnAddMedicine;
	String username1, membername;
	PrescriptionDataBaseAdapter prescDataBaseAdapter;
	String memname=new String();
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addmed);
//		Bundle bundle = getIntent().getExtras();
//	     String message = bundle.getString("mes");
		Intent intent=getIntent();
	    String message = intent.getStringExtra("user1");
	 //   String message=bundle.getString("use1");
	     username1=message;
	     membername=intent.getStringExtra("mem1");
	//	memname=message;
	     
		// get Instance  of Database Adapter
	     prescDataBaseAdapter=new PrescriptionDataBaseAdapter(this);
		 prescDataBaseAdapter=prescDataBaseAdapter.open();
		// Get Refferences of Views
	//	editTextMemberName=(EditText)findViewById(R.id.editTextMemberName);
		editTextMedicine=(EditText)findViewById(R.id.editTextMedicine);
		editTextDose=(EditText)findViewById(R.id.editTextDose);
		editTextDays=(EditText)findViewById(R.id.editTextDays);
		
		btnAddMedicine=(Button)findViewById(R.id.buttonAddMedicine);
		btnAddMedicine.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		//	String MemberName=editTextMemberName.getText().toString();
			String medicine=editTextMedicine.getText().toString();
			int dose=Integer.parseInt(editTextDose.getText().toString());
			int days=Integer.parseInt(editTextDays.getText().toString());
			
			// check if any of the fields are vaccant
	/*		if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
					return;
			} */
			// check if both password matches
	/*		if(!password.equals(confirmPassword))
			{
				Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
				return;
			} */
/*			else
			{ */
			    // Save the Data in Database
			    PrescriptionDataBaseAdapter.insertEntry(username1, membername, medicine, dose, days);
			    Toast.makeText(getApplicationContext(), "Medicine Successfully Added! ", Toast.LENGTH_LONG).show();
		//	    dialog.dismiss();
		//		String message=userName;
				Intent intentHomeP=new Intent(getApplicationContext(),ViewMedicine.class);
				intentHomeP.putExtra("use1", username1);
				intentHomeP.putExtra("memname", membername);
				startActivity(intentHomeP);
	//		}
		}
	});
}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		prescDataBaseAdapter.close();
	}
}
