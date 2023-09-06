package dk.cphbusiness.e23.sem2.streams;

import java.util.stream.Stream;

public class Example1
{
	public static void main(String[] args)
	{
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 2, 5);

		long count = stream.distinct().count();

		System.out.println(count);
	}
}
