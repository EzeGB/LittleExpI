package com.example.littleexpi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //it displays an emergent message with the name of the favorite band at the bottom
    public void showBand (View v){
        String bandput = ((EditText)findViewById(R.id.editTextText)).getText().toString();
        Toast.makeText(this, bandput, Toast.LENGTH_LONG).show();
    }

    //it enables or disables the SHOW button next to it
    public void toggleShowButton (View v){
        Button showButton = ((Button)findViewById(R.id.button2));
        if (showButton.isEnabled()){
            showButton.setEnabled(false);
        } else {
            showButton.setEnabled(true);
        }
    }

    //it sums the value of the button with the current sum
    public void add (View v){
        Button button = (Button) v;
        TextView currentResult = findViewById(R.id.textView3);
        int addend1 = Integer.parseInt(currentResult.getText().toString());
        int addend2 = Integer.parseInt(button.getText().toString());
        int newResult = addend1 +addend2;
        currentResult.setText(String.valueOf(newResult));
    }

    //it resets the value of the sum to 0
    public void resetSum (View v){
        TextView sum = findViewById(R.id.textView3);
        sum.setText("0");
    }
}