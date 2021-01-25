
/**
 * 定义抽象类Income
 */
public abstract class Income {

    // TODO
    protected double income;

    abstract public double getTax();

    public Income(double income)
    {
        this.income = income;
    }
}
