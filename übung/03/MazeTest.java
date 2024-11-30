class MazeTest {

    @org.junit.jupiter.api.Test
    void isValidPath() {
       for (int i = 0; i < Maze.EXAMPLE_MAZE.length; i++) {
           assert Maze.isValidPath(Maze.loadExampleMaze(i), Maze.EXAMPLE_PATH[i]);
       }

       assert !(Maze.isValidPath(Maze.loadExampleMaze(0), new int[][]{{0,0}, {0,2}} ));
       assert !(Maze.isValidPath(Maze.loadExampleMaze(0), new int[][]{{0,1}} ));
    }
}