package com.example.ahonlaptop.a312_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TurnCounter extends AppCompatActivity implements View.OnClickListener {

    private int turnValue = 0;
    private TextView counterValue, updateInfo, updateInfo2;
    private Button nextTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_counter);

        counterValue = findViewById(R.id.textViewTurnCount);
        updateInfo = findViewById(R.id.textViewUpdateInfo);
        updateInfo2 = findViewById(R.id.textViewUpdateInfo2);
        nextTurn = findViewById(R.id.buttonNextTurn);
        nextTurn.setOnClickListener(this);

        updateTurnValue();
    }

    public void updateTurnValue(){
        counterValue.setText(Integer.toString(turnValue));
        if(turnValue %3 == 0 && turnValue != 0){ //electric ants attack every 3 turns
            updateInfo.setText(getString(R.string.electric_attack));
            //if divisble by 3 AND 4
            if(turnValue %4 == 0) updateInfo2.setText(getString(R.string.fire_attack));
        }
        else if(turnValue %4 == 0 && turnValue != 0){ //fire ants attack every 4 turns
            updateInfo.setText(getString(R.string.fire_attack));
        }
        else{ //no updates
            updateInfo.setText(getString(R.string.no_updates));
            updateInfo2.setText(null);
        }

    }

    @Override
    public void onClick(View v) {
        //switch for expandability if more buttons needed in future
        switch(v.getId()){
            case R.id.buttonNextTurn:
                turnValue++;
                break;
        }
        updateTurnValue();
    }
}
