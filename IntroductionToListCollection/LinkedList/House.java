/**
     *	The class that includes the functions of all the operations that the House can do
     *<p>
     *  Extends	Building Class
     *<p>
     * Implements  HouseOperations Interface and Override its methods 
     */
public class House extends Building implements HouseOperations{
	private int room=0;
	final private int BuildingType=0;
	private String color="Undefinied";
	
	
	public House(int paramSide, int paramPosStart, int paramLen, int paramHeight){
		this.Side=paramSide;
		this.pos_start=paramPosStart;
		this.len=paramLen;
		this.height=paramHeight;
    }
	
	public void setRoom(int paramRoom) {
		this.room=paramRoom;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setColor(String paramColor) {
		this.color=paramColor;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getBuildingType() {
		return BuildingType;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(" House, Room:" + this.room + " Color:" + this.color);
		
	}
}
