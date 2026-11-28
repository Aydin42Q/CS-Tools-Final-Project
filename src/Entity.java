public abstract class Entity {
    private int[] position;

    public Entity(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
    
    
    public abstract void move(int[] position, Map map);
    public abstract void take(Entity entity, Map map);
    public abstract int[][] getAvailableMoves(Map map);

}
