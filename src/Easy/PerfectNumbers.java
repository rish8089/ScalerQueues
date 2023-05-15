package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine());
        PerfectNumbers obj=new PerfectNumbers();
        System.out.println(obj.solve(A));
    }
    public String solve(int A) {
        Queue<StringBuilder> q=new LinkedList<>();
        q.add(new StringBuilder("11"));
        q.add(new StringBuilder("22"));
        int cnt=1;
        while(!q.isEmpty()){
            StringBuilder str=q.poll();
            if(cnt==A)
                return str.toString();
            String s1=str.substring(0,str.length()/2);
            String s2=str.substring(str.length()/2);
            StringBuilder c1=new StringBuilder();
            c1.append(s1).append("11").append(s2);
            StringBuilder c2=new StringBuilder();
            c2.append(s1).append("22").append(s2);
            q.add(c1);
            q.add(c2);
            cnt++;
        }
        return "";
    }
}
