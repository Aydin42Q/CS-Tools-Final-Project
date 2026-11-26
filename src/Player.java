import java.util.ArrayList;
import java.util.Random;

public class Player extends Entity {
    
    public Player(Map map) {
        super(getSpawn(map));
        map.getCell(super.getPosition()).setOccupied(true);
        map.getCell(super.getPosition()).addState("Player");
        
    }

    public static int[] getSpawn(Map map) {
        int[] dimensions = map.getDimensions();
        int x = dimensions[0];
        int y = dimensions[1];

        Random random = new Random();
        int row = (x/2) + random.nextInt(x - (x/2) - 1);
        int col = 1 + random.nextInt(y - 2);
        while (true) {
            if (map.getCell(new int[]{row, col}).getOccupied() || 
                !map.getCell(new int[]{row, col}).isTraverseable()) {
                row = (x/2) + random.nextInt(x - (x/2) - 1);
                col = 1 + random.nextInt(y - 2);
            } else {
                break;
            }
        }

        return new int[]{row, col};
    }

    @Override 
    public void move(int[] position, Map map) {
        int[] old = super.getPosition();
        map.getCell(old).setOccupied(false);
        map.getCell(old).removeState("Player");
        map.getCell(position).setOccupied(true);
        map.getCell(position).addState("Player");
        super.setPosition(position);
    }

    @Override 
    public int[][] getAvailableMoves(Map map) {
        ArrayList<int[]> moves = new ArrayList<>();
        int[] position = super.getPosition();
        int x = position[0];
        int y = position[1];

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++){
                if (map.getCell(new int[]{x + i, y + j}).isTraverseable() && (i != 0 || j != 0)) {
                    moves.add(new int[]{x + i, y + j});
                }
            }
        }

        return moves.toArray(new int[0][0]);
    }

}
