
public class BSTNode<T> {
	private BSTNode<T> left,right;
	private T info;
	public BSTNode(T info)
	{
		left = null;
		right = null;
		this.info = info;
	}
	public BSTNode<T> getLeft() {
		return left;
	}
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	public BSTNode<T> getRight() {
		return right;
	}
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	
}
