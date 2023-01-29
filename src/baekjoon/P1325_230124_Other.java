package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1325_230124_Other {

    static int n,m;
    static ArrayList<Integer> map[];
    static boolean check[];
    static int res[] = new int[10001];
    static int cnt = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList();
        }

        for(int i = 0 ; i < m ; i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x].add(y);
        }

        for(int i =1; i<= n ;i++){
            check = new boolean[n+1];
            System.out.println("start");
            dfs(i);
        }

        int max = 0;
        for(int i =1 ; i <= n ; i++){
            if(max <res[i]){
                max = res[i];
            }
        }
        for(int i = 1 ; i <= n ; i++){
            if(res[i]==max){
                System.out.print(i+" ");
            }
        }
    }

    public static void dfs(int v){
        System.out.println("cnt: " + cnt++);
        check[v]=true;
        for(int vv : map[v]){
            if(!check[vv]){
                dfs(vv);
                res[vv]++;
            }
        }
    }
}