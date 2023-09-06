package dk.cphbusiness.e23.sem2.streams;

import java.util.Objects;

public class MyClass
{
	private int a;
	private String b;

	public MyClass(int a, String b)
	{
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof MyClass myClass)) return false;

		if (a != myClass.a) return false;
		return Objects.equals(b, myClass.b);
	}

	@Override
	public int hashCode()
	{
		int result = a;
		result = 31 * result + (b != null ? b.hashCode() : 0);
		return result;
	}
}
