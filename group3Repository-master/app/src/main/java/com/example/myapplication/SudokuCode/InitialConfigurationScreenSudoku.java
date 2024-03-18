package com.example.myapplication.SudokuCode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class InitialConfigurationScreenSudoku extends AppCompatActivity {
    private RadioButton button1;
    private RadioButton button2;
    private Button btn;
    public static int flag = 0;
    private EditText userName;
    public static final String KEY1 = "photo";
    public static final String KEY2 = "photo";
    public static final String KEY3 = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_configuration_screen_sudoku);
        button1 = findViewById(R.id.radioButtonYellow);
        button2 = findViewById(R.id.radioButtonPink);
        btn = findViewById(R.id.button);
        userName = findViewById(R.id.editTextText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = userName.getText().toString();
                if(button1.isChecked()) {
                    flag = 0;
                    if (message.equals("")) {
                        userName.setHint("Please enter the valid username.");
                    } else {
                        Intent intent = new Intent(InitialConfigurationScreenSudoku.this, GameScreenSudoku.class);
                        intent.putExtra(KEY1, R.drawable.kids);
                        intent.putExtra(KEY3, message);
                        startActivity(intent);
                    }
                } else {
                    flag = -50;
                    if (message.equals("")) {
                        userName.setHint("Please enter the valid username.");
                    } else {
                        Intent intent = new Intent(InitialConfigurationScreenSudoku.this, GameScreenSudoku.class);
                        intent.putExtra(KEY2, R.drawable.fun);
                        intent.putExtra(KEY3, message);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}