package edu.hw1;

public class Task8 {
    public static boolean knightBoardCapture(int[][] field) {
        var possibleWays = new int[][] {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (var i = 0; i < field.length; i++) {
            for (var j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    for (var el : possibleWays) {
                        int x = i + el[0];
                        int y = j + el[1];
                        if (x >= 0 & x < field.length & y >= 0 & y < field.length) {
                            if (field[x][y] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
