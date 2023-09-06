package dk.cphbusiness.e23.sem2.threads.producerconsumer;

public class DynamicTeacherFactory
{
	private ISyncBuffer<Question> box;
	private int nextTeacherID = 1;

	public DynamicTeacherFactory(ISyncBuffer<Question> box)
	{
		this.box = box;
	}

	public void createTeacher()
	{
		String name = "Teacher " + nextTeacherID++;
		System.out.println("Creating " + name);
		DynamicTeacher teacher = new DynamicTeacher(name, box);
		Thread teacherThread = new Thread(teacher);
		teacherThread.start();
	}
}
