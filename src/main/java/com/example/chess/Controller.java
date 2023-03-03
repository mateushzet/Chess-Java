package com.example.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Rectangle
            f00, f01, f02, f03, f04, f05, f06, f07,
            f10, f11, f12, f13, f14, f15, f16, f17,
            f20, f21, f22, f23, f24, f25, f26, f27,
            f30, f31, f32, f33, f34, f35, f36, f37,
            f40, f41, f42, f43, f44, f45, f46, f47,
            f50, f51, f52, f53, f54, f55, f56, f57,
            f60, f61, f62, f63, f64, f65, f66, f67,
            f70, f71, f72, f73, f74, f75, f76, f77;

    @FXML
    private ImageView
            WR1, WR2, WK1, WK2, WB1, WB2, WQ, Wk,
            WP1, WP2, WP3, WP4, WP5, WP6, WP7, WP8,
            BR1, BR2, BK1, BK2, BB1, BB2, BQ, Bk,
            BP1, BP2, BP3, BP4, BP5, BP6, BP7, BP8;

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

        boardFields = new Rectangle[][]{
                {f00, f01, f02, f03, f04, f05, f06, f07},
                {f10, f11, f12, f13, f14, f15, f16, f17},
                {f20, f21, f22, f23, f24, f25, f26, f27},
                {f30, f31, f32, f33, f34, f35, f36, f37},
                {f40, f41, f42, f43, f44, f45, f46, f47},
                {f50, f51, f52, f53, f54, f55, f56, f57},
                {f60, f61, f62, f63, f64, f65, f66, f67},
                {f70, f71, f72, f73, f74, f75, f76, f77}
        };

    }
}
