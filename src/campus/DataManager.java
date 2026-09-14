
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Demonstrates File I/O and Exception Handling
public class DataManager {

    private static final String FILE_NAME = "complaints.dat";

    // Save complaints to a file
    public static void saveComplaints(List<Complaint> complaints) {
        // Run in a background thread to demonstrate basic multithreading
        Thread saveThread = new Thread(() -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(complaints);
            } catch (IOException e) {
                System.out.println("Error saving data: " + e.getMessage());
            }
        });
        saveThread.start();
        
        try {
            saveThread.join(); // Wait for it to finish before shutting down
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Load complaints from a file
    @SuppressWarnings("unchecked")
    public static List<Complaint> loadComplaints() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>(); // Return empty list if no file exists
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Complaint>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
