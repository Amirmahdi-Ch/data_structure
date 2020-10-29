import java.util.Arrays;

public class Main{

    public static void main(String[] args) {
        int sparseMatrix[][]
                = {
                {6, 5, 3, 7, 4},
                {0, 8, 5, 7, 2},
                {0, 0, 9, 10, 1},
                {0, 0, 0, 6, 3},
                {0, 0, 0, 0, 3}

        };
        int [][] a = {
                {4,4,5},
                {0,1,10},
                {0,3,12},
                {2,2,5},
                {3,0,15},
                {3,1,12}
        };
        int b[][] = {
                {4,4,5},
                {0,2,8},
                {1,3,23},
                {2,2,9},
                {3,0,20},
                {3,1,25}
        };
        int c[][] = multiple(a,b);
        for(int i = 0;i<c.length;i++){
        System.out.println(Arrays.toString(c[i]));
        }
        int arr[] = higherTriangular(sparseMatrix);
       // System.out.println(getH(arr,2,3));


    }
    public static int[] higherTriangular(int [][] sparseMatrix){
        int size = sparseMatrix.length;
        int arr[] = new int[size * (size+1)/2];
        int k = 0;
        for(int j = 0 ;j <size;j++){
            for(int i = 0;i<j+1;i++){
                arr[k] = sparseMatrix[i][j];
                k++;
            }
        }
        return arr;
    }
    public static int getH(int[] arr,int i,int j){
        int a = j*(j+1)/2;
        a+= i;
        return arr[a];
    }
    public static int[] lowerTriangular(int [][] sparseMatrix){
        int size = sparseMatrix.length;
        int arr[] = new int[size * (size+1)/2];
        int k = 0;
        for(int i = 0 ;i <size;i++){
            for(int j = 0;j<i+1;i++){
                arr[k] = sparseMatrix[i][j];
                k++;
            }
        }
        return arr;
    }
    public static int getL(int[] arr,int i,int j){
        int a = i*(i+1)/2;
        a+= j;
        return arr[a];
    }

    public static int[][] transpose(int [][]arr){
        int size[] = new int[9];
        int start[] = new int[9];
        int[][] answer = new int[arr.length][3];
        answer[0][0] = arr[0][1];
        answer[0][1] = arr[0][0];
        answer[0][2] = arr[0][2];

        for(int i = 1;i<=arr[0][2];i++){
            size[arr[i][1]]++;
        }
        start[0] = 1;
        for(int i = 1;i<size.length;i++){
            start[i] = start[i-1]+ size[i-1];
        }
        for(int i = 1;i<=arr[0][2];i++){
            int k = start[arr[i][1]];
            answer[k][0] = arr[i][1];
            answer[k][1] = arr[i][01];
            answer[k][2] = arr[i][2];
            start[arr[i][1]]++;
        }
        return answer;
    }
    public static int[][] multiple(int[][] a,int[][] b){
        if(a[0][1] != b[0][0]){
            System.out.println("Can't multiply, "
                    + "Invalid dimensions");
            return null;
        }
        int answer[][] = new int[a[0][0]][b[0][1]];
        for(int i = 0;i<a[0][0];i++){
            for (int j = 0 ; j<b[0][1];j++){
            int result = 0;

                for(int m  = 1;m<=a[0][2];m++){
                    for(int n = 1 ; n<= b[0][2] ; n++){
                        if(a[m][0] == i && b[n][1] == j && a[m][1] == b[n][0]){
                           result += a[m][2] * b[n][2];
                        }
                    }
                }
            answer[i][j] = result;
            }
        }
        return answer;
    }

}