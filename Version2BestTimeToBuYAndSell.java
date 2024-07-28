// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Example 2:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.


// brute force algorithm

// 1.Initialize maxProfit to 0: This variable will keep track of the maximum profit found.

// 2.Outer Loop (Buy Day):

//         Loop through each element in the prices array using the index i from 0 to n-1, where n is the length of the array.
//         This loop represents the day you buy the stock.

// 3.Inner Loop (Sell Day):
//         For each day i, loop through the remaining days using the index j from i+1 to n-1.
//         This loop represents the day you sell the stock.

//4. Calculate Profit:
//     For each pair of days (i, j), calculate the profit as prices[j] - prices[i].

// 5.Update Maximum Profit:
// ,,    If the calculated profit is greater than the current maxProfit, update maxProfit to this new value.

// 6.Return Result
//      After all iterations are complete, return the value of maxProfit.



// public class Version2BestTimeToBuYAndSell {
//   public static int maxProfit(int prices[]){
//     int n=prices.length;
//     int maxProfit=0;
//     for(int i=0; i<n; i++){
//       for(int j=i+1; j<n; j++){
//         int profit=prices[j]-prices[i];
//         if(profit>maxProfit){
//           maxProfit=profit;

//         }

//       }
//     }
//     return maxProfit;
//   }

//   public static void main(String[] args) {
//     int prices[]={7,1,4,6,2,8};
//     System.out.println("maxProfit"+" "+ maxProfit(prices));
    
//   }
// }

// Complexity:
// Time Complexity: 
// O(n^2)
// Space Complexity: 
// O(1)
// , since we only use a constant amount of extra space





// optimized solution

// Algorithm Explanation:

// 1.Initialize Variables:
//       a.minPrice is set to Integer.MAX_VALUE to ensure any price encountered will be lower initially.
//       b.maxProfit is set to 0 to start tracking the maximum profit.

//2. Iterate through Prices:
//     a. For each price in the array:
//           1.If the current price is less than minPrice, update minPrice to the current price. This step keeps track of the lowest price encountered so far.
//           2.Otherwise, calculate the potential profit if the stock were sold at the current price by subtracting minPrice from the current price. If this profit is greater than maxProfit, update maxProfit.

// 3.Return maxProfit:
//    After iterating through all the prices, return the value of maxProfit, which now holds the maximum profit that can be achieved.




public class Version2BestTimeToBuYAndSell {
  public static int optimized(int prices[]){
    int n=prices.length;
    // step 1 initilized minPrice and maxProfit
    int minPrice=Integer.MAX_VALUE;
    int maxProfit=0;
    for(int price:prices){
      if(price<minPrice){// update the minPrice
        minPrice=price;
      } 
      // int profit=price-minPrice;
      else if(price-minPrice>maxProfit){// update the maxprofit
        maxProfit=price-minPrice;
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int prices[]={8,3,4,5,9};
    System.out.println("maxProfit"+" "+optimized(prices));
    
  }
}


// tc=O(n)
// sc=O(1)