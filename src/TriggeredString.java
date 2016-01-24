import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TriggeredString {
	//private List<String> output;
	//private List<String> triggers;
	private Map<String, String> map;
	
	public TriggeredString (List<String> output, List<String> triggers) throws Exception {
		map = new LinkedHashMap<String, String>();
		if (triggers.size() == output.size()) {
			/*this.output = output;
			this.triggers = triggers;*/
			for (int i = 0; i < output.size(); i++) {
				map.put(triggers.get(i), output.get(i));
			}
		}
		else {
			throw new Exception ("need to have same number of descriptions and triggers");
		}
	}
	
	public TriggeredString (LinkedHashMap<String, String> map) {
		this.map = map;
	}
	
	public String getOutput (List<String> characteristics) {
		/*for (int i = 0; i < triggers.size(); i++) {
			if (characteristics.contains(triggers.get(i))) {
				return output.get(i);
			}
		}
		return output.get(output.size() - 1);*/
		for (String trigger : map.keySet()) {
			if (characteristics.contains(trigger)) {
				return map.get(trigger);
			}
		}
		return null;
	}
}
