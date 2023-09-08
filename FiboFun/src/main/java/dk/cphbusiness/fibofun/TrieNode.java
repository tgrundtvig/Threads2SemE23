package dk.cphbusiness.fibofun;

import java.util.HashMap;
import java.util.Map;

public class TrieNode
{
	private Map<Character, TrieNode> children;
	private boolean isEndOfWord;
	private int count;

	public TrieNode()
	{
		isEndOfWord = false;
		children = null;
		count = 0;
	}

	public void insert(String str)
	{
		++count;
		if(str.isEmpty())
		{
			isEndOfWord = true;
			return;
		}
		Character firstChar = str.charAt(0);
		String rest = str.substring(1);
		TrieNode child = null;
		if(children == null)
		{
			children = new HashMap<>();
		}
		else
		{
			child = children.get(firstChar);
		}
		if(child == null)
		{
			child = new TrieNode();
			children.put(firstChar, child);
		}
		child.insert(rest);
	}

	public boolean lookUp(String str)
	{
		if(str.isEmpty())
		{
			return isEndOfWord;
		}
		Character firstChar = str.charAt(0);
		String rest = str.substring(1);
		if(children == null)
		{
			return false;
		}
		TrieNode child = children.get(firstChar);
		if(child == null)
		{
			return false;
		}
		return child.lookUp(rest);
	}

	public String getBestEnding(String str)
	{
		if(str.isEmpty())
		{
			StringBuilder result = new StringBuilder();
			return getBestEnding(result);
		}
		Character firstChar = str.charAt(0);
		String rest = str.substring(1);
		if(children == null)
		{
			return null;
		}
		TrieNode child = children.get(firstChar);
		if(child == null)
		{
			return null;
		}
		return child.getBestEnding(rest);
	}

	public String getBestEnding(StringBuilder result)
	{
		if(isEndOfWord)
		{
			return result.toString();
		}
		if(children == null)
		{
			return null;
		}
		TrieNode bestNode = null;
		int bestValue = -1;
		Character bestChar = null;
		for(Map.Entry<Character, TrieNode> entry : children.entrySet())
		{
			if(entry.getValue().count > bestValue)
			{
				bestNode = entry.getValue();
				bestValue = bestNode.count;
				bestChar = entry.getKey();
			}
		}
		if(bestNode == null)
		{
			return null;
		}
		result.append(bestChar);
		return bestNode.getBestEnding(result);
	}
}
