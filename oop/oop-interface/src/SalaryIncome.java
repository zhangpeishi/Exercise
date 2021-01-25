
public class SalaryIncome implements Income{
    private double salaryincome;
    @Override
    public double getTax() {
        return (salaryincome-3000) *0.2;
    }

    // TODO
    public SalaryIncome(double salaryincome){
        this.salaryincome = salaryincome;
    }


}
