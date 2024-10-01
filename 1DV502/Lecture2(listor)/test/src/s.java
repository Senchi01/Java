import java.util.Random;

public class s {
	public static void main(String[] args) {
		Random rnd = new Random();
		int dircetions = 0;

		for (int i = 0; i < 5; i++) {
			dircetions = rnd.nextInt(4) + 1;
			System.out.println(dircetions);

		}


	}

}
