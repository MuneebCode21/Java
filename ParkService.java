package park.service;

import park.model.*;
import java.util.*;
import java.util.stream.Collectors;

public class ParkService {
    private final List<Ride> rides = new ArrayList<>();
    private final List<Visitor> visitors = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Ticket> tickets = new ArrayList<>();
    private final List<FoodItem> foodItems = new ArrayList<>();
    private final List<FoodOrder> orders = new ArrayList<>();
    private final List<ParkEvent> events = new ArrayList<>();
    private final IdGenerator ids = new IdGenerator();

    public ParkService() { seedData(); }

    private void seedData() {
        rides.add(new Ride("R-101", "Thunder Loop", RideType.ROLLER_COASTER, 24, 12, 9.5));
        rides.add(new Ride("R-102", "Splash Rapids", RideType.WATER, 16, 8, 7.5));
        rides.add(new Ride("R-103", "Sky Wheel", RideType.FAMILY, 32, 0, 4.0));
        rides.add(new Ride("R-104", "Dragon Flight", RideType.THRILL, 20, 14, 9.0));
        rides.add(new Ride("R-105", "Mini Rocket", RideType.KIDS, 12, 4, 3.0));
        rides.add(new Ride("R-106", "Future Quest", RideType.SIMULATOR, 10, 10, 6.5));
        visitors.add(new Visitor("V-1001", "Ayesha Khan", "0300-1234567", "ayesha@example.com", 22));
        visitors.add(new Visitor("V-1002", "Hamza Ali", "0301-7654321", "hamza@example.com", 15));
        employees.add(new Employee("E-1001", "Sarah Ahmed", "0311-5551111", "sarah@wonderworld.com", "Ride Operator", 2200, "Morning"));
        employees.add(new Employee("E-1002", "Bilal Shah", "0322-5552222", "bilal@wonderworld.com", "Security Officer", 2400, "Evening"));
        foodItems.add(new FoodItem("F-01", "Classic Burger", "Main", 8.50));
        foodItems.add(new FoodItem("F-02", "Loaded Fries", "Side", 5.00));
        foodItems.add(new FoodItem("F-03", "Park Pizza", "Main", 10.00));
        foodItems.add(new FoodItem("F-04", "Cola", "Drinks", 2.50));
        foodItems.add(new FoodItem("F-05", "Ice Cream", "Dessert", 4.25));
        log("System initialized with demo data");
    }

    public List<Ride> getRides() { return rides; }
    public List<Visitor> getVisitors() { return visitors; }
    public List<Employee> getEmployees() { return employees; }
    public List<Ticket> getTickets() { return tickets; }
    public List<FoodItem> getFoodItems() { return foodItems; }
    public List<FoodOrder> getOrders() { return orders; }
    public List<ParkEvent> getEvents() { return events; }

    public Visitor registerVisitor(String name, String phone, String email, int age) {
        Visitor v = new Visitor(ids.next("V-"), name, phone, email, age);
        visitors.add(v); log("Registered visitor: " + name); return v;
    }

    public Employee addEmployee(String name, String phone, String email, String role, double salary, String shift) {
        Employee e = new Employee(ids.next("E-"), name, phone, email, role, salary, shift);
        employees.add(e); log("Added employee: " + name); return e;
    }

    public Ticket sellTicket(TicketType type, String visitorName) {
        double price = type.getPrice();
        Ticket t = new Ticket(ids.next("T-"), type, visitorName, price);
        tickets.add(t); log("Sold " + type.getLabel() + " to " + visitorName + " for $" + String.format("%.2f", price)); return t;
    }

    public void operateRide(String rideId, int riders) {
        Ride r = findRide(rideId);
        if (r == null) throw new IllegalArgumentException("Ride not found");
        if (r.getStatus() != RideStatus.OPEN) throw new IllegalStateException("Ride is not open");
        r.operateCycle(riders); log("Ride cycle operated: " + r.getName() + " (" + riders + " riders)");
    }

    public void updateRideStatus(String rideId, RideStatus status) {
        Ride r = findRide(rideId);
        if (r == null) throw new IllegalArgumentException("Ride not found");
        r.setStatus(status); log(r.getName() + " status changed to " + status);
    }

    public FoodOrder createOrder(String customer, FoodItem item, int quantity) {
        if (!item.isAvailable()) throw new IllegalStateException("Selected item is unavailable");
        FoodOrder order = new FoodOrder(ids.next("O-"), customer);
        order.addLine(new FoodOrderLine(item, quantity));
        orders.add(order); log("Food order " + order.getId() + " created for " + customer);
        return order;
    }

    public Ride findRide(String id) { return rides.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null); }
    public List<Ride> searchRides(String q) { return rides.stream().filter(r -> r.getName().toLowerCase().contains(q.toLowerCase())).collect(Collectors.toList()); }
    public double getRevenue() { return tickets.stream().mapToDouble(Ticket::getPrice).sum() + orders.stream().mapToDouble(FoodOrder::getTotal).sum(); }
    public int getOpenRides() { return (int) rides.stream().filter(r -> r.getStatus() == RideStatus.OPEN).count(); }
    public int getTotalRiders() { return rides.stream().mapToInt(Ride::getRidersToday).sum(); }
    public void log(String message) { events.add(0, new ParkEvent(message)); if (events.size() > 30) events.remove(events.size() - 1); }
}
