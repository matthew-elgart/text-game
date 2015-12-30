import java.util.ArrayList;
import java.util.List;

public class Level {
	private List<Item> items;
	private List<Edge> connections;
	//private List<String> descriptions;
	private TriggeredString descriptions;
	
	public Level (List<Item> items, List<String> descriptions, List<String> triggers) throws Exception {
		this.items = items;
		this.descriptions = new TriggeredString(descriptions, triggers);
		connections = new ArrayList<Edge>();
	}
	
	public List<Item> getItems () {
		return items;
	}
	
	public void removeItem (Item i) {
		items.remove(i);
	}
	
	public List<Edge> getAdjacentLevels () {
		return connections;
	}
	
	public void addEdge (Edge addition) {
		//if (!connections.contains(addition)) connections.add(addition);
		connections.add(addition);
	}
	
	public String getDescription (List<String> characteristics) {
		return descriptions.getOutput(characteristics);
	}
}