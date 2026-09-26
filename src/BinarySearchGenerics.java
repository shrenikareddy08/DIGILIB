public class BinarySearchGenerics<T extends Comparable<T>> {
  public int search(T array[], T key) {
    int si = 0;
    int ei = array.length-1;
    while(si <= ei) {
      int mi = (si+ei)/2;
      if(key.compareTo(array[mi])==0) {
        return mi;
      }
      else if(key.compareTo(array[mi])<0) {
        // key < array[mi] 
        ei=mi-1;
      }
      else {
        // key > array[mi]
        si = mi+1;
      }
    }
    return -1; // data not found
  }
}