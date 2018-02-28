package hello;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * A simple example to introduce building forms. As your real application is probably much
 * more complicated than this example, you could re-use this form in multiple places. This
 * example component is only used in VaadinUI.
 * <p>
 * In a real world application you'll most likely using a common super class for all your
 * forms - less code, better UX. See e.g. AbstractForm in Viritin
 * (https://vaadin.com/addon/viritin).
 */

@SpringComponent
@UIScope
public class CountrycodesEditor extends VerticalLayout {

		private final CountrycodesRepository repository;

		/**
		 * The currently edited customer
		 */
		private Countrycodes countrycodes;

		/* Fields to edit properties in Countrycodes entity */
	//	TextField country_ID = new TextField("country_ID ");
		
		TextField country_Name = new TextField("country_Name");
		TextField text_Description = new TextField("text_Description");
		TextField html_Description = new TextField("html_Description");
		//TextField image= new TextField("image");
		/* Action buttons */
		Button save = new Button("Save", FontAwesome.SAVE);
		Button cancel = new Button("Cancel");
		Button delete = new Button("Delete", FontAwesome.TRASH_O);
		CssLayout actions = new CssLayout(save, cancel, delete);

		Binder<Countrycodes> binder = new Binder<>(Countrycodes.class);

		@Autowired
		public CountrycodesEditor(CountrycodesRepository repository) {
			this.repository = repository;

			addComponents(country_Name, text_Description,html_Description,  actions );

			// bind using naming convention
			binder.bindInstanceFields(this);
			/*
			binder.forField ( meal_price ) 
      	  .withNullRepresentation( "" )
            .withConverter ( new StringToBigDecimalConverter(new BigDecimal(10.00), "Price must be in ##.## format"))
            .bind ( MealTbl:: getMealPrice, MealTbl:: setMealPrice );
      */
			
			

			// Configure and style components
			setSpacing(true);
			actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
			save.setStyleName(ValoTheme.BUTTON_PRIMARY);
			save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

			// wire action buttons to save, delete and reset
			save.addClickListener(e -> repository.save(countrycodes));
			delete.addClickListener(e -> repository.delete(countrycodes));
			cancel.addClickListener(e -> editCountrycodes(countrycodes));
			setVisible(false);
		}

		public interface ChangeHandler {

			void onChange();
		}

		public final void editCountrycodes(Countrycodes c) {
			if (c == null) {
				setVisible(false);
				return;
			}
			final boolean persisted = c.getCountry_ID() != 0;
			if (persisted) {
				// Find fresh entity for editing
				countrycodes = repository.findOne((long) c.getCountry_ID());
			}
			else {
				countrycodes = c;
			}
			cancel.setVisible(persisted);

			// Bind customer properties to similarly named fields
			// Could also use annotation or "manual binding" or programmatically
			// moving values from fields to entities before saving
			binder.setBean(countrycodes);

			setVisible(true);

			// A hack to ensure the whole form is visible
			save.focus();
			// Select all text in firstName field automatically
			country_Name.selectAll();
		}

		public void setChangeHandler(ChangeHandler h) {
			// ChangeHandler is notified when either save or delete
			// is clicked
			save.addClickListener(e -> h.onChange());
			delete.addClickListener(e -> h.onChange());
		}

	}


