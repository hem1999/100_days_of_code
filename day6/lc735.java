  public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<Integer>();
        for(int key: asteroids){
            if(!s.empty() &&   s.peek() > 0 && key < 0){
                boolean flag = true;
                while(!s.empty() &&  s.peek() >0 && key < 0){
                    if(Math.abs(key)==Math.abs(s.peek())){
                        s.pop();
                        flag = false;
                        break;
                    }else if(Math.abs(key) > Math.abs(s.peek())){
                        s.pop();
                        flag = true;
                    }else if(Math.abs(key) < Math.abs(s.peek())){
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    s.push(key);
                }
            }else{
                s.push(key);
            }
            // Solution.print_stack(s);
        }
        int[] ans = new int[s.size()];
        int i=s.size();
        while (!s.empty()){
            ans[--i] = s.pop();
        }
        return ans;
    }