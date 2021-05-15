import java.util.Scanner;

public class Strings
{
    public static void main(String[] args)
    {
        String[] strList;
        int size;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("\nHow many Strings do you want to order? ");
        size = scan.nextInt();
        strList = new String[size];
        
        System.out.println("\n---Insert Strings---");
        scan.nextLine();
        for (int i = 0; i < size; i++)
        {
            strList[i] = scan.nextLine();
        }
        Sorting.insertionSort(strList);
        System.out.println("\n---SORTED STRINGS---:");
        for (int i = 0; i < size; i++)
        {
            System.out.print(strList[i] + " ");
        }
        System.out.println();
    }
}