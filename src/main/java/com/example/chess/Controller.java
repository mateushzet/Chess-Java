package com.example.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Rectangle f00;
    @FXML
    private Rectangle f01;
    @FXML
    private Rectangle f02;
    @FXML
    private Rectangle f03;
    @FXML
    private Rectangle f04;
    @FXML
    private Rectangle f05;
    @FXML
    private Rectangle f06;
    @FXML
    private Rectangle f07;

    @FXML
    private Rectangle f10;
    @FXML
    private Rectangle f11;
    @FXML
    private Rectangle f12;
    @FXML
    private Rectangle f13;
    @FXML
    private Rectangle f14;
    @FXML
    private Rectangle f15;
    @FXML
    private Rectangle f16;
    @FXML
    private Rectangle f17;

    @FXML
    private Rectangle f20;
    @FXML
    private Rectangle f21;
    @FXML
    private Rectangle f22;
    @FXML
    private Rectangle f23;
    @FXML
    private Rectangle f24;
    @FXML
    private Rectangle f25;
    @FXML
    private Rectangle f26;
    @FXML
    private Rectangle f27;

    @FXML
    private Rectangle f30;
    @FXML
    private Rectangle f31;
    @FXML
    private Rectangle f32;
    @FXML
    private Rectangle f33;
    @FXML
    private Rectangle f34;
    @FXML
    private Rectangle f35;
    @FXML
    private Rectangle f36;
    @FXML
    private Rectangle f37;

    @FXML
    private Rectangle f40;
    @FXML
    private Rectangle f41;
    @FXML
    private Rectangle f42;
    @FXML
    private Rectangle f43;
    @FXML
    private Rectangle f44;
    @FXML
    private Rectangle f45;
    @FXML
    private Rectangle f46;
    @FXML
    private Rectangle f47;

    @FXML
    private Rectangle f50;
    @FXML
    private Rectangle f51;
    @FXML
    private Rectangle f52;
    @FXML
    private Rectangle f53;
    @FXML
    private Rectangle f54;
    @FXML
    private Rectangle f55;
    @FXML
    private Rectangle f56;
    @FXML
    private Rectangle f57;

    @FXML
    private Rectangle f60;
    @FXML
    private Rectangle f61;
    @FXML
    private Rectangle f62;
    @FXML
    private Rectangle f63;
    @FXML
    private Rectangle f64;
    @FXML
    private Rectangle f65;
    @FXML
    private Rectangle f66;
    @FXML
    private Rectangle f67;

    @FXML
    private Rectangle f70;
    @FXML
    private Rectangle f71;
    @FXML
    private Rectangle f72;
    @FXML
    private Rectangle f73;
    @FXML
    private Rectangle f74;
    @FXML
    private Rectangle f75;
    @FXML
    private Rectangle f76;
    @FXML
    private Rectangle f77;

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
    static protected Rectangle[][] boardFields = new Rectangle[8][8];
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

        boardFields[0][0] = f00;
        boardFields[0][1] = f01;
        boardFields[0][2] = f02;
        boardFields[0][3] = f03;
        boardFields[0][4] = f04;
        boardFields[0][5] = f05;
        boardFields[0][6] = f06;
        boardFields[0][7] = f07;

        boardFields[1][0] = f10;
        boardFields[1][1] = f11;
        boardFields[1][2] = f12;
        boardFields[1][3] = f13;
        boardFields[1][4] = f14;
        boardFields[1][5] = f15;
        boardFields[1][6] = f16;
        boardFields[1][7] = f17;

        boardFields[2][0] = f20;
        boardFields[2][1] = f21;
        boardFields[2][2] = f22;
        boardFields[2][3] = f23;
        boardFields[2][4] = f24;
        boardFields[2][5] = f25;
        boardFields[2][6] = f26;
        boardFields[2][7] = f27;

        boardFields[3][0] = f30;
        boardFields[3][1] = f31;
        boardFields[3][2] = f32;
        boardFields[3][3] = f33;
        boardFields[3][4] = f34;
        boardFields[3][5] = f35;
        boardFields[3][6] = f36;
        boardFields[3][7] = f37;

        boardFields[4][0] = f40;
        boardFields[4][1] = f41;
        boardFields[4][2] = f42;
        boardFields[4][3] = f43;
        boardFields[4][4] = f44;
        boardFields[4][5] = f45;
        boardFields[4][6] = f46;
        boardFields[4][7] = f47;

        boardFields[5][0] = f50;
        boardFields[5][1] = f51;
        boardFields[5][2] = f52;
        boardFields[5][3] = f53;
        boardFields[5][4] = f54;
        boardFields[5][5] = f55;
        boardFields[5][6] = f56;
        boardFields[5][7] = f57;

        boardFields[6][0] = f60;
        boardFields[6][1] = f61;
        boardFields[6][2] = f62;
        boardFields[6][3] = f63;
        boardFields[6][4] = f64;
        boardFields[6][5] = f65;
        boardFields[6][6] = f66;
        boardFields[6][7] = f67;

        boardFields[7][0] = f70;
        boardFields[7][1] = f71;
        boardFields[7][2] = f72;
        boardFields[7][3] = f73;
        boardFields[7][4] = f74;
        boardFields[7][5] = f75;
        boardFields[7][6] = f76;
        boardFields[7][7] = f77;


    }
}
