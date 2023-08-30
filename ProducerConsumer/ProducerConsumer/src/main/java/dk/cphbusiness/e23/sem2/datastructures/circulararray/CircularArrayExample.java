package dk.cphbusiness.e23.sem2.datastructures.circulararray;

public class CircularArrayExample
{
	public static void main(String[] args)
	{
		CircularArray<Integer> myArray = new CircularArray<>(5);
		myArray.addFirst(1);
		myArray.addFirst(2);
		myArray.addLast(3);
		System.out.println(myArray.removeFirst());
		System.out.println(myArray.removeLast());
		System.out.println(myArray.show());
	}
}
