import java.awt.*;

public class Circle {
    private int x;
    private int y;
    private int radius;
    private int dx;
    private int dy;

    private Color color;
    Circle( int x, int y, int r, Color c){
        this.x = x;
        this.y = y;
        radius = r;
        color = c;
    }
    Circle( int x, int y, int r, Color c,int dx,int dy){
        this.x = x;
        this.y = y;
        radius = r;
        color = c;
        this.dx = dx;
        this.dy = dy;
    }
    void draw(){
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);

    }
    boolean overlaps(Circle other){
        int d = (int)Math.sqrt(Math.pow(other.x-x,2 ) + Math.pow(other.y-y, 2));
        if(d < radius+other.radius)
            return true;
        return false;
    }
    void bounce(){
        if(x > 600-radius || x < 0+radius){
            dx = -1*dx;
        }
        if(y > 600-radius || y < 0+radius){
            dy = -1*dy;
        }
    }


    void update(){
        bounce();
        x+=dx;
        y+=dy;
    }
    int getX(){
        return x;
    }
    int getY() {
        return y;
    }
    int getRadius() {
        return radius;
    }
    int getDx(){
        return dx;
    }
    int getDy(){
        return dy;
    }
    Color getColor(){
        return color;
    }



}
