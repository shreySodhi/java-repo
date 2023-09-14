public class MobileSprite extends Sprite{
    private double vx;
    private double vy;
    private double origvx;
    private double origvy;
    MobileSprite(double x, double y, int width, int height, String image,double vx,double vy){
      super(x,y,width,height,image);
      this.vx = vx;
      this.vy = vy;
      origvx = vx;
      origvy = vy;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }
    public void setVy(double vy) {
        this.vy = vy;
    }
    public double getvx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }
      public double getOrigvy() {
        return origvy;
    }
    public double getOrigvx() {
        return origvx;
    }

    @Override
    public void step(World world) {
        setX(getX()+vx);
        setY(getY()+vy);
    }
}
