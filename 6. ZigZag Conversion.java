## 6. ZigZag Conversion

### Question:
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
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