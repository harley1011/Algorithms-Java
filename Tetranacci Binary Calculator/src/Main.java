import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;


public class Main {


	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		for ( int i=5; i<= 100; i= i+5)
		{
			PrintWriter writer = new PrintWriter("out.txt", "utf-8");
			long timeStart = System.nanoTime();
			BigInteger tetraNumber = binaryTetra(i);
			long timeEnd = (System.nanoTime()-timeStart);
			System.out.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber.floatValue() + " in " + timeEnd  + " nano seconds" );
			writer.println("Tetranacci(" + (long)i + ") returns: " +  tetraNumber.floatValue() + " in " + timeEnd  + " nano seconds" );
			writer.close();
		}
		

	}
	public static BigInteger binaryTetra(long k)
	{

		if (k <= 2) // check to see if we are 0,1,2 number 
			return BigInteger.ZERO;
		else if (k <= 4) //' check to see if we are 3 number
			return BigInteger.ONE;
		else
			return binaryTetra(k-1).multiply(BigInteger.valueOf(2)).subtract(binaryTetra(k-5));                                     
					//binaryTetra(k-1) + binaryTetra(k-2) + binaryTetra(k-3) + binaryTetra(k-4);
	}

}
