class Solution {
    /*
     *      #20 
     *  Want to place the items in a stack so we can take advantage of the first in last out properties.
     *  The main idea behind this is that we check if anytime we get a closing bracket we want to check if our most recent
     *  value added to the stack is a matching one for that type. So then this means we need to always add the opening bracket.
     *  This is because the stack should only contain the most recent type of opening bracket. So once we get a closing
     *  we can check each of the conditions. Then if at the end the stack is empty, we have matched all parentheses.
     */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        
        
        for(Character c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') stack.push(c);  //Add the openning bracket
            else if(stack.isEmpty()) return false; //if the stack is empty while iterating, it means close without openning
            else if(c == ']' && stack.pop() != '['){ // check if it has match
                return false;
            }
            else if(c == '}' && stack.pop() != '{'){// check if it has match
                return false;
            }
            else if(c == ')' && stack.pop() != '('){// check if it has match
                return false;
            }
            
        }
        return stack.empty();
    }
}