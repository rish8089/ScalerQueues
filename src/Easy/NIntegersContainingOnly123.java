package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContainingOnly123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine());
        NIntegersContainingOnly123 obj=new NIntegersContainingOnly123();
        System.out.println(obj.solve(A));
    }
    public ArrayList<Integer> solve(int A){
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        ArrayList<Integer> res=new ArrayList<>();
        int i=1;
        while(!q.isEmpty() && i<=A){
            int val=q.poll();
            res.add(val);
            q.add(val*10+1);
            q.add(val*10+2);
            q.add(val*10+3);
            i++;
        }
        return res;
    }
}
