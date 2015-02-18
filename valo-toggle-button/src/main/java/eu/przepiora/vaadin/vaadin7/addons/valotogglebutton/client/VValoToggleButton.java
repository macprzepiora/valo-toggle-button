package eu.przepiora.vaadin.vaadin7.addons.valotogglebutton.client;

import com.google.gwt.aria.client.Roles;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasValue;
import com.vaadin.client.ui.Field;
import com.vaadin.client.ui.VButton;
import com.vaadin.client.ui.aria.AriaHelper;
import com.vaadin.client.ui.aria.HandlesAriaInvalid;
import com.vaadin.client.ui.aria.HandlesAriaRequired;

public class VValoToggleButton extends VButton implements HandlesAriaInvalid,
		HandlesAriaRequired, Field, HasValue<Boolean>,
		IsEditor<LeafValueEditor<Boolean>> {

	private LeafValueEditor<Boolean> editor;
	private Boolean value = Boolean.FALSE;

	/** For internal use only. May be removed or replaced in the future. */
	public String id;

	public static final String CLASSNAME = VButton.CLASSNAME;
	private static final String CLASSNAME_PRESSED = "v-pressed";

	public VValoToggleButton() {
		super();
		setStyleName(CLASSNAME);
		Roles.getCheckboxRole().set(getElement());
	}

	@Override
	public void setAriaRequired(boolean required) {
		AriaHelper.handleInputRequired(this, required);
	}

	@Override
	public void setAriaInvalid(boolean invalid) {
		AriaHelper.handleInputInvalid(this, invalid);
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public void setValue(Boolean value) {
		setValue(value, false);
	}

	private void push() {
		value = true;
		addStyleName(CLASSNAME_PRESSED);
	}

	private void pop() {
		value = false;
		removeStyleName(CLASSNAME_PRESSED);
	}

	private void toggle() {
		if (value) { // the button is right now in 'down' state, so we need to
						// go to the normal state
			pop();
		} else { // the button is right now in normal state, so it should go to
					// the 'down' state
			push();
		}
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Boolean> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public void setValue(Boolean value, boolean fireEvents) {
		if (value == null) {
			value = Boolean.FALSE;
		}

		Boolean oldValue = getValue();
		if (value.equals(oldValue)) {
			return;
		}

		toggle(); // do the actual switch if the new value is different from the
					// old one

		if (fireEvents) {
			ValueChangeEvent.fire(this, value);
		}
	}

	@Override
	public LeafValueEditor<Boolean> asEditor() {
		if (editor == null) {
			editor = TakesValueEditor.of(this);
		}
		return editor;
	}

	@Override
	public void onBrowserEvent(Event e) {
		super.onBrowserEvent(e);
		if(value) {
			addStyleName(CLASSNAME_PRESSED);
		} else {
			removeStyleName(CLASSNAME_PRESSED);
		}
	}

}
