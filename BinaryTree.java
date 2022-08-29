import java.util.Random;

public class BinaryTree {
	
	private int depth;
	private int[] treeData;
	
	public BinaryTree(int d) {
		// generate simple pseudo-random binary tree with depth as input
		depth = d;
		treeData = new int[(int)Math.pow(2, depth)-1];
		Random rand = new Random();
		for (int i=0; i<treeData.length; i++){
			treeData[i] = rand.nextInt(9);
		}
	}
	
	public void listNodesByDepth(){
		String output;
		int idx = 0, idxlimit = 0;
		for (int i=0; i < depth; i++){
			output = "";
			idxlimit = idxlimit + (int)Math.pow(2, i);
			while (idx < idxlimit ){
				output = output + "(" + treeData[idx] + ")";
				if(idx < (idxlimit-1) )output = output + ", ";
				idx++;
			}
			System.out.println(output);
		}
	}
	
	public static void main(String[] args) {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 4;
		BinaryTree btree = new BinaryTree(n);
		btree.listNodesByDepth();
	}

}
