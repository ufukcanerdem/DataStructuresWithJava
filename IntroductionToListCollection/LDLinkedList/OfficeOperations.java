////////////////////////////////Office Operations Interface////////////////////////////////////
	/**
     *  It is inside Office Operation Functions.
     */
    public interface OfficeOperations{
        /**
         *   Sets string according to given string.
         * @param paramJobType
         */
    	public void setJobType(String paramJobType);
    /*-----------------------------------------------------------------------------------------*/
        /**
         * 	Returns a string.
         * @return
         */
    	public String getJobType();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Returns a integer.
         * @return
         */
    	public int getBuildingType();
    }