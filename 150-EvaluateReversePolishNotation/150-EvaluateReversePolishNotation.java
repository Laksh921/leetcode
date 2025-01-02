class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(isNumber(token)){
            stack.push(Integer.parseInt(token));
            }
            else{
                int op1 = stack.pop();
                int op2 = stack.pop();
                int result = 0;
                switch(token){
                    case "+":
                    result = op1 + op2;
                    break;
                    case "-":
                    result = op2 - op1;
                    break;
                    case "*":
                    result = op1 * op2;
                    break;
                    case "/":
                    
                    result = op2 / op1;
                    break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
    private boolean isNumber(String token){
        try{
            Integer.parseInt(token);
                return true;
            } catch (NumberFormatException e){
                return false;
            }
        }
}