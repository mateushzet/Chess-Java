package com.example.chess;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;
    static String turn = "white";
    private int nodeX;
    private int nodeY;
    private String color;
    static protected ImageView[][] board;
    private ImageView temp;

    public DraggableMaker(ImageView[][] board) {
        this.board = board;
    }

    public void makeDraggable(Node node){

        node.setOnMousePressed(mouseEvent -> {
            nodeX = (int)node.getLayoutX();
            nodeY = (int)node.getLayoutY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            color = node.getId().substring(0,5);
            if(turn.equals(color)) {
                if (mouseEvent.getSceneX() - mouseAnchorX > 700)
                    node.setLayoutX(700);
                else if (mouseEvent.getSceneX() - mouseAnchorX < 0)
                    node.setLayoutX(0);
                else
                    node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX-50);

                if (mouseEvent.getSceneY() - mouseAnchorY > 700)
                    node.setLayoutY(700);
                else if (mouseEvent.getSceneY() - mouseAnchorY < 0)
                    node.setLayoutY(0);
                else
                    node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY-50);

            }
        });

        node.setOnMouseReleased(mouseDragEvent -> {

            color = node.getId().substring(0,5);
            if(turn.equals(color)) {
                int fieldX, fieldY;
                if (mouseDragEvent.getSceneX() > 700)
                    fieldX = 700;
                else if (mouseDragEvent.getSceneX() < 0)
                    fieldX = 0;
                else
                    fieldX = (int) mouseDragEvent.getSceneX() / 100 * 100;

                if (mouseDragEvent.getSceneY() > 700)
                    fieldY = 700;
                else if (mouseDragEvent.getSceneY() < 0)
                    fieldY = 0;
                else
                    fieldY = (int) mouseDragEvent.getSceneY() / 100 * 100;




                System.out.println();
                if(board[fieldX/100][fieldY/100] != null)
                board[fieldX/100][fieldY/100].setVisible(false);
                board[fieldX/100][fieldY/100] = board[nodeX/100][nodeY/100];
                board[nodeX/100][nodeY/100] = null;
                node.setLayoutX(fieldX);
                node.setLayoutY(fieldY);
                turn = turn.equals("white") ? "black" : "white";

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8 ; j++) {
                        if(board[j][i]!=null)
                        System.out.print("X");
                        else System.out.print("_");
                    }
                    System.out.println();
                }
            }

        });
    }
}
