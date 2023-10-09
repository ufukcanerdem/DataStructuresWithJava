import java.util.*;
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
	private List<LDLinkedList<Integer> > filledPos = new LDLinkedList<LDLinkedList<Integer> >();  //Keeps the positions is filled.
	private List<LDLinkedList<Integer> > filledHeight = new LDLinkedList<LDLinkedList<Integer> >(); //Keeps the heights is filled. 
	public List<LDLinkedList<Building> > buildings = new LDLinkedList<LDLinkedList<Building> >(); //Keeps the Buildings,[0][x] is house,[1][x] is office, [2][x] is market.It can keep any type of buildings.(Polymorphism)
	public LDLinkedList<Playground> playgrounds = new LDLinkedList<Playground>();
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
		LDLinkedList<Integer> elem1 = new LDLinkedList<Integer>();
		LDLinkedList<Integer> elem2 = new LDLinkedList<Integer>();
		for(int x=0; x < 999; x++) {
			elem1.add(-1);
			elem2.add(-1);
		}
		filledPos.add(elem1);
		filledPos.add(elem2);
		
		LDLinkedList<Integer> elem11 = new LDLinkedList<Integer>();
		LDLinkedList<Integer> elem22 = new LDLinkedList<Integer>();
		for(int y=0; y < 999; y++) {
			elem11.add(-1);
			elem22.add(-1);
		}
		filledHeight.add(elem11);
		filledHeight.add(elem22);
		
		LDLinkedList<Building> elem31 = new LDLinkedList<Building>();
		LDLinkedList<Building> elem32 = new LDLinkedList<Building>();
		LDLinkedList<Building> elem33 = new LDLinkedList<Building>();
		
		for(int i=0;i<100;i++) {
			elem31.add(null);
			elem32.add(null);
			elem33.add(null);
			playgrounds.add(null);
		}
		buildings.add(elem31);
		buildings.add(elem32);
		buildings.add(elem33);
		
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
				if(filledPos.get(paramSide).get(i) != -1 ) { //filledPos[paramSide][i] != -1
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
				Building b = new House(paramSide, paramPosStart, paramLen, paramHeight); //Polymorphism
				buildings.get(0).add(HouseCount, b);	//buildings[0][HouseCount]=new House(paramSide, paramPosStart, paramLen, paramHeight); //Polymorphism
				HouseCount++;
			}
			else if(paramBuildingtype == 1) {
				System.out.println("Office Added.");
				Building b = new Office(paramSide, paramPosStart, paramLen, paramHeight); //Polymorphism
				buildings.get(1).add(OfficeCount, b);
				OfficeCount++;
			}
			else if(paramBuildingtype == 2) {
				System.out.println("Market Added.");
				Building b = new Market(paramSide, paramPosStart, paramLen, paramHeight); //Polymorphism
				buildings.get(2).add(MarketCount, b);
				MarketCount++;
			}
			else if(paramBuildingtype == 3) {
				System.out.println("Playground Added.");
				Playground p = new Playground(paramSide, paramPosStart, paramLen, paramHeight);
				playgrounds.add(PlaygroundCount, p);
				PlaygroundCount++;
			}
			else {
				System.out.println("Unknown Building TYPE! ERROR!!!");
			}
				
			/*
			 * 	The filled positions and heights are saving after add.
			 */
			for(int i=paramPosStart;i<=paramPosStart+paramLen;i++) {
				filledPos.get(paramSide).set(i, paramLen);	//filledPos[paramSide][i]=paramLen;
				filledHeight.get(paramSide).set(i, paramHeight);	//filledHeight[paramSide][i]=paramHeight;
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
			
			if(buildings.get(paramBuildingType).get(index) == null) {
				System.out.println("There is no such structure in the list.");
			}
			
			else {
				buildings.get(paramBuildingType).removeIndex(index);
			
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
		}
		else if(paramBuildingType==3) {
			
			if(playgrounds.get(index) == null ) {
				System.out.println("There is no such structure in the list.");
			}
			
			else {
				playgrounds.removeIndex(index);
				PlaygroundCount--;
			}
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
			  while( buildings.get(i).get(j) != null ) {
				if(i==0) {
					if(j==0) { System.out.println("----HOUSES----"); }
					System.out.println((j+1) + ")House color: " + ((House)buildings.get(i).get(j)).getColor());
				}
				if(i==1) {
					if(j==0) { System.out.println("----OFFICES----"); }
					System.out.println((j+1) + ")Office job type: " + ((Office)buildings.get(i).get(j)).getJobType());
				}
				if(i==2) {
					if(j==0) { System.out.println("----MARKETS----"); }
					System.out.println((j+1) + ")Market open/close time: " + ((Market)buildings.get(i).get(j)).getOpenTime() +" " + ((Market)buildings.get(i).get(j)).getCloseTime()) ;
				}
			  	j++;
			  }
			  i++;
			  j=0;
		  }
		  i=0;
		  while(playgrounds.get(i) != null) {
			  if(i==0) { System.out.println("----PLAYGROUNDS----"); }
				System.out.println((i+1) + ")Playground length: " + playgrounds.get(i).getLen());
				i++;
				
		  }
		  System.out.println();
	  }
	
	public void focus(int paramSide, int paramPositionIndex ) {
		int i=0;
		int j=0;
		while( i<3 && j<999 && buildings.get(i).get(j) != null) {
			if(paramPositionIndex <= buildings.get(i).get(j).getPosEnd() && paramPositionIndex >= buildings.get(i).get(j).getPosStart() && paramSide == buildings.get(i).get(j).getSide()) {
				System.out.print("Focused structure -> ");
				buildings.get(i).get(j).printInfo();
				break;
			}
			j++;
			if(buildings.get(i).get(j) == null) {
				i++;
				j=0;
			}
		}
		
		i=0;

		while(i<PlaygroundCount ) {
			if( paramPositionIndex <= playgrounds.get(i).getPosEnd() && paramPositionIndex >= playgrounds.get(i).getPosStart() && paramSide == playgrounds.get(i).getSide()) {
				System.out.println("Focused structure is Playground. Start position is -> " + playgrounds.get(i).pos_start);
				break;
			}
			i++;
		}
	}
	
	private double calculateRatioOfPlaygrounds() {
		int i=0;
		int tempTotalLen=0;
		double retval;
		while(playgrounds.get(i) != null) {
			tempTotalLen+=playgrounds.get(i).len;
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
			while(buildings.get(i).get(j) != null) {
				tempTotalLen+=buildings.get(i).get(j).len;
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
			if(filledPos.get(0).get(i) != -1 || filledPos.get(1).get(i) != -1 ) {
				if(filledHeight.get(0).get(i) > 0 && filledHeight.get(0).get(i) >= filledHeight.get(1).get(i)) {
					for(int x=0;x<posCount;x++) {
						System.out.print(" ");
					}
					for(int k=0;k<filledHeight.get(0).get(i)-currentHeight;k++) {	
						System.out.print("|\b");
						System.out.print("\u008D");
		  			}
					currentHeight=filledHeight.get(0).get(i);
				}
				
				else if(filledHeight.get(1).get(i) > 0 && filledHeight.get(1).get(i) > filledHeight.get(0).get(i)) {
				
					for(int k=0;k<filledHeight.get(1).get(i)-currentHeight;k++) {
						System.out.print("|\b");
						System.out.print("\u008D");
		  			}
					currentHeight=filledHeight.get(0).get(i);
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
