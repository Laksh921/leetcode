class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for(char ch:pattern.toCharArray()){
            stack.push(num);
            num++;
            if(ch == 'I'){
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
            }
        }
        stack.push(num);
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }
}