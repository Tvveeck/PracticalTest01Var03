package ro.pub.cs.systems.eim.PracticalTest01Var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    }
}