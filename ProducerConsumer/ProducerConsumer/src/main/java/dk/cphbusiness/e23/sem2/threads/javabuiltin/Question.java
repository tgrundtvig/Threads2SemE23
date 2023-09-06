package dk.cphbusiness.e23.sem2.threads.javabuiltin;

public class Question
{
	private int n1;
	private int n2;
	private int result;

	public Question(int n1, int n2)
	{
		this.n1 = n1;
		this.n2 = n2;
	}

	public int getResult()
	{
		return result;
	}

	public void setResult(int result)
	{
		this.result = result;
	}

	public int getN1()
	{
		return n1;
	}

	public int getN2()
	{
		return n2;
	}
}
