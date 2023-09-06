package dk.cphbusiness.e23.sem2.threads.producerconsumer;

import java.util.Random;

public class DynamicTeacher implements Runnable
{
	private String name;
	private ISyncBuffer<Question> box;

	public DynamicTeacher(String name, ISyncBuffer<Question> box)
	{
		this.name = name;
		this.box = box;
	}

	@Override
	public void run()
	{
		Random rnd = new Random();
		boolean done = false;
		while(!done)
		{
			System.out.println("Box size: " + box.getSize());
			Question question = box.getProductUnblocking();
			if (question == null)
			{
				done = true;
				continue;
			}
			int result = question.getN1() + question.getN2();
			question.setResult(result);
			System.out.println(name + " answered: " +
				question.getN1() +
				" + " + question.getN2() +
				" = " + question.getResult());
			question.getStudent().receiveResult(question);
			try
			{
				long waitTime = rnd.nextInt(10000) + 10000;
				Thread.sleep(waitTime);
			} catch (InterruptedException e)
			{
			}
		}
		System.out.println(name + " is done and quits!");
	}
}
