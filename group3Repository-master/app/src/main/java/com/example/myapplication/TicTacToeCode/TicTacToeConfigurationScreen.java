package com.example.myapplication.TicTacToeCode;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.example.myapplication.R;

public class TicTacToeConfigurationScreen extends AppCompatActivity {

    public EditText player1;
    public EditText player2;
    private Button submitButton;
    private Button pickButton1;
    private Button pickButton2;
    public String player1Name;
    public String player2Name;
    public static final String key1 = "name";

    public static final String key4 = "name";
    public static final String key2 = "photo";
    public static final String key3 = "image";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_configuration_screen);
        player1 = findViewById(R.id.editTextText);
        player2 = findViewById(R.id.editTextText2);
        submitButton = (Button) findViewById(R.id.button2);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonClick();
            }
        });
        pickButton1 = (Button) findViewById(R.id.button3);
        pickButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickButtonClick();
            }
        });
        pickButton2 = (Button) findViewById(R.id.button4);
        pickButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pickSecondButtonClick();
            }
        });

    }

    boolean flag;
    public void submitButtonClick() {
        flag = true;

        //if (player1.getText().toString().trim().equals(""))

        if (player1.getText().length() >= 1) {
            //player1.setHint("Please enter a name.");
            player1Name = player1.getText().toString();
        } else {
            player1Name = "Player1";
        }

        //if (player2.getText().toString().trim().equals(""))
        if (player2.getText().length() >= 1) {
           // player2.setHint("Please enter a name.");
            player2Name = player2.getText().toString();
        } else {
            player2Name = "Player2";
        }
    }

    public void pickButtonClick() {
        if(flag) {
            Intent intent = new Intent(this, TicTacToeGameScreen.class);
            intent.putExtra(key2, R.drawable.charactersprite2);
            intent.putExtra(key3, R.drawable.charactersprite1);
            intent.putExtra("PLAYER_NAMES", new String[]{player1Name, player2Name});
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, TicTacToeGameScreen.class);
            intent.putExtra(key2, R.drawable.charactersprite2);
            intent.putExtra(key3, R.drawable.charactersprite1);
            intent.putExtra("PLAYER_NAMES", new String[]{"Player1", "Player2"});
            startActivity(intent);

        }

    }

    public void pickSecondButtonClick() {
        if(flag) {
            Intent intent = new Intent(this, TicTacToeGameScreen.class);
            intent.putExtra(key2, R.drawable.charactersprite1);
            intent.putExtra(key3, R.drawable.charactersprite2);
            intent.putExtra("PLAYER_NAMES", new String[]{player1Name, player2Name});
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, TicTacToeGameScreen.class);
            intent.putExtra(key2, R.drawable.charactersprite1);
            intent.putExtra(key3, R.drawable.charactersprite2);
            intent.putExtra("PLAYER_NAMES", new String[]{"Player1", "Player2"});
            startActivity(intent);

        }
    }
}