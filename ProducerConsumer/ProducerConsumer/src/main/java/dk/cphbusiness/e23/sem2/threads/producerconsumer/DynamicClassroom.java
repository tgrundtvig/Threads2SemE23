package dk.cphbusiness.e23.sem2.threads.producerconsumer;

import java.util.ArrayList;

public class DynamicClassroom
{
	public static void main(String[] args)
	{
		ISyncBuffer<Question> box = new SynchronizedBuffer<>(16);
		DynamicTeacherFactory teacherFactory = new DynamicTeacherFactory(box);
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Alice", box));
		students.add(new Student("Bob", box));
		students.add(new Student("Carol", box));
		students.add(new Student("Dave", box));
		students.add(new Student("Eve", box));
		students.add(new Student("Frank", box));

		for(Student student : students)
		{
			new Thread(student).start();
		}
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
		}

		while(true)
		{
			if(box.getSize() == box.getCapacity())
			{
				teacherFactory.createTeacher();
				try
				{
					Thread.sleep(2000);
				} catch (InterruptedException e)
				{
				}
			}
		}
	}
}
