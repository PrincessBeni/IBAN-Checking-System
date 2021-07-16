package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class oneAccount {

    public static void singleValidation (String title, String message) throws Exception {
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();
        label.setText(message);

        //Cells settings
        GridPane form = new GridPane();
        form.setPadding(new Insets(10, 10, 10, 10));
        form.setVgap(10);
        form.setHgap(10);

        //Create form
        //Form text
        Label iban = new Label("Input IBAN:");
        GridPane.setConstraints(iban, 0, 0);

        //Form itself
        TextField inputIban = new TextField();
        GridPane.setConstraints(inputIban, 1, 0);

        Button button = new Button("Click to validate");
        GridPane.setConstraints(button, 1, 1);

        Button button2 = new Button("Back");
        GridPane.setConstraints(button2, 1, 2);

        form.getChildren().addAll(iban, inputIban, button, button2);


        button.setOnAction(e -> {
            String userInput = String.valueOf(inputIban.getText());
            String accepted = userInput;
            System.out.println(accepted);
            ibanCheckingFunctionality.testIban(accepted);
        });


        //close window if back button is clicked
        button2.setOnAction(e -> {
            window.close();
        });

        Scene scene = new Scene(form, 600, 600);
        window.setScene(scene);
        window.show();


    }
}
