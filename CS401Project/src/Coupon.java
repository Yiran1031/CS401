
public class Coupon {
	private String Provider;
	private String product;
	private int price;
	private double discount;
	private int expiration;
	private boolean status;
	public Coupon(String provider, String product, int price, double discount, int expiration) 
	{
		this.Provider =  provider;
		this.product = product;
		this.price = price;
		this.discount = discount; 
		this.expiration = expiration;
	}
	public String getProvider() {
		return Provider;
	}
	public void setProvider(String provider) {
		byte[] b = provider.getBytes();
		if(b.length <= 20)
			{
			System.out.println("the length is " + b.length);// test code
			this.Provider = provider;
			}
		else
			System.out.println("failure, please input valid value");
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		char[] c = product.toCharArray();
		if(c.length <= 20) 
		{
			System.out.println("the length is " + c.length);// test code
			this.product = product;
		}else
			System.out.println("failure, please input valid value");
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getExpiration() {
		return expiration;
	}
	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
