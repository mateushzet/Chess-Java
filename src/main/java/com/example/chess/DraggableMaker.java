package com.example.chess;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

import static java.lang.Math.abs;

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
            color = node.getId().substring(0,1);
            paintFields(startX/100, startY/100, node);
        });

        node.setOnMouseDragged(mouseEvent -> {
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

                if(isMoveLegal(startX/100, startY/100, targetX/100, targetY/100, node)){
                if(board[targetX/100][targetY/100] != null)
                board[targetX/100][targetY/100].setVisible(false);
                board[targetX/100][targetY/100] = board[startX /100][startY /100];
                board[startX /100][startY /100] = null;
                node.setLayoutX(targetX);
                node.setLayoutY(targetY);
                turn = turn.equals("W") ? "B" : "W";
                clearPaint();
            } else{
                    node.setLayoutX(startX);
                    node.setLayoutY(startY);
                    clearPaint();
                }
            }

        });
    }
    private boolean isMoveLegal(int startX, int startY, int targetX, int targetY, Node node){
        char pieceType = node.getId().charAt(1);
        char pieceColor = node.getId().charAt(0);
        boolean temp = true;
        switch (pieceType){
            case 'R':
                if (targetX == startX || targetY == startY) {
                    int dx = (targetX == startX) ? 0 : (targetX - startX > 0) ? 1 : -1;
                    int dy = (targetY == startY) ? 0 : (targetY - startY > 0) ? 1 : -1;
                    int x = startX + dx;
                    int y = startY + dy;
                    while (x != targetX || y != targetY) {
                        if (board[x][y] != null) {
                            return false;
                        }
                        x += dx;
                        y += dy;
                    }
                    if(allyOnField(board[targetX][targetY], pieceColor)){
                    return false;
                    }else return true;
                } else {
                    return false;
                }

            case 'K':
                if ((targetX == startX + 1 && targetY == startY + 2) || (targetX == startX - 1 && targetY == startY + 2) ||
                        (targetX == startX + 1 && targetY == startY - 2) || (targetX == startX - 1 && targetY == startY - 2) ||
                        (targetX == startX + 2 && targetY == startY + 1) || (targetX == startX - 2 && targetY == startY + 1) ||
                        (targetX == startX + 2 && targetY == startY - 1) || (targetX == startX - 2 && targetY == startY - 1)) {
                    if(allyOnField(board[targetX][targetY], pieceColor)){
                        return false;
                    } else return true;
                } else {
                    return false;
                }

            case 'B':
                if (Math.abs(targetX - startX) == Math.abs(targetY - startY)) {
                    int dx = (targetX - startX > 0) ? 1 : -1;
                    int dy = (targetY - startY > 0) ? 1 : -1;
                    int x = startX + dx;
                    int y = startY + dy;
                    while (x != targetX && y != targetY) {
                        if(x<0 || y <0){
                            return false;
                        }
                        if (board[x][y] != null) {
                            return false;
                        }
                        x += dx;
                        y += dy;
                    }
                    if(allyOnField(board[targetX][targetY], pieceColor)){
                        return false;
                    }else return true;
                } else {
                    return false;
                }
            case 'Q':
                if (targetX == startX || targetY == startY || Math.abs(targetX - startX) == Math.abs(targetY - startY)) {
                    int dx = (targetX == startX) ? 0 : (targetX - startX > 0) ? 1 : -1;
                    int dy = (targetY == startY) ? 0 : (targetY - startY > 0) ? 1 : -1;
                    if (dx != 0 && dy != 0) {
                        dx = (targetX - startX > 0) ? 1 : -1;
                        dy = (targetY - startY > 0) ? 1 : -1;
                    }
                    int x = startX + dx;
                    int y = startY + dy;
                    while (x != targetX || y != targetY) {
                        if (board[x][y] != null) {
                            return false;
                        }
                        x += dx;
                        y += dy;
                    }
                    if(allyOnField(board[targetX][targetY], pieceColor)){
                        return false;
                    } else return true;
                } else {
                    return false;
                }

            case 'k':
                int dx = Math.abs(targetX - startX);
                int dy = Math.abs(targetY - startY);
                if (dx <= 1 && dy <= 1) {
                    if(allyOnField(board[targetX][targetY], pieceColor)){
                        return false;
                    }else return true;
                } else {
                    return false;
                }

            case 'P':
                    if(pieceColor == 'B'){
                        if(startX == targetX && targetY-startY==1 && board[targetX][targetY] == null){
                            return true;
                        }
                        if(startX == targetX && targetY-startY==2 && board[targetX][targetY-1] == null && board[targetX][targetY] == null && startY == 1){
                            return true;
                        }
                        if((startX-targetX == 1 || startX-targetX == -1) && targetY-startY==1 && enemyOnField(board[targetX][targetY], pieceColor)){
                            return true;
                        }else return false;

                    }else{
                        if(startX == targetX && targetY-startY==-1 && board[targetX][targetY] == null){
                            return true;
                        }
                        if(startX == targetX && targetY-startY==-2 && board[targetX][targetY+1] == null && board[targetX][targetY] == null  && startY == 6){
                            return true;
                        }
                        if((startX-targetX == 1 || startX-targetX == -1) && targetY-startY==-1 && enemyOnField(board[targetX][targetY], pieceColor)){
                            return true;
                        }else return false;

                    }
        }
        return false;
    }

    boolean enemyOnField(ImageView field, char pieceColor){
        if(field == null)
            return false;
        if(field.getId().charAt(0) == pieceColor)
            return false;
        return true;
    }

    boolean allyOnField(ImageView field, char pieceColor){
        if(field == null)
            return false;
        if(field.getId().charAt(0) == pieceColor)
            return true;
        return false;
    }

    void paintFields(int startX, int startY, Node node){
        if(turn.equals(String.valueOf(node.getId().charAt(0)))) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (isMoveLegal(startX, startY, i, j, node)) {
                        if (enemyOnField(board[i][j], node.getId().charAt(0)))
                            Controller.boardFields[i][j].setFill(Paint.valueOf("red"));
                        else Controller.boardFields[i][j].setFill(Paint.valueOf("yellow"));
                    }
                }
            }
        }
    }

    void clearPaint(){
        boolean even = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 ; j++) {
                if(even){
                    Controller.boardFields[j][i].setFill(Paint.valueOf("#ecffbf"));
                    even = false;
                } else {
                    Controller.boardFields[j][i].setFill(Paint.valueOf("#47ae47"));
                    even = true;
                }
            }
            even = (even == false? true : false);
        }
    }
}
