module com.example.instagramproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.instagramproj to javafx.fxml;
    exports com.example.instagramproj;
}