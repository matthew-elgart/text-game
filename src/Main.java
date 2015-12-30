import java.util.Scanner;

public class Main {
	public static final String CLEARSCREEN = "\u001b[2J" + "\u001b[H";
	
	public static void main (String[] args) {
		// TODO: use args to pull from a file at some point
		Scanner s = new Scanner(System.in);
		//GamePlayer player = new GamePlayer(s);
		GamePlayer player = new HardCodeExample(s);
		System.out.print(CLEARSCREEN);
		player.run();
	}
}