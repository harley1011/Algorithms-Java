import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Main {


	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("out.txt", "utf-8");
		for ( int i=5; i<= 100; i= i+5)
		{
			long timeStart = System.nanoTime();
			long tetraNumber = binaryTetra(i);
			long timeEnd = (System.nanoTime()-timeStart);
			System.out.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber + " in " + timeEnd  + " nano seconds" );
			writer.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber + " in " + timeEnd  + " nano seconds" );
		}
		writer.close();

	}
	public static long binaryTetra(long k)
	{
		if (k <= 2) // check to see if we are 0,1,2 number 
			return 0;
		else if (k == 3) //' check to see if we are 3 number
			return 1;
		else
			return binaryTetra(k-1) + binaryTetra(k-2) + binaryTetra(k-3) + binaryTetra(k-4);
	}

}
