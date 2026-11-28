import java.util.ArrayList;
import java.util.Random;

public abstract class Enemy extends Entity {
    private final String enemyType;

    public Enemy(Map map, String enemyType) {
        super(getSpawn(map));
        this.enemyType = enemyType;
        map.getCell(super.getPosition()).setOccupied(true);
        map.getCell(super.getPosition()).addState(enemyType);
    }

    public static int[] getSpawn(Map map) {
        int[] dimensions = map.getDimensions();
        int x = dimensions[0];
        int y = dimensions[1];

        Random random = new Random();
        int row = 1 + random.nextInt(x - (x/2) - 1);
        int col = 1 + random.nextInt(y - 1);
        while (true) {
            if (map.getCell(new int[]{row, col}).getOccupied() || 
                !map.getCell(new int[]{row, col}).isTraverseable()) {
                row = 1 + random.nextInt(x - (x/2) - 1);
                col = 1 + random.nextInt(y - 2);
            } else {
                break;
            }
        }
        return new int[]{row, col};
    }

    @Override
    public void take(Entity entity, Map map) {
        if (super.getPosition() != null && entity instanceof Player player && player.getPosition() != null) {
            player.loseBodyDouble(map);
            remove(map);
        }
    }

    void remove(Map map) {
        map.getCell(super.getPosition()).setOccupied(false);
        map.getCell(super.getPosition()).removeState(enemyType);
        super.setPosition(null);
    }

    public abstract int[] getAttack(Map map);

    public static class Page extends Enemy {

        public Page(Map map) {
            super(map, "Page");
        }

        @Override 
        public void move(int[] position, Map map) {
            int[] old = super.getPosition();
            map.getCell(old).setOccupied(false);
            map.getCell(old).removeState("Page");
            map.getCell(position).setOccupied(true);
            map.getCell(position).addState("Page");
            super.setPosition(position);
        }

        @Override
        public int[][] getAvailableMoves(Map map) {
            ArrayList<int[]> moves = new ArrayList<>();
            int[] position = super.getPosition();
            int x = position[0];
            int y = position[1];

            for (int i = -1; i <= 1; i++) {
                if (map.getCell(new int[]{x + i, y}).isTraverseable() && i != 0 &&
                    !map.getCell(new int[]{x + i, y}).getOccupied()) {
                    moves.add(new int[]{x + i, y});
                }
            }
            for (int i = -1; i <= 1; i++){
                if (map.getCell(new int[]{x, y + i}).isTraverseable() && i != 0 &&
                    !map.getCell(new int[]{x, y + i}).getOccupied()) {
                    moves.add(new int[]{x, y + i});
                }
            }
            
            return moves.toArray(new int[0][0]);
        }

        public int[] getAttack(Map map) {
            int[] position = super.getPosition();
            int x = position[0];
            int y = position[1];

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++){
                    if ((i != 0 && j != 0) && map.getCell(new int[]{x + i, y + j})
                        .getState()[map.getCell(new int[]{x + i, y + j}).getState().length - 1]
                        .equals("Player")) {
                    return (new int[]{x + i, y + j});
                    }
                }
            }

            return null;
        }
    }

    public static class Knight extends Enemy {

        public Knight(Map map) {
            super(map, "Knight");
        }

        @Override 
        public void move(int[] position, Map map) {
            int[] old = super.getPosition();
            map.getCell(old).setOccupied(false);
            map.getCell(old).removeState("Knight");
            map.getCell(position).setOccupied(true);
            map.getCell(position).addState("Knight");
            super.setPosition(position);
        }

        @Override
        public int[][] getAvailableMoves(Map map) {
            ArrayList<int[]> moves = new ArrayList<>();
            int[] dimensions = map.getDimensions();
            int xMax = dimensions[0];
            int yMax = dimensions[1];
            int[] position = super.getPosition();
            int x = position[0];
            int y = position[1];

            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++){
                    if ((x + i > 0) && (y + j > 0) && 
                        (x + i < xMax) && (y + j < yMax) && 
                        ((Math.abs(i) == 2 && Math.abs(j) == 1) || 
                        (Math.abs(i) == 1 && Math.abs(j) == 2)) && 
                        !map.getCell(new int[]{x + i, y + j}).getOccupied() &&
                        map.getCell(new int[]{x + i, y + j}).isTraverseable()) {
                        
                        moves.add(new int[]{x + i, y + j});
                    }
                }
            }

            
            
            return moves.toArray(new int[0][0]);
        }

        public int[] getAttack(Map map) {
            int[] dimensions = map.getDimensions();
            int xMax = dimensions[0];
            int yMax = dimensions[1];
            int[] position = super.getPosition();
            int x = position[0];
            int y = position[1];

            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++){
                    if ((x + i > 0) && (y + j > 0) && 
                        (x + i < xMax) && (y + j < yMax) && 
                        ((Math.abs(i) == 2 && Math.abs(j) == 1) || 
                        (Math.abs(i) == 1 && Math.abs(j) == 2)) && 
                        map.getCell(new int[]{x + i, y + j})
                        .getState()[map.getCell(new int[]{x + i, y + j}).getState().length - 1]
                        .equals("Player")) {
                        return (new int[]{x + i, y + j});
                    }
                }
            }

            return null;
        }
    }
}
