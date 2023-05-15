package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        SlidingWindowMaximum obj=new SlidingWindowMaximum();
        List<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        int B=Integer.parseInt(br.readLine());
        System.out.println(obj.slidingMaximum(A,B));
    }
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n=A.size();
        B=Math.min(B,n);
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<B;i++)
            insertToQueue(q,A,i);
        ArrayList<Integer> res=new ArrayList<>();
        res.add(A.get(q.peekFirst()));
        for(int i=B;i<n;i++){
            //remove i-B and add i
            if(i-B==q.peekFirst())
                q.pollFirst();
            insertToQueue(q,A,i);
            res.add(A.get(q.peekFirst()));
        }
        return res;
    }
    private void insertToQueue(Deque<Integer> q, List<Integer> A,int pos){
        while(!q.isEmpty() && A.get(q.peekLast())<=A.get(pos))
            q.pollLast();
        q.addLast(pos);
    }
}
