package src;

public class Spaceto20conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spaceto20conversion sp = new Spaceto20conversion();
		System.out.println(sp.replaceString("jj kkkk  kkkkj lkj "));

	}

	public char[] replaceString(String str) {
		char[] array = str.toCharArray();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int code = (int) str.charAt(i);
			if (code == 32) {
				count = count + 1;

			}

		}
		int newlength = array.length + 2 * count;
		char[] output = new char[newlength];
		// output[newlength] = '\0';
		int newArrayPosition = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				output[newArrayPosition] = '%';
				output[newArrayPosition + 1] = '2';
				output[newArrayPosition + 2] = '0';
				newArrayPosition = newArrayPosition + 3;
			} else {
				output[newArrayPosition] = array[i];
				newArrayPosition++;
			}
		}

		return output;
	}

}
