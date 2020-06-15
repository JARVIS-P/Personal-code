#include<stdio.h>
int a[82]={0};//储存需要排序的数列。 
int main ()
{
	int n,i,j,k,m;
	scanf("%d",&n);//确定数列中数的个数。
	for(i=0;i<n;i++){
		scanf("%d",&a[i]);//将待排列的数列录入数组中。 
	}
	for(i=0;i<n-1;i++) {//控制扫描次数 。
		k=i;//用于记录未排序的数列最左边的序号。 
		for(j=i;j<=n-1;j++){//控制每次扫描的进程 。
			if(a[j]<a[k]){
				k=j;//找出剩余数中最小的。 
			}
		}
		if(k!=i){//当最小值非最左边的数时，使其与最左边的数交换。 
			m=a[i];
			a[i]=a[k];
			a[k]=m;
		}
	} 
	for(i=0;i<n;i++){
		printf("%d ",a[i]);
	}
	return 0;
 } 
