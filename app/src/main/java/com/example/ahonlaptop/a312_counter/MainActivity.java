package com.example.ahonlaptop.a312_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String DEBUG_START_SCREEN ="312_app_counter";

    private EditText input;
    private Button enter;
    private int inputData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editTextEntry);
        enter = findViewById(R.id.buttonEnter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getValue() == -1){
                    Toast.makeText(getApplicationContext(), "Please input an integer value greater than  0.", Toast.LENGTH_SHORT).show();

                }else {
                    inputData = getValue();
                    Log.i(DEBUG_START_SCREEN, Integer.toString(inputData));
                    Intent intent = new Intent(MainActivity.this, HandleMain.class);
                    intent.putExtra("input_value", inputData);
                    startActivity(intent);
                }
            }
        });
    }

    private int getValue(){
        try {
            if (Integer.parseInt(input.getText().toString()) <= 0) {
                return -1;
            } else {
                return Integer.parseInt(input.getText().toString());
            }
        }catch(NumberFormatException e){
            Log.e(DEBUG_START_SCREEN, "error receiving input");
            return -1;
        }
    }


}
