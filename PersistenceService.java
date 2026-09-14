package park.service;

import park.model.*;
import java.io.*;
import java.nio.file.*;

public class PersistenceService {
    private final Path dataDir;
    public PersistenceService(Path dataDir) { this.dataDir = dataDir; }

    public void export(ParkService service) throws IOException {
        Files.createDirectories(dataDir);
        writeRides(service);
        writeVisitors(service);
        writeEmployees(service);
        writeTickets(service);
        writeOrders(service);
        service.log("Data exported to CSV");
    }

    private void writeRides(ParkService s) throws IOException {
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(dataDir.resolve("rides.csv")))) {
            out.println("id,name,type,capacity,minAge,status,cycles,ridersToday");
            for (Ride r : s.getRides()) out.printf("%s,%s,%s,%d,%d,%s,%d,%d%n", csv(r.getId()),csv(r.getName()),r.getType(),r.getCapacity(),r.getMinAge(),r.getStatus(),r.getCycles(),r.getRidersToday());
        }
    }
    private void writeVisitors(ParkService s) throws IOException {
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(dataDir.resolve("visitors.csv")))) {
            out.println("id,name,phone,email,age,visits");
            for (Visitor v : s.getVisitors()) out.printf("%s,%s,%s,%s,%d,%d%n", csv(v.getId()),csv(v.getName()),csv(v.getPhone()),csv(v.getEmail()),v.getAge(),v.getVisits());
        }
    }
    private void writeEmployees(ParkService s) throws IOException {
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(dataDir.resolve("employees.csv")))) {
            out.println("id,name,phone,email,role,salary,shift,active");
            for (Employee e : s.getEmployees()) out.printf("%s,%s,%s,%s,%s,%.2f,%s,%s%n", csv(e.getId()),csv(e.getName()),csv(e.getPhone()),csv(e.getEmail()),csv(e.getRole()),e.getSalary(),csv(e.getShift()),e.isActive());
        }
    }
    private void writeTickets(ParkService s) throws IOException {
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(dataDir.resolve("tickets.csv")))) {
            out.println("id,type,visitor,price,purchasedAt");
            for (Ticket t : s.getTickets()) out.printf("%s,%s,%s,%.2f,%s%n", csv(t.getId()),t.getType(),csv(t.getVisitorName()),t.getPrice(),t.getTimestamp());
        }
    }
    private void writeOrders(ParkService s) throws IOException {
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(dataDir.resolve("orders.csv")))) {
            out.println("orderId,customer,total");
            for (FoodOrder o : s.getOrders()) out.printf("%s,%s,%.2f%n", csv(o.getId()),csv(o.getCustomer()),o.getTotal());
        }
    }
    private String csv(String value) { return "\"" + value.replace("\"", "\"\"") + "\""; }
}
