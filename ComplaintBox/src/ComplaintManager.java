import java.util.ArrayList;
import java.util.List;

public class ComplaintManager {
    private List<Complaint> complaints;
    private int complaintCounter;

    public ComplaintManager() {
        complaints = new ArrayList<>();
        complaintCounter = 1;
    }

    public synchronized int registerComplaint(String username, String description) {
        int id = complaintCounter++;
        Complaint c = new Complaint(id, username, description);
        complaints.add(c);
        return id;
    }

    public List<Complaint> getAllComplaints() {
        return new ArrayList<>(complaints);
    }

    public List<Complaint> getComplaintsByUser(String username) {
        List<Complaint> res = new ArrayList<>();
        for (Complaint c : complaints) {
            if (c.getUsername().equals(username)) res.add(c);
        }
        return res;
    }

    public boolean updateComplaintStatus(int complaintId, String newStatus) {
        for (Complaint c : complaints) {
            if (c.getComplaintId() == complaintId) {
                c.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public Complaint getComplaintById(int complaintId) {
        for (Complaint c : complaints) {
            if (c.getComplaintId() == complaintId) return c;
        }
        return null;
    }
}
