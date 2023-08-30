package dk.cphbusiness.e23.sem2.datastructures.circulararray;

import java.util.NoSuchElementException;

public class CircularArray<E>
{
	private E[] array;
	private int first;
	private int size;

	public CircularArray(int capacity)
	{
		array = (E[]) new Object[capacity];
		first = 0;
		size = 0;
	}

	public int capacity()
	{
		return array.length;
	}

	public int size()
	{
		return size;
	}

	public int availableSpace()
	{
		return capacity() - size();
	}

	public void addFirst(E element)
	{
		if(availableSpace() < 1)
		{
			throw new RuntimeException("CircularArray is full!");
		}
		if(size == 0)
		{
			first = 0;
		}
		else
		{
			--first;
			if(first < 0)
			{
				first = array.length-1;
			}
		}
		array[first] = element;
		++size;
	}

	public void addLast(E element)
	{
		if(availableSpace() < 1)
		{
			throw new RuntimeException("CircularArray is full!");
		}
		if(size == 0)
		{
			first = 0;
		}
		int last = first + size;
		if(last >= array.length)
		{
			last -= array.length;
		}
		array[last] = element;
		++size;
	}

	public E removeFirst()
	{
		if(size < 1)
		{
			throw new NoSuchElementException("CircularArray is empty!");
		}
		E element = array[first];
		array[first] = null;
		++first;
		if(first >= array.length)
		{
			first = 0;
		}
		--size;
		return element;
	}

	public E removeLast()
	{
		if(size < 1)
		{
			throw new NoSuchElementException("CircularArray is empty!");
		}
		int last = first + size - 1;
		if(last >= array.length)
		{
			last -= array.length;
		}
		E element = array[last];
		array[last] = null;
		--size;
		return element;
	}

	public String show()
	{
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < array.length; ++i)
		{
			res.append( ((array[i] == null) ? "0" : "X") );
		}
		res.append(System.lineSeparator());
		for(int i = 0; i < first; ++i)
		{
			res.append(" ");
		}
		res.append("^").append(System.lineSeparator());
		res.append("Size = ").append(size).append(System.lineSeparator());
		return res.toString();
	}
}
