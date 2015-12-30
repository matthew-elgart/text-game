import java.util.ArrayList;
import java.util.List;

public class Protagonist {
	private List<Characteristic> characteristics;
	
	public Protagonist () {
		characteristics = new ArrayList<Characteristic>();
		characteristics.add(new Characteristic("true"));
	}
	
	public void addCharacteristic (Characteristic c) {
		if (!characteristics.contains(c)) characteristics.add(c);
	}
	
	public List<Characteristic> getCharacteristics () {
		return characteristics;
	}
	
	public List<Item> getItems () {
		List<Item> result = new ArrayList<Item>();
		for (Characteristic c : characteristics) {
			if (c instanceof Item) result.add((Item) c);
		}
		return result;
	}
}
