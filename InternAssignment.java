import java.util.Scanner;

public class StudentCGPA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.next();

            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            int[] grades = new int[numSubjects];

            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                grades[j] = scanner.nextInt();
            }

            students[i] = new Student(name, grades);
        }

        scanner.close();

        for (Student student : students) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Average Grade: " + student.getAverageGrade());
            System.out.println("Letter Grade: " + student.getLetterGrade());
            System.out.println();
        }
    }
}

class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public char getLetterGrade() {
        double averageGrade = getAverageGrade();
        if (averageGrade >= 90) {
            return 'A';
        } else if (averageGrade >= 80) {
            return 'B';
        } else if (averageGrade >= 70) {
            return 'C';
        } else if (averageGrade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
