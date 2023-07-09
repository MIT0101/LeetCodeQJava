public class SearchA2DMatrixII_Med {

    public static void main(String[] args) {
        int [][] matrix = {{1,2,6,7,8,15},
                            {2,5,8,12,19},
                            {3,6,9,16,22},
                            {10,13,14,17,24},
                            {18,21,23,26,30}};

        int target=9;

        System.out.println(findMaxColIndex(matrix[0],0,matrix[0].length-1,target));

    }
    public boolean searchMatrix(int[][] matrix, int target) {
    return false;

    }

    public static int findMaxColIndex(int[] row,int startIndex,int endIndex,int target){

        if(startIndex>=endIndex&&row[startIndex]>target){
            return -1;
        }
        if(row[endIndex]<=target){
            return endIndex;
        }
        if(row[startIndex]==target){
            return startIndex;
        }

        int middle=(endIndex+1)/2;

        if(row[middle]==target){
           return middle;
        }
        if(row[middle]>target){
            return findMaxColIndex(row,startIndex,middle-1,target);
        }

        if(row[middle]<target){
            return middle;
        }
        return -1;
    }

}
