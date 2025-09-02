package student.fee;

public class Student {
    int NustID;
    String Name;
    double TotalFee;

    Student() {
        NustID = 0;
        Name = "NoName";
        TotalFee = 0.0;
    }

    Student(int id, String name, double fee) {
        NustID = id;
        Name = name;
        TotalFee = fee;
    }

    Student(Student s) {
        NustID = s.NustID;
        Name = s.Name;
        TotalFee = s.TotalFee;
    }

    void PrintFee() {
        System.out.println("I am NUST student.");
    }

    void PrintFee(double extra) {
        System.out.println("Total fee with extra: " + (TotalFee + extra));
    }
}
