import java.util.Comparator;

public class UserComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Coupon c1 = (Coupon)o1;
		Coupon c2 = (Coupon)o2;
		/*if(key.equals("Provider")) 
		{
			if(c1.getProvider().compareTo(c2.getProvider()) < 0)
				return -1;
			else if(c1.getProvider().compareTo(c2.getProvider()) > 0)
				return 1;
			else
				return 0;
		}else*/
		
			if(c1.getProduct().compareTo(c2.getProduct()) < 0)
				return -1;
			else if(c1.getProduct().compareTo(c2.getProduct()) > 0)
				return 1;
			else
				return 0;
	}
	
}
