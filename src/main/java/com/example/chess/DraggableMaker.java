package com.example.chess;

import javafx.scene.Node;

import static java.lang.Math.round;

public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;
    static String turn = "white";
    String color;

    public void makeDraggable(Node node){

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

                node.setLayoutX(fieldX);
                node.setLayoutY(fieldY);

                turn = turn.equals("white") ? "black" : "white";
            }
        });
    }
}
