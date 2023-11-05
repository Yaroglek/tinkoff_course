package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Generator {
    Maze generate(int height, int width);

    // Генератор лабиринта использует упрощенный алгоритм Прима (т.е. без весов ребер).
    class GeneratorImpl implements Generator {

        @Override
        public Maze generate(int height, int width) {
            Cell[][] grid = new Cell[height][width];

            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    grid[row][col] = new Cell(row, col, Cell.Type.WALL);
                }
            }

            // Начальная клетка берется с нечетными координатами, для того чтобы генератор лабиринта изначально создавал
            // его со стенами и их не приходилось отрисовывать в дальнейшем отдельно.
            Random random = new Random();
            int startRow = random.nextInt(0, height / 2) * 2 + 1;
            int startCol = random.nextInt(0, width / 2) * 2 + 1;

            grid[startRow][startCol] = new Cell(startRow, startCol, Cell.Type.PASSAGE);

            var stack = new ArrayDeque<Coordinate>();
            stack.push(new Coordinate(startRow, startCol));

            while (!stack.isEmpty()) {
                Coordinate current = stack.pop();
                int currentRow = current.row();
                int currentCol = current.col();
                var neighbors = getUnvisitedNeighbors(currentRow, currentCol, grid);

                if (!neighbors.isEmpty()) {
                    stack.push(current);
                    Cell randomNeighbor = neighbors.get(random.nextInt(0, neighbors.size()));
                    int neighborRow = randomNeighbor.row();
                    int neighborCol = randomNeighbor.col();

                    // Это координаты точки, находящейся между current и randomNeighbor.
                    // Ее также необходимо сделать PASSAGE, чтобы соединить их.
                    int middleRow = currentRow + (neighborRow - currentRow) / 2;
                    int middleCol = currentCol + (neighborCol - currentCol) / 2;

                    grid[neighborRow][neighborCol] = new Cell(neighborRow, neighborCol, Cell.Type.PASSAGE);
                    grid[middleRow][middleCol] = new Cell(middleRow, middleCol, Cell.Type.PASSAGE);

                    stack.push(new Coordinate(neighborRow, neighborCol));
                }
            }

            return new Maze(height, width, grid);
        }

        private List<Cell> getUnvisitedNeighbors(int row, int col, Cell[][] grid) {
            List<Cell> neighbors = new ArrayList<>();

            if (row - 2 >= 0 && grid[row - 2][col].type() == Cell.Type.WALL) {
                neighbors.add(grid[row - 2][col]);
            }
            if (row + 2 < grid.length && grid[row + 2][col].type() == Cell.Type.WALL) {
                neighbors.add(grid[row + 2][col]);
            }
            if (col - 2 >= 0 && grid[row][col - 2].type() == Cell.Type.WALL) {
                neighbors.add(grid[row][col - 2]);
            }
            if (col + 2 < grid[0].length && grid[row][col + 2].type() == Cell.Type.WALL) {
                neighbors.add(grid[row][col + 2]);
            }

            return neighbors;
        }
    }
}
