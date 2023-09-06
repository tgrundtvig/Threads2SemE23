package dk.cphbusiness.e23.sem2.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Example5
{


	public static void main(String[] args)
	{
		Stream<String> inStream = new BufferedReader(new InputStreamReader(System.in)).lines();
		inStream.map(Integer::parseInt).filter(i -> i % 2 == 1).limit(5).forEach(System.out::println);
		inStream.filter(Example5::isInteger).map(Integer::parseInt).filter(i -> i % 2 == 1).limit(5).forEach(System.out::println);
	}

	private static boolean isInteger(String s)
	{
		try
		{
			Integer.parseInt(s);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}

}
