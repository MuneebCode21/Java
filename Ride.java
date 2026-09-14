package park.model;

public class Ride {
    private final String id;
    private String name;
    private RideType type;
    private int capacity;
    private int minAge;
    private double thrillLevel;
    private RideStatus status;
    private int cycles;
    private int ridersToday;

    public Ride(String id, String name, RideType type, int capacity, int minAge, double thrillLevel) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.minAge = minAge;
        this.thrillLevel = thrillLevel;
        this.status = RideStatus.OPEN;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public RideType getType() { return type; }
    public void setType(RideType type) { this.type = type; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getMinAge() { return minAge; }
    public void setMinAge(int minAge) { this.minAge = minAge; }
    public double getThrillLevel() { return thrillLevel; }
    public RideStatus getStatus() { return status; }
    public void setStatus(RideStatus status) { this.status = status; }
    public int getCycles() { return cycles; }
    public int getRidersToday() { return ridersToday; }
    public boolean canRide(int age) { return status == RideStatus.OPEN && age >= minAge; }

    public void operateCycle(int riders) {
        cycles++;
        ridersToday += Math.max(0, Math.min(riders, capacity));
    }
}
