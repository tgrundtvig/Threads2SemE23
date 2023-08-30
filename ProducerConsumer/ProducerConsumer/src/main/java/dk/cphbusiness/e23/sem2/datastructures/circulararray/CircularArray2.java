package dk.cphbusiness.e23.sem2.datastructures.circulararray;

import java.util.NoSuchElementException;

public class CircularArray2<E>
{
	private E[] array;
	private int head;
	private int tail;
	private int size;

	public CircularArray2(int capacity)
	{
		array = (E[]) new Object[capacity];
		head = 0;
		tail = 0;
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
		head = dec(head);
		array[head] = element;
		++size;
	}

	public void addLast(E element)
	{
		if(availableSpace() < 1)
		{
			throw new RuntimeException("CircularArray is full!");
		}
		array[tail] = element;
		tail = inc(tail);
		++size;
	}

	public E removeFirst()
	{
		if(size < 1)
		{
			throw new NoSuchElementException("CircularArray is empty!");
		}
		E element = array[head];
		array[head] = null;
		head = inc(head);
		--size;
		return element;
	}

	public E removeLast()
	{
		if(size < 1)
		{
			throw new NoSuchElementException("CircularArray is empty!");
		}
		tail = dec(tail);
		E element = array[tail];
		array[tail] = null;
		--size;
		return element;
	}

	public String show()
	{
		StringBuilder res = new StringBuilder();
		res.append("   ");
		for(int i = 0; i < array.length; ++i)
		{
			res.append( ((array[i] == null) ? "0" : "X") );
		}
		res.append(System.lineSeparator());
		res.append("H: ");
		for(int i = 0; i < head; ++i)
		{
			res.append(" ");
		}
		res.append("^").append(System.lineSeparator());
		res.append("T: ");
		for(int i = 0; i < tail; ++i)
		{
			res.append(" ");
		}
		res.append("^").append(System.lineSeparator());
		res.append("Size = ").append(size).append(System.lineSeparator());
		return res.toString();
	}

	private int inc(int index)
	{
		return (index + 1) % array.length;
	}

	private int dec(int index)
	{
		return (index + array.length - 1) % array.length;
	}
}
