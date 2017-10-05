public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottoNumbers = new int[6];
		for (int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = (int)(Math.random() * 100);
		}
		
		for (int i : lottoNumbers) {
			System.out.println(i);
		}
		
		System.out.println();

		
	}

}
