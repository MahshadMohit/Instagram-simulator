module com.example.instagramproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.instagramproj to javafx.fxml;
    exports com.example.instagramproj;
}