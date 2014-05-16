import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("out.txt", "utf-8");
		for ( int i=5; i<= 100; i= i+5)
		{
			BigInteger tetraNumber = linearTetra(i)[0];
			long timeStart = System.nanoTime();
			//long tetraNumber = linearTetra(i)[0];
			long timeEnd = (System.nanoTime()-timeStart);
			System.out.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber.floatValue() + " in " + timeEnd  + " nano seconds" );
			writer.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber.floatValue() + " in " + timeEnd  + " nano seconds" );
		}
		writer.close();

	}
	public static BigInteger[] linearTetra(long k)
	{
		BigInteger tempArray[] = {BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ZERO};
		if (k <= 2) // check to see if we are 0,1,2 number 
			return tempArray;
		else if (k == 3) //' check to see if we are 3 number
		{
			tempArray[0] = BigInteger.ONE;
			return tempArray;
		}
		else
		{
			tempArray = linearTetra(k - 1);
		    BigInteger returnArray[] = {tempArray[0].add(tempArray[1].add(tempArray[2]).add(tempArray[3])), tempArray[0], tempArray[1], tempArray[2]};
			return returnArray;
		}
	}


}
