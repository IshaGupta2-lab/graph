// // import java.util.*;
// // public class planetQueries1 {
// //     static final int LOG=30;
// //     public static void main(String[] args) {
// //         Scanner sc=new Scanner(System.in);
// //         int n=sc.nextInt();
// //         int q=sc.nextInt();

// //         int[][] up=new int[n+1][LOG];
// //         for(int i=1;i<=n;i++){
// //             up[i][0]=sc.nextInt();
// //         }

// //         for(int j=1;j<LOG;j++){
// //             for(int i=1;i<=n;i++){
// //                 up[i][j]=up[up[i][j-1]][j-1];
// //             }
// //         }

// //         while(q-->0){
// //             int x=sc.nextInt();
// //             int k=sc.nextInt();

// //             for(int j=0;j<LOG;j++){
// //                 if((k & (1<<j))!=0){
// //                     x=up[x][j];
// //                 }
// //             }
// //             System.out.println(x);
// //         }
// //     }
// // }
// import java.io.*;
// import java.util.*;

// public class planetQueries1 {
//     static final int LOG = 30;

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int q = Integer.parseInt(st.nextToken());

//         int[][] up = new int[n + 1][LOG];

//         // teleporters
//         st = new StringTokenizer(br.readLine());
//         for (int i = 1; i <= n; i++) {
//             up[i][0] = Integer.parseInt(st.nextToken());
//         }

//         // binary lifting
//         for (int j = 1; j < LOG; j++) {
//             for (int i = 1; i <= n; i++) {
//                 up[i][j] = up[ up[i][j - 1] ][j - 1];
//             }
//         }

//         StringBuilder sb = new StringBuilder();

//         // queries
//         while (q-- > 0) {
//             st = new StringTokenizer(br.readLine());
//             int x = Integer.parseInt(st.nextToken());
//             long k = Long.parseLong(st.nextToken());

//             for (int j = 0; j < LOG; j++) {
//                 if ((k & (1L << j)) != 0) {
//                     x = up[x][j];
//                 }
//             }

//             sb.append(x).append('\n');
//         }

//         System.out.print(sb);
//     }
// }
import java.io.*;
import java.util.*;

public class planetQueries1 {
    static final int LOG = 30;

    
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c=='-') {
                sign=-1;
                c=read();
            }

            while(c>' ') {
                val=val*10+(c-'0');
                c=read();
            }
            return val*sign;
        }

        long nextLong()throws IOException {
            int c,sign=1;
            long val=0;
            do {
                c=read();
            } while(c<=' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while(c>' ') {
                val=val*10+(c-'0');
                c=read();
            }
            return val*sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int q = fs.nextInt();

        int[][] up = new int[n + 1][LOG];

        for (int i = 1; i <= n; i++) {
            up[i][0] = fs.nextInt();
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[ up[i][j - 1] ][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int x = fs.nextInt();
            long k = fs.nextLong();

            for (int j = 0; j < LOG; j++) {
                if ((k & (1L << j)) != 0) {
                    x = up[x][j];
                }
            }

            sb.append(x).append('\n');
        }

        System.out.print(sb);
    }
}