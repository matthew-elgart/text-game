import java.util.ArrayList;
import java.util.List;

public class Item extends Characteristic {
	/*private List<String> descriptions;
	private List<String> descTriggers;*/
	private TriggeredString descriptions;
	private String takeTrigger;
	
	public Item (String name, List<String> descriptions, List<String> dependencies, String takeable) throws Exception {
		super(name);
		/*this.descriptions = descriptions;
		this.descTriggers = dependencies;*/
		this.descriptions = new TriggeredString(descriptions, dependencies);
		takeTrigger = takeable;
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
	
	public boolean isTakeable (List<String> characteristics) {
		if (characteristics.contains(takeTrigger)) return true;
		return false;
	}
}
