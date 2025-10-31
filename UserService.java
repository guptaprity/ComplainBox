import java.util.List;
import java.util.Scanner;

public class UserService {
    private ComplaintManager cm;
    private Scanner sc;

    public UserService(ComplaintManager cm, Scanner sc) {
        this.cm = cm;
        this.sc = sc;
    }

    public void fileComplaint(String username) {
        System.out.println("Enter complaint description:");
        sc.nextLine();
        String desc = sc.nextLine().trim();
        if (desc.isEmpty()) {
            System.out.println("Description cannot be empty.");
            return;
        }
        int id = cm.registerComplaint(username, desc);
        System.out.println("Complaint filed successfully. Complaint ID: " + id);
    }

    public void viewMyComplaints(String username) {
        List<Complaint> list = cm.getComplaintsByUser(username);
        if (list.isEmpty()) {
            System.out.println("You have not filed any complaints yet.");
            return;
        }
        System.out.println("Your complaints:");
        for (Complaint c : list) System.out.println(c);
    }
}
