/**
     *	The class that includes the functions of all the operations that the Office can do
     *<p>
     *  Extends	Building Class
     *<p>
     * Implements  OfficeOperations Interface and Override its methods 
     */
public class Office extends Building implements OfficeOperations{
	private String job_type=null;
	final private int BuildingType=1;
	
	public Office(int paramSide, int paramPosStart, int paramLen, int paramHeight){
		this.Side=paramSide;
		this.pos_start=paramPosStart;
		this.len=paramLen;
		this.height=paramHeight;
    }
	
	public void setJobType(String paramJobType) {
		this.job_type=paramJobType;
	}
	public String getJobType() {
		return job_type;
	}
	
	public int getBuildingType() {
		return BuildingType;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(" Office, Job Type:" + this.job_type + " Owner Name" + this.OwnerName);
		
	}
}
