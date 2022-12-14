public class ReverseBits {
        // you need treat n as an unsigned value
        /*
        1. right shifted n & 1
        2. left shifted result OR value of no.1
        3. loop for 32 bits
         */
        public int reverseBits(int n) {
            int result = 0 ;

            for(int i = 0 ; i<32; i++){ //for loop as much as 32 bits
                result <<= 1; // left shift
                result = result | (n&1); // n and 1 then or result
                n>>=1; //right shift
            }
            return result;
        }
}
