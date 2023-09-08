import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shakespeare
{
	private static final String PATH = "src\\main\\resources\\Shakespeare.txt";


	public static void main(String[] args) throws IOException
	{
		System.out.println("Start");
		long begin = System.currentTimeMillis();
		List<WordEntry> wordEntries = getSortedWordEntries();
		long end = System.currentTimeMillis();
		System.out.println("End");
		wordEntries.stream().limit(10).forEach(System.out::println);
		System.out.println("Time: " + (end - begin) + " ms");
	}

	private static List<WordEntry> getSortedWordEntries() throws IOException
	{
		Map<String, Integer> wordCounts = new HashMap<>();
		try(Stream<String> lines = getLines())
		{
			Stream<String> words = getWords(lines);
			words.forEach(word -> addWordToMap(word, wordCounts));
		}

		return wordCounts.entrySet().stream().map(entry -> new WordEntry(entry.getKey(), entry.getValue())).sorted().collect(Collectors.toList());
	}

	private static void addWordToMap(String word, Map<String, Integer> wordCounts)
	{
		synchronized (wordCounts)
		{
			Integer count = wordCounts.get(word);
			if (count == null)
			{
				count = 0;
			}
			wordCounts.put(word, count + 1);
		}
	}

	private static Stream<String> getWords(Stream<String> lines) throws IOException
	{
		return lines.flatMap(line -> Stream.of(line.split("\\W+"))).filter(word -> word.length() > 0).map(word -> word.toUpperCase());
	}

	private static Stream<String> getLines() throws IOException
	{
		return Files.lines(Paths.get(PATH)).parallel(); //TODO: parallel
	}

	private static class WordEntry implements Comparable<WordEntry>
	{
		private final String word;
		private final int count;

		public WordEntry(String word, int count)
		{
			this.word = word;
			this.count = count;
		}

		@Override
		public int compareTo(WordEntry other)
		{
			int c = Integer.compare(other.count, count);
			if(c != 0)
			{
				return c;
			}
			return word.compareTo(other.word);
		}

		@Override
		public String toString()
		{
			return word + ": " + count;
		}
	}
}
