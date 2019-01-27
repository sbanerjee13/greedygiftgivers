/*
ID: siddban1
LANG: JAVA
TASK: gift1
 */

import java.io.*;
import java.util.*;

class main {
    public static void main(String[] args) throws IOException {

            BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
            StringTokenizer f;

            LinkedHashMap<String, Integer> balance = new LinkedHashMap<>();

            int n = Integer.parseInt(in.readLine());

            for(int i = 0; i < n; i++){
                balance.put(in.readLine(), 0);
            }

            int d = 1;

            while(d != 0){
                String giver = in.readLine();
                f = new StringTokenizer(in.readLine());
                int amount = Integer.parseInt(f.nextToken());
                d = Integer.parseInt(f.nextToken());
                if(d != 0 && amount != 0) {
                    int remainder = amount % d;
                    balance.put(giver, balance.get(giver) + remainder);

                    amount = amount - remainder;
                    amount = amount / d;
                    for (int i = 0; i < d; i++) {
                        String r = in.readLine();
                        balance.put(r, balance.get(r) + amount);
                    }
                    amount = amount * d + remainder;
                    balance.put(giver, balance.get(giver) - amount);
                } else if (amount == 0){
                    for(int j = 0; j < d; j++){
                        in.readLine();
                    }
                }
            }

            for(String i : balance.keySet()) {
                out.println(i  + " " + balance.get(i));
            }

            out.close();
    }
}
