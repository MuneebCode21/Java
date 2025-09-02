package student.fee;

public class NC extends Student {
    NC(int id, String name, double fee) {
        super(id, name, fee);
    }

    @Override
    void PrintFee() {
        System.out.println(Name + " (NC): Fee paid by student = " + TotalFee);
    }
}
