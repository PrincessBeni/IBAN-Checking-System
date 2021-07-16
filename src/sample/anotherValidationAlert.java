package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class anotherValidationAlert {

    static boolean yesOrNo;
    public static boolean alert (String title, String message) {

        Stage window = new Stage();
        //close this window before getting access to the parent window again
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(500);
        window.setHeight(500);
        Label label = new Label();
        label.setText(message);

        //yes and no buttons
        Button yes = new Button ("Yes");
        Button no = new Button ("No");


        yes.setOnAction(e ->{
                yesOrNo = true;
                window.close();
        });

        no.setOnAction(e ->{
            thankYou.thanks("Validation Completed", "Thank you for using our IBAN validation system");
            yesOrNo = false;
            window.close();
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yes, no);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return yesOrNo;
    }
}
