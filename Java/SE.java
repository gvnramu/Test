import java.util.Scanner;
class SE {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("how many members");
		int n = in.nextInt();
		String names[] = new String[n];
		System.out.println("Enter names");
		for(int i = 0; i  < n;i++) {
			names[i] = in.next();
		}
		
		int ex[][] = new int[n][n];
		int ch;
		while(true) {
			System.out.println("1.Add Expense\n2.Show Expenses\n3.Exit");
			ch = in.nextInt();
			switch(ch) {
				case 1:
					System.out.println("Who spend money");
					String s = in.next();
					System.out.println("How much");
					int a = in.nextInt();
					int ia = a/n,index=0; 
					for(int j = 0;j<n;j++) {
						if(names[j].equals(s)) {
							index = j;
						}
					}
					for(int i = 0;i  <n;i++) {
						if(!names[i].equals(s)){
							if(ex[index][i] == ia) {
								ex[index][i] = 0;
							}
							else if(ex[index][i] > ia ){
								ex[index][i] -= ia;
							}
							else {
								int t = ia - ex[index][i];
								ex[index][i] = 0;
								ex[i][index] += t;
							}
							//ex[i][index] = ia;
						}
					}
				break;
				case 2:
					for(int i = 0;i < n;i++)
						System.out.print("  "+names[i]+"\t");
					System.out.println();
					for(int i = 0;i <n ;i++){
						System.out.print(names[i]);
						for(int j = 0;j  < n;j++) {
							
							System.out.print("  "+ex[i][j]+"\t");
						}
						System.out.println();
					}
				break;
				case 3:
					System.exit(0);
			}	
		}
	}
}