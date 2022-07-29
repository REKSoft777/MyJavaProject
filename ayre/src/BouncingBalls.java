
public class BouncingBalls { 

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);
        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++)
            balls[i] = new Ball();
        StdDraw.enableDoubleBuffering();
        while (true) {

        	StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            for (int i = 0; i < n; i++) {
                balls[i].move();
                balls[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
