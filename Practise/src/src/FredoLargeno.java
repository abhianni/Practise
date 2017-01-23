package src;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class FredoLargeno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		LinkedHashMap<Long, Long> map = new LinkedHashMap<>();
		for (int i = 0; i < N; i++) {
			Long ip = s.nextLong();
			if (!(map.containsKey(ip))) {
				map.put(ip, (Long) 1L);
			} else {
				Long no = map.get(ip);
				map.put(ip, no + 1);
			}
		}
		List<Long> ip = new ArrayList<>(map.keySet());
		int Q = s.nextInt();
		for (int i = 0; i < Q; i++) {
			int a = s.nextInt();
			int check=0;
			Long b = s.nextLong();
			if (a == 0) {
				for (int j = 0; j < ip.size(); j++) {
					if (map.get(ip.get(j)) >= b) {
						System.out.println(ip.get(j));
						
						break;
					}
					check=1;
				}
				

			} else if (a == 1)

			{
				for (int j = 0; j < ip.size(); j++) {
					if (map.get(ip.get(j)) == b) {
						System.out.println(ip.get(j));
						break;
					}
					check=1;
				}
				
			}
			if(check==1)
			{
				System.out.println(0);
			}

		}

	}

}
