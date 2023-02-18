import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreatePoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
    	StdDraw.setPenColor(Color.BLACK);
    	StdDraw.setPenRadius(0.02);
		Boolean save = true;
		ArrayList<Point> p = new ArrayList<>();
		int press = 0;
		while (save) {

            if (StdDraw.hasNextKeyTyped()) {
 
                char key = StdDraw.nextKeyTyped();
                if(key == 's')
                {
                	save = false;
                }
            }
            if(StdDraw.mousePressed()) {
            	if(press ==0) {
            		//press = 1;
            		p.add(new Point(StdDraw.mouseX(),StdDraw.mouseY()));
            		StdDraw.point(StdDraw.mouseX(),StdDraw.mouseY());
            	}
            }else {
            	press = 0;
            }
            
            
		}
		System.out.println("Saving...");
		 PrintWriter disk = null;
		try {
			disk = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not write to file: "+"output.txt");
		}
		disk.println(p.size());
		for(Point x : p) {
			disk.println(x.getX()+" "+x.getY());
		}

		disk.close();
		System.out.println("Done");
	}

}
