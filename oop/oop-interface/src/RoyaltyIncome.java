
/**
 * 稿费收入税率是20%
 */
public class RoyaltyIncome implements Income{
    private double royalincome;
    @Override
    public double getTax() {
        return royalincome*0.2;
    }
    public RoyaltyIncome(double royalincome){
        this.royalincome = royalincome;
    }

    // TODO


}
