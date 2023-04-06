package ro.pub.cs.systems.eim.PracticalTest01Var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    Button plusButton;
    Button minusButton;
    Button navigateButton;

    EditText number1;
    EditText number2;

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivity_practical_test01_var03_main);

        plusButton = findViewById(R.id.plus);
        minusButton = findViewById(R.id.minus);
        navigateButton = findViewById(R.id.navigate);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        result = findViewById(R.id.result);

        plusButton.setOnClickListener(it -> {

            try {
                Integer.parseInt(number1.getText().toString());
                Integer.parseInt(number2.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Input must be a number", Toast.LENGTH_LONG).show();
                return;
            }

            Integer left = Integer.parseInt(number1.getText().toString());
            Integer right = Integer.parseInt(number2.getText().toString());
            result.setText(number1.getText().toString() + " + " + number2.getText().toString() + " = " + String.valueOf(left + right));
        });

        minusButton.setOnClickListener(it -> {

            try {
                Integer.parseInt(number1.getText().toString());
                Integer.parseInt(number2.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Input must be a number", Toast.LENGTH_LONG).show();
                return;
            }

            Integer left = Integer.parseInt(number1.getText().toString());
            Integer right = Integer.parseInt(number2.getText().toString());
            result.setText(number1.getText().toString() + " - " + number2.getText().toString() + " = " + String.valueOf(left - right));
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("result", result.getText().toString());
        savedInstanceState.putString("number1", number1.getText().toString());
        savedInstanceState.putString("number2", number2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String got = "Saved values: ";

        if (savedInstanceState.containsKey("result")) {
            got += savedInstanceState.getString("result") + " | ";
            result.setText(savedInstanceState.getString("result"));
        }
        if (savedInstanceState.containsKey("number1")) {
            got += savedInstanceState.getString("number1") + " | ";
            number1.setText(savedInstanceState.getString("number1"));
        }
        if (savedInstanceState.containsKey("number2")) {
            got += savedInstanceState.getString("number2") + " | ";
            number2.setText(savedInstanceState.getString("number2"));
        }

        Toast.makeText(this, got, Toast.LENGTH_LONG).show();
    }

}

