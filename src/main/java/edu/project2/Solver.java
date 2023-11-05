package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);

    class SolverImpl implements Solver {

        @Override
        public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
            List<Coordinate> path = new ArrayList<>();

            // Создание очереди для поиска в ширину
            Queue<Coordinate> queue = new LinkedList<>();
            Map<Coordinate, Coordinate> parentMap = new HashMap<>();

            // Добавление стартовой точки в очередь
            queue.add(start);
            parentMap.put(start, null);

            while (!queue.isEmpty()) {
                Coordinate current = queue.poll();

                // Проверка, достигнута ли конечная точка
                if (current.equals(end)) {
                    // Восстановление пути, начиная от конечной точки
                    while (current != null) {
                        path.add(current);
                        current = parentMap.get(current);
                    }

                    // Переворачивание пути, чтобы он начинался с стартовой точки
                    Collections.reverse(path);
                    break;
                }

                // Поиск соседних проходов от текущей точки
                List<Coordinate> neighbors = getPassageNeighbors(maze, current);

                for (Coordinate neighbor : neighbors) {
                    if (!parentMap.containsKey(neighbor)) {
                        // Добавление соседней точки в очередь и сохранение родительской точки
                        queue.add(neighbor);
                        parentMap.put(neighbor, current);
                    }
                }
            }

            return path;
        }

        // Вспомогательный метод для получения соседних проходов от заданной точки
        private List<Coordinate> getPassageNeighbors(Maze maze, Coordinate coordinate) {
            int row = coordinate.row();
            int col = coordinate.col();

            List<Coordinate> neighbors = new ArrayList<>();

            if (row - 1 >= 0 && maze.grid()[row - 1][col].type() == Cell.Type.PASSAGE) {
                neighbors.add(new Coordinate(row - 1, col));
            }
            if (col - 1 >= 0 && maze.grid()[row][col - 1].type() == Cell.Type.PASSAGE) {
                neighbors.add(new Coordinate(row, col - 1));
            }
            if (row + 1 < maze.height() && maze.grid()[row + 1][col].type() == Cell.Type.PASSAGE) {
                neighbors.add(new Coordinate(row + 1, col));
            }
            if (col + 1 < maze.width() && maze.grid()[row][col + 1].type() == Cell.Type.PASSAGE) {
                neighbors.add(new Coordinate(row, col + 1));
            }

            return neighbors;
        }
    }
}
