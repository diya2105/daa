import java.util.Scanner;
import java.util.Arrays;
public class MinMax{
    static class Result
   {
    int min;
    int max;
    public  Result(int min,int max)
    {
        this.min=min;
        this.max=max;
    }
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=s.nextInt();
        System.out.println("Enter the array elements:");
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        System.out.println("Array : "+Arrays.toString(a));
        Result r=findminmax(a,0,n-1);
        System.out.println("Min:"+r.min+"  Max:"+r.max);
        s.close();
    }
    static Result findminmax(int[] a,int s,int e)
    {
        if(s==e)
        {
            return new Result(a[s],a[e]);
        }
        else if(e-s==1)
        {
            if(a[s]<a[e])
            {
                return new Result(a[s],a[e]);
            }
            else{
                return new Result(a[e],a[s]);
            }
        }
        else
        {
            int mid=(s+e)/2;
            Result lr=findminmax(a, s, mid);
            Result rr=findminmax(a, mid+1, e);
            int min=Math.min(lr.min,rr.min);
            int max=Math.max(rr.max,lr.max);
            return new Result(min,max);
        }
    }
}
