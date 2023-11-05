package edu.project2;

import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);

    class SolverImpl implements Solver {

        @Override
        public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
            return null;
        }
    }
}
