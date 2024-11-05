class Solution {
	    public String convert(String s, int numRows) {
	        int len = 2 * numRows - 2;
	        StringBuilder[numRows] sbs = new StringBuilder[numRows];
	        for(int i = 0; i < numRows; i++){
	            sbs[i] = new StringBuilder();
	        }
	        int slen = s.length();
	        for(int i = 0; i < slen; i++){
	            int index = i % len;
	            if(index < len){
	                sbs[index].append(s.charAt(i).toString);
	            }else{
	                sbs[numRows - 1 - (index - numRows)].append(s.charAt(i).toString);
	            }
	        }
	        for(int i = 1; i < numRows; i++){
	            sbs[0].append(sbs[i].toString);
	        }
	        return sbs[0].toString;
	    }
	}