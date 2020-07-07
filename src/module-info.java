module m0604 {
	requires com.google.gson;
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;

	opens jp.ac.kcg.E19C4019 to
		javafx.graphics, javafx.fxml, javafx.base;
	opens com.heartrails to
		javafx.base, com.google.gson;
}