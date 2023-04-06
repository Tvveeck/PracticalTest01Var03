package ro.pub.cs.systems.eim.PracticalTest01Var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;



public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    Button correctButton;
    Button incorrectButton;

    TextView result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        correctButton = findViewById(R.id.correct);
        incorrectButton = findViewById(R.id.incorrect);

        result = findViewById(R.id.result);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("result")) {
            String resultText = intent.getStringExtra("result");
            result.setText(resultText);
        }

        correctButton.setOnClickListener(it -> {
            setResult(RESULT_OK, null);
            finish();
        });

        incorrectButton.setOnClickListener(it -> {
            setResult(RESULT_CANCELED, null);
            finish();
        });

    }


}