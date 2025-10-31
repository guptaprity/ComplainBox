import java.util.List;

public class AdminService {
    private ComplaintManager cm;
    private LoginManager lm;

    public AdminService(ComplaintManager cm, LoginManager lm) {
        this.cm = cm;
        this.lm = lm;
    }

    public void viewAllComplaints() {
        List<Complaint> list = cm.getAllComplaints();
        if (list.isEmpty()) {
            System.out.println("No complaints in the system.");
            return;
        }
        System.out.println("All complaints:");
        for (Complaint c : list) System.out.println(c);
    }

    public void updateComplaintStatus(int complaintId, String status) {
        if (!status.equalsIgnoreCase("PENDING") &&
            !status.equalsIgnoreCase("IN_PROGRESS") &&
            !status.equalsIgnoreCase("RESOLVED")) {
            System.out.println("Invalid status. Use PENDING / IN_PROGRESS / RESOLVED");
            return;
        }
        boolean ok = cm.updateComplaintStatus(complaintId, status);
        if (ok) System.out.println("Complaint " + complaintId + " status updated to " + status.toUpperCase());
        else System.out.println("Complaint ID not found: " + complaintId);
    }

    public void addUser(String username, String password, String role) {
        if (lm.usernameExists(username)) {
            System.out.println("Username already exists: " + username);
            return;
        }
        if (!role.equalsIgnoreCase("ADMIN") && !role.equalsIgnoreCase("USER")) {
            System.out.println("Role must be USER or ADMIN");
            return;
        }
        lm.addUser(new User(username, password, role.toUpperCase()));
        System.out.println("User added: " + username + " (" + role.toUpperCase() + ")");
    }
}
