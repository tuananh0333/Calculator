package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OperatorActivity extends AppCompatActivity {
    private EditText edtA;
    private EditText edtB;

    Button btnPlus;
    Button btnSubt;
    Button btnMult;
    Button btnDivi;

    double dA;
    double dB;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operator_layout);

        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnSubt = (Button) findViewById(R.id.btnSubt);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDivi = (Button) findViewById(R.id.btnDivi);

        super.onResume();

        intent = getIntent();
        final Bundle data = intent.getBundleExtra("data");

        final String a = data.getString("a");
        final String b = data.getString("b");
        edtA.setText(a);
        edtB.setText(b);

        dA = Double.parseDouble(a);
        dB = Double.parseDouble(b);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = dA + dB;

                data.putString("result",result+"");
                data.putString("a",a);
                data.putString("b",b);
                data.putString("operator","+");

                intent.setClass(OperatorActivity.this, CalculatorActivity.class);
                intent.putExtra("data", data);

                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btnSubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = dA - dB;

                data.putString("result",result+"");
                data.putString("a",a);
                data.putString("b",b);
                data.putString("operator","-");

                intent.setClass(OperatorActivity.this, CalculatorActivity.class);
                intent.putExtra("data", data);

                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = dA * dB;

                data.putString("result",result+"");
                data.putString("a",a);
                data.putString("b",b);
                data.putString("operator","x");

                intent.setClass(OperatorActivity.this, CalculatorActivity.class);
                intent.putExtra("data", data);

                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = dA / dB;

                data.putString("result",result+"");
                data.putString("a",a);
                data.putString("b",b);
                data.putString("operator","÷");

                intent.setClass(OperatorActivity.this, CalculatorActivity.class);
                intent.putExtra("data", data);

                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        intent = getIntent();
        final Bundle data = intent.getBundleExtra("data");

        final String a = data.getString("a");
        final String b = data.getString("b");
        edtA.setText(a);
        edtB.setText(b);

        dA = Double.parseDouble(a);
        dB = Double.parseDouble(b);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
    }

    //    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        //save instance khi xoay man hinh
//
}
