import java.awt.*;

public class PictureTester 
{
    public static void main(String[] args) 
    {
    	//consntruct a Picture object from a jpg image on disk
        Picture beach = new Picture("waterlilies.jpg"); 
        beach.blur(1).view();
        beach.view(); //calling the view() bmethod displays the picture with the PictureViewer GUI
        //testChvromakey();
        //PUT YOUR TESTS HERE
        //testSteganography();
        
    }
    
    /** this method is static, you don't need to call it on an object (just "testChromekey()") */
	public static void testChromakey()
	{
		Picture one = new Picture("blue-mark.jpg");
		Picture two = new Picture("moon-surface.jpg");
		
		one.view(); //show original mustache guy picture
		two.view(); //show the untouched moon's surface pic
		
		one.chromakey(two, new Color(10, 40, 75), 60); //replace this color if within 60
		
		one.view();
	}
	
    /** this method is static, you don't need to call it on an object (just "testSteganography()") */
	public static void testSteganography()
	{
		Picture msg   = new Picture("msg.jpg");
		Picture beach = new Picture("beach.jpg");
		//msg.view();
		beach.encode(msg); //hide message in beach picture
		beach.view();      //beach w/ hidden message inside, shouldn't look different
		
		beach.decode().view(); //see the hidden message in the beach picture
	}
}
