/**
     *	The class that includes the functions of all the operations that the Street can do
     *<p>
     *  Extends	Street Class
     *<p>
     */
public class Playground extends Street{
	final private int BuildingType=3;
	
	public Playground(int paramSide, int paramPosStart, int paramLen, int paramHeight){
		this.Side=paramSide;
		this.pos_start=paramPosStart;
		this.len=paramLen;
		this.height=paramHeight;
    }
	
	public int getBuildingType() {
		return BuildingType;
	}
}
