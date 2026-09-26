
import java.util.Scanner;
class QuickSortGenerics<T extends Comparable<T>> {

      void quickSort(T[] a, int si, int ei) 
      {
          if (si < ei) 
          {
              int pi = partition(a, si, ei);
              quickSort(a, si, pi - 1);
              quickSort(a, pi+1, ei);
          }
      }

      int partition(T[] a, int si, int ei) 
      {
          T pivot = a[si];
          int i = si;
          int j = ei + 1;

          do 
          {
              do 
              {
                  i++;
              } while (i <= ei && a[i].compareTo(pivot) < 0);

              do 
              {
                  j--;
              } while (a[j].compareTo(pivot) > 0);
                 if(i<j)
                 {
             swap(a, i, j);
                 }
          }while(i<j);

          swap(a, si, j);
          return j;
      }

      void swap(T[] a, int i, int j) 
      {
          T temp = a[i];
          a[i] = a[j];
          a[j] = temp;
      }
  }