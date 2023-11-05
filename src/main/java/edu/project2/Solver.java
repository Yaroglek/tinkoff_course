package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);

    class SolverImpl implements Solver {

        @Override
        public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
            List<Coordinate> path = new ArrayList<>();

            var queue = new ArrayDeque<Coordinate>();
            Map<Coordinate, Coordinate> parentMap = new HashMap<>();

            queue.add(start);
            parentMap.put(start, null);

            while (!queue.isEmpty()) {
                Coordinate current = queue.poll();

                if (current.equals(end)) {
                    while (current != null) {
                        path.add(current);
                        current = parentMap.get(current);
                    }

                    // Переворачивание пути, чтобы он начинался со стартовой точки
                    Collections.reverse(path);
                    break;
                }

                List<Coordinate> neighbors = getPassageNeighbors(maze, current.row(), current.col());

                for (Coordinate neighbor : neighbors) {
                    if (!parentMap.containsKey(neighbor)) {
                        queue.add(neighbor);
                        parentMap.put(neighbor, current);
                    }
                }
            }

            return path;
        }

        private List<Coordinate> getPassageNeighbors(Maze maze, int row, int col) {
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
