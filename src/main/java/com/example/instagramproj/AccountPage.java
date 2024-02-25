package com.example.instagramproj;

import com.example.instagramproj.Controller.AccountController;
import com.example.instagramproj.model.Account;
import com.example.instagramproj.model.Story;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AccountPage implements Initializable {

    public Circle circleProfile;
    public Text postNum;
    public Text followerNum;
    public Text followingNum;
    public Text bio;
    public HBox firstHboxRecent;
    public VBox recentActionVbox;
    public HBox posthbox;
    public VBox postVbox;
    public HBox highlightsHbox;
    public VBox firstVboxHighlight;
    public Circle newHighlighCircle;
    public Text addHighlightTxt;
    public Text feed;
    public Text explore;
    public Text reels;
    public Text logout;
    public HBox storyHbox;
    public VBox firstVboxStory;
    public Circle addStoryCircle;
    public Text addStoryTxt;
    public AnchorPane pane;
    @FXML
    private Circle circle;

    @FXML
    private Text name;

    @FXML
    private Text username;

    @FXML
    private VBox vboxProfile;
    @FXML
    private VBox mainVbox;
    public static Account account;
    public AccountController controller = new AccountController();

    private void setProfile(ImageView view, Account ac) {
        if (ac.getProfile() == null) {
            view.setImage(new Image("img.png"));
        } else {
            view.setImage(ac.getProfile());
        }
    }

    public void setCircleProfile(Circle c) {
        c = new Circle();
        c.setStroke(Color.BLACK);
        c.setFill(new ImagePattern(new Image("Picsart_23-01-09_19-06-30-016.jpg")));

        c.setEffect(new DropShadow(+25d, 0d, +2d, Color.GRAY));


    }

    public void setBio() {
        if (account.getBio() == null) {
            bio.setText("Click to write Bio!");
            bio.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    double x = bio.getX();
                    double y = bio.getY();
                    bio.setVisible(false);
                    VBox vBox1 = new VBox();
                    vBox1.setAlignment(Pos.TOP_CENTER);
                    vBox1.setSpacing(2);
                    TextField field = new TextField();
                    field.setPromptText("write about yourself: ");
                    Button btn = new Button("Done");
                    btn.setFont(Font.font("Tw Cen MT"));
                    vBox1.getChildren().addAll(field, btn);
                    mainVbox.getChildren().add(2, vBox1);
                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            account.setBio(field.getText());
                            bio.setText(account.getBio());
                            vBox1.setVisible(false);
                            bio.setVisible(true);

                        }
                    });

                }
            });
            mainVbox.getChildren().remove(2);
            mainVbox.getChildren().add(2, bio);
            mainVbox.setSpacing(5);
        } else {
            bio.setText(account.getBio());
        }
    }

    public void setAddHighligh(MouseEvent mouseEvent) {
        //  add story images to a dialog
        // 1303/22/22
        double x = addHighlightTxt.getLayoutX();
        double y = addHighlightTxt.getLayoutY();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        for (Story s : account.getArchiveStory()) {
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.setSpacing(2);
            ImageView view = new ImageView(s.getImage());
            view.setFitHeight(50);
            view.setFitWidth(50);
            Text text = new Text(s.getTime().getYear() + "/" + s.getTime().getMonthValue() + "/" + s.getTime().getDayOfMonth());
            vBox.getChildren().addAll(view, text);
            hBox.getChildren().add(vBox);
        }

        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setContent(hBox);
        scroll.setLayoutX(x);
        scroll.setLayoutY(y+260);
        pane.getChildren().add(scroll);


    }

    public void setAddStory(MouseEvent mouseEvent) {
        // TODO : choose image from file explore and add to it
        // todo : show other stories
    }

    public void seeFollowers(MouseEvent mouseEvent) {
        ScrollPane scroll = new ScrollPane();
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        HBox hBox = new HBox();
        scroll.setContent(hBox);
        hBox.setAlignment(Pos.CENTER_LEFT);
        for (Account ac : account.getFollowers()) {
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.TOP_LEFT);
            ImageView imgView = new ImageView();
            imgView.setFitWidth(50);
            imgView.setFitHeight(50);
            setProfile(imgView, ac);
            Button btn = new Button("remove");
            btn.setMinSize(40, 20);
            vBox.getChildren().addAll(imgView, new Text(ac.getUsername()), btn);
            vBox.setSpacing(3);
            hBox.getChildren().add(vBox);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    account.getFollowers().remove(ac);
                    ac.getFollowing().remove(account);
                    hBox.getChildren().remove(vBox);
                }
            });

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Your followers : ");
        alert.getDialogPane().getChildren().add(hBox);
        alert.getDialogPane().getChildren().get(3).setLayoutX(40);
        alert.getDialogPane().getChildren().get(3).setLayoutY(50);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println(account.getFollowers().size());
        } else {
            System.out.println("Hey done");
        }
        followerNum.setText(String.valueOf(account.getFollowers().size()));
    }

    public void seeFollowing(MouseEvent mouseEvent) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        for (Account ac : account.getFollowing()) {
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.TOP_LEFT);
            ImageView imgView = new ImageView();
            imgView.setFitWidth(20);
            imgView.setFitHeight(20);
            setProfile(imgView, ac);
            Button btn = new Button("unfollow");
            vBox.getChildren().addAll(imgView, new Text(ac.getUsername()), btn);
            vBox.setSpacing(3);
            hBox.getChildren().add(vBox);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    account.getFollowing().remove(ac);
                    ac.getFollowers().remove(account);
                    hBox.getChildren().remove(vBox);
                }
            });

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Your following : ");
        alert.getDialogPane().getChildren().add(hBox);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println(account.getFollowers().size());
        } else {
            System.out.println("Hey done");
        }
        followerNum.setText(String.valueOf(account.getFollowers().size()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Glow g = new Glow();
        g.setLevel(200);


        feed.setEffect(g);
        setCircleProfile(circle);
        setCircleProfile(newHighlighCircle);
        setCircleProfile(addStoryCircle);


        followerNum.setText(String.valueOf(account.getFollowers().size()));
        followingNum.setText(String.valueOf(account.getFollowing().size()));
        postNum.setText(String.valueOf(account.getPosts().size()));
        name.setText(account.getName());
        username.setText(account.getUsername());

        setBio();

        Story story = new Story(account);
        story.setImage(new Image("img.png"));
        story.setTime(LocalDateTime.now());
        account.getArchiveStory().add(story);


    }


}
