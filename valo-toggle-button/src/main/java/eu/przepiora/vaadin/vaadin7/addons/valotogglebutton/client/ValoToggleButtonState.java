package eu.przepiora.vaadin.vaadin7.addons.valotogglebutton.client;

import com.vaadin.shared.ui.checkbox.CheckBoxState;

public class ValoToggleButtonState extends CheckBoxState {

	/**
	 * 
	 */
	private static final long serialVersionUID = 947456284106053767L;

	{
		primaryStyleName = "v-button";
	}
	
	//Below copied&pasted from ButtonState
    public boolean disableOnClick = false;
    public int clickShortcutKeyCode = 0;
    /**
     * If caption should be rendered in HTML
     */
    public boolean htmlContentAllowed = false;
    public String iconAltText = "";
}
