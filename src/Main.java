import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		try {
			StudentArrayOperation studentArrayOperation = new StudentGroup(3);

			Student student1 = new Student(1, "Veena Pulicharla", df.parse("03/23/1997"), 98.5);

			Student student2 = new Student(2, "Mounika", df.parse("07/23/1995"), 88.5);

			Student student3 = new Student(3, "Srujana", df.parse("10/12/1996"), 72.5);

			Student[] students = new Student[3];
			students[0]=student1;
			students[1]=student2;
			students[2]=student3;
			studentArrayOperation.setStudents(students);
			System.out.println("Array Size:"+studentArrayOperation.getStudents().length);

			Student student4 = new Student(4, "Sindhu", df.parse("10/11/1996"), 62.5);
			studentArrayOperation.addFirst(student4);

			studentArrayOperation.bubbleSort();
			for (Student student : studentArrayOperation.getStudents()) {
				System.out.println(student.getFullName());
			}

			System.out.println(studentArrayOperation.getStudentsWithMaxAvgMark()[0].getFullName());

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
