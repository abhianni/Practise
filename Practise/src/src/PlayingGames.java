package src;

import java.util.Scanner;

//import for Scanner and other utility  classes

class PlayingGames {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int Q = s.nextInt();
		int[] ip = new int[N];
		for (int i = 0; i < N; i++) {

			ip[i] = s.nextInt();
		}
		int a, b;
		for (int j = 0; j < Q; j++) {
			a = s.nextInt();
			b = s.nextInt();
			int check = 0;
			int turn=0;
			for (int i = a - 1; i < b; i++) {
				int current = ip[i];
			
				if(current%2==0)
				{
					check=turn;
					
				}
				else{
					if(turn==1)
					{
						turn=0;
					}
					else
					{
						turn=1;
					}
					check=turn;
				}

			}
			if (check == 0) {
				System.out.println("Mishki");
			} else {
				System.out.println("Hacker");
			}

		}

	}
}
