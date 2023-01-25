module maera {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jsoup;
	requires javafx.base;
	
	opens main to javafx.graphics, javafx.fxml;
}
