package com.hamidul.homework233;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fromNumber,toNumber;
    Button button;
    TextView textView;
    String prime = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        fromNumber = findViewById(R.id.fromNumber);
        toNumber = findViewById(R.id.toNumber);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        toNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().startsWith("0")){
                    s.delete(0,1);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                prime = "";
                int from = Integer.parseInt(fromNumber.getText().toString());
                int to = Integer.parseInt(toNumber.getText().toString());
                if (from<=to){
                    if (from<=2 && to!=1){
                        textView.append(2+"  ");
                    }
                    for (int x=from; x<=to; x++){

                        for (int i=2; i<x; i++){
                            if (x%i==0){
                                prime = "";
                                break;
                            }else {
                                prime = x+"  ";
                            }
                        }
                        textView.append(prime+"");
                    }
                    if (textView.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "No prime number available", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Please fill the box correctly", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }//onCreate=====================================================================================



}//AppCompatActivity================================================================================