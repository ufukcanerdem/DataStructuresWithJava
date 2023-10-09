/**
     *	The class that includes the functions of all the operations that the Market can do
     *<p>
     *  Extends	Building Class
     *<p>
     * Implements  MarketOperations Interface and Override its methods 
     */
public class Market extends Building implements MarketOperations{
	private String OpenTime;
	private String CloseTime;
	final private int BuildingType=2;
	
	public Market(int paramSide, int paramPosStart, int paramLen, int paramHeight){
		this.Side=paramSide;
		this.pos_start=paramPosStart;
		this.len=paramLen;
		this.height=paramHeight;
    }
	
	public void setOpenTime(String paramOpenTime) {
		this.OpenTime=paramOpenTime;
	}
	
	public String getOpenTime() {
		return OpenTime;
	}
	
	public void setCloseTime(String paramCloseTime) {
		this.CloseTime=paramCloseTime;
	}
	
	public String getCloseTime() {
		return CloseTime;
	}
	
	public int getBuildingType() {
		return BuildingType;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(" Market, Open Time:" + this.OpenTime + " Close Time:" + this.CloseTime);
		
	}
}
