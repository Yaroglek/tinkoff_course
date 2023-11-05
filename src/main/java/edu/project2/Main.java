package edu.project2;

public class Main {
    private Main() {

    }

    public static void main(String[] args) {
        var generator = new Generator.GeneratorImpl();
        var maze = generator.generate(21, 31);

        var solver = new Solver.SolverImpl();
        var path = solver.solve(
            maze,
            new Coordinate(1, 1),
            new Coordinate(maze.height() - 1, maze.width() - 1)
        );

        var rend = new Renderer.RendererImpl();
        System.out.print(rend.render(maze));
        System.out.print(rend.render(maze, path));
    }
}
