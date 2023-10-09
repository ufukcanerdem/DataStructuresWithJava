import java.util.Arrays;
/**
 *	The class that includes the functions of all the operations that the Street can do
 * Implements  StreetOperations Interface and Override its methods
 * ALL THE FUNCTIONS AND THEIR RESULTS ARE EXPLAINED AND COMMENTED IN "StreetOperations" INTERFACE. 
 */

public class Street implements StreetOperations {
	private int street_len;
	protected int Side;		//0 means left, 1 means right side of the street
	protected int pos_start;
	protected int len;
	protected int height;
	private int[][] filledPos=new int[2][999]; //Keeps the positions is filled. Max valid street length is 999.
	private int[][] filledHeight=new int[2][999]; //Keeps the heights is filled. 
	public Building[][] buildings = new Building[3][100]; //Default size,[0][x] is house,[1][x] is office, [2][x] is market. Maximum Building count is 300.It can keep any type of buildings.(Polymorphism)
	public Playground[] playgrounds = new Playground[100];
	protected int BuildingCount=0;
	protected int HouseCount=0;
	protected int OfficeCount=0;
	protected int MarketCount=0;
	protected int PlaygroundCount=0;
	private int TotalLen=0;
	
	
	
	/*
	 * Default constructor, It automatically fills arrays with the value -1 for further processing.
	 */
	public Street() {
		for (int[] x: filledPos) {
		    Arrays.fill(x, -1);
		}
		for (int[] y: filledHeight) {
		    Arrays.fill(y, -1);
		}
	}
	
	public void setStreetLen(int param) {
		this.street_len=param;
	}
	
	public int getStreetLen(){
        return street_len;
    }
	
	public int getPosStart() {
		return pos_start;
	}
	
	public int getPosEnd() {
		return pos_start+len;
	}
	
	public int getLen() {
		return len;
	}
	
	public int getSide() {
		return Side;
	}
	
	public boolean isInputsCorrect(int paramSide, int paramPosStart, int paramLen) {
		boolean retval=false;
		
		if( (paramSide == 0 || paramSide == 1) && (paramPosStart >= 0 && (paramPosStart+paramLen) < street_len) ) {
			retval=true;
		}
		return retval;
	}
	
	public boolean checkPosIsFilled(int paramSide, int paramPosStart, int paramPosEnd) {
		boolean retval=false;
		int i;
		
		if( paramPosStart < 0 || paramPosEnd>street_len) {
			retval=true;
		}	
		else {
			for(i=paramPosStart;i<paramPosEnd;i++) {
				if(filledPos[paramSide][i] != -1 ) {
					retval=true;
					break;
				}
			}		
		}
		return retval;
	}
	
	public void addBuilding(int paramBuildingtype, int paramSide, int paramPosStart, int paramLen, int paramHeight) {
		if( isInputsCorrect(paramSide,paramPosStart,paramLen) == true && checkPosIsFilled(paramSide, paramPosStart,(paramPosStart+paramLen)) == false ) {
			/*
			 * According to building type its creates house, office or market and adds them into 'buildings' array. 
			 */
			if(paramBuildingtype == 0 ) {
				System.out.println("House Added.");
				buildings[0][HouseCount]=new House(paramSide, paramPosStart, paramLen, paramHeight); //Polymorphism
				HouseCount++;
			}
			else if(paramBuildingtype == 1) {
				System.out.println("Office Added.");
				buildings[1][OfficeCount]=new Office(paramSide, paramPosStart, paramLen, paramHeight); //Polymorphism
				OfficeCount++;
			}
			else if(paramBuildingtype == 2) {
				System.out.println("Market Added.");
				buildings[2][MarketCount]=new Market(paramSide, paramPosStart, paramLen, paramHeight); //Polymorphism
				MarketCount++;
			}
			else if(paramBuildingtype == 3) {
				System.out.println("Playground Added.");
				playgrounds[PlaygroundCount]=new Playground(paramSide, paramPosStart, paramLen, paramHeight);
				PlaygroundCount++;
			}
			else {
				System.out.println("Unknown Building TYPE! ERROR!!!");
			}
				
			/*
			 * 	The filled positions and heights are saving after add.
			 */
			for(int i=paramPosStart;i<=paramPosStart+paramLen;i++) {
				filledPos[paramSide][i]=paramLen;
				filledHeight[paramSide][i]=paramHeight;
			}
			BuildingCount++;
			TotalLen+=paramLen;  //Keeps total length
		}
		else {
				System.out.println("Position(s) is already filled or Wrong Input(s)! ERROR!!!");
		}
	}
	
	public void DeleteBuilding(int paramBuildingType, int paramListNumber) {
		int index=paramListNumber-1;
		if(paramBuildingType==0 || paramBuildingType==1 || paramBuildingType==2) {
			buildings[paramBuildingType][index]=null; //The index to be deleted is set to null.
		
			/*
			 * With the for loop, all indexes after the value in the parameter are moved to the previous index.
			 */
			for(int i=index;i<buildings[paramBuildingType].length-1;i++) {
				buildings[paramBuildingType][i]=buildings[paramBuildingType][i+1];
			}
		
			buildings[paramBuildingType][buildings[paramBuildingType].length-1]=null; //Last Element is set to null after deleting.
		
			switch(paramBuildingType) {
				case 0: HouseCount--;
					System.out.println("House is deleted.");
					break;
				case 1: OfficeCount--;
					System.out.println("Office is deleted.");
					break;
				case 2: MarketCount--;
					System.out.println("Market is deleted.");
					break;
			}
		}
		else if(paramBuildingType==3) {
			playgrounds[index]=null;
			for(int i=index;i<playgrounds.length-1;i++) {
				playgrounds[i]=playgrounds[i+1];
			}
			playgrounds[PlaygroundCount]=null;
			PlaygroundCount--;
		}
		else {
			System.out.println("Undefinied Structure TYPE!");
		}
	}
	
	public void ListBuildings() {
		  int i=0;
		  int j=0;
		  System.out.println();
		  while( i<=2 ) {
			  while( buildings[i][j] != null ) {
				if(i==0) {
					if(j==0) { System.out.println("----HOUSES----"); }
					System.out.println((j+1) + ")House color: " + ((House)buildings[i][j]).getColor());
				}
				if(i==1) {
					if(j==0) { System.out.println("----OFFICES----"); }
					System.out.println((j+1) + ")Office job type: " + ((Office)buildings[i][j]).getJobType());
				}
				if(i==2) {
					if(j==0) { System.out.println("----MARKETS----"); }
					System.out.println((j+1) + ")Market open/close time: " + ((Market)buildings[i][j]).getOpenTime() +" " + ((Market)buildings[i][j]).getCloseTime()) ;
				}
			  	j++;
			  }
			  i++;
			  j=0;
		  }
		  i=0;
		  while(playgrounds[i] != null) {
			  if(i==0) { System.out.println("----PLAYGROUNDS----"); }
				System.out.println((i+1) + ")Playground length: " + playgrounds[i].getLen());
				i++;
				
		  }
		  System.out.println();
	  }
	
	public void focus(int paramSide, int paramPositionIndex ) {
		int i=0;
		int j=0;
		while( i<3 && j<999 && buildings[i][j] != null) {
			if(paramPositionIndex <= buildings[i][j].getPosEnd() && paramPositionIndex >= buildings[i][j].getPosStart() && paramSide == buildings[i][j].getSide()) {
				System.out.print("Focused structure -> ");
				 buildings[i][j].printInfo();
				break;
			}
			j++;
			if(buildings[i][j] == null) {
				i++;
				j=0;
			}
		}
		
		i=0;

		while(i<PlaygroundCount ) {
			if( paramPositionIndex <= playgrounds[i].getPosEnd() && paramPositionIndex >= playgrounds[i].getPosStart() && paramSide == playgrounds[i].getSide()) {
				System.out.println("Focused structure is Playground. Start position is -> " + playgrounds[i].pos_start);
				break;
			}
			i++;
		}
	}
	
	private double calculateRatioOfPlaygrounds() {
		int i=0;
		int tempTotalLen=0;
		double retval;
		while(playgrounds[i]!=null) {
			tempTotalLen+=playgrounds[i].len;
			i++;
		}
		retval=((double)tempTotalLen/street_len);

		return retval;
	}
	
	private int calculateTotalLengthOfBuildings() {
		int i=0;
		int j=0;
		int tempTotalLen=0;
		while(i<3) {
			while(buildings[i][j] != null) {
				tempTotalLen+=buildings[i][j].len;
				j++;
			}
			i++;
			j=0;
		}
		return tempTotalLen;
	}
	
	public void viewAnswers(int paramQuesNum) {
		
		if(paramQuesNum==1) {
			System.out.println("The total remaining length of lands on the street is ->" + (street_len-TotalLen) );
		}
		else if(paramQuesNum==2) {
			ListBuildings();
			
		}
		else if(paramQuesNum==3) {
			System.out.println("Total Number of Playgrounds is -> " + PlaygroundCount);
			System.out.println("Ratio of length of Playgrounds in the street is -> " + calculateRatioOfPlaygrounds());
		}
		
		else if(paramQuesNum==4) {
			System.out.println("Total length of street occupied by the markets, houses or offices is -> " + calculateTotalLengthOfBuildings());
		}
		
		else if(paramQuesNum==5) {
			drawSkylineSly();
		}
		
		else {
			System.out.println("Undefinied!!");
		}
	}
	
	
	public void drawSkylineSly() {
		int i=0;
		int j=0;
		int posCount=0;
		int currentHeight=0;
		
		for(int k=0;k<10;k++){
		  	System.out.println();
		  }
		
		while( i < street_len && j < street_len ) {
			//System.out.print("_");
			if(filledPos[0][i] != -1 || filledPos[1][i] != -1 ) {
				if(filledHeight[0][i] > 0 && filledHeight[0][i] >= filledHeight[1][i]) {
					for(int x=0;x<posCount;x++) {
						System.out.print(" ");
					}
					for(int k=0;k<filledHeight[0][i]-currentHeight;k++) {	
						System.out.print("|\b");
						System.out.print("\u008D");
		  			}
					currentHeight=filledHeight[0][i];
				}
				
				else if(filledHeight[1][i] > 0 && filledHeight[1][i] > filledHeight[0][i]) {
				
					for(int k=0;k<filledHeight[1][i]-currentHeight;k++) {
						System.out.print("|\b");
						System.out.print("\u008D");
		  			}
					currentHeight=filledHeight[0][i];
				}
			}
			else{
				for(int x=0;x<posCount;x++) {
					System.out.print(" ");
				}
				if(currentHeight>0) {
					while(currentHeight>0) {
						System.out.println("|");
						currentHeight--;
						for(int x=0;x<posCount;x++) {
							System.out.print(" ");
						}
					}	
				}
				else if(currentHeight==0) {
					System.out.print("_");
				}
			}
		posCount++;
		i++;
		j++;
		}
		
		for(int k=0;k<10;k++){
		  	System.out.println();
		  }
		
		
		
		
		/*
		int i=0;
		int j=0;
		int maxHeight=0;
		while(i<3) {
			while(buildings[i][j] != null) {
				if(buildings[i][j].height>maxHeight) {
					maxHeight=buildings[i][j].height;
				}
				j++;
			}
			i++;
			j=0;
		}
		*/
	}
}
