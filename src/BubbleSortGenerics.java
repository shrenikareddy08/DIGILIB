
class BubbleSortGenerics<T extends Comparable<T>> {
	public void bubbleSort(T Arr[])
	{
		int i,j;
		T temp;
		for(i=1;i<Arr.length;i++)
		{
			for (j=0;j<Arr.length-i;j++)
			{
				if (Arr[j].compareTo(Arr[j + 1]) > 0)
						{
					temp=Arr[j];
					Arr[j]=Arr[j+1];
					Arr[j+1]=temp;
						}
			}
		}
	}
	

}
