package com.example.myapplication.SudokuCode;

import static com.example.myapplication.SudokuCode.InitialConfigurationScreenSudoku.flag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.myapplication.App;
import com.example.myapplication.MainScreen;
import com.example.myapplication.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.example.myapplication.SudokuCode.ComponentStopwatch;
import com.example.myapplication.SudokuCode.ModelStopwatch;
import com.example.myapplication.SudokuCode.DecoratorStopwatch;
import com.example.myapplication.SudokuCode.BehaviorLoss;
import com.example.myapplication.SudokuCode.BehaviorWin;

public class GameScreenSudoku extends AppCompatActivity {

    //Declare all the variables for Sudoku game -- pull request checking
    Cell[][] table;
    TableLayout tl;
    String sudokuGameBoard;
    CheckBox hintCheckbox;
    TextView hintTextView;
    Button playAgainButton;
    Button mainMenuButton;
    TextView youWonTextView;
    TextView gameOverTextView;
    TextView jaehoonTextView;
    LinearLayout linearLayout;
    static ComponentStopwatch stopwatch;

    int randomNumber;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * [Stopwatch Logic] start the stopwatch (start playing the game)
         */
        stopwatch = ModelStopwatch.getInstance();
        stopwatch.start();
        // Initial game set-up values
        jaehoonTextView = new TextView(this);
        jaehoonTextView.setTextSize(25);
        jaehoonTextView.setTypeface(null, Typeface.BOLD);
        table = new Cell[9][9];
        tl = new TableLayout(this);
        youWonTextView = new TextView(this);
        hintTextView = new TextView(this);
        hintTextView.setTextSize(25);
        hintTextView.setTypeface(null, Typeface.BOLD);
        gameOverTextView = new TextView(this);
        gameOverTextView.setTextSize(25);
        gameOverTextView.setTypeface(null, Typeface.BOLD);

        //Random values from 1 to 3
        Random rn = new Random();
        randomNumber = rn.nextInt(3) + 1;

        //Hard coded the grid, based on the random values from 1 to 3 generated above
        if (randomNumber == 1) {
            sudokuGameBoard =      "6 8 5 7 4 9 2 1 3 " +
                                    "3 1 2 5 8 6 ? 7 9 " +
                                    "9 4 7 3 1 2 5 6 8 " +
                                    "7 2 ? 6 9 8 3 4 5 " +
                                    "5 3 9 2 7 4 6 8 1 " +
                                    "8 6 4 1 5 3 9 2 7 " +
                                    "2 9 8 4 3 1 7 5 6 " +
                                    "1 5 6 9 2 ? 8 3 4 " +
                                    "4 7 3 8 6 5 1 9 2 ";
        } else if (randomNumber == 2) {
            sudokuGameBoard =       "4 6 7 9 2 1 3 5 8 " +
                                    "8 9 5 4 7 3 2 6 1 " +
                                    "2 3 1 8 ? 5 7 4 9 " +
                                    "5 1 3 6 9 8 4 2 7 " +
                                    "9 2 8 7 5 4 6 1 3 " +
                                    "7 4 6 ? 3 2 9 8 5 " +
                                    "3 5 4 2 8 7 1 9 6 " +
                                    "1 8 9 3 4 6 5 7 2 " +
                                    "6 7 2 5 1 9 ? 3 4 " ;
        } else {
            sudokuGameBoard =       "3 8 7 5 2 1 9 6 4 " +
                                    "5 ? 2 6 3 9 1 7 8 " +
                                    "9 1 6 4 8 7 5 2 3 " +
                                    "7 6 8 1 4 5 2 3 9 " +
                                    "2 3 1 9 ? 8 4 5 ? " +
                                    "4 9 5 3 6 2 7 8 1 " +
                                    "6 2 9 8 5 4 3 1 7 " +
                                    "? 7 3 2 9 6 8 4 5 " +
                                    "8 5 4 7 1 3 6 9 2 " ;
        }

        String[] split = sudokuGameBoard.split(" ");

            //show initial sudoku GameBoard on screen
            for (int i = 0; i < 9; i++) {
                TableRow tr = new TableRow(this);
                for (int j = 0; j < 9; j++) {
                    String s = split[i * 9 + j];
                    Character c = s.charAt(0);
                    int initialValue = c == '?' ? 0 : c - '0';

                    table[i][j] = new Cell(initialValue, GameScreenSudoku.this);
                    tr.addView(table[i][j].bt);
                    if(c == '?')  {
                        table[i][j].bt.setText(i+"_"+j);
                        table[i][j].bt.setTextColor(Color.rgb(204, 255 + flag, 220));
                    }
                    table[i][j].bt.setTextSize(20);
                }
                tl.addView(tr);
            }

        //Sets the background color of the GameBoard cells. loop 9 times for coloring 9 blocks of sudoku
        //flag is used to change background color based on what color player chooses.
        for (int grid = 0; grid < 9; grid++) {
            if (grid % 2 == 0) { //Mod 2 to color alternate blocks
                for (int i = grid / 3 * 3; i < grid / 3 * 3 + 3; i++) {
                    for (int j = grid % 3 * 3; j < grid % 3 * 3 + 3; j++) {
                        table[i][j].bt.setBackgroundColor(Color.rgb(255, 255 + flag, 220));
                        if (table[i][j].value < 1 || table[i][j].value > 9) {
                            table[i][j].bt.setBackgroundColor(Color.rgb(204, 255 + flag, 220));
                        }
                    }
                }
            } else {
                for (int i = ((grid / 3) * 3); i < ((grid / 3) * 3) + 3; i++) {
                    for (int j = grid % 3 * 3; j < grid % 3 * 3 + 3; j++) {
                        table[i][j].bt.setBackgroundColor(Color.rgb(255, 255 + flag, 175));
                        if (table[i][j].value < 1 || table[i][j].value > 9) {
                            table[i][j].bt.setBackgroundColor(Color.rgb(204, 255 + flag, 220));
                        }
                    }
                }
            }
        }

        tl.setShrinkAllColumns(true);
        tl.setStretchAllColumns(true);

        //Timer Logic to win the game within 30 seconds
        new CountDownTimer(30000, 1000) { // Sets 10 second remaining
            public void onTick(long millisUntilFinished) {
                gameOverTextView.setText("No.of Lives: 1. Seconds remaining to win: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                gameOverTextView.setText("No. Of Lives: 0. Sorry, GameOver.");
                /**
                 * [Stopwatch Logic] stop the stopwatch (stop playing the game, either win or loss)
                 */
                if (stopwatch instanceof BehaviorWin) return;
                stopwatch.stop();
                stopwatch = new BehaviorLoss(stopwatch); // the user lost
                jaehoonTextView.setText(stopwatch.getReport()); // report if the user won / lost
            }
        }.start();

        //hint button
        hintCheckbox = new CheckBox(this);
        hintCheckbox.setText("SHOW HINT");
        hintCheckbox.setTextSize(20);
        hintCheckbox.setTypeface(null, Typeface.BOLD);

        //Play Again button Click Logic
        playAgainButton = new Button(this);
        playAgainButton.setText("PLAY AGAIN");
        playAgainButton.setTextSize(20);
        playAgainButton.setTextColor(Color.WHITE);
        playAgainButton.setTypeface(null, Typeface.BOLD);
        playAgainButton.setBackground(ContextCompat.getDrawable(context, R.drawable.playbutton));
        playAgainButton.setWidth(550);
        playAgainButton.setHeight(48);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreenSudoku.this, GameScreenSudoku.class);
                startActivity(intent);
            }
        });

        //Main Menu button logic
        mainMenuButton = new Button(this);
        mainMenuButton.setText("MAIN MENU");
        mainMenuButton.setTextSize(20);
        mainMenuButton.setTextColor(Color.WHITE);
        mainMenuButton.setTypeface(null, Typeface.BOLD);
        mainMenuButton.setBackground(ContextCompat.getDrawable(context, R.drawable.playbutton));
        mainMenuButton.setWidth(550);
        mainMenuButton.setHeight(48);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreenSudoku.this, MainScreen.class);
                startActivity(intent);
            }
        });

        //Add all programmatically created controls to the liner layout.
        linearLayout = new LinearLayout(this);
        linearLayout.addView(tl);
        linearLayout.addView(youWonTextView);
        linearLayout.addView(playAgainButton);
        linearLayout.addView(mainMenuButton);
        linearLayout.addView(gameOverTextView);
        linearLayout.addView(jaehoonTextView);
        linearLayout.addView(hintCheckbox);
        linearLayout.addView(hintTextView);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
    }

    Context context = App.getContext();

    private class Cell {
        int value;
        boolean fixed;
        Button bt;

        boolean flag;
        Set hs = new HashSet();

        public Cell(int initvalue, Context THIS) {
            value = initvalue;
            if (value != 0) fixed = true;
            else fixed = false;
            bt = new Button(THIS);
            if (fixed) bt.setText(String.valueOf(value));
            else bt.setTextColor(Color.BLUE);

            //logic on click of evey blank cell on the sudoku game
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!flag) {
                        hs.add(bt.getText().toString());
                        flag = true;
                    }
                        bt.setText("");
                        bt.setTextColor(Color.BLUE);
                        if (hintCheckbox.isChecked()) {
                            int row = Integer.parseInt(hs.iterator().next().toString().substring(0, 1));
                            int col = Integer.parseInt(hs.iterator().next().toString().substring(2, 3));
                            int hintValue = getHintValue(table, row, col);
                            hintTextView.setText(hintValue + "");
                        }
                    if (!youWonTextView.getText().equals("") || fixed) return;

                    value++;
                    if (value > 9) value = 1;
                    bt.setText(String.valueOf(value));

                    if (completed() && isSudokuSolvedCorrectly(table) 
                    && !gameOverTextView.getText().equals("No. Of Lives: 0. Sorry, GameOver.")) {
                        gameOverTextView.setVisibility(View.GONE);
                        youWonTextView.setText("You Won !!!!"); 
                        youWonTextView.setTextSize(25);
                        youWonTextView.setTextColor(Color.BLUE);
                        youWonTextView.setBackgroundColor(Color.rgb(204, 255, 220));
                        youWonTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        youWonTextView.setGravity(Gravity.CENTER | Gravity.BOTTOM);
                        /**
                         * [Stopwatch Logic] stop the stopwatch (stop playing the game, either win or loss)
                         */
                        if (stopwatch instanceof BehaviorLoss) return;
                        stopwatch.stop();
                        stopwatch = new BehaviorWin(stopwatch); // the user won
                        jaehoonTextView.setText(stopwatch.getReport()); // report if the user won / lost
                    }
                }
            });
        }
    }

    //method to check if all the blank cells on Sudoku cells are filled by the player
    boolean completed(){
        for(int i = 0; i<9;i++)
            for(int j = 0; j <9;j++)
                if(table[i][j].value == 0)
                    return  false;
        return true;
    }

    //created a method for hint feature
    int getHintValue(Cell[][] board, int row, int column) {
        Set hashSet = new HashSet();
        int res = 0;
        for (int i = 0; i < 9; ++i) {
            for (int j = column; j <= column; ++j) {
                Cell number = board[i][j];
                hashSet.add(number.value);
                if(i == row && j == column){
                    res = board[i][j].value;
                }
            }
        }
        for(int i = 1; i <= 9; i++){
            if(!hashSet.contains(i)) {
                return i;
            }
        }
        return res;
    }
    //method to check if sudoku is solved correctly
    boolean isSudokuSolvedCorrectly(Cell[][] gameBoard){
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                Cell number = gameBoard[i][j];
                if (number.value != '.')
                    if (!seen.add(number.value + " in row " + i) ||
                            !seen.add(number.value + " in column " + j) ||
                            !seen.add(number.value + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true; // return value
    }

    public String getSudokuGameBoard() {
        return sudokuGameBoard;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public Cell[][] getTable() {
        return table;
    }

}
