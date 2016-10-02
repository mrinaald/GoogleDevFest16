package com.example.sandeep.facultysearchiitk;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Spinner Designation,Dept,Gender;
    ArrayAdapter<CharSequence> adapter,adapter1,adapter2;
    int count=0;
    RadioButton nm,usn;
    EditText finalresult;
    Button btn=null;
    String Name=null,Username=null,Rinterest=null,Sex=null,Department=null,designation=null;
    int flag=0;
    String dept=null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finalresult=(EditText) findViewById(R.id.finalres);
        nm=(RadioButton)findViewById(R.id.name);
        usn=(RadioButton)findViewById(R.id.usrname);
        btn=(Button)findViewById(R.id.button);
        Designation = (Spinner)findViewById(R.id.Designation);
        adapter = ArrayAdapter.createFromResource(this,R.array.designation,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Designation.setAdapter(adapter);
        Designation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()  {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(count>=3){

                    Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
                }
                count++;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Dept = (Spinner)findViewById(R.id.Dept);
        adapter1 = ArrayAdapter.createFromResource(this,R.array.dept,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Dept.setAdapter(adapter1);
        Dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()  {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(count>=3){
                    Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
                    dept = Dept.getSelectedItem().toString();

                }
                count++;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Gender = (Spinner)findViewById(R.id.Gender);
        adapter2 = ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Gender.setAdapter(adapter2);
        Gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()  {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(count>=3){
                    Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
                }
                count++;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void SelectedField(View view){
        boolean checked=((RadioButton) view).isChecked();
        if(view.getId()==nm.getId()&&checked){
        finalresult.setHint("Please enter the Name");
        Name=finalresult.getText().toString();
        flag=1;
        }
        else if(view.getId()==usn.getId()&&checked){
            finalresult.setHint("Please enter the username");
            Username=finalresult.getText().toString();
            flag=2;
        }
        else{
            finalresult.setHint("Research Interest Please");
            Rinterest=finalresult.getText().toString();
            flag=3;
        }
    }

    public void Search(View view){
        Intent intent = new Intent(MainActivity.this , second_activity.class);

// EditText txt= (EditText)findViewById(R.id.edit);
////       txt.setText(dept);
//        intent.putExtra("One",dept);
        if(dept!=null)
        {
//
        SQLiteDatabase mydatabase = openOrCreateDatabase("database/"+dept+"/",MODE_PRIVATE,null);
        Cursor resultSet = mydatabase.rawQuery("Select * from ? WHERE lower(name) = ?",new String[]{dept.toLowerCase(), Name.toLowerCase()});
            resultSet.moveToFirst();
//
//            txt.setText(resultSet.getString(1));
//
            intent.putExtra("One",resultSet.getString(1));
            startActivity(intent);
//
//
//
    }


}}

