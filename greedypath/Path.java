import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Path
{
	private Point[] points;
	private double  minX, minY; //min X and Y values, for setting canvas scale
	private double  maxX, maxY; //maxes

	/** construct a path from a given file */
	public Path(String fileName) throws IOException
	{
		minX = Double.MAX_VALUE;
		minY = Double.MAX_VALUE;
		maxX = 0.0;
		maxY = 0.0;
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		points = new Point[sc.nextInt()];
		int pos = 0;
		while(sc.hasNext() && pos < points.length){
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			minX = Double.min(x,minX);
			minY = Double.min(y,minY);
			maxX = Double.max(x,maxX);
			maxY = Double.max(y,maxY);
			points[pos] = new Point(x,y); 
			pos++;

		}
	}



	/** returns the distance traveled going point to point, in order given in file */
	public double getDistance()
	{
		Double d = 0.0;
		for(int x = 0; x < points.length-1;x++){
			d+=points[x].getDistance(points[x+1]);
		}

		return d; //replace
	}

	@Override
	public String toString()
	{
		
		return Arrays.toString(points);
	}
	double getMinX(){
		return minX;
	}
	double getMinY(){
		return minY;
	}
	double getMaxY(){
		return maxY;
	}
	double getMaxX(){
		return maxX;
	}
	int getNumPoints(){
		return points.length;
	}
	Point getPoint(int x){
		return points[x];
	}
}
