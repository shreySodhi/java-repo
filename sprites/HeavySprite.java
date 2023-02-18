public class HeavySprite extends BouncingSprite{
    HeavySprite(int x, int y, int width, int height, String image,double vx, double vy){
        super(x,y,width,height, image,  vx ,vy);
    }

    @Override
     public void step(World world) {
        if(super.getY() > 0 && super.getY() < 600)
            super.setVy(super.getVy()-.25);
        super.step(world);
    }
}

