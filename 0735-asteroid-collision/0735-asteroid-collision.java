import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision can happen only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (!stack.isEmpty()
                    && stack.peek() > 0
                    && asteroid < 0) {

                if (stack.peek() < -asteroid) {
                    // Stack asteroid is smaller → it explodes
                    stack.pop();
                } 
                else if (stack.peek() == -asteroid) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    // Current asteroid is smaller → it explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}