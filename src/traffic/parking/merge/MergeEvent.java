package traffic.parking.merge;

import java.util.EventObject;

public class MergeEvent extends EventObject {

	public MergeEvent(Object source, String message) {
		super(source);
		this.message = message+"\n";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}
	
}
