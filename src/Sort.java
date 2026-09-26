class Sort {

    public void sortByAscending(Product arr[], int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);

            sortByAscending(arr, low, pi - 1);
            sortByAscending(arr, pi + 1, high);
        }
    }

    int partition(Product arr[], int low, int high) {

        double pivot = arr[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].price < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    void swap(Product arr[], int i, int j) {

        Product temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



public void sortByDescending(Product arr[], int low, int high) {
	if (low < high) {
		int mi = (low +high)/2;
		sortByDescending(arr,low,mi);
		sortByDescending(arr,mi+1,high);
		merge(arr,low,mi,high);
		
		
	}
}
	void merge(Product arr[],int low,int mi,int high)
	{
		int i =low;
		int j=mi+1;
		int k =0;
		Product temp[]= new Product[high - low + 1];


		while(i<=mi && j<=high)
		{
			if(arr[i].price>arr[j].price)
			{
				 temp[k++]=arr[i++];
			}
			else
			{
				  temp[k++]=arr[j++];
			}
			
		}
		while(i<=mi)
		{
			temp[k++]=arr[i++];
		}
		while(j<=high) {
			temp[k++]=arr[j++];
		}
		for (int x= low, y=0; x<=high;x++,y++)
		{
			arr[x]=temp[y];
		}
	
}
	void sortByName(Product arr[])
	{
		for (int i=0;i<arr.length-1;i++)
		{
			Product min = arr[i];
			int minIndex = i;
			for (int j=i+1;j<arr.length;j++)
			{
				if (arr[j].name.compareTo(arr[minIndex].name) < 0)				{
					minIndex =j;
					min=arr[j];
					
				}
				Product temp = arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
		}
	}
	
}