package dk.cphbusiness.e23.sem2.streams;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Example3
{
	public static void main(String[] args)
	{
		List<String> list = List.of("The", "Quick", "Brown", "Fox", "Jumps", "Over", "The", "Lazy", "Dog");

		String res = list.stream().reduce((text, word) -> text + " " + word).get();
		System.out.println(res);

		list.stream().map(s -> s + ": " + s.length()).forEach(System.out::println);
	}
}
