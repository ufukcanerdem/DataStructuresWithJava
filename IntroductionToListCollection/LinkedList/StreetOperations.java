////////////////////////////////Street Operations Interface////////////////////////////////////
	/**
     *  It is inside Street Operation Functions.
     */
    public interface StreetOperations{
        /**
         *   Sets integer according to given integer.
         * @param param
         */
    	public void setStreetLen(int param);
    /*-----------------------------------------------------------------------------------------*/
        /**
         * 	Returns an integer.
         * @return
         */
    	public int getStreetLen();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns an integer.
         * @return
         */
    	public int getPosStart();
   	/*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns an integer.
         * @return
         */
    	public int getPosEnd();
   	/*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns an integer.
         * @return
         */
    	public int getLen();
   	/*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns an integer.
         * @return
         */
    	public int getSide();
   	/*-----------------------------------------------------------------------------------------*/
        /**
         *   Checks whether the place to be filled is occupied and returns a boolean value.
         * @param paramSide
         * @param paramPosStart
         * @param paramPosEnd
         * @return
         */
    	public boolean checkPosIsFilled(int paramSide, int paramPosStart, int paramPosEnd);
   	/*-----------------------------------------------------------------------------------------*/
        /**
        *   Adds a building according to given parameters.(BuildingType=0 is House, BuildingType=1 is Office,
        *   BuildingType=2 is Market and BuildingType=3 is Playground).
        *   Side=0 is left and Side=1 is right.
         * @param paramBuildingtype
         * @param paramSide
         * @param paramPosStart
         * @param paramLen
         * @param paramHeight
         */
    	public void addBuilding(int paramBuildingtype, int paramSide, int paramPosStart, int paramLen, int paramHeight);
   	/*-----------------------------------------------------------------------------------------*/
        /**
         *   Deletes building according to given parameters which is related with List of Buildings.
         *   (BuildingType=0 is House, BuildingType=1 is Office, BuildingType=2 is Market and BuildingType=3 is Playground).
         * @param paramBuildingType
         * @param paramListNumber
         */
    	public void DeleteBuilding(int paramBuildingType, int paramListNumber);
   	/*-----------------------------------------------------------------------------------------*/
        /**
         *   Lists all structures in the street.
         */
    	public void ListBuildings();
   	/*-----------------------------------------------------------------------------------------*/
        /**
         *   It focuses on a specific building on the street with side and position parameters and 
         *   prints a specific feature about it.
         * @param paramSide
         * @param paramPositionIndex
         */
    	public void focus(int paramSide, int paramPositionIndex );
    /*-----------------------------------------------------------------------------------------*/
        /**
         * Draws skyline slyhouitte.
         */
    	public void drawSkylineSly();
    }