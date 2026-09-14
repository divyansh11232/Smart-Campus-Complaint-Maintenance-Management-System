
import java.io.Serializable;

public class Complaint implements Serializable {
    private int id;
    private String title;
    private String description;
    private Status status;
    private String createdBy;
    private String assignedTo;

    public Complaint(int id, String title, String description, String createdBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.status = Status.OPEN;
        this.assignedTo = "None";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "ID: " + id + 
               " | Title: " + title + 
               " | Status: " + status + 
               " | Created By: " + createdBy + 
               " | Assigned To: " + assignedTo;
    }
}
