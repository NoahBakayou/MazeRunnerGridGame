# MazeRunnerGridGame: A Java Console Adventure

## About the Game
MazeRunnerGridGame is a Java-based console game that challenges players to navigate through a 10x10 grid filled with hidden walls. The player aims to reach the bottom right corner of the grid without hitting any walls. The game's grid is dynamically generated in each session, making every playthrough unique.

## Technical Highlights

### Dynamic Grid Generation
Utilizes a 2D integer array (`int[][] aiGrid`) to represent the game grid, with each cell potentially being a wall or a path.
```java
int[][] aiGrid = new int[10][10];
```
### Secure Randomization
Employs java.security.SecureRandom to randomly place walls within the grid, enhancing the unpredictability of the game.

```java
SecureRandom oRand = new SecureRandom();
```
### Player Interaction
Uses a java.util.Scanner object to capture player input, allowing for interactive movement within the grid.

```java
Scanner scanner = new Scanner(System.in);
int ans = scanner.nextInt();
```

### Game Mechanics
Implements logic to update the player's position and check for walls, using a mix of conditional statements and loops.
```java
if (ans == 1) {
    printBoard[iUserCol][iUserRow] = clearedSpace;
    iUserRow++;
    if (iUserRow < aiGrid[0].length) {
        printBoard[iUserCol][iUserRow] = playerPiece;
        if (aiGrid[iUserCol][iUserRow] == 1) {
            printBoard[iUserCol][iUserRow] = wall;
            System.out.println("You hit a wall. You lose.");
            break;
        }
    } else {
        System.out.println("You moved outside the grid. You lose.");
        break;
    }
} else if (ans == 2) {
    printBoard[iUserCol][iUserRow] = clearedSpace;
    iUserCol++;
    if (iUserCol < aiGrid.length) {
        printBoard[iUserCol][iUserRow] = playerPiece;
        if (aiGrid[iUserCol][iUserRow] == 1) {
            printBoard[iUserCol][iUserRow] = wall;
            System.out.println("You hit a wall. You lose.");
            break;
        }
    } else {
        System.out.println("You moved outside the grid. You lose.");
        break;
    }
}
// Code to update the grid display
for (int y = 0; y < aiGrid.length; y++) {
    for (int x = 0; x < aiGrid[0].length; x++) {
        System.out.print(printBoard[y][x] + "  ");
    }
    System.out.println();
}
// Check for winner
if (iUserRow == 9 && iUserCol == 9) {
    System.out.println("You reached the end! You win!");
    break;
}
```
## How to Play
1. **Start the Game**: Run the `GameGrid` class in your Java environment.
2. **Navigate the Grid**: Use the console to input your moves.
   - Press `1` to move right.
   - Press `2` to move down.
3. **Winning and Losing**:
   - Reach the bottom right corner of the grid to win.
   - Hitting a wall results in a loss.
     
### Contributing
Contributions to MazeRunnerGridGame are welcome! Whether it's bug fixes, new features or improvements to existing features, I value any input. Please send pull requests or open an issue to discuss proposed changes.
