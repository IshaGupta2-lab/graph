import java.util.*;

public class twobuttons {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int steps=0;

        while(m>n){
            if(m%2==0){
                m=m/2;
                steps++;
            }
            else{
                m=m+1;
                steps++;
            }
        }
        steps+=(n-m);
        System.out.println(steps);
    }
}