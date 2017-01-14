import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner s;

		s = new Scanner(System.in);

		System.out.println("Enter the percentage");
		int grade;
		grade = s.nextInt();
		if (grade >= 90 && grade <= 100) {
			System.out.println("You got an A");

		}
		if (grade >= 80 && grade < 90) {
			System.out.println("You got a B");
		}

		if (grade >= 70 && grade < 80) {
			System.out.println("You got a C");
		}
		
		if (grade >= 60 && grade < 70) {
			System.out.println("You got a D");
		}
		
		if (grade < 60){
			System.out.println("You got a F");
		}
		
	}

}
