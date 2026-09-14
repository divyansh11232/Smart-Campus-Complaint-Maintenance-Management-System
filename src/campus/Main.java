
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Complaint> complaints = new ArrayList<>();
    private static int complaintIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;

    public static void main(String[] args) {
        // Load data from file at startup
        complaints = DataManager.loadComplaints();
        if (!complaints.isEmpty()) {
            // Find the highest ID so we can safely auto-increment
            for (Complaint c : complaints) {
                if (c.getId() >= complaintIdCounter) {
                    complaintIdCounter = c.getId() + 1;
                }
            }
        }

        System.out.println("=========================================");
        System.out.println(" Welcome to Campus Complaint System");
        System.out.println("=========================================");

        while (true) {
            if (currentUser == null) {
                loginMenu();
            } else {
                if (currentUser instanceof Student) {
                    studentMenu();
                } else if (currentUser instanceof Admin) {
                    adminMenu();
                } else if (currentUser instanceof Maintenance) {
                    maintenanceMenu();
                }
            }
        }
    }

    private static void loginMenu() {
        System.out.println("\n--- Login ---");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Login as Maintenance");
        System.out.println("4. Exit Program");
        
        System.out.print("Choice: ");
        int choice = getIntInput();

        if (choice == 4) {
            System.out.println("Saving data...");
            DataManager.saveComplaints(complaints);
            System.out.println("Goodbye!");
            System.exit(0);
        }

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (choice == 1) currentUser = new Student(username);
        else if (choice == 2) currentUser = new Admin(username);
        else if (choice == 3) currentUser = new Maintenance(username);
        else System.out.println("Invalid choice!");
        
        if (currentUser != null) {
            System.out.println("Logged in as: " + currentUser);
        }
    }

    private static void studentMenu() {
        System.out.println("\n--- Student Menu (" + currentUser.getUsername() + ") ---");
        System.out.println("1. Create new complaint");
        System.out.println("2. View my complaints");
        System.out.println("3. Logout");
        System.out.print("Choice: ");
        
        int choice = getIntInput();
        if (choice == 1) {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Description: ");
            String desc = scanner.nextLine();
            
            Complaint c = new Complaint(complaintIdCounter++, title, desc, currentUser.getUsername());
            complaints.add(c);
            System.out.println("Complaint logged with ID: " + c.getId());
        } else if (choice == 2) {
            boolean found = false;
            for (Complaint c : complaints) {
                if (c.getCreatedBy().equals(currentUser.getUsername())) {
                    System.out.println(c);
                    found = true;
                }
            }
            if (!found) System.out.println("You have no complaints.");
        } else if (choice == 3) {
            currentUser = null;
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void adminMenu() {
        System.out.println("\n--- Admin Menu (" + currentUser.getUsername() + ") ---");
        System.out.println("1. View ALL complaints");
        System.out.println("2. Assign complaint to maintenance");
        System.out.println("3. Logout");
        System.out.print("Choice: ");
        
        int choice = getIntInput();
        if (choice == 1) {
            if (complaints.isEmpty()) System.out.println("No complaints in the system.");
            for (Complaint c : complaints) System.out.println(c);
        } else if (choice == 2) {
            System.out.print("Enter Complaint ID to assign: ");
            int id = getIntInput();
            System.out.print("Enter Maintenance worker's username: ");
            String worker = scanner.nextLine();
            
            for (Complaint c : complaints) {
                if (c.getId() == id) {
                    c.setAssignedTo(worker);
                    c.setStatus(Status.ASSIGNED);
                    System.out.println("Assigned complaint " + id + " to " + worker);
                    return;
                }
            }
            System.out.println("Complaint not found.");
        } else if (choice == 3) {
            currentUser = null;
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void maintenanceMenu() {
        System.out.println("\n--- Maintenance Menu (" + currentUser.getUsername() + ") ---");
        System.out.println("1. View my assigned complaints");
        System.out.println("2. Resolve a complaint");
        System.out.println("3. Logout");
        System.out.print("Choice: ");
        
        int choice = getIntInput();
        if (choice == 1) {
            boolean found = false;
            for (Complaint c : complaints) {
                if (currentUser.getUsername().equals(c.getAssignedTo())) {
                    System.out.println(c);
                    found = true;
                }
            }
            if (!found) System.out.println("You have no assigned tasks.");
        } else if (choice == 2) {
            System.out.print("Enter Complaint ID to resolve: ");
            int id = getIntInput();
            
            for (Complaint c : complaints) {
                if (c.getId() == id && currentUser.getUsername().equals(c.getAssignedTo())) {
                    c.setStatus(Status.RESOLVED);
                    System.out.println("Complaint " + id + " has been RESOLVED.");
                    return;
                }
            }
            System.out.println("Complaint not found or not assigned to you.");
        } else if (choice == 3) {
            currentUser = null;
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Helper method to demonstrate Exception Handling
    private static int getIntInput() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }
}
