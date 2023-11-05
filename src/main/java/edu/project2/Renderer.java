package edu.project2;

import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Coordinate> path);

    class RendererImpl implements Renderer {
        private static final String WALL = "XXX";
        private static final String PASSAGE = "   ";
        private static final String PATH = " . ";

        @Override
        public String render(Maze maze) {
            StringBuilder output = new StringBuilder();

            for (Cell[] row : maze.grid()) {
                for (Cell cell : row) {
                    switch (cell.type()) {
                        case WALL -> output.append(WALL);
                        case PASSAGE -> output.append(PASSAGE);
                        default -> throw new RuntimeException();
                    }
                }
                output.append("\n");
            }

            return output.toString();
        }

        @Override
        public String render(Maze maze, List<Coordinate> path) {
            StringBuilder output = new StringBuilder();

            for (Cell[] row : maze.grid()) {
                for (Cell cell : row) {
                    Coordinate currentCoordinate = new Coordinate(cell.row(), cell.col());
                    if (path.contains(currentCoordinate)) {
                        output.append(PATH);
                    } else {
                        switch (cell.type()) {
                            case WALL -> output.append(WALL);
                            case PASSAGE -> output.append(PASSAGE);

                            default -> throw new RuntimeException();
                        }
                    }
                }
                output.append("\n");
            }

            return output.toString();
        }
    }
}
