package park.model;

public class Visitor extends Person {
    private int age;
    private int visits;

    public Visitor(String id, String name, String phone, String email, int age) {
        super(id, name, phone, email);
        this.age = age;
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getVisits() { return visits; }
    public void recordVisit() { visits++; }

    public String getCategory() {
        if (age < 13) return "Child";
        if (age < 18) return "Teen";
        if (age >= 60) return "Senior";
        return "Adult";
    }
}
