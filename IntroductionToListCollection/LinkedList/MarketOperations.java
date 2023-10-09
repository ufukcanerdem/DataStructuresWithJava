////////////////////////////////Market Operations Interface////////////////////////////////////
	/**
     *  It is inside  Market Operation Functions.
     */
    public interface MarketOperations{
        /**
         *   Sets string according to given string.
         * @param paramOpenTime
         */
    	public void setOpenTime(String paramOpenTime);
    /*-----------------------------------------------------------------------------------------*/
        /**
         * 	Returns a string
         * @return
         */
    	public String getOpenTime();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Sets string according to given string.
         * @param paramCloseTime
         */
    	public void setCloseTime(String paramCloseTime);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns a string.
         * @return
         */
    	public String getCloseTime();
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