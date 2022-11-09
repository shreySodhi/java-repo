import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
	private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File("./images/"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
            throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

    /**
     * Return the 2D array of pixels that comprise this Picture
     * You can save a reference to a Picture's pixels with the following:
     * Pixel[][] pixels = pic.getPixels(); //for a Picture object called pic
     * @return 2D array of pixels that make up this Picture
     */
    public Pixel[][] getPixels() {
    		return pixels;
    }

    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
    	for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[x].length;y++)
                pixels[x][y].setBlue(0);
        }
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
    	for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[x].length;y++){
                pixels[x][y].setGreen(0);
                pixels[x][y].setRed(0);
            }
        }
    }

    /** invert a picture's colors */
    public void negate()
    {
    	for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[x].length;y++){
                pixels[x][y].setGreen(255-pixels[x][y].getGreen());
                pixels[x][y].setRed(255-pixels[x][y].getRed());
                pixels[x][y].setBlue(255-pixels[x][y].getBlue());
            }
        }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold)
    {
    	for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[x].length;y++){
                if(pixels[x][y].getBlue() < threshold){
                    pixels[x][y].setBlue(255-pixels[x][y].getBlue());
                }
                if(pixels[x][y].getGreen() < threshold){
                    pixels[x][y].setGreen(255-pixels[x][y].getGreen());
                }
                if(pixels[x][y].getRed() < threshold){
                    pixels[x][y].setRed(255-pixels[x][y].getRed());
                }
            }
        }
    }

    /** convert an image to grayscale */
    public void grayscale()
    {
    	
        for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[x].length;y++){
                int avg = pixels[x][y].getRed() + pixels[x][y].getBlue()+ pixels[x][y].getGreen();
                avg/=3;
                pixels[x][y].setColor(avg, avg, avg);

            }
        }
    }

	/** change the tint of the picture by the supplied coefficients */
	public void tint(double red, double blue, double green)
	{
		for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[x].length;y++){
                int nred = (int)(pixels[x][y].getRed()*red);
                int ngreen =(int) (pixels[x][y].getGreen()*green);
                int nblue = (int)(pixels[x][y].getBlue()*blue);
                 pixels[x][y].setGreen(Math.min(ngreen, 255));
                 pixels[x][y].setRed(Math.min(nred, 255));
                 pixels[x][y].setBlue(Math.min(nblue, 255));pixels[x][y].setGreen(Math.min(ngreen, 255));
                 
        }
	}
}
	
	/** reduces the number of colors in an image to create a "graphic poster" effect */
	public void posterize(int span)
	{
		for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[x].length;y++){
                pixels[x][y].setColor(pixels[x][y].getRed()/span * span, pixels[x][y].getGreen()/span * span, pixels[x][y].getBlue()/span * span);
            }
        }
	}

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
		Pixel leftPixel  = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int r = 0; r < pixels.length; r++)
		{
			for (int c = 0; c < width / 2; c++)
			{
				leftPixel  = pixels[r][c];
				rightPixel = pixels[r][(width - 1) - c];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    	
    

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal()
    {
    	Pixel top  = null;
        Pixel bottom = null;

        int height = pixels.length;

        for (int r = 0; r < height/2; r++)
        {
            for (int c = 0; c < pixels[0].length; c++)
            {
                top  = pixels[r][c];
                bottom = pixels[(height-1) - r][c];
                bottom.setColor(top.getColor());
            }
        }
    }
    

    /** flip an image upside down about its bottom edge */
    public void verticalFlip()
    {
    	Pixel top  = null;
        Pixel bottom = null;
        Color temp = null;
        int height = pixels.length;

        for (int r = 0; r < height/2; r++)
        {
            for (int c = 0; c < pixels[0].length; c++)
            {
                
                top  = pixels[r][c];
                bottom = pixels[height-r-1][c];
                temp = top.getColor();
                top.setColor(bottom.getColor());
                bottom.setColor(temp);
            }
        }
    }

    /** fix roof on greek temple */
    public void fixRoof()
    {
    	
        // for(int x = 40; x < 75;x++){
        //     for(int y = 70; y < 253;y++){
        //         pixels[x+75][y+253] = pixels[x][y]; 
        //     }
        // }
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = 280;

        for (int r = 90; r > 10; r--)
        {
            for (int c = width; c > 30; c--)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width) + (width-c)];

                rightPixel.setColor(leftPixel.getColor());
            }
        }

    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist)
    {
    	for(int x = 0; x < pixels.length-1;x++){
            for(int y = 0; y < pixels[x].length-1;y++){
                if(pixels[x][y].colorDistance(pixels[x+1][y].getColor()) > dist || pixels[x][y].colorDistance(pixels[x][y+1].getColor()) > dist || pixels[x][y].colorDistance(pixels[x+1][y+1].getColor()) > dist){

                    pixels[x][y].setColor(0, 0, 0);
                }
                else{
                    pixels[x][y].setColor(255, 255 ,255);
                    
                }
                
                
            }
        }
    }


	/** copy another picture's pixels into this picture, if a color is within dist of param Color */
	public void chromakey(Picture other, Color color, int dist)
	{
        Pixel[][] o = other.getPixels();
		for(int x = 0; x < pixels.length;x++){
            for(int y = 0; y < pixels[0].length;y++){
                if(pixels[x][y].colorDistance(color) < dist){
                    pixels[x][y].setColor(o[x][y].getColor());
                }
            }
        }
	}

	/** steganography encode (hide the message in msg in this picture) */
	public void encode(Picture msg)
	{
		//TODO
	}

	/** steganography decode (return a new Picture containing the message hidden in this picture) */
	public Picture decode()
	{
		//TODO

		return null; //REPLACE
	}

	/** perform a simple blur using the colors of neighboring pixels */
	public Picture simpleBlur()
	{
		//TODO

		return null; //REPLACE
	}

	/** perform a blur using the colors of pixels within radius of current pixel */
	public Picture blur(int radius)
	{
		//TODO

		return null; //REPLACE
	}
	
	/**
	 * Simulate looking at an image through a pane of glass
	 * @param dist the "radius" of the neighboring pixels to use
	 * @return a new Picture with the glass filter applied
	 */
	public Picture glassFilter(int dist) 
	{
		//TODO
		
		return null; //REPLACE
	}
}
