import java.util.*;

class Subject {
    String subjectCode;
    String subjectName;
    int credits;
    String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }
}

class Student {
    String studentId;
    String studentName;
    String className;
    String[] subjects;
    double[][] marks; // [subject][exam] marks
    double gpa;

    // Static variables
    static int totalStudents = 0;
    static String schoolName = "SRM Public School";
    static String[] gradingScale = {"A: 90-100", "B: 75-89", "C: 60-74", "D: 40-59", "F: <40"};
    static double passPercentage = 40.0;

    public Student(String studentId, String studentName, String className, String[] subjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length][3]; // 3 exams per subject
        this.gpa = 0.0;
        totalStudents++;
    }

    // Instance Methods
    public void addMarks(String subject, double[] examMarks) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subject)) {
                for (int j = 0; j < examMarks.length; j++) {
                    marks[i][j] = examMarks[j];
                }
                return;
            }
        }
        System.out.println("Subject not found for student " + studentName);
    }

    public void calculateGPA() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        double percentage = (total / (count * 100)) * 100; // assuming marks out of 100
        if (percentage >= 90) gpa = 4.0;
        else if (percentage >= 75) gpa = 3.5;
        else if (percentage >= 60) gpa = 3.0;
        else if (percentage >= 40) gpa = 2.0;
        else gpa = 0.0;
    }

    public void generateReportCard() {
        System.out.println("\n--- Report Card ---");
        System.out.println("School      : " + schoolName);
        System.out.println("Student     : " + studentName + " (" + studentId + ")");
        System.out.println("Class       : " + className);
        for (int i = 0; i < subjects.length; i++) {
            double total = 0;
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }
            double avg = total / marks[i].length;
            System.out.println(subjects[i] + " | Average Marks: " + avg + " | Grade: " + getGrade(avg));
        }
        System.out.println("GPA         : " + gpa);
        System.out.println("Promotion   : " + (checkPromotionEligibility() ? "Eligible" : "Not Eligible"));
    }

    public boolean checkPromotionEligibility() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        double percentage = total / count;
        return percentage >= passPercentage;
    }

    private String getGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    // Static Methods
    public static void setGradingScale(String[] newScale) {
        gradingScale = newScale;
    }

    public static double calculateClassAverage(Student[] students, String className) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            if (s != null && s.className.equalsIgnoreCase(className)) {
                for (int i = 0; i < s.subjects.length; i++) {
                    for (int j = 0; j < s.marks[i].length; j++) {
                        total += s.marks[i][j];
                        count++;
                    }
                }
            }
        }
        return count > 0 ? total / count : 0.0;
    }

    public static void getTopPerformers(Student[] students, int count) {
        Arrays.sort(students, (a, b) -> Double.compare(b.gpa, a.gpa));
        System.out.println("\n--- Top " + count + " Performers ---");
        for (int i = 0; i < Math.min(count, students.length); i++) {
            if (students[i] != null) {
                System.out.println(students[i].studentName + " | GPA: " + students[i].gpa);
            }
        }
    }

    public static void generateSchoolReport(Student[] students) {
        System.out.println("\n--- School Report ---");
        System.out.println("Total Students: " + totalStudents);
        double schoolAvg = 0;
        int count = 0;
        for (Student s : students) {
            if (s != null) {
                schoolAvg += s.gpa;
                count++;
            }
        }
        if (count > 0) {
            schoolAvg /= count;
        }
        System.out.println("Average GPA   : " + schoolAvg);
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        // Subjects
        String[] subjects = {"Math", "Science", "English"};

        // Students
        Student s1 = new Student("S101", "Alice", "10A", subjects);
        Student s2 = new Student("S102", "Bob", "10A", subjects);
        Student s3 = new Student("S103", "Charlie", "10B", subjects);

        // Add marks
        s1.addMarks("Math", new double[]{95, 90, 92});
        s1.addMarks("Science", new double[]{88, 85, 91});
        s1.addMarks("English", new double[]{78, 82, 80});
        s1.calculateGPA();

        s2.addMarks("Math", new double[]{70, 65, 72});
        s2.addMarks("Science", new double[]{60, 68, 64});
        s2.addMarks("English", new double[]{55, 58, 60});
        s2.calculateGPA();

        s3.addMarks("Math", new double[]{85, 89, 90});
        s3.addMarks("Science", new double[]{92, 94, 91});
        s3.addMarks("English", new double[]{88, 86, 90});
        s3.calculateGPA();

        Student[] allStudents = {s1, s2, s3};

        // Generate reports
        s1.generateReportCard();
        s2.generateReportCard();
        s3.generateReportCard();

        // Class average
        System.out.println("\nClass 10A Average: " + Student.calculateClassAverage(allStudents, "10A"));
        System.out.println("Class 10B Average: " + Student.calculateClassAverage(allStudents, "10B"));

        // Top performers
        Student.getTopPerformers(allStudents, 2);

        // School report
        Student.generateSchoolReport(allStudents);
    }
}
