import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HardCodeExample extends GamePlayer {
	public HardCodeExample (Scanner s) {
		super(s);
		
		
		try {
			List<Item> items = new ArrayList<Item>();
			
			List<String> itemDesc = new ArrayList<String>();
			itemDesc.add("An old, rusty key you found on the mantlepiece. It looks like it could fit into the locked door.");
			itemDesc.add("An old, rusty key lying on the mantlepiece. It looks like it could fit into the locked door.");
			
			List<String> itemTriggers = new ArrayList<String>();
			itemTriggers.add("Old Key");
			itemTriggers.add("true");
			
			Item key = new Item("Old Key", itemDesc, itemTriggers, "true");
			items.add(key);
			
			List<String> levelDesc = new ArrayList<String>();
			levelDesc.add("You are in an old, beaten up room. Doesn't seem like there's much to do here, but there is a door on the far side of the room.");
			
			List<String> levelTriggers = new ArrayList<String>();
			levelTriggers.add("true");
			
			Level room = new Level(items, levelDesc, levelTriggers);
			
			levelDesc = new ArrayList<String>();
			levelDesc.add("You win! Type 'exitgame' to quit.");
			
			levelTriggers = new ArrayList<String>();
			levelTriggers.add("true");
			
			Level goal = new Level(new ArrayList<Item>(), levelDesc, levelTriggers);
			
			List<String> edgeName = new ArrayList<String>();
			edgeName.add("Heavy Door");
			
			List<String> edgeNameTriggers = new ArrayList<String>();
			edgeNameTriggers.add("true");
			
			List<String> edgeDesc = new ArrayList<String>();
			edgeDesc.add("A large, heavy iron door. The key you found on the mantlepiece seems to fit its keyhole.");
			edgeDesc.add("A large, heavy iron door. It's shut and won't budge.");
			
			List<String> edgeDescTriggers = new ArrayList<String>();
			edgeDescTriggers.add("Old Key");
			edgeDescTriggers.add("true");
			
			Edge door = new Edge(goal, edgeName, edgeNameTriggers, edgeDesc, edgeDescTriggers, "Old Key");
			
			room.addEdge(door);
			
			currentLevel = room;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		protagonist = new Protagonist();
	}
}
