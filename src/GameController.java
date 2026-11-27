import java.util.ArrayList;
import java.util.Arrays;

public class GameController implements Runnable{
    
    public GameController() {

    }

    public void run() {
        boolean game = true;

         Map map = new Map(new int[]{10, 10}, "test", -1);
        map.displayMap();
        Player player = new Player(map);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy.Page(map));
        enemies.add(new Enemy.Knight(map));

        for (Enemy enemy : enemies) {
            IO.println(enemy.getClass().getSimpleName() + " spawned at " +
                Arrays.toString(enemy.getPosition()));

            int[][] moves = enemy.getAvailableMoves(map);
            
            for (int[] move : moves) {
                if (!map.getCell(move).getOccupied()) {
                    map.getCell(move).addState("threatened");
                }
            }
        }
        while (game) {
            int[][] movelist = player.getAvailableMoves(map);
            for (int[] move : movelist) {
                if (!map.getCell(move).getOccupied()) {
                    map.getCell(move).addState("move");
                }
            }
            map.displayMap();
            IO.println("Enter Move From List") ;
            for (int[] i : movelist) {
                for (int j : i) {
                    IO.print(j + ",");
                }
                IO.print(" ");
            }
            String[] sMove = IO.readln().split(",");
            if (sMove[0].equals("Exit")){
                break;
            }
            int[] move = new int[2];
            for (int i = 0; i < 2; i++) {
                move[i] = Integer.parseInt(sMove[i]);
            }
            for (Enemy enemy : enemies) {
                int[][] moves = enemy.getAvailableMoves(map);
                for (int[] m : moves) {
                    map.getCell(m).removeState("threatened");
                }
                
            }
            boolean flag = false;
            for (int[] m : movelist) {
                map.getCell(m).removeState("move");
                if (Arrays.equals(m, move)) {
                    player.move(move, map);
                    flag = true;
                    moveEnemies(enemies, map);
                }
            }
            if (!flag) {
                IO.println("Enter a valid move");
            }

            for (Enemy enemy : enemies) {
                int[][] moves = enemy.getAvailableMoves(map);
                
                for (int[] m : moves) {
                    if (!map.getCell(m).getOccupied()) {
                        map.getCell(m).addState("threatened");
                    }
                }
            }
            

        }
    }

    public void moveEnemies(ArrayList<Enemy> enemies, Map map) {
        
        for (Enemy enemy : enemies) {
            //if (enemy.getAttack(map) != null) {
              //  enemy.move(enemy.getAttack(map), map);
            //} else {
                int[] playerPos = map.getPlayer();
                int xDiff = 0;
                int yDiff = 0;
                int bestDistance = Integer.MAX_VALUE;
                int[] bestMove = null;
                for (int[] move : enemy.getAvailableMoves(map)){
                    xDiff = Math.abs(move[0] - playerPos[0]);
                    yDiff = Math.abs(move[1] - playerPos[1]);
                    int distance = xDiff + yDiff;
                    if (distance < bestDistance) {
                        bestDistance = distance;
                        bestMove = move;
                    }

                }
                
                if (bestMove != null) {
                    enemy.move(bestMove, map);
                }
          //  }
        }
    }
    

}
