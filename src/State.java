import java.util.HashMap;

/**
 * @author D'Artagnan Wake
 */
final class State {

	// -------------------- Private --------------------

	private HashMap<Integer, Integer> state;

	// -------------------- Constructors --------------------

	State() {
		state = new HashMap<>();
	}

	State(State initialState) {
		state = initialState.getState();
	}


	public HashMap<Integer, Integer> getState() {
		return state;
	}
}
