package dk.cphbusiness.e23.sem2.streams;

import java.util.stream.Stream;

public class Example4
{
	public static void main(String[] args)
	{
		Stream<String> stream = Stream.of("Anna", "Bertil", "Caesar", "Ludvig", "Dennis", "Emil", "Frida", "Gustav", "Hans", "Mette", "Ida", "Gustav", "Mette", "Jens", "Karl", "Ludvig","Dennis","Dennis", "Mette", "Nikolaj", "Otto", "Peter", "Quintus", "Rasmus", "Sofie", "Tove", "Ulla", "Viggo", "William", "Xenia", "Yrsa", "Zack");
		stream.distinct().filter(s -> s.toLowerCase().contains("e")).forEach(System.out::println);
	}
}
