 class Solution {
   func getSum(_ a: Int, _ b: Int) -> Int {
    let result = a ^ b
    let carry = (a & b) << 1
    if carry != 0 {
        return getSum(result, carry)
    }
    return result
}
    
 
}