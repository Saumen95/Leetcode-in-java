public class Solution {
    public int coinChange(int[] coins, int amount) {
        int length=coins.length;
        Arrays.sort(coins);
        if(length<=0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        int[] needCoins=new int[amount+1];
        for(int i=1;i<amount+1;i++){
            needCoins[i]=-1;
        }
        for(int i=1;i<amount+1;i++){
            int min=Integer.MAX_VALUE;	
            boolean canReach=false;
            for(int j=0;j<length;j++){			
                int nowCoin=coins[j];
                if(i-nowCoin<0){
                    continue;
                }
                if(needCoins[i-nowCoin]<min){
                    if(needCoins[i-nowCoin]==-1){
                        continue;
                    }
                    min=needCoins[i-nowCoin];
                    canReach=true;
                }
            }
            if(!canReach){
                needCoins[i]=-1;
            }
            else{
                needCoins[i]=min+1;
            }		
        }		
        return needCoins[amount];
        }
    }
        
     
    
    