package org.cytoscape.view.presentation.customgraphics;

import java.awt.Image;
import java.util.List;

import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.model.CyNetwork;


/**
 * Base interface for all Custom Graphics.  Fundamentally, a {@link CyCustomGraphics}
 * object is a container for one or more {@link CustomGraphicLayer} objects.  It is
 * the layer objects that will actually create the graphics that are used by the
 * renderer.
 * @CyAPI.Spi.Interface
 * @CyAPI.InModule presentation-api
 */
public interface CyCustomGraphics<T extends CustomGraphicLayer> {
		
	/**
	 * Immutable session-unique identifier of this custom graphic generated by the 
	 * custom graphics manager.  If this returns null, the custom graphics manager 
	 * will generate a new identifier when this custom graphics is added.
	 * 
	 * @return Immutable ID as Long.
	 */
	public Long getIdentifier();
		
	/**
	 * Set the session-unique identifier of this custom graphics.  This method is used by
	 * the renderer to track custom graphics objects for serialization/deserialization.  Your
	 * implementation should not generate or set this value.
	 * 
	 * @param id Immutable ID as Long.
	 */
	public void setIdentifier(Long id);
	
	/**
	 * Display name is a simple description of this image object.  For discrete mappings, this
	 * is the name that the user will see.
	 * 
	 * @return display name as String.
	 */
	public String getDisplayName();
	
	
	/**
	 * Set human readable display name.
	 * 
	 * @param displayName
	 */
	public void setDisplayName(final String displayName);
	
	/**
	 * Generate a string suitable for serializing the state of this
	 * custom graphic.  Note that the first part of this
	 * <b>must</b> be the class of the implementing object followed by a 
	 * comma.  This is used by the deserialization logic to recreate the
	 * factory objects that are used for discrete mappings.  If your implementation
	 * doesn't support discrete mappings, just return null.  This method is the
	 * mirror of {@link CyCustomGraphicsFactory#parseSerializableString()}.
	 * 
	 * @return serialized custom graphic state, or null if discrete mappings aren't supported
	 */
	public String toSerializableString();
	
	/**
	 * Get layers that belong to this object.  Get the list of layers to be rendered.  Each
	 * layer is rendered in list order, which means that the layers at the end of the list are
	 * rendered last, and are therefore on top.  The {@link CyNetwork} and {@link CyIdentifiable}
	 * graph object are passed in case there is information about the network that is required
	 * to render the layer.  For example, a pie chart layer might need to extract data from the
	 * {@link CyRow} for this graph object.  For other layer types, this can be safely ignored.
	 * 
	 * @param network the network the Renderer is rendering
	 * @param grObject the graph object the Renderer is rendering (currently only nodes are supported)
	 * @return List of layer objects
	 * 
	 */
	public List<T> getLayers(CyNetwork network, CyIdentifiable grObject);
	
	
	/**
	 * Returns width of current object.
	 * 
	 * @return the current width
	 */
	public int getWidth();
	
	
	/**
	 * Returns height of current object.
	 * 
	 * @return the height of the current object
	 */
	public int getHeight();
	
	
	/**
	 * Set width of Custom Graphics. This is used by discrete mappers to support the creation
	 * of a sample image.
	 * 
	 * @param width
	 */
	public void setWidth(final int width);
	
	/**
	 * Set height of Custom Graphics. This is used by discrete mappers to support the creation
	 * of a sample image.
	 * 
	 * @param height
	 */
	public void setHeight(final int height);
	
	/**
 	 * Get the fit ratio for this custom graphic.  This is used to set the proportion of the 
 	 * node to fill when sizing the graphic.  For example, if your custom graphic should leave
 	 * a border round the fill, set this to &lt;1 -- if you want your cutom graphic to be
 	 * larger than the node, set this to &gt; 1.
 	 *
 	 * @return the fit ratio
 	 */
	public float getFitRatio();


	/**
 	 * Set the fit ratio for this custom graphic.
 	 *
 	 * @param ratio the fit ratio
 	 */
	public void setFitRatio(float ratio);
	
	/**
	 * From layers of graphics objects, render a composite scaled Image object.
	 * Usually, the image returned by this method is used in GUI components (as icons).
	 * 
	 * @return rendered image object.
	 */
	public Image getRenderedImage();
}
