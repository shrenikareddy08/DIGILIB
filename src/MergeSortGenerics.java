import java.util.Arrays;

 class MergeSortGenerics<T extends Comparable<T>> {
public void mergeSort(T a[],int si,int ei)
{
	if(si<ei)
	{
		int mi=(si+ei)/2;
		mergeSort(a,si,mi);
		mergeSort(a,mi+1,ei);
		merge(a,si,mi,ei);
	}
	
}
public void merge(T a[],int si,int mi, int ei)
{
	int i=si;
	int j=mi+1;
	int k=0;
	T[] temp=Arrays.copyOfRange(a,si,ei+1);
	while((i<=mi)&& (j<=ei))
	{
		if(a[i].compareTo(a[j])<=0)
		{
			temp[k++]=a[i++];
		}
		else
		{
			temp[k++]=a[j++];
		}
	}
	while (i<=mi)
	{
		temp[k++]=a[i++];
	}
	while (j<=ei)
	{
		temp[k++]=a[j++];
	}
	for (int x = si, y = 0; x <= ei; x++, y++)
	{
		a[x]=temp[y];
	}
}
}