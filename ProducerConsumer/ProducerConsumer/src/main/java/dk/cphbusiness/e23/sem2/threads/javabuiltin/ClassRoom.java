package dk.cphbusiness.e23.sem2.threads.javabuiltin;

public class ClassRoom
{
	public static void main(String[] args)
	{
		int numberOfStudents = 10;
		Teacher teacher = new ThreadPoolTeacher();
		Student[] students = new Student[numberOfStudents];
		for(int i = 0; i < numberOfStudents; i++)
		{
			students[i] = new Student(teacher, "Student " + (i + 1));
		}

		try
		{
			Thread.sleep(20000);
		} catch (InterruptedException e)
		{
		}

		for(Student student : students)
		{
			student.stop();
		}
	}
}
