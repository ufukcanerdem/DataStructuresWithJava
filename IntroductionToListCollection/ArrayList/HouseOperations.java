////////////////////////////////House Operations Interface////////////////////////////////////
	/**
     *  It is inside  House Operation Functions.
     */
    public interface HouseOperations{
        /**
         *   Sets integer according to given integer.
         * @param paramRoom
         */
    	public void setRoom(int paramRoom);
    /*-----------------------------------------------------------------------------------------*/
        /**
         * 	Returns a integer.
         * @return
         */
    	public int getRoom();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Sets string according to given string.
         * @param paramColor
         */
    	public void setColor(String paramColor);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns a string.
         * @return
         */
    	public String getColor();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns a integer.
         *   if building type is '0' it means it is a house,
         *   if building type is '1' it means it is an office,
         *   if building type is '2' it means it is a market,
         *   if building type is '3' it means it is a playground.
         * @return
         */
    	public int getBuildingType();
    }