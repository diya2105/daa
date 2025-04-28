import java.util.Scanner;

class FractionalKnapsackDemo
{
public static void main(String args[])
{
// Item[] item={new Item(10,60),new Item(20,100),new Item(30,120)};
Scanner s=new Scanner(System.in);
System.out.println("Enter the size: ");
int n=s.nextInt();
Item item[]= new Item[n];
System.out.println("Enter the weight and profit respectively: ");
for(int i=0;i<n;i++)
{
int w=s.nextInt();
int p=s.nextInt();
item[i]=new Item(w,p);
}
System.out.println("Enter the size of Knapsack: ");
int w=s.nextInt();
double tp=knapsack(item,w);
System.out.println("Total profit:"+tp);
s.close();
} 
public static double knapsack(Item item[] ,int w)
{
double t=0.0;
sortBy(item);
for(int i=0;i<item.length;i++)
{
Item x=item[i];
if(w==0)
{
return t;
}
else if(x.weight<=w)
{
t+=x.profit;
w-=x.weight;
}
else
{
t+=(x.profit/x.weight)*w;
w=0;
}
}
return t;
}
public static void sortBy(Item item[])
{
Item temp;
for(int i=0;i<item.length-1;i++)
{
for(int j=i+1;j<item.length;j++)
{
double r1=(item[i].profit)/(item[i].weight);
double r2=item[j].profit/item[j].weight;
if (r1<r2)
{
temp=item[i];
item[i]=item[j];
item[j]=temp;
}
}
}

}
}
class Item
{
int profit;
int weight;
Item(int w,int p)
{
profit=p;
weight=w;
}
}
