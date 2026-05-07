{
  "studentId": 101,
  "name": "Priya"
}

{
  "studentId": 101,
  "type": "Electricity",
  "description": "Fan not working",
  "status": "Pending",
  "date": "2026-03-17"
}

{
  "resource": "Study Room",
  "studentId": 101,
  "timeSlot": "10AM-11AM",
  "date": "2026-03-18"
}

import com.mongodb.client.*;
import org.bson.Document;
import java.util.*;

public class HostelManagementSystem {
    private static Scanner sc = new Scanner(System.in);
    private static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private static MongoDatabase db = mongoClient.getDatabase("hostelDB");
    private static MongoCollection<Document> students = db.getCollection("students");
    private static MongoCollection<Document> complaints = db.getCollection("complaints");
    private static MongoCollection<Document> bookings = db.getCollection("bookings");

    // Student login
    public static Document studentLogin(int id, String name) {
        Document student = students.find(new Document("studentId", id).append("name", name)).first();
        if (student == null) {
            students.insertOne(new Document("studentId", id).append("name", name));
            System.out.println("New student registered!");
        }
        return student;
    }

    // Raise complaint
    public static void raiseComplaint(int studentId) {
        System.out.println("Enter type (Electricity/Water/Cleanliness): ");
        String type = sc.nextLine();
        System.out.println("Enter description: ");
        String desc = sc.nextLine();

        Document complaint = new Document("studentId", studentId)
                .append("type", type)
                .append("description", desc)
                .append("status", "Pending")
                .append("date", new Date().toString());

        complaints.insertOne(complaint);
        System.out.println("Complaint registered!");
    }

    // View complaints
    public static void viewComplaints(int studentId) {
        for (Document c : complaints.find(new Document("studentId", studentId))) {
            System.out.println(c.toJson());
        }
    }

    // Book resource
    public static void bookResource(int studentId) {
        System.out.println("Enter resource (Washing Machine/Study Room/Gym Slot): ");
        String resource = sc.nextLine();
        System.out.println("Enter time slot: ");
        String slot = sc.nextLine();
        System.out.println("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        Document existing = bookings.find(new Document("resource", resource)
                .append("timeSlot", slot)
                .append("date", date)).first();

        if (existing != null) {
            System.out.println("Slot already booked! Choose another time.");
        } else {
            Document booking = new Document("resource", resource)
                    .append("studentId", studentId)
                    .append("timeSlot", slot)
                    .append("date", date);
            bookings.insertOne(booking);
            System.out.println("Booking confirmed!");
        }
    }

    // Cancel booking
    public static void cancelBooking(int studentId) {
        System.out.println("Enter resource to cancel: ");
        String resource = sc.nextLine();
        bookings.deleteOne(new Document("studentId", studentId).append("resource", resource));
        System.out.println("Booking cancelled.");
    }

    // Admin: View all complaints
    public static void adminViewComplaints() {
        for (Document c : complaints.find()) {
            System.out.println(c.toJson());
        }
    }

    // Admin: Update complaint status
    public static void updateComplaintStatus() {
        System.out.println("Enter complaint studentId: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter new status (Pending/In Progress/Resolved): ");
        String status = sc.nextLine();

        complaints.updateOne(new Document("studentId", id),
                new Document("$set", new Document("status", status)));
        System.out.println("Complaint status updated.");
    }

    // Admin: View bookings
    public static void adminViewBookings() {
        for (Document b : bookings.find()) {
            System.out.println(b.toJson());
        }
    }

    public static void main(String[] args) {
        // Console menu logic here (Student Menu / Admin Menu)
    }
}
