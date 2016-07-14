import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Main {

	static String path="input.in";
	
	public static void main(String[] args) throws IOException {
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		int N=Integer.parseInt(reader.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++){
			int credit = Integer.parseInt(reader.readLine());
			int numItems = Integer.parseInt(reader.readLine());
			ArrayList<Integer> prices = new ArrayList<>();
			String[] priceStr = reader.readLine().split(" ");
			for(int j=0;j<numItems;j++){
				prices.add(Integer.parseInt(priceStr[j]));
			}
			int[] res = Solve(credit,prices);
			sb.append("Case #"+(i+1)+": "+res[0]+" "+res[1]+"\n");
		}
		reader.close();	
		Writer writer = new FileWriter("output.out");
		writer.write(sb.toString());		
		writer.close();		
		System.out.println("Done");
	}

	private static int[] Solve(int credit,ArrayList<Integer> prices){
		int[] result = new int[2];
		for(int i=1;i<=credit;i++){
			int left=i;
			int right=credit-i;
			if(prices.contains(left)&&prices.contains(right)){
				result[0]=prices.indexOf(left)+1;				
				result[1]=prices.indexOf(right)+1;
				if(result[1]==result[0]){
					for(int a=1;a<=prices.size();a++){
						if(prices.get(a-1).equals(right)&&a!=result[1]){
							result[1]=a;
							break;
						}
					}
				}
				if(result[1]<result[0]){
					int temp = result[0];
					result[0]=result[1];
					result[1]=temp;
				}
				return result;
			}
		}
		return result;
	}
	
	
	
}
