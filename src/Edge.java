import java.util.List;

public class Edge {
	private Level destination;
	private TriggeredString names;
	private TriggeredString descriptions;
	/*private List<String> names;
	private List<String> nameTriggers;
	private List<String> descriptions;
	private List<String> descTriggers;*/
	private String enterTrigger;
	
	public Edge (Level dest, List<String> names, List<String> nameTriggers, List<String> descriptions, List<String> descTriggers, String enterTrigger) throws Exception {
		destination = dest;
		this.names = new TriggeredString(names, nameTriggers);
		this.descriptions = new TriggeredString(descriptions, descTriggers);
		/*this.names = names;
		this.nameTriggers = nameTriggers;
		this.descriptions = descriptions;
		this.descTriggers = descTriggers;*/
		this.enterTrigger = enterTrigger;
	}
	
	public String getName (List<String> characteristics) {
		return names.getOutput(characteristics);
	}
	
	public String getDescription (List<String> characteristics) {
		/*List<String> itemDescriptions = extractNames(items);
		for (int i = 0; i < descTriggers.size(); i++) {
			if (itemDescriptions.contains(descTriggers.get(i))) {
				return descriptions.get(i);
			}
		}
		return descriptions.get(descriptions.size());*/
		return descriptions.getOutput(characteristics);
	}
	
	public Level getDestination (List<String> characteristics) {
		if (isEnterable(characteristics)) return destination;
		return null;
	}
	
	public boolean isEnterable (List<String> characteristics) {
		if (characteristics.contains(enterTrigger)) return true;
		return false;
	}
}
