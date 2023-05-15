package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumFrequencyStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String []str=br.readLine().split(" ");
            ArrayList<Integer> subList=new ArrayList<>();
            for(int j=0;j<2;j++)
                subList.add(Integer.parseInt(str[j]));
            list.add(subList);
        }
        MaximumFrequencyStack obj=new MaximumFrequencyStack();
        System.out.println(obj.solve(list));
    }
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A){
        PriorityQueue<PQNode> pq=new PriorityQueue<>((pq1,pq2)->{
            if(pq1.freq==pq2.freq)
                return Integer.compare(pq2.occurrence,pq1.occurrence);
            else
                return Integer.compare(pq2.freq,pq1.freq);
        });
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<A.size();i++){
            ArrayList<Integer> list=A.get(i);
            int a=list.get(0);
            int b=list.get(1);
            if(a==1){
                insert(pq,mp,b,i);
                res.add(-1);
            }else
                res.add(remove(pq,mp));
        }
        return res;
    }

    private void insert(PriorityQueue<PQNode> pq, Map<Integer,Integer> mp, int val, int occurrence){
        if(!mp.containsKey(val))
            mp.put(val,1);
        else
            mp.put(val,mp.get(val)+1);

        PQNode pqNode=new PQNode(val,mp.get(val),occurrence);
        pq.add(pqNode);
    }

    private int remove(PriorityQueue<PQNode> pq, Map<Integer,Integer> mp){
        if(pq.isEmpty())
            return -1;
        PQNode pqNode=pq.poll();
        if(pqNode.freq==1)
            mp.remove(pqNode.val);
        else
            mp.put(pqNode.val, pqNode.freq-1);
        return pqNode.val;
    }

    class PQNode{
        int val;
        int freq;
        int occurrence;
        PQNode(int val, int freq, int occurrence){
            this.val=val;
            this.freq=freq;
            this.occurrence=occurrence;
        }
    }
}
