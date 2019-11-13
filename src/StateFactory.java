/**
 * @author D'Artagnan Wake
 */

// Interface?
public class StateFactory {


	public static final State createNewState() {
		return new State();
	}

	public static final State fromState(State oldState) {
		return new State(oldState);
	}


}
