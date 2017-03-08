
public class zigzagSubsequence {

	
	public static void main(String[] args){
		
		int[] a=new int[]{
				10, 22, 9, 33, 49, 50, 31, 60
		};
		System.out.println(zigzag(a));
	}
	public static int zigzag(int[] arr){
		int n=arr.length;
		int[][] sol=new int[n][2];
		//initialize all the values from 1
		for(int i=0;i<n;i++){
			sol[i][0]=sol[i][1]=1;			
		}
		int res=1;
		//compute the values in the bottom up manner
		for(int i=1;i<n;i++){
			//consider all the values previous of i
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && sol[i][0]<sol[j][1]+1){
					sol[i][0]=sol[j][1]+1;
				}
				if(arr[j]>arr[i] && sol[i][1]<sol[j][0]+1){
					sol[i][1]=sol[j][0]+1;
				}
			}
			//PICK THE MAX VALUE AT THE INDEX I
			res=Math.max(sol[i][0], sol[i][1]);
		}
		return res;
	}
}
