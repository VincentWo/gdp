import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MazeTest {

    @org.junit.jupiter.api.Test
    void isValidPath() {
       for (int i = 0; i < Maze.EXAMPLE_MAZE.length; i++) {
           assert Maze.isValidPath(Maze.loadExampleMaze(i), Maze.EXAMPLE_PATH[i]);
       }

       assert !(Maze.isValidPath(Maze.loadExampleMaze(0), new int[][]{{0,0}, {0,2}} ));
       assert !(Maze.isValidPath(Maze.loadExampleMaze(0), new int[][]{{0,1}} ));
    }

    @Test
    void getShortestPathLength() {
        var maze = Maze.loadExampleMaze(0);
        var cache = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        Assertions.assertEquals(11, Maze.getShortestPathLengthRekursiv(maze, -1, -1, 0, 0, 5, 4));
        Assertions.assertEquals(11, Maze.getShortestPathLengthRekursivCached(maze, cache, -1, -1, 0, 0, 5, 4));

    }
}