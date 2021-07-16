package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class multipleIbanValidation {
    public static void multipleValidation (String title, String message) throws Exception {
        List<String> user_input = new ArrayList<>();
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

        //Form
        //Form text
        Label iban = new Label("Input IBANs:");
        GridPane.setConstraints(iban, 0, 0);

        //Form itself
        TextField inputIban = new TextField();
        GridPane.setConstraints(inputIban, 1, 0);

        Button button0 = new Button("Add IBAN");
        GridPane.setConstraints(button0, 1, 1);

        Button button1 = new Button("Click to validate");
        GridPane.setConstraints(button1, 1, 2);

        Button button2 = new Button("Back");
        GridPane.setConstraints(button2, 1, 3);

        form.getChildren().addAll(iban, inputIban, button0, button1, button2);


        //add multiple iban to list
        button0.setOnAction(e -> {
            String userInput = String.valueOf(inputIban.getText());
            String accepted = userInput;
            user_input.add(accepted);
            inputIban.clear();
        });


        button1.setOnAction(e -> {

            System.out.println(user_input);
            multipleIbanCheckingFunctionality.testMultipleIban(user_input);
        });


        //close window if back button is clicked
        button2.setOnAction(e -> window.close());

        Scene scene = new Scene(form, 600, 600);
        window.setScene(scene);
        window.show();

    }


}
