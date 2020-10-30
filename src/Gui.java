import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.*;

public class Gui extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Registration");

        Label label1 = new Label("General Admission Per Person $875: \t\t\t   ");
        TextField field1 = new TextField();
        field1.setPromptText("#");
        field1.setMaxWidth(30);

        HBox generalRegistration = new HBox(label1, field1);

        Label label2 = new Label("Student Admission Per Person $495: \t\t\t   ");
        TextField field2 = new TextField();
        field2.setPromptText("#");
        field2.setMaxWidth(30);

        HBox studentRegistration = new HBox(label2, field2);

        Label label3 = new Label("Opening Night Dinner + Keynote Speech $30:\t   ");
        TextField field3 = new TextField();
        field3.setPromptText("#");
        field3.setMaxWidth(30);

        HBox keynoteSpeech = new HBox(label3, field3);

        Label label4 = new Label("Introdution to E-commerce $295:\t\t\t\t   ");
        TextField field4 = new TextField();
        field4.setPromptText("#");
        field4.setMaxWidth(30);

        HBox eCommerce = new HBox(label4, field4);

        Label label5 = new Label("The Future of The Web $295:\t\t\t\t\t   ");
        TextField field5 = new TextField();
        field5.setPromptText("#");
        field5.setMaxWidth(30);

        HBox futureWeb = new HBox(label5, field5);

        Label label6 = new Label("Advanced Java Programming $395:\t\t\t   ");
        TextField field6 = new TextField();
        field6.setPromptText("#");
        field6.setMaxWidth(30);

        HBox advancedJava = new HBox(label6, field6);

        Label label7 = new Label("Network Security $395:\t\t\t\t\t\t   ");
        TextField field7 = new TextField();
        field7.setPromptText("#");
        field7.setMaxWidth(30);

        HBox networkSecurity = new HBox(label7, field7);

        TextField totalCost = new TextField();
        totalCost.setDisable(true);
        totalCost.setText("hi");

        Button button = new Button();
        button.setText("Calculate Total");

        Separator seperate = new Separator(Orientation.HORIZONTAL);


        VBox layout = new VBox(generalRegistration, studentRegistration, seperate,
                keynoteSpeech,  advancedJava, eCommerce, futureWeb, networkSecurity);
        layout.setPadding(new Insets(25));

        button.setOnAction(e -> {
            double total = Gui.calculateTotal(field1, field2, field3,
                    field4, field5, field6, field7);

            totalCost.setText("The total price is " + total);
        });

        VBox layoutTotal = new VBox(5);
        layoutTotal.setPadding(new Insets(10));
        layoutTotal.getChildren().addAll(button, totalCost);

        Text t = new Text();
        t.setText("Please Fill Out The Conference Registration Form Below\n");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(t);
        mainLayout.setLeft(layout);
        mainLayout.setBottom(layoutTotal);

        Scene scene = new Scene(mainLayout, 380, 325);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static double calculateTotal(TextField student, TextField general, TextField keynote,
                                        TextField java, TextField commerce, TextField web, TextField network) {
        double total = 0;

        int commerceTotal = Integer.parseInt(commerce.getText());
        int studentTotal = Integer.parseInt(student.getText());
        int generalTotal = Integer.parseInt(general.getText());
        int keynoteTotal = Integer.parseInt(keynote.getText());
        int networkTotal = Integer.parseInt(network.getText());
        int javaTotal = Integer.parseInt(java.getText());
        int webTotal = Integer.parseInt(web.getText());

        total += commerceTotal * 295;
        total += studentTotal * 495;
        total += generalTotal * 875;
        total += keynoteTotal * 30;
        total += networkTotal * 395;
        total += javaTotal * 395;
        total += webTotal * 295;

        return total;
    }

}