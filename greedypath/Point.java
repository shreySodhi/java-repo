public class Point 
{
	private double  x, y;
	private boolean visited;
	Point(double x, double y,boolean v ){
		this.x = x;
		this.y = y;
		visited = v;
	}
	Point(double x, double y){
		this.x = x;
		this.y = y;
		visited = false;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	boolean isVisited(){
		return visited;
	}

	public void setVisited() {
		visited = true;
	}

	/** get the Euclidean distance between two points */
	public double getDistance(Point other)
	{


		
		return  Math.abs(Math.sqrt(Math.pow(x-other.getX(),2) + Math.pow(y-other.getY(),2)));   //replace
	}
	
	@Override
	public String toString()
	{

		
		return "x pos: "+ x+ " y pos: " + y + " visited = " + visited;
	}
}
