package BalancesFunctions;

interface IPayment {
    double GetPaymentBalance();
    void SetPaymentBalance(double priceBalance);
}

public class FunctionalBalance implements IPayment {

    private double balancePrice = 0;
    @Override
    public double GetPaymentBalance() {
        return balancePrice;
    }

    @Override
    public void SetPaymentBalance(double priceBalance) {
        this.balancePrice = priceBalance;
    }
}


