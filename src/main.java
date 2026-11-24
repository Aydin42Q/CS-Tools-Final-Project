
public static void main(String[] args) {
    Thread game = new Thread(new GameController());
    game.start();
    try {
        game.join();
    } catch (Exception e) {
    }
    
    
}