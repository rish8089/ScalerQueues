package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingcharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FirstNonRepeatingcharacter obj=new FirstNonRepeatingcharacter();
        System.out.println(obj.solve(br.readLine()));
    }
    public String solve(String A) {
        HashMap<Character,Integer> mp=new HashMap<>();
        Queue<Character> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(!mp.containsKey(ch)) {
                q.add(ch);
                mp.put(ch,1);
            }
            else{
                mp.put(ch,mp.get(ch)+1);
            }
            while(!q.isEmpty()){
                ch=q.peek();
                if(mp.get(ch)==1) {
                    sb.append(ch);
                    break;
                }
                else
                    q.poll();
            }
            if(q.isEmpty())
                sb.append("#");
        }
        return sb.toString();
    }
}
