package com.example.myapplication.FlappyBirdCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.myapplication.R;


public class InitialConfigurationScreenFlappybird extends AppCompatActivity {
    private RadioButton button1;
    private RadioButton button2;
    private Button btn;

    public static boolean color;

    private EditText userName;
    public static final String KEY1 = "photo";
    public static final String KEY2 = "photo";
    public static final String KEY3 = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_configuration_screen_flappybird);
        button1 = findViewById(R.id.radioButton);
        button2 = findViewById(R.id.radioButton4);
        btn = findViewById(R.id.button);
        userName = findViewById(R.id.editTextText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = userName.getText().toString().trim();
                if (message.isEmpty()) {
                    userName.setHint("Please enter a valid username.");
                } else {
                    if (button1.isChecked()) {
                        color = true;
                        Intent intent = new Intent(InitialConfigurationScreenFlappybird.this, GameScreenFlappybird.class);
                        intent.putExtra(KEY1, R.drawable.blueflappy3);
                        intent.putExtra(KEY3, message);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(InitialConfigurationScreenFlappybird.this, GameScreenFlappybird.class);
                        intent.putExtra(KEY2, R.drawable.redflappy3);
                        intent.putExtra(KEY3, message);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
