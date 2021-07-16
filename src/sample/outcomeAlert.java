package sample;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class outcomeAlert {
    static boolean yesOrNo;
    public static boolean alert (String title, String message) {

        Stage window = new Stage();
        //close this window before getting access to the parent window again
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(400);
        window.setHeight(400);
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
