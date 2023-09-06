package dk.cphbusiness.e23.sem2.threads.javabuiltin;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Student implements Runnable
{
	private static final Random rnd = new Random();
	private Teacher teacher;
	private String name;
	private boolean stop;
	private Thread thread;

	public Student(Teacher teacher, String name)
	{
		this.teacher = teacher;
		this.name = name;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public synchronized void run()
	{
		System.out.println(name + " is going to school!");
		while(!stop)
		{

			Question question = new Question(rnd.nextInt(100) + 1, rnd.nextInt(100) + 1);
			System.out.println(name + " asks: " + question.getN1() + " + " + question.getN2() + " = ?");
			teacher.answer(question);
			System.out.println(name + " got answer: " + question.getResult());
		}
		System.out.println(name + " is going home!");
	}

	public synchronized void stop()
	{
		stop = true;
		thread.interrupt();
	}
}
