import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {
      System.out.println("Welcome to Battleship!\n");
      Scanner input = new Scanner(System.in);

      System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
      int[][] player1Shipes = initPlayerShips(input);
      char[][] player1Board = initPlayerBoard(player1Shipes);
      printBattleShip(player1Board);
      for (int i = 0; i < 100; i++) {
        System.out.println();
      }

      System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
      int[][] player2Shipes = initPlayerShips(input);
      char[][] player2Board = initPlayerBoard(player2Shipes);
      printBattleShip(player2Board);
      for (int i = 0; i < 100; i++) {
        System.out.println();
      }



      int[][] player1Hits = new int[25][2];
      for (int i = 0; i < player1Hits.length; i++) {
        player1Hits[i] = new int[] { -1, -1};
      }
      int player1HitSize = 0;


      int[][] player2Hits = new int[25][2];
      for (int i = 0; i < player2Hits.length; i++) {
        player2Hits[i] = new int[] { -1, -1};
      }
      int player2HitSize = 0;



      boolean gameOver = false;
      int numA = 1;

      do {
        int[][] playerHits = numA == 1 ? player1Hits : player2Hits;
        int[][] targetShips = numA == 1 ? player2Shipes : player1Shipes;

        int[] playerHit = new int[2];
        boolean invalidHit = true;
        do {
          System.out.println("Player " + numA + ", enter hit row/column:");

          playerHit[0] = input.nextInt();
          playerHit[1] = input.nextInt();
          if (isInvalidCoordinates(playerHit)) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            continue;
          }
          if (matchCoordinates(playerHit, playerHits)) {
            System.out.println("You already fired on this spot. Choose different coordinates.");
            continue;
          }
          invalidHit = false;
        } while (invalidHit);

        playerHits[ numA == 1 ? player1HitSize : player2HitSize] = playerHit;
        if (numA == 1) {
          player1HitSize++;
        } else {
          player2HitSize++;
        }

        if (matchCoordinates(playerHit, targetShips)) {
          System.out.println("PLAYER " + (numA == 1 ? 1 : 2) + " HIT PLAYER " + (numA == 1 ? 2 : 1) + "'s SHIP!");
        } else  {
          System.out.println("PLAYER " + (numA == 1 ? 1 : 2) + " MISSED!");
        }

        char[][] playerBoard = new char[5][5];
        for (int row = 0; row < 5; row++) {
          for (int column = 0; column < 5; column++) {
            int[] coordinates = {row, column};
            if (matchCoordinates(coordinates, playerHits)) {
              if (matchCoordinates(coordinates, targetShips)) {
                playerBoard[row][column] = 'X';
              } else {
                playerBoard[row][column] = 'O';
              }
            } else {
              playerBoard[row][column] = '-';
            }
          }
        }
        printBattleShip(playerBoard);

        if (isAllShipsSunk(playerHits, targetShips)) {
          System.out.println("PLAYER " + numA + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
          gameOver = true;
        } else {
          numA = numA == 1 ? 2 : 1;
        }

        System.out.println();
      } while (!gameOver);

      System.out.println("Final boards:");
      System.out.println();

      char[][] player1FinalBoard = new char[5][5];
      for (int row = 0; row < 5; row++) {
        for (int column = 0; column < 5; column++) {
          int[] coordinates = {row, column};
          if (matchCoordinates(coordinates, player2Hits)) {
            if (matchCoordinates(coordinates, player1Shipes)) {
              player1FinalBoard[row][column] = 'X';
            } else {
              player1FinalBoard[row][column] = 'O';
            }
          } else if (matchCoordinates(coordinates, player1Shipes)) {
            player1FinalBoard[row][column] = '@';
          } else {
            player1FinalBoard[row][column] = '-';
          }
        }
      }
      printBattleShip(player1FinalBoard);
      System.out.println();

      char[][] player2FinalBoard = new char[5][5];
      for (int row = 0; row < 5; row++) {
        for (int column = 0; column < 5; column++) {
          int[] coordinates = {row, column};
          if (matchCoordinates(coordinates, player1Hits)) {
            if (matchCoordinates(coordinates, player2Shipes)) {
              player2FinalBoard[row][column] = 'X';
            } else {
              player2FinalBoard[row][column] = 'O';
            }
          } else if (matchCoordinates(coordinates, player2Shipes)) {
            player2FinalBoard[row][column] = '@';
          } else {
            player2FinalBoard[row][column] = '-';
          }
        }
      }
      printBattleShip(player2FinalBoard);

    }

    private static boolean isAllShipsSunk(int[][] playerHits, int[][] targetShips) {
      int matchedQty = 0;
      for (int[] hit : playerHits) {
        for (int[] ship:targetShips) {
          if (hit[0] == ship[0] && hit[1] == ship[1]) {
            matchedQty++;
          }
        }
      }
      boolean allShipsSunk = matchedQty == targetShips.length;
      return allShipsSunk;
    }

    private static int[][] initPlayerShips(Scanner input) {
      int[][] playerShips = new int[5][2];
      for (int i = 0; i < playerShips.length; i++) {
        playerShips[i] = new int[] { -1, -1};
      }
      for (int i = 0; i < 5; i++) {
        System.out.println("Enter ship " + (i + 1) + " location:");
        int row = input.nextInt();
        int column = input.nextInt();
        int[] newCoordinates = {row, column};
        if (isInvalidCoordinates(newCoordinates)) {
          System.out.println("Invalid coordinates. Choose different coordinates.");
          i--;
          continue;
        }
        if (matchCoordinates(newCoordinates, playerShips)) {
          System.out.println("You already have a ship there. Choose different coordinates.");
          i--;
          continue;
        }
        playerShips[i][0] = row;
        playerShips[i][1] = column;
      }

      return playerShips;
    }

    private static boolean isInvalidCoordinates(int[] coordinates) {
      if (coordinates[0] < 0 || coordinates[0] > 4 || coordinates[1] < 0 || coordinates[1] > 4) {
        return true;
      }
      return false;
    }

    private static char[][] initPlayerBoard(int[][] playerShips) {
      char[][] playerBoard = new char[5][5];

      for (int row = 0; row < 5; row++) {
        for (int column = 0; column < 5; column++) {
          int[] coordinates = {row, column};
          if (matchCoordinates(coordinates, playerShips)) {
            playerBoard[row][column] = '@';
          } else {
            playerBoard[row][column] = '-';
          }
        }
      }
      return playerBoard;
    }

    private static boolean matchCoordinates(int[] coordinates, int[][] ships) {
      for (int[] ship : ships) {
        if (coordinates[0] == ship[0] && coordinates[1] == ship[1]) {
          return true;
        }
      }
      return false;
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}
