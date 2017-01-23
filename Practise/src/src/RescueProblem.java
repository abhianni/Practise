package src;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RescueProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		double x1, x2, y1, y2;
		double v1 ;
		// v1.setScale(5,double.ROUND_UP);
		double v2 ;
		// v2.setScale(5,double.ROUND_UP);
		DecimalFormat formatter = new DecimalFormat("0.00000");
		for (int i = 0; i < N; i++) {
			x1 = s.nextDouble();
			y1 = s.nextDouble();
			x2 = s.nextDouble();
			y2 = s.nextDouble();
			v1 = s.nextDouble();
			v2 = s.nextDouble();
			
			BigDecimal t1 = new BigDecimal(0);
			BigDecimal t2 = new BigDecimal(0);
			BigDecimal t = new BigDecimal(0);
			BigDecimal d = new BigDecimal(0);
			d.setScale(5, BigDecimal.ROUND_UP);
			t1.setScale(5, BigDecimal.ROUND_UP);
			t2.setScale(5, BigDecimal.ROUND_UP);
			t.setScale(5, BigDecimal.ROUND_UP);
			BigDecimal ip = new BigDecimal(0);
			ip.setScale(5, BigDecimal.ROUND_UP);
			// d.setScale(5,double.ROUND_UP);
			if (x1 == x2) {

				if (y1 <= 0 && y2 >= 0 || y1 >= 0 && y2 <= 0) {
					if (y1 >= 0 && y2 <= 0) {
						double temp;
						temp = y2;
						y2 = y1;
						y1 = temp;
					}
					d = (BigDecimal.valueOf(y1) .multiply(new BigDecimal(-1)));
					t1 = d .divide(BigDecimal.valueOf(v1));
					d = (BigDecimal.valueOf(y2));
					t2 = d .divide(BigDecimal.valueOf(v2));
					t = t1.add(t2);
					System.out.println(formatter.format(t));
				} else if (y1 < 0 && y2 < 0 || y1 > 0 && y2 > 0) {
					if (y1 < 0) {
						y1 = y1 * -1;
						y2 = y2 * -1;
					}
					if (y1 > y2) {
						double temp;
						temp = y2;
						y2 = y1;
						y1 = temp;
					}
					d = BigDecimal.valueOf(y2).subtract(BigDecimal.valueOf(y1));
					
					t = d .divide(BigDecimal.valueOf(v1));
					System.out.println(formatter.format(t));
				}

			} else if (y1 < 0 && y2 < 0 || y1 > 0 && y2 > 0) {

				if (y1 < 0) {
					y1 = y1 * -1;
					y2 = y2 * -1;
					if (x1 < 0) {
						x1 = x1 * -1;
					}
					if (x2 < 0) {
						x2 = x2 * -1;
					}
				}
				if (y1 > y2) {
					double temp;
					temp = y2;
					y2 = y1;
					y1 = temp;
					temp = x2;
					x2 = x1;
					x1 = temp;

				}
				d = (BigDecimal.valueOf(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))));
			//	ip=BigInteger.valueOf(d);
				t = d .divide(BigDecimal.valueOf(v1));
				System.out.println(formatter.format(t));

			} else if((y1<0 && y2>0 || y1>0 && y2<0) && (x1<0 && x2 >0 || x1>0 && x2<0)  )
			{
				double m = (y1-y2)/(x1-x2);
				double c =(y1*(x1-x2))/(x1-x2);
				double x3 = -(c/m);				
				d=BigDecimal.valueOf(Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y1), 2)));				
				double d2=d.doubleValue();
				t1=BigDecimal.valueOf(d2/v1);
				d=BigDecimal.valueOf(Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y2), 2)));
				d2=d.doubleValue();
				t2=BigDecimal.valueOf(d2/v2);
				t=t1.add(t2);
				System.out.println(formatter.format(t));

			}
		}

	}

}
