package com.example.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView whiteRook1;
    @FXML
    private ImageView whiteRook2;
    @FXML
    private ImageView whiteKnight1;
    @FXML
    private ImageView whiteKnight2;
    @FXML
    private ImageView whiteBishop1;
    @FXML
    private ImageView whiteBishop2;
    @FXML
    private ImageView whiteQueen;
    @FXML
    private ImageView whiteKing;
    @FXML
    private ImageView whitePawn1;
    @FXML
    private ImageView whitePawn2;
    @FXML
    private ImageView whitePawn3;
    @FXML
    private ImageView whitePawn4;
    @FXML
    private ImageView whitePawn5;
    @FXML
    private ImageView whitePawn6;
    @FXML
    private ImageView whitePawn7;
    @FXML
    private ImageView whitePawn8;

    @FXML
    private ImageView blackBishop1;
    @FXML
    private ImageView blackBishop2;
    @FXML
    private ImageView blackKing;
    @FXML
    private ImageView blackKnight1;
    @FXML
    private ImageView blackKnight2;
    @FXML
    private ImageView blackPawn1;
    @FXML
    private ImageView blackPawn2;
    @FXML
    private ImageView blackPawn3;
    @FXML
    private ImageView blackPawn4;
    @FXML
    private ImageView blackPawn5;
    @FXML
    private ImageView blackPawn6;
    @FXML
    private ImageView blackPawn7;
    @FXML
    private ImageView blackPawn8;
    @FXML
    private ImageView blackQueen;
    @FXML
    private ImageView blackRook1;
    @FXML
    private ImageView blackRook2;

    static protected ImageView[][] board = new ImageView[8][8];



    DraggableMaker draggableMaker = new DraggableMaker(board);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        board[0][7] = whiteRook1;
        board[7][7] = whiteRook2;
        board[1][7] = whiteKnight1;
        board[6][7] = whiteKnight2;
        board[2][7] = whiteBishop1;
        board[5][7] = whiteBishop2;
        board[3][7] = whiteQueen;
        board[4][7] = whiteKing;
        board[0][6] = whitePawn1;
        board[1][6] = whitePawn2;
        board[2][6] = whitePawn3;
        board[3][6] = whitePawn4;
        board[4][6] = whitePawn5;
        board[5][6] = whitePawn6;
        board[6][6] = whitePawn7;
        board[7][6] = whitePawn8;

        board[0][0] = blackRook1;
        board[7][0] = blackRook2;
        board[1][0] = blackKnight1;
        board[6][0] = blackKnight2;
        board[2][0] = blackBishop1;
        board[5][0] = blackBishop2;
        board[3][0] = blackQueen;
        board[4][0] = blackKing;
        board[0][1] = blackPawn1;
        board[1][1] = blackPawn2;
        board[2][1] = blackPawn3;
        board[3][1] = blackPawn4;
        board[4][1] = blackPawn5;
        board[5][1] = blackPawn6;
        board[6][1] = blackPawn7;
        board[7][1] = blackPawn8;

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
