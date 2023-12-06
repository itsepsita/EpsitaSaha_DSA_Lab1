import java.util.Random;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class CredentialService {
    public static String generatePassword() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        String allChars = capitalLetters + smallLetters + numbers + specialChars;

        StringBuilder password = new StringBuilder();

        Random random = new Random();

        // Ensure at least one character from each category
        password.append(capitalLetters.charAt(random.nextInt(capitalLetters.length())));
        password.append(smallLetters.charAt(random.nextInt(smallLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Generate the rest of the password
        for (int i = 4; i < 12; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }

    public static String generateEmailAddress(Employee employee, String department, String company) {
        return employee.getFirstName().toLowerCase() +
                employee.getLastName().toLowerCase() +
                "@" +
                department.toLowerCase() +
                "." +
                company.toLowerCase() +
                ".com";
    }

    public static void showCredentials(Employee employee, String department, String company) {
        String password = generatePassword();
        String emailAddress = generateEmailAddress(employee, department, company);

        System.out.println("Generated Credentials:");
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Password: " + password);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee newEmployee = new Employee("John", "Doe");
        String department = "Technical";
        String company = "example";

        CredentialService.showCredentials(newEmployee, department, company);
    }
}
