package park.model;

public class Employee extends Person {
    private String role;
    private double salary;
    private String shift;
    private boolean active;

    public Employee(String id, String name, String phone, String email, String role, double salary, String shift) {
        super(id, name, phone, email);
        this.role = role;
        this.salary = salary;
        this.shift = shift;
        this.active = true;
    }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
