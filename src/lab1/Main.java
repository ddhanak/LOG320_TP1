package lab1;

public class Main {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		AnagramAnalyzer analyzer = new AnagramAnalyzer();

		System.out.println("Processing...");
		
		for (int i = 0; i != 1000000; i++) {
			analyzer.isAnagram("ancestries", "resistance");
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Done in " + (endTime - startTime) + " ms.");

	}

}
