package com.nitinakash.bmiapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText weight_val;
    EditText height_val;
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        weight_val = (EditText) findViewById((R.id.textHeight));
        height_val = (EditText) findViewById((R.id.textHeight));
        tv4 = (TextView) findViewById(R.id.tv4);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        }
            public void onClickNameRetrivel(View view){
                InClassDatabaseHelper helper =new InClassDatabaseHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();

                //run a query
                Cursor cursor= db.query(InClassDatabaseHelper.TABLE_NAME,new String[]{"NAME" , "PASSWORD", "DATE"}, null,null,null,null,null);

                if (cursor.moveToFirst()){
                    String name=cursor.getString(0);
                    System.out.println(name);

                    TextView results = (TextView) findViewById (R.id.tvName);
                    results.setText(name);
                }

                cursor.close();
                db.close();
            }

            public void onClickEvent(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                String weight1 = weight_val.getText().toString();
                String height1 = height_val.getText().toString();

                float weight = Float.parseFloat(weight1);
                float height = Float.parseFloat(height1)/100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));
            }
            private float calculateBMI (float weight, float height) {
                return (float) (weight / (height * height));
            }

            // Interpret what BMI means
            private String interpretBMI(float bmiValue) {

                if (bmiValue < 16) {
                    return "Severely underweight";
                } else if (bmiValue < 18.5) {

                    return "Underweight";
                } else if (bmiValue < 25) {

                    return "Normal";
                } else if (bmiValue < 30) {

                    return "Overweight";
                } else {
                    return "Obese";
                }
            }
        }
