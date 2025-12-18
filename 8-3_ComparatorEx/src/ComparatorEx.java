import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student2 {
	int studentNumber;
	String name;
	String department;
	int grade;

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public Student2(int studentNumber, String name, String department, int grade) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.department = department;
		this.grade = grade;
	}
}

public class ComparatorEx {
	static int flag;
	public static void main(String[] args) {
		
		Student2 s1 = new Student2(202234001, "김", "AI", 4);
		Student2 s2 = new Student2(202234002, "이", "Computer Science", 3);
		Student2 s3 = new Student2(202234003, "박", "Software engineering ", 2);
		Student2 s4 = new Student2(202234004, "최", "Information and Communication Engineering ", 1);

		Student2 arr[] = { s1, s2, s3, s4 };
		
		while(true) {
		System.out.println("정렬기준을 입력해주세요.");
		System.out.println("학번 : 0  이름 : 1  학과 : 2 학년 : 3");
		Scanner sc = new Scanner(System.in);
		flag = sc.nextInt();
		
		Arrays.sort(arr, new Comparator<Student2>() {

			@Override
			public int compare(Student2 o1, Student2 o2) {
				// TODO Auto-generated method stub

				if (flag == 0) {
					if (o1.studentNumber > o2.studentNumber) {
						return 1;

					} else if (o1.studentNumber < o2.studentNumber) {
						return -1;
					} else {
						return 0;
					}
				} else if (flag == 1) {

					String o1name = o1.getName();
					String o2name = o2.getName();

					return o1name.compareToIgnoreCase(o2name);

				} else if (flag == 2) {

					String o1department = o1.getDepartment();
					String o2department = o2.getDepartment();

					return o1department.compareToIgnoreCase(o2department);
				} else if (flag == 3) {
					if (o1.grade > o2.grade) {
						return 1;

					} else if (o1.grade < o2.grade) {
						return -1;
					} else {
						return 0;
					}

				}
				return 0;

			}
		});


		for (Student2 s : arr) {

			System.out.println(s.studentNumber + " " + s.name + " " + s.department + " " + s.grade);

		}

		}
	}
}
