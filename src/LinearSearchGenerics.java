
public class LinearSearchGenerics<T extends Comparable<T>> 
{
public int search(T a[],T key)
{
	for(int i=0;i<a.length;i++)
	{
		if(a[i].compareTo(key)==0)
		{
			return i;
		}
	}
	return -1;
}
}
