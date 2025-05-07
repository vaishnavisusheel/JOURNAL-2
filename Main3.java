import java.time.*;
import java.time.format.DateTimeFormatter;

// Person class
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void displayName() {
        System.out.println("Name: " + name);
    }

    void displayAge(String dob) {
        try {
            DateTimeFormatter formatter = dob.indexOf('-') == 2 ?
                DateTimeFormatter.ofPattern("dd-MM-yyyy") :
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate birthDate = LocalDate.parse(dob, formatter);
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            System.out.println("Age: " + age);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }
}

// Employee class
class Employee extends Person {
    int empId;
    double salary;

    Employee(String name, int empId, double salary) {
        super(name);
        this.empId = empId;
        this.salary = salary;
    }

    void displayDetails() {
        displayName();
        System.out.println("Emp ID: " + empId);
        System.out.println("Salary: ₹" + salary);
    }
}

// Main class
public class Main3 {
    public static void main(String[] args) {
        Employee e = new Employee("Anjali", 101, 50000);
        e.displayDetails();
        e.displayAge("15-08-2000"); // or use "2000-08-15"
        Employee e1 = new Employee("Akash", 101, 50000);
        e1.displayDetails();
        e1.displayAge("15-08-2004"); // or use "2004-08-15"
    }
}