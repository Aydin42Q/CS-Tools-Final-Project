import java.util.Arrays;

public class GameController implements Runnable{
    
    public GameController() {

    }

    public void run() {
        boolean game = true;

         Map map = new Map(new int[]{10, 10}, "test", -1);
        map.displayMap();
        Player player = new Player(map);
        while (game) {
            map.displayMap();
            int[][] movelist = player.getAvailableMoves(map);
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
            for (int[] m : movelist) {
                if (Arrays.equals(m, move)) {
                    player.move(move, map);
                    continue;
                }
            }
            IO.println("Enter a valid move");

        }
    }
    

}
