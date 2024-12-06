class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int p1 = 0, p2 = 0;
        while(p1 < arr1.length || p2 < arr2.length){
            if(p1 >= arr1.length && p2 < arr2.length){
                if(Integer.valueOf(arr2[p2]) != 0)
                    return -1;
                else{
                    p2++;continue;
                }
            }
            if(p2 >= arr2.length && p1 < arr1.length){
                if(Integer.valueOf(arr1[p1]) != 0)
                    return 1;
                else{ p1++; continue;}
            }
            if(p1 < arr1.length && p2 < arr2.length){
                if(Integer.valueOf(arr1[p1]) == Integer.valueOf(arr2[p2])){
                    p1++;
                    p2++;
                }else if(Integer.valueOf(arr1[p1]) > Integer.valueOf(arr2[p2]))
                    return 1;
                else if(Integer.valueOf(arr1[p1]) < Integer.valueOf(arr2[p2]))
                    return -1;
                }
        }
        return 0;
    }
}