 void selectionSort(int arr[], int n)
    {
       //code here
       for(int i=0;i<n-1;i++){
           int mini = i;
           
           for(int j=i+1;j<n;j++){
               
               if(arr[mini] > arr[j]){
                   mini = j;
               }
           }
           
           int temp = arr[mini];
           arr[mini] = arr[i];
           arr[i] = temp;
       }
