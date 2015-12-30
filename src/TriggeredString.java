import java.util.List;

public class TriggeredString {
	private List<String> output;
	private List<String> triggers;
	
	public TriggeredString (List<String> output, List<String> triggers) throws Exception {
		if (triggers.size() == output.size()) {
			this.output = output;
			this.triggers = triggers;
		}
		else {
			throw new Exception ("need to have same number of descriptions and triggers");
		}
	}
	
	public String getOutput (List<String> characteristics) {
		for (int i = 0; i < triggers.size(); i++) {
			if (characteristics.contains(triggers.get(i))) {
				return output.get(i);
			}
		}
		return output.get(output.size() - 1);
	}
}
