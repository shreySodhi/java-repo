import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		g.setColor(Color.BLUE);
		drawStar(g,200,200,150);
	}
	public void drawStar(Graphics g, int x, int y, int size){
		if(size < 50){
			g.drawLine(x-size, y, x+size, y); //horizontal line
			g.drawLine(x-(int)(size*Math.cos(Math.PI/3)), y-(int)(size*Math.sin(Math.PI/3)), x+(int)(size*Math.cos(Math.PI/3)), y+(int)(size*Math.sin(Math.PI/3))); // diagonal line with negative slope
			g.drawLine(x-(int)(size*Math.cos(2*Math.PI/3)), y-(int)(size*Math.sin(2*Math.PI/3)), x+(int)(size*Math.cos(2*Math.PI/3)), y+(int)(size*Math.sin(2*Math.PI/3))); //diagonal line with positive slope
			return; // base case
		}
		g.drawLine(x-size, y, x+size, y); //horizontal line drawn
		drawStar(g,x-size, y, size-60); //star on left 
		drawStar(g,x+size, y, size-60); // star on right 
		
		g.drawLine(x-(int)(size*Math.cos(Math.PI/3)), y-(int)(size*Math.sin(Math.PI/3)), x+(int)(size*Math.cos(Math.PI/3)), y+(int)(size*Math.sin(Math.PI/3)));// diagonal line with positive slope
		drawStar(g,x-(int)(size*Math.cos(Math.PI/3)), y-(int)(size*Math.sin(Math.PI/3)), size-60);// star on top left 
		drawStar(g,x+(int)(size*Math.cos(Math.PI/3)), y+(int)(size*Math.sin(Math.PI/3)), size-60); // star on bottom right 

		g.drawLine(x-(int)(size*Math.cos(2*Math.PI/3)), y-(int)(size*Math.sin(2*Math.PI/3)), x+(int)(size*Math.cos(2*Math.PI/3)), y+(int)(size*Math.sin(2*Math.PI/3)));// diagonal line 2
		drawStar(g,x-(int)(size*Math.cos(2*Math.PI/3)), y-(int)(size*Math.sin(2*Math.PI/3)), size-60); // star on top right
		drawStar(g,x+(int)(size*Math.cos(2*Math.PI/3)), y+(int)(size*Math.sin(2*Math.PI/3)), size-60); // star on bottpm left 
	}

}
// 	public void drawStar(Graphics g, int x, int y, int size)
// 	{
// 		if (size<50) {
// 			g.drawLine(x, y, x + size, y);
// 			g.drawLine(x, y, x + (int) (size * Math.cos(2 * Math.PI / 6)), y - (int) (size * Math.sin(2 * Math.PI / 6)));
// 			g.drawLine(x, y, x + (int) (size * Math.cos(4 * Math.PI / 6)), y - (int) (size * Math.sin(4 * Math.PI / 6)));
// 			g.drawLine(x, y, x - size, y);
// 			g.drawLine(x, y, x + (int) (size * Math.cos(8 * Math.PI / 6)), y - (int) (size * Math.sin(8 * Math.PI / 6)));
// 			g.drawLine(x, y, x + (int) (size * Math.cos(10 * Math.PI / 6)), y - (int) (size * Math.sin(10 * Math.PI / 6)));
// 			return;
// 		}
// 		g.drawLine(x, y, x + size, y);
// 		drawStar(g,x + size, y, size-60);
// 		g.drawLine(x, y, x + (int) (size * Math.cos(2 * Math.PI / 6)), y - (int) (size * Math.sin(2 * Math.PI / 6)));
// 		drawStar(g,x + (int) (size * Math.cos(2 * Math.PI / 6)), y - (int) (size * Math.sin(2 * Math.PI / 6)), size-60);
// 		g.drawLine(x, y, x + (int) (size * Math.cos(4 * Math.PI / 6)), y - (int) (size * Math.sin(4 * Math.PI / 6)));
// 		drawStar(g,x + (int) (size * Math.cos(4 * Math.PI / 6)), y - (int) (size * Math.sin(4 * Math.PI / 6)), size-60);
// 		g.drawLine(x, y, x - size, y);
// 		drawStar(g,x - size, y,size-60);
// 		g.drawLine(x, y, x + (int) (size * Math.cos(8 * Math.PI / 6)), y - (int) (size * Math.sin(8 * Math.PI / 6)));
// 		drawStar(g,x + (int) (size * Math.cos(8 * Math.PI / 6)), y - (int) (size * Math.sin(8 * Math.PI / 6)), size-60);
// 		g.drawLine(x, y, x + (int) (size * Math.cos(10 * Math.PI / 6)), y - (int) (size * Math.sin(10 * Math.PI / 6)));
// 		drawStar(g,x + (int) (size * Math.cos(10 * Math.PI / 6)), y - (int) (size * Math.sin(10 * Math.PI / 6)), size-60);
// 	}
// }

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
		
	}
}
