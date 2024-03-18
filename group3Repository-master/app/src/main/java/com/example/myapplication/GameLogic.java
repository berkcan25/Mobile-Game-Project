package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import

public class GameLogic {
    private int[][] gameBoard;
    private String[] playerNames = {"Player1", "Player2"};
    private int[] winType = {-1, -1, -1};

    private Button playAgainButton;
    private Button homeButton;
    private TextView playerTurn;

    private boolean isBoardFilled;

    private int player = 1;

    public GameLogic() {
        gameBoard = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean hasWon() {
        boolean isWinner = false;

        for (int r = 0; r < 3; r++) {
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2]
                    && gameBoard[r][0] != 0) {
                winType = new int[]{r, 0, 1};
                isWinner = true;
            }
        }

        for (int c = 0; c < 3; c++) {
            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[2][c] == gameBoard[0][c] &&
                    gameBoard[0][c] != 0) {
                winType = new int[]{0, c, 2};
                isWinner = true;
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] &&
                gameBoard[0][0] != 0) {
            winType = new int[]{0, 2, 3};
            isWinner = true;
        }

        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] &&
                gameBoard[2][0] != 0) {
            winType = new int[]{2, 2, 4};
            isWinner = true;
        }
        int boardFilled = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (gameBoard[r][c] != 0) {
                    boardFilled += 1;
                }
            }
        }
        if (isWinner) {
            return true;
        } else if (boardFilled == 9) {
            isBoardFilled = true;
            return false;
        } else {
            return false;
        }
    }

    public boolean winnerCheck() {
        if (hasWon()) {
            playAgainButton.setVisibility(View.VISIBLE);
            homeButton.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player - 1] + " Won!!!"));
            return true;
        } else if (hasWon() == false && isBoardFilled == true) {
            playAgainButton.setVisibility(View.VISIBLE);
            homeButton.setVisibility(View.VISIBLE);
            playerTurn.setText("Tie Game!!!!");
            return false;
        } else {
            return false;
        }
    }

    public void resetGameBoardValues() {
        isBoardFilled = false;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
    }

    public void resetGames() {
        resetGameBoardValues();
        player = 1;
        playAgainButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);

        playerTurn.setText((playerNames[0] + "'s turn"));
    }

    public boolean updateGameBoardValues(int row, int col) {
        if (gameBoard[row - 1][col - 1] == 0) {
            gameBoard[row - 1][col - 1] = player;
            return true;
        } else {
            return false;
        }
    }

    public boolean updateGameBoard(int row, int col) {
        if (updateGameBoardValues(row, col)) {
            if (player == 1) {
                playerTurn.setText((playerNames[1]) + "'s turn");
            } else {
                playerTurn.setText((playerNames[0] + "'s turn"));
            }
            return true;
        } else {
            return false;
        }
    }

    public void setPlayAgainButton(Button playAgainButton) {
        this.playAgainButton = playAgainButton;
        isBoardFilled = false;
    }

    public void setHomeButton(Button homeButton) {
        this.homeButton = homeButton;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public TextView getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    /**
     * this is for testing purposes only
     */
    public void setGameBoard(int[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType() {
        return winType;
    }


    public Button getPlayAgainButton() {
        return playAgainButton;
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public GameLogic getGameLogic() {
        return this;
    }

    public boolean getIsBoardFilled() {
        return isBoardFilled;
    }
}
