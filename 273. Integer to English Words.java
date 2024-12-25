class Solution {
		private static final String[] units = new String[]{"", "Thousand", "Million", "Billion"};
		private static final String[] ones = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		private static String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		private static String[] overTens = new String[]{"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		public String numberToWords(int num) {
			if(num == 0) return "Zero";
			int bigUnit = 0;
			String result = "";
			while(num != 0){
				String cur = parseThree(num % 1000);
				if(cur.length() != 0){
					result = cur
						+ (bigUnit == 0 ? "": " ")
						+ units[bigUnit]
						+ (result.length() == 0 ? "": " ")
						+ result;
				}
				bigUnit++;
				num /= 1000;
			}
			return result;
		}
		private String parseThree(int num){
			String result = "";
			if(num % 100 > 10 && num % 100 < 20){
				result = overTens[num % 100 - 10];
				num /= 100;
			}else{
				if(num % 10 != 0){
					result = ones[num % 10];
				}
				num /= 10;
				if(num % 10 != 0){
					result = tens[num % 10] + (result.length() == 0 ? "" : " ") + result;
				}
				num /= 10;
			}
			if(num % 10 != 0){
				result = ones[num % 10] + " Hundred" + (result.length() == 0 ? "": " ") + result; 
			}
			return result;
		}
	}