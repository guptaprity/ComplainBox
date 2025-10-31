public class Complaint {
    private int complaintId;
    private String username;
    private String description;
    private String status;

    public Complaint(int complaintId, String username, String description) {
        this.complaintId = complaintId;
        this.username = username;
        this.description = description;
        this.status = "PENDING";
    }

    public int getComplaintId() { return complaintId; }
    public String getUsername() { return username; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status.toUpperCase();
    }

    @Override
    public String toString() {
        return "ID: " + complaintId +
               " | User: " + username +
               " | Status: " + status +
               " | Desc: " + description;
    }
}
