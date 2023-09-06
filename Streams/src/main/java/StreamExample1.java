import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1
{
	public static void main(String[] args)
	{
		int n = 10000000;

		for(int i = 0; i < 10; ++i)
		{
			Stream<String> streamSequential = IntStream.rangeClosed(1, n).mapToObj(x -> "abc" + x);
			long beginSequential = System.currentTimeMillis();
			List<String> list2 = streamSequential.sequential().map(s -> s.toUpperCase()).collect(Collectors.toList());
			long endSequential = System.currentTimeMillis();
			long timeSequential = endSequential - beginSequential;
			System.out.println("Time sequential: " + timeSequential);

			Stream<String> streamParallel = IntStream.rangeClosed(1, n).mapToObj(x -> "abc" + x);
			long beginParallel = System.currentTimeMillis();
			List<String> list = streamParallel.parallel().map(s -> s.toUpperCase()).collect(Collectors.toList());
			long endParallel = System.currentTimeMillis();
			long timeParallel = endParallel - beginParallel;
			System.out.println("Time parallel: " + timeParallel);
		}


	}

	static String touch(String str)
	{
		return str;
	}
}
