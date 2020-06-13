#include<stdio.h>
int a[82]={1};// 储存需要排序的数列。 
int main ()
{
	int n,i,j,k,m;
	scanf("%d",&n);//确定数列中数的个数。
	for(i=0;i<n;i++){
		scanf("%d",&a[i]);//将待排列的数列录入数组中。 
	}
	for(i=0;i<n-1;i++) {//控制扫描次数 。 
		m==0;//初始化标志变量 （极其重要） 。 
		for(j=0;j<n-1-i;j++){//控制每次扫描的进程 。 
			if(a[j]>a[j+1]){
				k=a[j];
				a[j]=a[j+1];
				a[j+1]=k;
				m=1;//若交换则改变标志变量 。 
			}
		}
		if(m==0) break;//判断数列是否发生交换。 
	}
	for(i=0;i<n;i++){
		printf("%d ",a[i]);
	}
	return 0;
 } 
