import java.math.BigInteger;

public class BoardGame {
	
	private int n; //number spaces away from starting to finishing point
	
	public BoardGame(int input){
		n = input;
	}
	
	public static BigInteger sumOfArray(BigInteger[] input){
		BigInteger result = BigInteger.valueOf(0);
		for (int i=0; i<input.length; i++){
			result = result.add(input[i]);
		}
		return result;
	}
	
	public BigInteger doCalculateNbPossibleWayToFinish(){
		if(n == 1) return BigInteger.valueOf(1);
		int idx;
		BigInteger[] prev = null, curr = null;
		for (int i=1; i<n; i++){
			curr = new BigInteger[i+1];
			curr[0]=BigInteger.valueOf(1); curr[i]=BigInteger.valueOf(1);
			idx = 1;
			while (idx<i){
				curr[idx] = prev[idx-1].add(prev[idx]);
				idx++;
			}
			prev = curr;
		}
		return sumOfArray(curr);
	}
	
	public static void main(String[] args) {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 610;
		if(n == 0) System.exit(1);
		BoardGame game = new BoardGame(n);
		System.out.println("Nb possible ways to arrive exactly at " + n + ": " + game.doCalculateNbPossibleWayToFinish());
	}

}
