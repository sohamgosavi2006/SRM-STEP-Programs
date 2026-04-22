public class Student {
    private String studentID;
    private String name;
    private double grade;
    private String course;

    // Default constructor
    public Student() {
        studentID = "";
        name = "";
        grade = 0.0;
        course = "";
    }

    // Parameterized constructor
    public Student(String studentID, String name, double grade, String course) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // Getter and Setter methods
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Method to calculate letter grade
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    // Method to display student info
    public void displayStudent() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        // Creating student using default constructor
        Student s1 = new Student();
        s1.setStudentID("RA2411001");
        s1.setName("Soham");
        s1.setGrade(85.5);
        s1.setCourse("OOP Fundamentals");

        // Creating student using parameterized constructor
        Student s2 = new Student("RA2411002", "Sameer", 72.0, "Data Structures");

        // Display info for both students
        s1.displayStudent();
        s2.displayStudent();
    }
}
