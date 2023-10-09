/**
     *	The class that includes the functions of all the operations that the Building can do
     *<p>
     *  Extends	Street Class
     *<p>
     */
public class Building extends Street {
	protected String OwnerName="Unknown";
	
	public void setOwnerName(String paramOwnerName) {
		this.OwnerName=paramOwnerName;
	}
	
	public String getOwnerName() {
		return OwnerName;
	}
	
	public void printInfo() {
		System.out.print("Side:" + this.Side + " posStart:" + this.pos_start + " posEnd:" + (this.pos_start+this.len) 
							+ " height:" + this.height);
	}
}
