package jp.ac.kcg.E19C4019;


import java.util.List;

import com.heartrails.Area;
import com.heartrails.Response;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HR01Controller {
	@FXML
    private TextField tf;

    @FXML
    private TableView<Area> tv;

    @FXML
    private TableColumn<Area, String> postal;

    @FXML
    private TableColumn<Area, String> prefecture;

    @FXML
    private TableColumn<Area, String> city;

    @FXML
    private TableColumn<Area, String> city_kana;

    @FXML
    private TableColumn<Area, String> town;

    @FXML
    private TableColumn<Area, String> town_kana;

    @FXML
    private TableColumn<Area, String> x;

    @FXML
    private TableColumn<Area, String> y;

    @FXML
    protected void initialize() {
    	postal.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("postal"));
    	prefecture.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("prefecture"));
    	city.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("city"));
    	city_kana.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("city_kana"));
    	town.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("town"));
    	town_kana.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("town_kana"));
    	x.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("x"));
    	y.setCellValueFactory(
    			new PropertyValueFactory<Area, String>("y"));
    }


    @FXML
    void doSearch(ActionEvent event) {
    	ObservableList<Area> model = tv.getItems();
    	model.clear();

    	String key = tf.getText();
    	Response response = HRJson.search(key);
    	List<Area> location = response.getLocation();
    	if(location != null) {
    		model.addAll(location);
    	}
    }
}
