package eu.przepiora.vaadin.vaadin7.addons.valotogglebutton;

import com.vaadin.data.Property;
import com.vaadin.ui.CheckBox;

import eu.przepiora.vaadin.vaadin7.addons.valotogglebutton.client.ValoToggleButtonState;

// This is the server-side UI component that provides public API 
// for ToggleButton
public class ValoToggleButton extends CheckBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8050666306123685852L;

	public ValoToggleButton() {
		super();
	}

	public ValoToggleButton(String caption, boolean initialState) {
		super(caption, initialState);
	}

	public ValoToggleButton(String caption, Property<?> dataSource) {
		super(caption, dataSource);
	}

	public ValoToggleButton(String caption) {
		super(caption);
	}

	public void setHtmlContentAllowed(boolean htmlAllowed) {
    	getState().htmlContentAllowed = htmlAllowed;
    }
	
	public boolean isHtmlContentAllowed() {
		return getState(false).htmlContentAllowed;
	}

	@Override
	protected ValoToggleButtonState getState() {
		return (ValoToggleButtonState) super.getState();
	}
	
	@Override
	protected ValoToggleButtonState getState(boolean markAsDirty) {
		return (ValoToggleButtonState) super.getState(markAsDirty);
	}

}
