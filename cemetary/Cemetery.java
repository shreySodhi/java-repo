
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Cemetery{
	private ArrayList<Tombstone> cem;
	public Cemetery(String filename) throws FileNotFoundException{
		cem = new ArrayList<>();
		File parser = new File(filename);
		Scanner sc = new Scanner(parser);

		while(sc.hasNextLine()){
			String n = "";
			String d = "";
			Scanner line = new Scanner(sc.nextLine());
			while(!line.hasNextInt()){
				n+= line.next();
			}
			d+=line.next();
			d+=line.next();
			d+=line.next();
			int a = parseAge(line.next());
			String address = "";
			while(line.hasNext()){
				address+=line.next();
			}
			cem.add(new Tombstone(n, d, a, address));

		}



	}
	/** 
	 * convert the ageString to a number of days; age can 
	 * take a variety of forms in the data file
	 */
	public static int parseAge(String ageString)
	{
		if (ageString.contains("d")) { //age supplied in days
			ageString = ageString.replaceAll("d", "");
			return Integer.parseInt(ageString);
			}
		
		int result = 0;
		
		boolean done = true;

		try { result = Integer.parseInt(ageString); } //is the String a whole number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) //successfully parsed as an int, return value
			return 365 * result; //ignoring leap years
		
		double ageDouble = 0;
		
		done = true;
		
		try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) { //successfully parse as a double, String doesn't contain any text
			return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
		}
		
		if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
			ageString = ageString.replaceAll("w", "");
			return Integer.parseInt(ageString) * 7;
		}
		
		return 0;
	} 
	double getAvgAge(){

		double total = 0;
		for(int x = 0; x < cem.size();x++)
			total+=cem.get(x).getAge()/365.0;
		return Math.round((10*(total/cem.size())))/10.0;

	} 
}