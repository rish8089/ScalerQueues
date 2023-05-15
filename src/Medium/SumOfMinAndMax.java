package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SumOfMinAndMax {
    private int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        SumOfMinAndMax obj=new SumOfMinAndMax();
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        int B=Integer.parseInt(br.readLine());
        System.out.println(obj.solve(A,B));
    }
    public int solve(ArrayList<Integer> A, int B){
        int n=A.size();
        B=Math.min(B,n);
        Deque<Integer> q1=new LinkedList<>();
        Deque<Integer> q2=new LinkedList<>();
        for(int i=0;i<B;i++)
            insertToMaxQueue(q1,A,i);
        long sum=0;
        sum=(sum+A.get(q1.peekFirst())+MOD)%MOD;
        //max queue
        for(int i=B;i<n;i++){
            //remove i-B and add i
            if(i-B==q1.peekFirst())
                q1.pollFirst();
            insertToMaxQueue(q1,A,i);
            sum=(sum+A.get(q1.peekFirst())+MOD)%MOD;
        }
        for(int i=0;i<B;i++)
            insertToMinQueue(q2,A,i);
        sum=(sum+A.get(q2.peekFirst())+MOD)%MOD;
        //min queue
        for(int i=B;i<n;i++){
            //remove i-B and add i
            if(i-B==q2.peekFirst())
                q2.pollFirst();
            insertToMinQueue(q2,A,i);
            sum=(sum+A.get(q2.peekFirst())+MOD)%MOD;
        }
        return (int)sum;
    }
    private void insertToMaxQueue(Deque<Integer> q, List<Integer> A, int pos){
        while(!q.isEmpty() && A.get(q.peekLast())<=A.get(pos))
            q.pollLast();
        q.addLast(pos);
    }
    private void insertToMinQueue(Deque<Integer> q, List<Integer> A,int pos){
        while(!q.isEmpty() && A.get(q.peekLast())>=A.get(pos))
            q.pollLast();
        q.addLast(pos);
    }

}
