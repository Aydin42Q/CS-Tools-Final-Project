import java.util.ArrayList;

public class Map {
    private Cell[][] map;
    
    private String mapName;
    private int mapLevel;
    private int[] dimensions;


    public Map (int[] dimensions, String mapName, int mapLevel) {
        this.dimensions = dimensions;
        map = new Cell[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                if (i != 0 && i != dimensions[0] - 1 && j != 0 && j != dimensions[1] - 1){
                    map[i][j] = new Cell(new String[]{"terrain", "normal"});
                } else {
                    map[i][j] = new Cell(new String[]{"border", "inaccessible"});
                }
            }
        }
        this.mapName = mapName;
        this.mapLevel = mapLevel;

    }

    public int[] getDimensions() {
        return dimensions;
    }

    public void displayMap() {
        IO.println(mapName + ": Level " + mapLevel);
        for (Cell[] mapRow : map) {
            for (int j = 0; j < mapRow.length; j++) {
                IO.print(mapRow[j]);
            }
            IO.println();
        }
    }

    public Cell getCell(int[] position) {
        return map[position[0]][position[1]];
    }





    public class Cell {
        private ArrayList<String> state = new ArrayList<>();
        private boolean isOccupied;
        
        private Cell (String[] state) {
            for (String s : state) {
                this.state.add(s);
            }
            isOccupied = false;
        }

    

        public boolean getOccupied() {
            return isOccupied;
        }

        public void setOccupied(boolean b) {
            isOccupied = b;
        }

        public void addState(String state) {
            this.state.add(state);
        }

        public void removeState(String state) {
            this.state.remove(state);
        }

        public String[] getState() {
            return state.toArray(new String[0]);
        }

        public boolean isTraverseable() {
            return !state.contains("inaccessible");
        }

        @Override
        public String toString() {
            if (!isOccupied) {
                switch (state.get(0)) {
                    case "border" -> {return "*";}
                    case "terrain" -> {return "O";}
                    default -> {return null;}
                }
            } else {
                switch (state.get(state.size() - 1)) {
                    case "Player" -> {return "V";}
                    case "Page" -> {return "P";}
                    case "Knight" -> {return "N";}
                    default -> throw new AssertionError();
                }
            }
        }
    }
    
}