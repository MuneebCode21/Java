package student.fee;

public class PC extends Student {
    PC(int id, String name, double fee) {
        super(id, name, fee);
    }

    @Override
    void PrintFee() {
        System.out.println(Name + " (PC): 50% Student = " + (TotalFee / 2) + ", 50% Army = " + (TotalFee / 2));
    }
}
