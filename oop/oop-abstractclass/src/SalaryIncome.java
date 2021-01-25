
public class SalaryIncome extends Income{
    public SalaryIncome(double income){
        super(income);
    }
    @Override
    public double getTax() {
        return (income-3000)*0.2;
    }

    // TODO

}
