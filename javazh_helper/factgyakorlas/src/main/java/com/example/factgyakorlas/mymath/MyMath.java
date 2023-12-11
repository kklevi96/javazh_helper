package com.example.factgyakorlas.mymath;

public class MyMath {
    private static int maxLimit=15;

    private int visits;
    private static MyMath instance;

    public static MyMath getInstance(){
        if(instance==null)
            instance=new MyMath();
        return instance;
    }

    public MyMath(){

    }

    public static long factIterative(int n){
        long output=1;
        if(n==0||n==1)
            return 1;
        if(n<0||n>maxLimit)
            return -1;
        else
            for (int i = 1; i <= n; i++) {
                output=output*i;
            }
        return output;
    }

    public static long factRecursive(int n){
        if(n==0||n==1)
            return 1;
        if(n<0||n>maxLimit)
            return -1;
        else
            return n*factRecursive(n-1);
    }

    public static long bin(int n, int k){
        return factRecursive(n)/(factRecursive(k)*factRecursive(n-k));
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

}
