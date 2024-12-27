class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast = n;
        while(true){
        slow = squareOfDigits(slow);
        fast = squareOfDigits(squareOfDigits(fast));
        if(slow == 1 || fast == 1){
            return true;
        }
        else if(slow == fast){
        return false;
        }
        }
    }
    private int squareOfDigits(int n){
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit; 
            n /= 10; 
        }
        return sum;
    }
}