package student.fee;

public class GC extends Student {
    GC(int id, String name, double fee) {
        super(id, name, fee);
    }

    @Override
    void PrintFee() {
        System.out.println(Name + " (GC): Fee paid by Army = " + TotalFee);
    }
}
