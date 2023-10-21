package edu.hw1;

public class Task8 {
    private Task8() {
    }

    private static final int[][] POSSIBLE_WAYS =
        new int[][] {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static boolean knightBoardCapture(int[][] field) {
        for (var i = 0; i < field.length; i++) {
            for (var j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    for (var el : POSSIBLE_WAYS) {
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
