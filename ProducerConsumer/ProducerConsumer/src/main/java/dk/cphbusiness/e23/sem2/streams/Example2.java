package dk.cphbusiness.e23.sem2.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example2
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("One");
		list.add("OneAndOnly");
		list.add("Derek");
		list.add("Change");
		list.add("factory");
		list.add("justBefore");
		list.add("Italy");
		list.add("Italy");
		list.add("Thursday");
		list.add("");
		list.add("");

		List<String> res = list.stream().filter(s -> s.contains("a")).collect(Collectors.toList());

		res.stream().forEach(s -> System.out.println(s));
	}
}
