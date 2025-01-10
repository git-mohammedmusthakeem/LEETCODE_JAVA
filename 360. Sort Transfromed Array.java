public class SortTransformedArray {
	public static void sort(int[] nums, int a, int b, int c){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int n : nums)
			queue.add(a * n * n + b * n + c);
		int index = -1;
		while(!queue.isEmpty()){
			nums[++index] = queue.poll();
		}
	}
	public static void main(String[] args) {
		int[] nums = new int[]{-1, 2, 3,-2, 5};
		sort(nums, 1, 2, 3);
		for(int n : nums)
			System.out.println(n);
	}
}