package dk.cphbusiness.fibofun;

public class Test
{
	public static void main(String[] args)
	{
		TrieNode root = new TrieNode();
		root.insert("hej");
		root.insert("hejsa");
		root.insert("hello");
		root.insert("helt");
		root.insert("heltinde");
		root.insert("med");
		root.insert("dig");


		String start = "he";
		String ending = root.getBestEnding(start);
		if(ending == null)
		{
			System.out.println("Did not find an ending for " + start);
		}
		else
		{
			System.out.println("Found ending " + ending +
				" for " + start + " making the word : " + start + ending);
		}
	}
}
