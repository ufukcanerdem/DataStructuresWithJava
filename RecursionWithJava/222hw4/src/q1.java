/**
 * Driver and main of HW4-Q1
 *
 * @author UfukcanErdem
 * @version 1.0.0
 * @since  01.04.2022
 */


/**
     *	The class is solution of q1 in HW4.
     */
public class q1 {
	
	/**
     *   Finds first occurrence of short string in long string.
     * @param strLong
     * @param strShort
     * @param n
     * @return
     */
	public static int searchStr(String strLong, String strShort, int n) {
		if( strLong == null || strLong.equals("") || strShort == null || strShort.equals("") || (strShort.length() > strLong.length())) {
			return -1;
		}
		
		String temp = strLong.substring(n, ( n+strShort.length() ) );
		
		if( temp.equals(strShort) == true ) {
			return n;
		}
		else if ( n+strShort.length() < strLong.length() ) {
			return searchStr(strLong,strShort,n+1);
		}
		else {
			return -1;
		}
	}
	
	/**  
     * @param args
     */
	public static void main(String args[]){
		
		//Must find and return the value 7.
		String str1long = "bjbjstrbjkxds";
		String str2short = "bjk";
		
		System.out.println("1)First occurence index of query string is -> " + searchStr(str1long,str2short,0) );
		
		//Can Not find so must return -1
		str1long= "asjfkafnjansnjfnsjsfnnnfdjkdafd";
		str2short= "cantfind";
		
		System.out.println("2)First occurence index of query string is -> " + searchStr(str1long,str2short,0) );
		
		//Must return 0
		str1long= "asj";
		str2short= "asj";
				
		System.out.println("3)First occurence index of query string is -> " + searchStr(str1long,str2short,0) );
		
		//strShort is longer than strLong so must return -1
		str1long= "asj";
		str2short= "longerthanlong";
						
		System.out.println("4)First occurence index of query string is -> " + searchStr(str1long,str2short,0) );
	}
}
