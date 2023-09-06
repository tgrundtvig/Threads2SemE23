package dk.cphbusiness.e23.sem2.threads.javabuiltin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTeacher implements Teacher
{
	private final ExecutorService executor = Executors.newFixedThreadPool(1000);

	@Override
	public void answer(Question question)
	{
		QuestionSolver solver = new QuestionSolver(question);
		Future<Question> future = executor.submit(solver, question);
		try
		{
			future.get();
		} catch (InterruptedException e)
		{
		} catch (ExecutionException e)
		{
			throw new RuntimeException(e);
		}
	}
}
