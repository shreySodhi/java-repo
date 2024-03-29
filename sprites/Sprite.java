import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public abstract class  Sprite
{
	private double x;      //the x-coordinate of the center of the sprite
	private double y;      //the y-coordinate of the center of the sprite
	private int    width;  //width of the sprite (for drawing)
	private int    height; //height of the sprite (for drawing)
	private String image;  //filename of the sprite's image

	public Sprite(double x, double y, int width, int height, String image)
	{
		this.x      = x;
		this.y      = y;
		this.width  = width;
		this.height = height;

		this.setImage(image);
	}

	/** draw the sprite to the screen */
	public void draw() {
		//draw based on sprite's size, so you don't have to manually scale images
		StdDraw.picture(this.getX(), this.getY(), this.getImage(), this.width, this.height);

	}
	boolean overlaps(Sprite other){
		double d = Math.sqrt(Math.pow(this.getX()-other.getX(),2)+ Math.pow(this.getY()-other.getY(),2));
		if(d <= width|| d <= height)
			return true;
		return false;
	}

	/**
	 * One step of the simulation - a Sprite does whatever a Sprite does (move around, etc.)
	 *
	 * must be supplied with a reference to the world this sprite exists in
	 */
	public abstract void step(World world);

	//-----------------Getters-------------------

	public double getX()      { return this.x;      }
	public int    getWidth()  { return this.width;  }
	public double getY()      { return this.y;      }
	public int    getHeight() { return this.height; }
	public String getImage()  { return this.image;  }

	//-----------------Setters-------------------

	public void setX(double x)         { this.x      = x;      }
	public void setY(double y)         { this.y      = y;      }
	public void setWidth(int width)    { this.width  = width;  }
	public void setHeight(int height)  { this.height = height; }
	public void setImage(String image) { this.image  = image;  }
}
