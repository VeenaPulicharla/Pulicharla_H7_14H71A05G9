import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if(students == null){
			throw new IllegalArgumentException();
		}
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {

		if(index < 0 || index >= this.students.length){
			throw new IllegalArgumentException();
		}
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if(student == null){
			throw new IllegalArgumentException();
		}
		if(index < 0 || index >= this.students.length){
			throw new IllegalArgumentException();
		}
		this.students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		if(student == null){
			throw new IllegalArgumentException();
		}
		List<Student> newStudents = new ArrayList<>();
		newStudents.add(student);
		newStudents.addAll(Arrays.asList(students));
		this.students = newStudents.toArray(new Student[newStudents.size()]);
	}

	@Override
	public void addLast(Student student) {
		if(student == null){
			throw new IllegalArgumentException();
		}
		List<Student> newStudents = new ArrayList<>();
		newStudents.addAll(Arrays.asList(students));
		newStudents.add(student);
		this.students = newStudents.toArray(new Student[newStudents.size()]);
	}

	@Override
	public void add(Student student, int index) {
		if(student == null){
			throw new IllegalArgumentException();
		}
		if(index < 0 || index >= this.students.length){
			throw new IllegalArgumentException();
		}
		List<Student> newStudents = new ArrayList<>();
		for (int i = 0; i < i; i++) {
			newStudents.add(students[i]);
		}
		newStudents.add(student);
		for (int i = index; i < students.length; i++) {
			newStudents.add(students[i]);
		}
		this.students = newStudents.toArray(new Student[newStudents.size()]);

	}

	@Override
	public void remove(int index) {
		if(index < 0 || index >= this.students.length){
			throw new IllegalArgumentException();
		}
		List<Student> newStudents = new ArrayList<>();
		for (int i = 0; i < students.length; i++) {
			if(i == index) continue;
			newStudents.add(students[i]);
		}

		this.students = newStudents.toArray(new Student[newStudents.size()]);

	}

	@Override
	public void remove(Student student) {
		if(student == null){
			throw new IllegalArgumentException("Student not exist");
		}

		List<Student> newStudents = new ArrayList<>();

		for (int i = 0; i < students.length; i++) {
			if(!student.equals(students[i])){
				newStudents.add(students[i]);
			}
		}
		this.students = newStudents.toArray(new Student[newStudents.size()]);

	}

	@Override
	public void removeFromIndex(int index) {
		if(index < 0 || index >= this.students.length){
			throw new IllegalArgumentException();
		}
		List<Student> newStudents = new ArrayList<>();

		for (int i = 0; i <= index; i++) {
			newStudents.add(students[i]);
		}
		this.students = newStudents.toArray(new Student[newStudents.size()]);
	}

	@Override
	public void removeFromElement(Student student) {
		if(student == null){
			throw new IllegalArgumentException();
		}

		List<Student> newStudents = new ArrayList<>();

		for (int i = 0; i < students.length; i++) {

			if(student.equals(students[i])){

				break;
			}
			newStudents.add(students[i]);
		}
		this.students = newStudents.toArray(new Student[newStudents.size()]);

	}

	@Override
	public void removeToIndex(int index) {
		if(index < 0 || index >= this.students.length){
			throw new IllegalArgumentException();
		}
		List<Student> newStudents = new ArrayList<>();

		for (int i = index; i < index; i++) {
			newStudents.add(students[i]);
		}
		this.students = newStudents.toArray(new Student[newStudents.size()]);

	}

	@Override
	public void removeToElement(Student student) {
		if(student == null){
			throw new IllegalArgumentException();
		}
		List<Student> newStudents = new ArrayList<>();

		for (int i = 0; i < students.length; i++) {
			newStudents.add(students[i]);
			if(student.equals(students[i])){

				break;
			}
		}
		this.students = newStudents.toArray(new Student[newStudents.size()]);

	}

	@Override
	public void bubbleSort() {
	    int len = students.length;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len- i; j++) {
				if ((students[j]).compareTo(students[j + 1]) > 0) {
					Student temp =students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if(date == null){
			throw new IllegalArgumentException();
		}
		List<Student> studdArrayy = new ArrayList<>();

		for (int i = 0; i < students.length; i++) {
			if(this.students[i]==null || students[i].getBirthDate() == null) continue;
			if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date)){
				studdArrayy.add(students[i]);
			}
		}
		return studdArrayy.toArray(new Student[studdArrayy.size()]);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		List<Student> studdArrayy = new ArrayList<>();

		if(firstDate == null || lastDate == null){
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < students.length; i++) {
			if(this.students[i]==null || students[i].getBirthDate() == null) continue;
			if(students[i].getBirthDate().before(lastDate) || students[i].getBirthDate().after(firstDate)
					||students[i].getBirthDate().equals(firstDate)||students[i].getBirthDate().equals(lastDate)){
				studdArrayy.add(students[i]);
			}
		}
		return studdArrayy.toArray(new Student[studdArrayy.size()]);
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		List<Student> studdArrayy = new ArrayList<>();
		if(date == null){
			throw new IllegalArgumentException();
		}

		Date lastDate = new Date(date.getTime() + TimeUnit.DAYS.toMillis(days));
		for (int i = 0; i < students.length; i++) {
			if(this.students[i]==null || students[i].getBirthDate() == null) continue;
			if(students[i].getBirthDate().before(lastDate) || students[i].getBirthDate().after(date)
					||students[i].getBirthDate().equals(date)||students[i].getBirthDate().equals(lastDate)){
				studdArrayy.add(students[i]);
			}
		}
		return studdArrayy.toArray(new Student[studdArrayy.size()]);
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if(indexOfStudent == 0){
			throw new IllegalArgumentException();
		}
		Student student = students[indexOfStudent];
		if(student == null){
			return 0;
		}
		Date date = student.getBirthDate();
		Date currentDate = new Date();
		return getAge(currentDate, date);

	}

	@Override
	public Student[] getStudentsByAge(int age) {
		List<Student> studdArrayy = new ArrayList<>();
		Date currentDate = new Date();
		int j = 0;
		for (int i = 0; i < students.length; i++) {
			if(students[i] == null) continue;
			if(getAge(currentDate, students[i].getBirthDate()) == age){
				studdArrayy.add(students[i]);
			}
		}
		return studdArrayy.toArray(new Student[studdArrayy.size()]);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double maxMarks = students[0].getAvgMark();
		for (int i = 0; i < students.length; i++) {
			if(students[i].getAvgMark() > maxMarks ){
				maxMarks = students[i].getAvgMark();
			}
		}
		List<Student> studdArrayy = new ArrayList<>();
		for (int i = 0; i < students.length; i++) {
			if(students[i].getAvgMark() == maxMarks){
				studdArrayy.add(students[i]);
			}
		}
		return studdArrayy.toArray(new Student[studdArrayy.size()]);
	}

	@Override
	public Student getNextStudent(Student student) {
		if(student == null){
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < students.length; i++) {
			if(student.equals(students[i])){
				if(i+1 < students.length){
					return students[i+1];
				}
			}
		}
		return null;
	}

	private int getAge(Date d1, Date d2){
		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

	}
}
