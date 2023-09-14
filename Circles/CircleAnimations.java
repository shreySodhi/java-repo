import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations {
	private ArrayList<Circle> circles; //the circles to animate
	private int size;    //canvas width and height (will be square)
	private Random rng;     //use to make random numbers

	/**
	 * create a drawing pane of a particular size
	 */
	public CircleAnimations(int s) {
		circles = new ArrayList<>();
		size = s;
		rng = new Random();

		//don't mess with this
		StdDraw.setCanvasSize(size, size); //set up drawing canvas
		StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
		StdDraw.setYscale(0, size);
	}

	void drawCircles() {
		for (int x = 0; x < circles.size(); x++) {
			circles.get(x).draw();

		}
	}

	void addCircles() {

		for (int x = 0; x < 3; x++) {
			int i = 0;
			if (circles.size() != 0) {
				i = rng.nextInt(circles.size());
			}
			int r = rng.nextInt(255);
			int g = rng.nextInt(255);
			int b = rng.nextInt(255);
			int ra = rng.nextInt(50) + 10;
			int cx = rng.nextInt(size-(ra*2))+ra;
			int cy = rng.nextInt(size-(ra*2))+ra;
			circles.add(i, new Circle(cx, cy, ra, new Color(r, g, b)));
		}
	}

	void addCircles(int num) {

		for (int x = 0; x < num; x++) {
			int r = rng.nextInt(255);
			int g = rng.nextInt(255);
			int b = rng.nextInt(255);
			int ra = rng.nextInt(50) + 10;
			int cx = rng.nextInt(size - (ra*2))+ra;
			int cy = rng.nextInt(size - (ra*2))+ra;
			Circle cir = new Circle(cx,cy,ra,new Color(r,g,b));
			boolean c = true;

			circles.add(new Circle(cx, cy, ra, new Color(r, g, b)));
		}
	}
	void noOverlapping(int num){
		int i  = 0;

		while(i < num){
			boolean good = true;
			while (good){
				int xc = rng.nextInt(size);
				int y = rng.nextInt(size);
				int r = rng.nextInt(74) + 1;
				int red = rng.nextInt(255);
				int green = rng.nextInt(255);
				int blue = rng.nextInt(255);
				Circle cir = new Circle(xc,y,r,new Color(red,green,blue));
				for(int j = 0; j < circles.size() && good;j++){
					good = !circles.get(j).overlaps(cir);
				}
				if(good){
					circles.add(cir);
					//drawCircles();
					i++;
					//System.out.println(i);
				}
			}
		}
		drawCircles();


	}
	void movingCircles(int amount){
		addCircles(amount);
		for(int x = 0; x < amount;x++){
			int vx = rng.nextInt(0,4)+1;
			int vy = rng.nextInt(0,4)+1;
			circles.set(x, new Circle(circles.get(x).getX(),circles.get(x).getY(),circles.get(x).getRadius(), circles.get(x).getColor(),vx,vy));
		}
		while(true){
			drawCircles();
			removeClicked();
			for(int x = 0; x < circles.size();x++){
				circles.get(x).update();
			}
			
			StdDraw.show(10);
			StdDraw.clear();


		}

	}
	int getSize(){
		return circles.size();
	}
	void removeClicked(){
				
		if(StdDraw.isMousePressed()){
			
			Circle c = new Circle((int)StdDraw.mouseX(), (int)StdDraw.mouseY(), 2, new Color(0,0,0));
			 for(int x = 0; x < circles.size();x++){
			 	if(circles.get(x).overlaps(c)){
			 		circles.remove(x);
			 		//break;
			 	}
			 }
			 
		
	}

}
}
