package searchcount2x2;

import java.util.Random;
import java.util.Scanner;

public class SearchCount2x2 {
    private final int N, M;
    private final int[][] matris;
    private final Random r;
    private final int[] sutunToplam;
    private final int[] sutunIndex;
    
    public SearchCount2x2(int N){
        this.N = N;
        M = 100;
        r = new Random();
        matris = new int[N][M];
        sutunToplam = new int[M];
        sutunIndex = new int[M];
        matrisDoldur();
        matrisYazdir();
        sutunToplamHesapla();        
        sutunToplamSirala();       
        sutunToplamYazdir();
    }
    
    private void matrisDoldur(){
        for(int i=0; i< N; i++){
            for(int j=0; j< M; j++){
                matris[i][j] = r.nextInt(2);
            }
        }
    }
    
    private void matrisYazdir(){
        System.out.println("#Oluşturulan matris:");
        for(int i=0; i< N; i++){
            for(int j=0; j< M; j++){
                System.out.print(matris[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    private void sutunToplamHesapla(){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sutunToplam[i] += matris[j][i];
                sutunIndex[i] = i;
            }
        }
    }
    
    private void sutunToplamYazdir(){
        System.out.print("#Sütun indisleri  : ");
        for (int i = 0; i < M; i++) {
            System.out.print(sutunIndex[i]+" ");
        }
        System.out.println("");
        
        System.out.print("#Sütun toplamları : ");
        for (int i = 0; i < M; i++) {
            System.out.print(sutunToplam[i]+" ");
        }
        System.out.println("");
        
    }
    
    private void sutunToplamSirala(){
        quicksort(sutunToplam, 0, sutunToplam.length-1);
    }
    
    private void quicksort(int[] A, int left, int right) {
        if (left < right) {
            int pivot = partition(A, left, right);
            quicksort(A, left, pivot);
            quicksort(A, pivot + 1, right);
        }
    }

    private int partition(int[] A, int left, int right) {
        int x = A[left];
        int i = left;
        int j = right;
        while(true) {
            while (A[i] > x) {
                i++;
            }
            while (A[j] < x) {
                j--;
            }
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                int temp2 = sutunIndex[i];
                sutunIndex[i] = sutunIndex[j];
                sutunIndex[j] = temp2;
                i++;
                j--;
            } else {
                return j;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("#Lütfen satır sayısını giriniz: ");
        new SearchCount2x2(input.nextInt());
    }    
}
