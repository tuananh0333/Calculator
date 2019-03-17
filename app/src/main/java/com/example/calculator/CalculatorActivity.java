package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private EditText edtA;
    private EditText edtB;
    private EditText edtResult;

    private Intent intent;

    Button btnCalculate;

    //key names
    public static String A_KEY = "a";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        Log.d("test","on Create() called");

        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        edtResult = (EditText) findViewById(R.id.edtResult);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        intent = new Intent(CalculatorActivity.this, OperatorActivity.class);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtA.getText().toString().isEmpty() && !edtB.getText().toString().isEmpty())
                {
                    double a = Double.parseDouble(edtA.getText().toString());
                    double b = Double.parseDouble(edtB.getText().toString());

                    //send data
                    Bundle data = new Bundle();
                    data.putString("a", a+"");
                    data.putString("b", b+"");
                    intent.putExtra("data",data);

                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    intent.setClass(CalculatorActivity.this,OperatorActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(CalculatorActivity.this, "please input variables", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test", "onResume()");

        //get data from OperatorActvity
        Bundle data = intent.getBundleExtra("data");
        if (data != null)
        {
            Log.d("test", data.toString());
            String a = data.getString("a");
            String b = data.getString("b");
            String result = data.getString("result");
            String operator = data.getString("operator");

            edtA.setText(a);
            edtB.setText(b);
            edtResult.setText(a + " " + operator + " " + b + " = " + result);
        }
    }
}
