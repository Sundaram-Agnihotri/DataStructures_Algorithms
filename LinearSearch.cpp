#include<iostream>
using namespace std;
int main(){
	int arr[5] = [2,3,4,1,10];
	int key;
	cin >> key;
	
	for(int i=0;i<5;i++){
		if(arr[i] == key)
		return i;
	}
	
	return -1;
}
