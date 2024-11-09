class Solution {
	    public int divide(int dividend, int divisor) {
	        int sign = 1;
	        if((dividend > 0 && divisor< 0) || (dividend < 0 && divisor > 0))   sign = -1;
	        Long ldividend = Math.abs((long)dividend);
	        Long ldivisor = Math.abs((long)divisor);
	        if(ldividend < ldivisor) return 0;
	        long result = divide(ldividend, ldivisor);
	        if(result > Integer.MAX_VALUE)  return (sign == 1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
	        return (int)((sign == 1)?result:-result);
	    }
	    
	    private long divide(long ldividend, long ldivisor){
	        if(ldividend < ldivisor) return 0;
	        long sum = ldivisor;
	        long result = 1;
	        while((sum + sum) < ldividend){
	            sum += sum;
	            result += result;
	        }
	        return result + divide(ldividend - sum , ldivisor);
	    }
	}