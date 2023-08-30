package dk.cphbusiness.e23.sem2.datastructures.circulararray;

public class CircularArray2Example
{
	public static void main(String[] args)
	{
		CircularArray2<Integer> myArray = new CircularArray2<>(5);
		System.out.println(myArray.show());
		myArray.addFirst(1);
		System.out.println(myArray.show());
		myArray.addFirst(2);
		System.out.println(myArray.show());
		myArray.addLast(3);
		System.out.println(myArray.show());
		System.out.println(myArray.removeFirst());
		System.out.println(myArray.show());
		System.out.println(myArray.removeLast());
		System.out.println(myArray.show());
	}
}
