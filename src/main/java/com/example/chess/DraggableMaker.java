package com.example.chess;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;
    static String turn = "W";
    private int startCoordinatesX;
    private int startCoordinatesY;
    private int startX;
    private int startY;
    private String color;
    static protected ImageView[][] board;
    int[] blackKing;
    int[] whiteKing;

    public DraggableMaker(ImageView[][] board) {
        this.board = board;
        blackKing = new int[2];
        whiteKing = new int[2];
        blackKing[0] = 4;
        blackKing[1] = 0;
        whiteKing[0] = 4;
        whiteKing[1] = 7;
    }

    public void makeDraggable(Node node) {

        node.setOnMousePressed(mouseEvent -> {
            startCoordinatesX = (int) node.getLayoutX();
            startCoordinatesY = (int) node.getLayoutY();
            startX = startCoordinatesX/100;
            startY = startCoordinatesY/100;
            color = node.getId().substring(0, 1);
            paintFields(startX, startY, node);
        });

        node.setOnMouseDragged(mouseEvent -> {
            if (turn.equals(color)) {
                node.setLayoutX(
                        Math.max(0, Math.min(700, mouseEvent.getSceneX() - mouseAnchorX - 50))
                );
                node.setLayoutY(
                        Math.max(0, Math.min(700, mouseEvent.getSceneY() - mouseAnchorY - 50))
                );
            }
        });

        node.setOnMouseReleased(mouseDragEvent -> {
            if (turn.equals(color)) {
                int targetCoordinatesX = Math.max(0, Math.min(700, (int) mouseDragEvent.getSceneX() / 100 * 100));
                int targetCoordinatesY = Math.max(0, Math.min(700, (int) mouseDragEvent.getSceneY() / 100 * 100));
                int targetX = targetCoordinatesX / 100;
                int targetY = targetCoordinatesY / 100;
                makeMove(targetX, targetY, targetCoordinatesX, targetCoordinatesY, node);
            }
        });
    }

    private boolean isMoveLegal(int startX, int startY, int targetX, int targetY, Node node) {
        char pieceType = node.getId().charAt(1);
        char pieceColor = node.getId().charAt(0);
        switch (pieceType) {
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
                    if (allyOnField(board[targetX][targetY], pieceColor)) {
                        return false;
                    } else return true;
                } else {
                    return false;
                }

            case 'K':
                if ((targetX == startX + 1 && targetY == startY + 2) || (targetX == startX - 1 && targetY == startY + 2) ||
                        (targetX == startX + 1 && targetY == startY - 2) || (targetX == startX - 1 && targetY == startY - 2) ||
                        (targetX == startX + 2 && targetY == startY + 1) || (targetX == startX - 2 && targetY == startY + 1) ||
                        (targetX == startX + 2 && targetY == startY - 1) || (targetX == startX - 2 && targetY == startY - 1)) {
                    if (allyOnField(board[targetX][targetY], pieceColor)) {
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
                        if (x < 0 || y < 0) {
                            return false;
                        }
                        if (board[x][y] != null) {
                            return false;
                        }
                        x += dx;
                        y += dy;
                    }
                    if (allyOnField(board[targetX][targetY], pieceColor)) {
                        return false;
                    } else return true;
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
                    if (allyOnField(board[targetX][targetY], pieceColor)) {
                        return false;
                    } else return true;
                } else {
                    return false;
                }

            case 'k':
                int dx = Math.abs(targetX - startX);
                int dy = Math.abs(targetY - startY);
                if (dx <= 1 && dy <= 1) {
                    if (allyOnField(board[targetX][targetY], pieceColor)) {
                        return false;
                    } else return true;
                } else {
                    return false;
                }

            case 'P':
                if (pieceColor == 'B') {
                    if (startX == targetX && targetY - startY == 1 && board[targetX][targetY] == null) {
                        return true;
                    }
                    if (startX == targetX && targetY - startY == 2 && board[targetX][targetY - 1] == null && board[targetX][targetY] == null && startY == 1) {
                        return true;
                    }
                    if ((startX - targetX == 1 || startX - targetX == -1) && targetY - startY == 1 && enemyOnField(board[targetX][targetY], pieceColor)) {
                        return true;
                    } else return false;

                } else {
                    if (startX == targetX && targetY - startY == -1 && board[targetX][targetY] == null) {
                        return true;
                    }
                    if (startX == targetX && targetY - startY == -2 && board[targetX][targetY + 1] == null && board[targetX][targetY] == null && startY == 6) {
                        return true;
                    }
                    if ((startX - targetX == 1 || startX - targetX == -1) && targetY - startY == -1 && enemyOnField(board[targetX][targetY], pieceColor)) {
                        return true;
                    } else return false;

                }
        }
        return false;
    }

    boolean enemyOnField(ImageView field, char pieceColor) {
        if (field == null)
            return false;
        if (field.getId().charAt(0) == pieceColor)
            return false;
        return true;
    }

    boolean allyOnField(ImageView field, char pieceColor) {
        if (field == null)
            return false;
        if (field.getId().charAt(0) == pieceColor)
            return true;
        return false;
    }

    void paintFields(int startX, int startY, Node node) {
        if (turn.equals(String.valueOf(node.getId().charAt(0)))){
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

    void clearPaint() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String color = ((i + j) % 2 == 0) ? "#ecffbf" : "#47ae47";
                Controller.boardFields[j][i].setFill(Paint.valueOf(color));
            }
        }
    }

    boolean checkChecker(String player) {
        boolean isCheck = false;
        for (int i = 0; i < 8 && !isCheck; i++) {
            for (int j = 0; j < 8 && !isCheck; j++) {
                if (board[i][j] != null) {
                    if (player.equals("W")) {
                        isCheck = isMoveLegal(i, j, whiteKing[0], whiteKing[1], board[i][j]) ? true : false;
                    } else {
                        isCheck = isMoveLegal(i, j, blackKing[0], blackKing[1], board[i][j]) ? true : false;
                    }
                }
            }
        }
        return isCheck;
    }

    private void updateKingsPosition(int targetX, int targetY, Node node) {
        if(node.getId().charAt(1) =='k'){
            if(color.equals("W")){
                whiteKing[0] = targetX;
                whiteKing[1] = targetY;
            } else{
                blackKing[0] = targetX;
                blackKing[1] = targetY;
            }
        }
    }

    void checkPaint(){
        if(checkChecker("W")) {
            Controller.boardFields[whiteKing[0]][whiteKing[1]].setFill(Paint.valueOf("red"));
        }
        if(checkChecker("B")) {
            Controller.boardFields[blackKing[0]][blackKing[1]].setFill(Paint.valueOf("red"));
        }
    }

    void makeMove(int targetX, int targetY, int targetCoordinatesX, int targetCoordinatesY, Node node){
        boolean canMove = isMoveLegal(startX, startY, targetX, targetY, node);
        boolean isKingMove = node.getId().charAt(1) == 'k';
        boolean isNotCheck = !checkChecker(color);

        if (canMove && (isNotCheck || isKingMove)){
            if (board[targetX][targetY] != null) board[targetX][targetY].setVisible(false);
            board[targetX][targetY] = board[startX][startY];
            board[startX][startY] = null;
            node.setLayoutX(targetCoordinatesX);
            node.setLayoutY(targetCoordinatesY);
            turn = turn.equals("W") ? "B" : "W";
            updateKingsPosition(targetX, targetY, node);
            clearPaint();
            checkPaint();
        } else {
            node.setLayoutX(startCoordinatesX);
            node.setLayoutY(startCoordinatesY);
            clearPaint();
            checkPaint();
        }
    }
}