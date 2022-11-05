public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0 ;
        while(n!=0){
            n = n & (n-1); //find 1 bits exist
            count++;
        }
        return count;
    }
}
