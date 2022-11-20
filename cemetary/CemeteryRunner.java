import java.io.*;
class CemeteryRunner{
	public static void main(String [] args) throws IOException{
		Cemetery c = new Cemetery("cemetery.txt");
		System.out.println(c.getAvgAge());
	}
}