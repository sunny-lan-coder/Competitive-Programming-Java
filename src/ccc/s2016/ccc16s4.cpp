#include <iostream>
#include <algorithm>

using namespace std;

int a[401];
int dp[401][401];
int sum[401][401];

int f(int i, int j){
    int res=dp[i][j];
    
    if(res==-1){
	    res=0;
	    if(i>=j){
	        res= 1;
	    }else{
	        int a=i;
	        int b=j;
	        while(a<b){
	            int c=sum[i][a];
	            int d=sum[b][j];
	            if(c<d){
	                a++;
	            }else if(d<c){
	                b--;
	            }else{
	                res=f(i,a)*f(a+1,b-1)*f(b,j);
	                if(res==1){
	                    break;
	                }else{
	                    a++;
	                    b--;
	                }
	            }
	        }
	    }
    	dp[i][j]=res;
	}
//	cout << "range [" << i << ", " << j << "] = " << res << " * " << sum[i][j] << endl;
    return res;
}

int main(){
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>a[i];
        for(int j=0;j<n;j++){
            dp[i][j]=-1;
        }
    }
    
    for(int i=0;i<n;i++){
    	for(int j=0;j<n;j++){
    		int six=0;
    		for(int k=i;k<=j;k++){
    			six+=a[k];
			}
			sum[i][j]=six;
		}
	}
    
    int best=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            best=max(sum[i][j]*f(i,j),best);
        }
    }
    cout<<best<<endl;
        
    return 0;
}
