
class InsertionSortGenerics<T extends Comparable<T>> {
	
public void insertionSort(T a[])
{
	for(int i=1;i<=a.length-1;i++)
	{
		T temp=a[i];
		int j=i-1;
	while((j>=0)&&(temp.compareTo(a[j])<0))
	{
		a[j+1]=a[j];
		j--;
	}
	a[j+1]=temp;
	}
}
}
