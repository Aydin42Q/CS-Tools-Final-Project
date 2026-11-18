public class Map {
    private Cell[][] map;
    
    private String mapName;
    private int mapLevel;

    public Map (int[] dimensions, String mapName, int mapLevel) {
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

    public void displayMap() {
        IO.println(mapName + ": Level " + mapLevel);
        for (Cell[] mapRow : map) {
            for (int j = 0; j < mapRow.length; j++) {
                IO.print(mapRow[j].getCell());
            }
            IO.println();
        }
    }





    private class Cell {
        private String[] state;
        private boolean isOccupied;
        
        private Cell (String[] state) {
            this.state = state;
            isOccupied = false;
        }

        private boolean getOccupied() {
            return isOccupied;
        }

        private String[] getState() {
            return state;
        }

        private String getCell() {
            if (state[0].equals("border")) {
                return "*";
            } else if (state[0].equals("terrain")) {
                return "O";
            } else {
                return null;
            }
        }
    }
    
}