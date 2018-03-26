package traffic.parking.merge;

import java.util.EventListener;

public interface MergeEventListener extends EventListener {
	
	public void mergeEventOccurred(MergeEvent evt);
}
