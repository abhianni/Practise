package src;

import java.util.Arrays;

public class Zigzagno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zigzagno no = new Zigzagno();
		int[] ar = { 1,2,3,4,5,6,7,8,9,10 };
		no.zigzag(ar);

	}

	// 0,9,5,3,2,4,1,6,7,8
	public void zigzag(int[] ar) {
		boolean high = false;
		{
			int j = 0;
			for (int i = 1; i <= ar.length - 1; i++) {
				if (!(high)) {
					if (ar[j] < ar[i])

					{
						int temp = ar[i];
						ar[i] = ar[j];
						ar[j] = temp;
						j = j + 1;
						high = true;
					} else {
						j = j + 1;
						high = true;
					}
				} else if (high) {
					if (ar[j] > ar[i])
					{
						int temp = ar[i];
						ar[i] = ar[j];
						ar[j] = temp;
						j = j + 1;
						high = false;
					} else {

						j = j + 1;
						high = false;
					}

				}
			}
		}
		System.out.println(Arrays.toString(ar));
	}

}
