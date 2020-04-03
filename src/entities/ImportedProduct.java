package entities;

public class ImportedProduct extends Product{
	private Double customesFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customesFee) {
		super(name, price);
		this.customesFee = customesFee;
	}

	public Double getCustomesFee() {
		return customesFee;
	}

	public void setCustomesFee(Double customesFee) {
		this.customesFee = customesFee;
	}
	@Override
	public String priceTag() {
		return getName()+" $ "+totalPrice()+" (Customs fee: $"+getCustomesFee()+")";
	}
	public Double totalPrice() {
		return getPrice()+getCustomesFee();
	}
}
