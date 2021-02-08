public class fact {
    public int  fact(int n){
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
