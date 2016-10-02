package com.example.sandeep.facultysearchiitk;

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
    Button btn;



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
        }
        else if(view.getId()==usn.getId()&&checked){
            finalresult.setHint("Please enter the username");
        }
        else{
            finalresult.setHint("Research Interest Please");
        }
    }

    public void search(View view){
        
    }
}

