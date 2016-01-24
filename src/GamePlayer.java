import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlayer {
	private boolean gameOver;
	private Scanner s;
	protected Level currentLevel;
	protected Protagonist protagonist;
	
	public GamePlayer(Scanner scan) {
		// TODO: maybe take in a file to read from
		gameOver = false;
		s = scan;
	}
	
	public void run() {
		/*pl("This simulation just repeats things that you type. Type 'end' to stop.");
		while (!gameOver) {	
			String input = askForInput(s);
			pl("This is just me repeating what you typed: " + input);
			if (input.toLowerCase().equals("end")) {
				gameOver = true;
			}
		}*/
		
		printCurrentLevelDescription();
		while (!gameOver) {
			parseInput(askForInput(s));
		}
	}
	
	private void parseInput(String input) {
		String[] in = input.split(" ", 2);
		String command = in[0].toLowerCase();
		List<String> charNames = extractNames(protagonist.getCharacteristics());
		
		if (command.equals("look")) {
			for (Item i : currentLevel.getItems()) {
				if (i.getName().toLowerCase().equals(in[1].toLowerCase())) {
					pl(i.getDescription(charNames));
				}
			}
			for (Edge e : currentLevel.getAdjacentLevels()) {
				if (e.getName(charNames).toLowerCase().equals(in[1].toLowerCase())) {
					pl(e.getDescription(charNames));
				}
			}
		}
		else if (command.equals("take")) {
			Item item = null;
			for (Item i : currentLevel.getItems()) {
				if (i.getName().toLowerCase().equals(in[1].toLowerCase())) {
					if (i.isTakeable(charNames)) {
						item = i;
					}
					else pl("Can't take that.");
				}
			}
			if (!item.equals(null)) {
				protagonist.addCharacteristic(item);
				currentLevel.removeItem(item);
			}
		}
		else if (command.equals("go")) {
			for (Edge edge : currentLevel.getAdjacentLevels()) {
				if (edge.getName(charNames).toLowerCase().equals(in[1].toLowerCase())) {
					if (edge.isEnterable(charNames)) {
						currentLevel = edge.getDestination(charNames);
						printCurrentLevelDescription();
					}
					else pl("Can't go there.");
				}
			}
		}
		else if (command.equals("examine")) {
			for (Item i : protagonist.getItems()) {
				if (i.getName().toLowerCase().equals(in[1].toLowerCase())) {
					pl(i.getDescription(charNames));
				}
			}
		}
		else if (command.equals("inventory")) {
			for (Item i : protagonist.getItems()) {
				pl(i.getName());
			}
		}
		else if (command.equals("description")) {
			printCurrentLevelDescription();
		}
		else if (command.equals("exitgame")) {
			pl("Thanks for playing!");
			gameOver = true;
		}
		else {
			pl("Invalid command");
		}
	}
	
	private void printCurrentLevelDescription () {
		List<String> characteristics = extractNames(protagonist.getCharacteristics());
		pl(currentLevel.getDescription(characteristics));
		for (Item item : currentLevel.getItems()) {
			pl("There is a " + item.getName() + " here.");
		}
		for (Edge edge : currentLevel.getAdjacentLevels()) {
			pl("There is a " + edge.getName(characteristics) + " here.");
		}
	}
	
	private List<String> extractNames (List<Characteristic> characteristics) {
		List<String> itemDescriptions = new ArrayList<String>();
		for (Characteristic characteristic : characteristics) {
			itemDescriptions.add(characteristic.getName());
		}
		return itemDescriptions;
	}

	private String askForInput(Scanner s) {
		p("> ");
		return s.nextLine();
	}
	
	private void p(String output) {
		System.out.print(output);
	}
	
	private void pl(String output) {
		System.out.println(output);
	}
}