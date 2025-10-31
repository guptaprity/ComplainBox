import java.util.Scanner;

public class MainApp {
    private static LoginManager loginManager = new LoginManager();
    private static ComplaintManager complaintManager = new ComplaintManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService(complaintManager, sc);
        AdminService adminService = new AdminService(complaintManager, loginManager);

        System.out.println("=== Complaint Registration & Resolution System ===");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1) Login");
            System.out.println("2) Exit");
            System.out.print("Choose: ");
            String choice = sc.next();

            if (choice.equals("1")) {
                sc.nextLine();
                System.out.print("Username: ");
                String username = sc.nextLine().trim();
                System.out.print("Password: ");
                String password = sc.nextLine().trim();

                User user = loginManager.login(username, password);
                if (user == null) {
                    System.out.println("Invalid credentials. Try again.");
                    continue;
                }

                System.out.println("Welcome, " + user.getUsername() + " (" + user.getRole() + ")");
                if (user.getRole().equals("USER")) {
                    userMenu(user, userService, sc);
                } else if (user.getRole().equals("ADMIN")) {
                    adminMenu(user, adminService, sc);
                } else {
                    System.out.println("Unknown role. Contact admin.");
                }

            } else if (choice.equals("2")) {
                System.out.println("Exiting... Bye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }

    private static void userMenu(User user, UserService userService, Scanner sc) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1) File a Complaint");
            System.out.println("2) View My Complaints");
            System.out.println("3) Logout");
            System.out.print("Choose: ");
            String c = sc.next();

            if (c.equals("1")) {
                userService.fileComplaint(user.getUsername());
            } else if (c.equals("2")) {
                userService.viewMyComplaints(user.getUsername());
            } else if (c.equals("3")) {
                System.out.println("Logged out.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private static void adminMenu(User user, AdminService adminService, Scanner sc) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1) View All Complaints");
            System.out.println("2) Update Complaint Status");
            System.out.println("3) Add User");
            System.out.println("4) Logout");
            System.out.print("Choose: ");
            String c = sc.next();

            if (c.equals("1")) {
                adminService.viewAllComplaints();
            } else if (c.equals("2")) {
                System.out.print("Enter Complaint ID: ");
                int id = -1;
                try {
                    id = Integer.parseInt(sc.next());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID input.");
                    continue;
                }
                System.out.print("Enter new status (PENDING / IN_PROGRESS / RESOLVED): ");
                String status = sc.next();
                adminService.updateComplaintStatus(id, status);
            } else if (c.equals("3")) {
                sc.nextLine();
                System.out.print("New username: ");
                String uname = sc.nextLine().trim();
                System.out.print("New password: ");
                String pass = sc.nextLine().trim();
                System.out.print("Role (USER / ADMIN): ");
                String role = sc.nextLine().trim();
                adminService.addUser(uname, pass, role);
            } else if (c.equals("4")) {
                System.out.println("Admin logged out.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
