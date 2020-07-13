public class CalculationArea {
	public static void main(String[] args) {
		int[] a=new int[] {2,1};
		System.out.println(maxArea(a));
	}
	
    public static int maxArea(int[] height) {
    	//基础解法
    	/*int max=-1;
    	for(int i=0;i<height.length-1;i++) {
    		for(int j=i+1;j<height.length;j++) {
    			int temp=height[i]<height[j]?height[i]:height[j];
    			if(temp*(j-i)>max){
    				max=temp*(j-i);
    			}
    		}
    	}
    	return max;*/
    	//双指针法
    	int l=0,s=height.length-1;
    	int max=-1;
    	while(l<s) {
    		int ans=Math.min(height[l], height[s])*(s-l);
    		max=Math.max(max,ans);
    		if(height[l]>height[s]) {
    			s--;
    		}else l++;
    	}
    	return max;
    }
}