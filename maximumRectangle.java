import java.util.*;
public class maximumRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        maximumRectangle obj = new maximumRectangle();
        int result = obj.maximalRectangle(matrix);
        System.out.println(result); // Output the area of the largest rectangle
    }       
    public int calculateMaxArea(int heights[]){
        int nsl[]=new int[heights.length];
        int nsr[]=new int[heights.length];
         Stack<Integer>s=new Stack<>();
         for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i])s.pop();
            if(s.isEmpty())nsr[i]=heights.length;
            else nsr[i]=s.peek();
            s.push(i);
         }
         s=new Stack<>();
         for(int i=0;i<heights.length;i++){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i])   s.pop();
            if(s.isEmpty()) nsl[i]=-1;
            else nsl[i]=s.peek();
            s.push(i);
         }
           int max=0;
         for(int i=0;i<heights.length;i++){
            int width=nsr[i]-nsl[i]-1;
            int currarea=heights[i]*width;
            max=Math.max(currarea,max);
         }
         return max;
    }     
           
            
            
        
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int heights[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    if(i==0)heights[i][j]=1;
                    else
                    heights[i][j]=1+heights[i-1][j];
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int row[]:heights){
            int area=calculateMaxArea(row);
            max=Math.max(max,area);
        }
        return max;
    }
}
