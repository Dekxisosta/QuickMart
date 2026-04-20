package service;

public class TaxService {
	private final static double vatRate = .12;
    public double calculateVatableSale(double finalTotal) {
        double vatableSale = finalTotal / (1+vatRate);
        return vatableSale;
    }
    public double calculateVat(double finalTotal) {
    	return finalTotal - calculateVatableSale(finalTotal);
    }
}
