import java.util.*;

public class SumOfSubsetDemo {
    public static void main(String[] args) {
        int w[], target;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        w = new int[n];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++)
            w[i] = sc.nextInt();
        System.out.print("Enter the target sum : ");
        target = sc.nextInt();
        sc.close();
        findSubset(w, target);
    }
    public static void findSubset(int w[],int target)
    {
        Arrays.sort(w);
        listSubsets(w, 0 , 0, target, new ArrayList<Integer>());
    }
    public static void listSubsets(int w[], int sum, int i, int target, List<Integer> list)
    {
        if(sum==target)
        {
            System.out.println(list);
            return;
        }
        if(sum>target || i==w.length)
            return;
        list.add(w[i]);
        listSubsets(w, sum+w[i], i+1, target, list);
        list.remove(list.size()-1);
        listSubsets(w, sum, i+1, target, list);
    }
}
