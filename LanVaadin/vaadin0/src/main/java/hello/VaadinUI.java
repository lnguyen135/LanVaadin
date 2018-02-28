package hello;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class VaadinUI extends UI {

	
	private static final long serialVersionUID = 1L;

	private final CountrycodesRepository repo;

	private final CountrycodesEditor editor;

	final Grid<Countrycodes> grid;

	final TextField filter;

	private final Button addNewBtn;

	@Autowired
	public VaadinUI(CountrycodesRepository repo, CountrycodesEditor editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid<>(Countrycodes.class);
		this.filter = new TextField();
		this.addNewBtn = new Button("New Countrycodes", FontAwesome.PLUS);
	}

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("country_Name", "text_Description","html_Description", "image");

		filter.setPlaceholder("Filter by country_ID");

		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listCountrycodes(e.getValue()));

		// Connect selected Countrycodes to editor or hide if none is selected
		grid.asSingleSelect().addValueChangeListener(e -> {
			editor.editCountrycodes(e.getValue());
		});

		// Instantiate and edit new Countrycodes the new button is clicked
		addNewBtn.addClickListener(e -> editor.editCountrycodes(new Countrycodes(0L,"", "","", "")));

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listCountrycodes(filter.getValue());
		});

		// Initialize listing
		listCountrycodes(null);
	}

	// tag::listCountrycodess[]
	void listCountrycodes(String filterText) {
		if (StringUtils.isEmpty(filterText))	
		{
		ArrayList item = new ArrayList();
		for (Countrycodes c : repo.findAll()){
			item.add(c);
		}
			grid.setItems(item);
		}
		
	}
	// end::listCountrycodess[]

}
