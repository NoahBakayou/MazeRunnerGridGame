import java.security.SecureRandom;

public class GameGrid_Test {
    public static void main(String[] args) {

        //this is how you call a non-static method
        // you generally want to avoid static, it's dangerous.
        GameGrid oGameGrid1 = new GameGrid();
        //oWeek3.runTest1();
        oGameGrid1.run();

    }
}
