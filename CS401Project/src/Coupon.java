
public class Coupon {
	private String Provider;
	private String product;
	private int price;
	private int discount;
	private int expiration;
	private boolean status;
	public Coupon(String provider, String product, int price, int discount, int expiration) 
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
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		if(discount <= 0.8 && discount >=0.05) 
		{
			this.discount = discount;
		}else
			System.out.println("failure, please input valid value");
	}
			
		
	public int getExpiration() {
		return expiration;
	}
	public void setExpiration(int expiration) {
		if(expiration<= 365 && expiration >=0)
		{
			this.expiration = expiration;
		}else
			System.out.println("failure, please input valid value");	
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String toString() 
	{
		return this.getProvider()+","+this.getProduct() + "," +this.getPrice() + "," + this.getDiscount()+","+this.getExpiration()+","+this.isStatus();
	} 
	
	public int compareTo(Coupon c, String type) 
	{
		if(type.equals("Product"))
		{
			if(this.getProduct().compareTo(c.getProduct()) < 0)
				return -1;
			else if(this.getProduct().compareTo(c.getProduct()) == 0)
				return 0;
			else if(this.getProduct().compareTo(c.getProduct()) > 0)
				return 1;
		}
		return 1;
	}
}
