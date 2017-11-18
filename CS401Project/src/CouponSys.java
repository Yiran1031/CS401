import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CouponSys {
	String str;
	int num = 0;
	public LinkedList<Coupon> readFile() throws IOException 
	{
		LinkedList<Coupon> list = new LinkedList();
		File f = new File("./src/data.txt");
		BufferedReader bf = new BufferedReader(new FileReader(f));
		while((str=bf.readLine())!=null)
		  {
			if(!str.trim().isEmpty())
				{
				String[] s=str.split(",");
			    //System.out.println(s[0]+","+s[1]+","+s[2]+","+s[3]+","+s[4]);
			    Coupon c = new Coupon(s[0],s[1],Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]));
			    list.add(c);
				}
		  }
		return list;
		 
	}
	
	public void write(Coupon c) throws IOException {
			FileWriter fw;
			fw = new FileWriter("./src/data.txt",true);
			fw.write("\r\n");
			fw.write(c.getProvider()+","+c.getProduct()+","+c.getPrice()+","+c.getDiscount()+","+c.getExpiration()+","+c.isStatus());
            fw.flush();
            fw.close();
		}
	
	public static void main(String[] args) 
	{
		CouponSys cs = new CouponSys();
		Coupon cp = new Coupon(null,"qqq",0,0,0);
		/*try {
			LinkedList<Coupon> ul = cs.readFile();
			SortedList sl = new SortedList(ul,"provider",30);
			sl.addToSL();
			LLNode<Coupon> coupon = sl.getHead();
			while(coupon != null) 
			{
				//System.out.println(coupon.getInfo());
				coupon = coupon.getLink();
			}
			//cs.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//cs.search(cp);
	}
	
	public String search(Coupon c) 
	{
		UserComparator uc = new UserComparator();
		BinarySearchTree<Coupon> bst = new BinarySearchTree(uc);
		CouponSys cs = new CouponSys();
		try {
			LinkedList<Coupon> ul = cs.readFile();
			LLNode<Coupon> temp = ul.getFirst();
			while(temp != null) 
			{
				bst.add(temp.getInfo());
				//System.out.println(temp.getInfo());
				temp = temp.getLink();
			}
			Iterator<Coupon> iter =  bst.getIterator(BSTInterface.Traversal.Inorder);
			System.out.println("---------------------------------------------------------");
			while(iter.hasNext())
				System.out.println(iter.next()+",");
			//System.out.println(bst.contains(c));
			System.out.println(bst.getN());
			if(bst.contains(c)&&cs.linearSearch(c))
				return "Found in "+bst.getN()+ "th by BST and "+cs.num+"th by Linear Search";
			else
				return "No Coupon is found ¨C "+bst.getN()+"th by BST and "+cs.num+"th by Linear Search";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "No Coupon is found ¨C "+bst.getN()+"th by BST and "+cs.num+"th by Linear Search";
	}
	public boolean linearSearch(Coupon c) 
	{
		CouponSys cs = new CouponSys();
		try {
			LinkedList<Coupon> ul = cs.readFile();
			LLNode<Coupon> temp = ul.getFirst();
			while(temp != null) 
			{	
				num++;
				if(temp.getInfo().getProduct().equals(c.getProduct()))
				{
					return true;
				}
				temp = temp.getLink();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
