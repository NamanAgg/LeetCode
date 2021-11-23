public class FindTheWinnerOfTheCircularGame {
    public int solution(int n,int k){
        if(n==1) return 0;
        return (solution(n-1,k)+k)%n;
    }
    public int findTheWinner(int n, int k) {
        return solution(n,k)+1;
    }
}
