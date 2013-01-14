package org.cytoscape.group.events;


import org.cytoscape.event.CyListener;

/**
 * Listener for {@link GroupAboutToBeDestroyedEvent}
 * @CyAPI.Spi.Interface
 * @CyAPI.InModule group-api
 */
public interface GroupAboutToBeDestroyedListener extends CyListener {
	/**
	 * The method that should handle the specified event.
	 * @param e The event to be handled.
	 */
	public void handleEvent(GroupAboutToBeDestroyedEvent e);
}
