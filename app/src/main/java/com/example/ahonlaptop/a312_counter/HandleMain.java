package com.example.ahonlaptop.a312_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HandleMain extends AppCompatActivity implements View.OnClickListener {
    private final String DEBUG_HANDLE_SCREEN ="312_app_counter";

    private int honeyBase, honeyCurr, leafcutterNum, bulletNum, fireNum, electricNum;

    private TextView honeyVal, leafcutter, bullet, fire, electric;
    private Button subOne, subTwo, subFour, subFive, reset, toTurnCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_main);

        Bundle intentInfo = getIntent().getExtras();
        if(intentInfo != null){
            honeyBase = intentInfo.getInt("input_value");
        }
        honeyCurr = honeyBase;

        honeyVal = findViewById(R.id.textViewHoneyValue);

        subOne = findViewById(R.id.buttonSub1);
        subTwo = findViewById(R.id.buttonSub2);
        subFour = findViewById(R.id.buttonSub4);
        subFive = findViewById(R.id.buttonSub5);
        reset = findViewById(R.id.buttonReset);
        toTurnCounter = findViewById(R.id.buttonToTurnCounter);

        subOne.setOnClickListener(this);
        subTwo.setOnClickListener(this);
        subFour.setOnClickListener(this);
        subFive.setOnClickListener(this);
        reset.setOnClickListener(this);
        toTurnCounter.setOnClickListener(this);

        leafcutter = findViewById(R.id.textViewLeafcutterValue);
        bullet = findViewById(R.id.textViewBulletValue);
        fire = findViewById(R.id.textViewFireValue);
        electric = findViewById(R.id.textViewElectricValue);

        updateHoneyView(honeyCurr);
        updateNumOfTowers();
    }

    public void updateHoneyView(int val){
        honeyVal.setText(Integer.toString(val));
    }

    public void updateNumOfTowers(){
        doTowerMath();
        leafcutter.setText(Integer.toString(leafcutterNum));
        bullet.setText(Integer.toString(bulletNum));
        fire.setText(Integer.toString(fireNum));
        electric.setText(Integer.toString(electricNum));
    }

    public void doTowerMath(){
        leafcutterNum = honeyCurr;
        //calculate cost of each tower
        bulletNum = (int)Math.floor(honeyCurr/2);
        fireNum = (int)Math.floor(honeyCurr/4);
        electricNum = (int)Math.floor(honeyCurr/5);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonSub1:
                if(honeyCurr > 0) honeyCurr-= 1;
                else Toast.makeText(getApplicationContext(), "Honey can't be negative.", Toast.LENGTH_SHORT).show();
                Log.i(DEBUG_HANDLE_SCREEN, Integer.toString(honeyCurr));
                break;
            case R.id.buttonSub2:
                if(honeyCurr > 1) honeyCurr -= 2;
                else Toast.makeText(getApplicationContext(), "Honey can't be negative.", Toast.LENGTH_SHORT).show();
                Log.i(DEBUG_HANDLE_SCREEN, Integer.toString(honeyCurr));
                break;
            case R.id.buttonSub4:
                if(honeyCurr > 3) honeyCurr -= 4;
                else Toast.makeText(getApplicationContext(), "Honey can't be negative.", Toast.LENGTH_SHORT).show();
                Log.i(DEBUG_HANDLE_SCREEN, Integer.toString(honeyCurr));
                break;
            case R.id.buttonSub5:
                if(honeyCurr > 4) honeyCurr -= 5;
                else Toast.makeText(getApplicationContext(), "Honey can't be negative.", Toast.LENGTH_SHORT).show();
                Log.i(DEBUG_HANDLE_SCREEN, Integer.toString(honeyCurr));
                break;
            case R.id.buttonReset:
                honeyCurr = honeyBase;
                Log.i(DEBUG_HANDLE_SCREEN, Integer.toString(honeyCurr));
                break;
            case R.id.buttonToTurnCounter:
                Intent toCounter = new Intent(HandleMain.this, TurnCounter.class);
                startActivity(toCounter);
                break;
        }
        updateHoneyView(honeyCurr);
        updateNumOfTowers();
    }
}
