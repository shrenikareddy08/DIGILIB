
class SelectionSortGenerics<T extends Comparable<T>> {
public void selectionSort(T a[]) {
	for(int i=0;i<a.length-i;i++)
	{
		T temp;
		T min=a[i];
		int minIndex=i;
		for(int j=i+1;j<a.length;j++)
		{
			if (a[j].compareTo(min)<0)
			{
				minIndex=j;
				min=a[j];
			}
			temp=a[j];
			a[i]=a[minIndex];
			a[minIndex]=temp;
			
			
		}
	}
}
}
