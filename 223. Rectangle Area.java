class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (D - B) * (C - A) + (H - F)  * (G - E);
        if(E >= C || G <= A || H <= B || F >= D) return total;
        return total - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(F, B));
    }
}