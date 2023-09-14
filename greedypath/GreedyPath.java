import java.io.IOException;
import java.util.Arrays;
class GreedyPath extends Path{
	private Point [] greedyArray;
	private double d;
	GreedyPath(String filename) throws IOException{
		super(filename);
		findpath();

	}
	public void findpath(){
        greedyArray = new Point[super.getNumPoints()];
        greedyArray[0] = super.getPoint(0);//get first point to populate array
        greedyArray[0].setVisited();
		int index = 0;
        d = 0.0;// initialize distance 
        for(int x = 0; x < greedyArray.length-1;x++){// x is the current it is on
            double min =Double.MAX_VALUE;//reset min
            int i = -1;//reset index
            for(int y = 0; y < greedyArray.length;y++){
                if( index!=y && !super.getPoint(y).isVisited() && greedyArray[x].getDistance(super.getPoint(y)) < min){// if x != y and y hasn't been visited and distance between x and y is less than min
                    min = greedyArray[x].getDistance(super.getPoint(y));
                     i = y;                                       
                }
            }
			index = i;
            greedyArray[x+1] = super.getPoint(i);
			super.getPoint(i).setVisited();
			// greedyArray[x].setVisited();
			
            d+=min;

        }

	}
	@Override
	public double getDistance(){
		return d;
	}
	@Override
	public Point getPoint(int x){
		return greedyArray[x];
	}
	@Override
	public String toString(){
		
		return Arrays.toString(greedyArray);
	}


}