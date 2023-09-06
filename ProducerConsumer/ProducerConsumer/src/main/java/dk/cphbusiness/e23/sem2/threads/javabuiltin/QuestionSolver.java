package dk.cphbusiness.e23.sem2.threads.javabuiltin;

import java.util.Random;

public class QuestionSolver implements Runnable
{
	private static final Random rnd = new Random();
	private Question question;

	public QuestionSolver(Question question)
	{
		this.question = question;
	}

	@Override
	public void run()
	{
		int n1 = question.getN1();
		int n2 = question.getN2();
		int result = n1 + n2;
		question.setResult(result);
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
		}
	}
}

