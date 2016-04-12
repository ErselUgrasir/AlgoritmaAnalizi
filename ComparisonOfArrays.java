package comparisonofarrays;

import java.util.ArrayList;
import java.util.Random;

public class ComparisonOfArrays {
    
    private static long startTime, endTime;
    private static int swap = 0;
    private static ArrayList<Integer> dizi;
    private static int elemanSayisi;

    public static void main(String[] args) {
        
        // @param lenght of array
        initArray(1000);
        
        startTime = System.nanoTime();
        
        /**
         * @param int for
         * BubbleSort = 1
         * InsertionSort = 2
         * SelectionSort = 3
         * QuickSort = 4
         */
        calculate(1);
    }
    
    private static void BubbleSort(ArrayList<Integer> dizi)
    {
        int temp;  
        for (int i=1; i<dizi.size(); i++)
        {
            for(int j=0; j<dizi.size()-i; j++)
            {
                if (dizi.get(j) > dizi.get(j+1))
                {
                    temp = dizi.get(j);
                    dizi.set(j, dizi.get(j+1));
                    dizi.set(j+1, temp);
                    swap++;
                }
            }
        }
        endTime = System.nanoTime();
    }
    
    public static void InsertionSort(ArrayList<Integer> dizi)
    {
        for (int j = 1; j < dizi.size(); j++) {
            int key = dizi.get(j);
            int i = j-1;
            while ( (i > -1) && ( dizi.get(i) > key ) ) {
                dizi.set(i+1,dizi.get(i));
                i--;
                swap++;
            }
            dizi.set(i+1, key);
        }
        endTime = System.nanoTime();
    }
    
    public static void SelectionSort(ArrayList<Integer> dizi){
         
        for (int i = 0; i < dizi.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < dizi.size(); j++){
                if (dizi.get(j) < dizi.get(index)){
                    index = j;
                    swap++;
                }
            }
            int smallerNumber = dizi.get(index); 
            dizi.set(index,dizi.get(i));
            dizi.set(i,smallerNumber);
        }
        endTime = System.nanoTime();
    }
    
    private static void QuickSort(ArrayList<Integer> dizi, int left, int right) {
        int index = partition(dizi, left, right);
        if (left < index - 1)
              QuickSort(dizi, left, index - 1);
        if (index < right)
              QuickSort(dizi, index, right);
        endTime = System.nanoTime();
    }
    
    //for QuickSort
    private static int partition(ArrayList<Integer> dizi, int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = dizi.get((left + right) / 2);

        while (i <= j) {
              while (dizi.get(i) < pivot)
                    i++;
              while (dizi.get(j) > pivot)
                    j--;
              if (i <= j) {
                    tmp = dizi.get(i);
                    dizi.set(i,j);
                    dizi.set(j,tmp);
                    i++;
                    j--;
                    swap++;
              }
        }
        
        return i;
    }

    private static void calculate(int sortValue) {
        switch(sortValue){
            case 1:
                BubbleSort(dizi);
                System.out.println("BubbleSort (" + elemanSayisi + " eleman için)");
                break;
            case 2:
                InsertionSort(dizi);
                System.out.println("InsertionSort (" + elemanSayisi + " eleman için)");
                break;
            case 3:
                SelectionSort(dizi);
                System.out.println("SelectionSort (" + elemanSayisi + " eleman için)");
                break;
            case 4:
                QuickSort(dizi, 0, dizi.size() - 1);
                System.out.println("QuickSort (" + elemanSayisi + " eleman için)");
                break;
        }
        
        System.out.println("Geçen Süre : " + (endTime - startTime)/1e6 + " milisaniye");
        System.out.println("Yer Değiştirme : " + swap);
    }

    private static void initArray(int size) {
        elemanSayisi = size;
        
        dizi = new ArrayList();
        
        Random rand = new Random();
               
        for(int j = 0 ; j < elemanSayisi; j++){
            dizi.add(rand.nextInt(elemanSayisi * 10) + 1);
        }    }
    
}
