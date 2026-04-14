public class ceshi {
    public static void main(String[] args) {
        int  t[][]={{21,2,13,24},{25,16,47,38},{29,11,32,54},{42,21,3,10}};
        System.out.println("The original data:");
        for(int i=0;i<t.length; i++){
            for(int j=0; j<t[i].length; j++)
                System.out.printf("%4d",t[i][j]);
            System.out.println();
        }
        System.out.println("The result is:"+fun(t));
    }
    public static int fun(int  t[][]){
        int  sum;
        sum=0;
        for(int i=0; i<t.length; i++)
            sum+=t[i][i];
        for(int i=0; i<t.length; i++)
            sum+= t[i][t.length-i-1];
        return sum;
    }
}
