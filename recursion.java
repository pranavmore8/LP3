import java.util.*;

public class Main {
    public int fibonacciRecursive(int n){
       if(n<=0){
        return -1;
       }
       else if(n==1){
        return 0;
       }
       else if(n==2){
        return 1;
       }
       else{
        return fibonacciRecursive(n-1)+ fibonacciRecursive(n-2);
       }
    }
    public int nonfibonacciRecursive(int n){
      if(n<=0){
        return -1;
      }
      else if(n==1){
        return 0;
      }
      else if(n==2){
        return 1;
      }
      else{
        int a=0,b=1;
        for(int i=2;i<n;i++){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
      }
    }
    public static void main(String[] args) {
      Main m=new Main();
      System.out.println(m.fibonacciRecursive(5));
      System.out.println(m.nonfibonacciRecursive(5));
    }
}