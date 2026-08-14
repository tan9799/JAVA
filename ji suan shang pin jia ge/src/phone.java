public class phone extends devices{
    public double calculate() {
        double payment = super.calculate();
        payment *= 0.9;
        return payment;
    }
}
