package edu.project2;

import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Coordinate> path);

    class RendererImpl implements Renderer {

        @Override
        public String render(Maze maze) {
            StringBuilder output = new StringBuilder();

            for (Cell[] row : maze.grid()) {
                for (Cell cell : row) {
                    switch (cell.type()) {
                        case WALL -> output.append("XXX");
                        case PASSAGE -> output.append("   ");
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
                    switch (cell.type()) {
                        case WALL -> output.append("XXX");
                        case PASSAGE -> output.append("   ");

                        default -> throw new RuntimeException();
                    }
                }
                output.append("\n");
            }

            return output.toString();
        }
    }
}
