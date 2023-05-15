package Easy;

import Medium.SlidingWindowMaximum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReversingElementsOfQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ReversingElementsOfQueue obj=new ReversingElementsOfQueue();
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        int B=Integer.parseInt(br.readLine());
        System.out.println(obj.solve(A,B));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Queue<Integer> q=new LinkedList<>();
        int n=A.size();
        B=Math.min(B,n);
        for(int i=0;i<B;i++){
            q.add(A.get(i));
        }
        for(int i=B-1;i>=0;i--)
            A.set(i,q.poll());
        return A;
    }
}
