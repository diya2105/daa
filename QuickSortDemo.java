// import javax.swing.JOptionPane;
import java.util.Scanner;
public class QuickSortDemo {
    public static void showArray(int[] a)
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
    public static void QuickSort(int[] a,int lb,int ub)
    {
        int left=lb; 
        int right=ub;
        int pivot =lb;
        while(left!=right)
        {
        while(a[right]>a[pivot] && left!=right)
            right--;
        if(left!=right)
        {
            int temp;
            temp=a[right];
            a[right]=a[pivot];
            a[pivot]=temp;
            pivot=right;
        }
        while(a[pivot]>a[left] && left!=right)
            left++;
        if(left!=right)
        {
            int temp;
            temp=a[left];
            a[left]=a[pivot];
            a[pivot]=temp;
            pivot=left;
        }
        }
        if(lb<pivot)
            QuickSort(a,lb,pivot-1);
        if(pivot<ub)
            QuickSort(a,pivot+1,ub);
    }
    
    public static void main(String [] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the size");
        int n=s.nextInt();
        int arr[] =new int[n];
        System.out.println("Enter the Array elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        System.out.println("Before sorting: ");
        showArray(arr);
        QuickSort(arr,0,n-1);
        System.out.println("\nSorted Array: ");
        showArray(arr);
        s.close();
    }
}
