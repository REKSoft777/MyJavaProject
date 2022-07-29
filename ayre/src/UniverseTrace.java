
public class UniverseTrace {
    


    // client to simulate a universe
    public static void main(String[] args) {
        StdDraw.setCanvasSize(600, 600);
        Universe newton = new Universe(args[1]);
        double dt = Double.parseDouble(args[0]);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        while (true) {
            StdDraw.setPenColor(StdDraw.WHITE);
            newton.draw(); 
            newton.increaseTime(dt); 
            StdDraw.setPenColor(StdDraw.BLACK);
            newton.draw(); 
            StdDraw.show();
            StdDraw.pause(50);
        } 
    } 
}
