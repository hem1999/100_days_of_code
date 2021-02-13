import java.util.*;
class StackSpan{
    public static void main(String[] args){
        int arr[] = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        ArrayList<Integer> an = solve(arr);
        for(int i=0;i<an.size();i++){
            System.out.print(an.get(i)+"  -->  ");
        }
    }

    public static ArrayList<Integer> solve(int arr[]){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int span = 1;
        for(int i=0;i<arr.length;i++){
            if(stack.size()!=0 && stack.peek() <arr[i]){
                span++;
                stack.add(arr[i]); 
            }else{
                span = 1;
                stack.add(arr[i]);
            }
            ans.add(span);
        }
        return ans;
    }
}