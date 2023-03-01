package com.example.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView WR1;
    @FXML
    private ImageView WR2;
    @FXML
    private ImageView WK1;
    @FXML
    private ImageView WK2;
    @FXML
    private ImageView WB1;
    @FXML
    private ImageView WB2;
    @FXML
    private ImageView WQ;
    @FXML
    private ImageView Wk;
    @FXML
    private ImageView WP1;
    @FXML
    private ImageView WP2;
    @FXML
    private ImageView WP3;
    @FXML
    private ImageView WP4;
    @FXML
    private ImageView WP5;
    @FXML
    private ImageView WP6;
    @FXML
    private ImageView WP7;
    @FXML
    private ImageView WP8;

    @FXML
    private ImageView BR1;
    @FXML
    private ImageView BR2;
    @FXML
    private ImageView BK1;
    @FXML
    private ImageView BK2;
    @FXML
    private ImageView BB1;
    @FXML
    private ImageView BB2;
    @FXML
    private ImageView BQ;
    @FXML
    private ImageView Bk;
    @FXML
    private ImageView BP1;
    @FXML
    private ImageView BP2;
    @FXML
    private ImageView BP3;
    @FXML
    private ImageView BP4;
    @FXML
    private ImageView BP5;
    @FXML
    private ImageView BP6;
    @FXML
    private ImageView BP7;
    @FXML
    private ImageView BP8;

    static protected ImageView[][] board = new ImageView[8][8];
    DraggableMaker draggableMaker = new DraggableMaker(board);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        board[0][7] = WR1;
        board[7][7] = WR2;
        board[1][7] = WK1;
        board[6][7] = WK2;
        board[2][7] = WB1;
        board[5][7] = WB2;
        board[3][7] = WQ;
        board[4][7] = Wk;
        board[0][6] = WP1;
        board[1][6] = WP2;
        board[2][6] = WP3;
        board[3][6] = WP4;
        board[4][6] = WP5;
        board[5][6] = WP6;
        board[6][6] = WP7;
        board[7][6] = WP8;

        board[0][0] = BR1;
        board[7][0] = BR2;
        board[1][0] = BK1;
        board[6][0] = BK2;
        board[2][0] = BB1;
        board[5][0] = BB2;
        board[3][0] = BQ;
        board[4][0] = Bk;
        board[0][1] = BP1;
        board[1][1] = BP2;
        board[2][1] = BP3;
        board[3][1] = BP4;
        board[4][1] = BP5;
        board[5][1] = BP6;
        board[6][1] = BP7;
        board[7][1] = BP8;

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[j][i] = null;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                draggableMaker.makeDraggable(board[j][i]);
                draggableMaker.makeDraggable(board[j][i+6]);
            }
        }
    }
}
