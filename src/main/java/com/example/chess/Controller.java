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

    DraggableMaker draggableMaker = new DraggableMaker();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        draggableMaker.makeDraggable(whiteRook1);
        draggableMaker.makeDraggable(whiteRook2);
        draggableMaker.makeDraggable(whiteKnight1);
        draggableMaker.makeDraggable(whiteKnight2);
        draggableMaker.makeDraggable(whiteBishop1);
        draggableMaker.makeDraggable(whiteBishop2);
        draggableMaker.makeDraggable(whiteQueen);
        draggableMaker.makeDraggable(whiteKing);
        draggableMaker.makeDraggable(whitePawn1);
        draggableMaker.makeDraggable(whitePawn2);
        draggableMaker.makeDraggable(whitePawn3);
        draggableMaker.makeDraggable(whitePawn4);
        draggableMaker.makeDraggable(whitePawn5);
        draggableMaker.makeDraggable(whitePawn6);
        draggableMaker.makeDraggable(whitePawn7);
        draggableMaker.makeDraggable(whitePawn8);

        draggableMaker.makeDraggable(blackRook1);
        draggableMaker.makeDraggable(blackRook2);
        draggableMaker.makeDraggable(blackKnight1);
        draggableMaker.makeDraggable(blackKnight2);
        draggableMaker.makeDraggable(blackBishop1);
        draggableMaker.makeDraggable(blackBishop2);
        draggableMaker.makeDraggable(blackQueen);
        draggableMaker.makeDraggable(blackKing);
        draggableMaker.makeDraggable(blackPawn1);
        draggableMaker.makeDraggable(blackPawn2);
        draggableMaker.makeDraggable(blackPawn3);
        draggableMaker.makeDraggable(blackPawn4);
        draggableMaker.makeDraggable(blackPawn5);
        draggableMaker.makeDraggable(blackPawn6);
        draggableMaker.makeDraggable(blackPawn7);
        draggableMaker.makeDraggable(blackPawn8);

    }
}
