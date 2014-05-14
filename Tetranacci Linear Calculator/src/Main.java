import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("out.txt", "utf-8");
		for ( int i=5; i<= 100; i= i+5)
		{
			long timeStart = System.nanoTime();
			long tetraNumber = linearTetra(i)[0];
			long timeEnd = (System.nanoTime()-timeStart);
			System.out.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber + " in " + timeEnd  + " nano seconds" );
			writer.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber + " in " + timeEnd  + " nano seconds" );
		}
		writer.close();

	}
	public static long[] linearTetra(long k)
	{
		long tempArray[] = {0,0,0,0};
		if (k <= 2) // check to see if we are 0,1,2 number 
			return tempArray;
		else if (k == 3) //' check to see if we are 3 number
		{
			tempArray[0] = 1;
			return tempArray;
		}
		else
		{
			tempArray = linearTetra(k - 1);
		    long returnArray[] = {tempArray[0] + tempArray[1] + tempArray[2] + tempArray[3], tempArray[0], tempArray[1], tempArray[2]};
			return returnArray;
		}
	}


}
