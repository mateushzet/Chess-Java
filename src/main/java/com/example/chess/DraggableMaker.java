package com.example.chess;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;
    static String turn = "W";
    private int startX;
    private int startY;
    private String color;
    static protected ImageView[][] board;
    private ImageView temp;

    public DraggableMaker(ImageView[][] board) {
        this.board = board;
    }

    public void makeDraggable(Node node){

        node.setOnMousePressed(mouseEvent -> {
            startX = (int)node.getLayoutX();
            startY = (int)node.getLayoutY();
        });

        node.setOnMouseDragged(mouseEvent -> {
            color = node.getId().substring(0,1);
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

            color = node.getId().substring(0,1);
            if(turn.equals(color)) {
                int targetX, targetY;
                if (mouseDragEvent.getSceneX() > 700)
                    targetX = 700;
                else if (mouseDragEvent.getSceneX() < 0)
                    targetX = 0;
                else
                    targetX = (int) mouseDragEvent.getSceneX() / 100 * 100;

                if (mouseDragEvent.getSceneY() > 700)
                    targetY = 700;
                else if (mouseDragEvent.getSceneY() < 0)
                    targetY = 0;
                else
                    targetY = (int) mouseDragEvent.getSceneY() / 100 * 100;


                System.out.println(node.getId());

                if(isMoveLegal(startX, startY, targetX, targetY, node)){
                if(board[targetX/100][targetY/100] != null)
                board[targetX/100][targetY/100].setVisible(false);
                board[targetX/100][targetY/100] = board[startX /100][startY /100];
                board[startX /100][startY /100] = null;
                node.setLayoutX(targetX);
                node.setLayoutY(targetY);
                turn = turn.equals("W") ? "B" : "W";

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8 ; j++) {
                        if(board[j][i]!=null)
                        System.out.print("X");
                        else System.out.print("_");
                    }
                    System.out.println();
                }
            } else{
                    node.setLayoutX(startX);
                    node.setLayoutY(startY);
                }
            }

        });
    }
    private boolean isMoveLegal(int startX, int startY, int targetX, int targetY, Node node){
        char pieceType = node.getId().charAt(0);
        switch (pieceType){
            case 'R':

                break;

            case 'K':

                break;

            case 'B':

                break;

            case 'Q':

                break;

            case 'k':

                break;

            case 'P':
                if(startY>targetY){
                    if
                }
                break;
        }
        return true;
    }
}
