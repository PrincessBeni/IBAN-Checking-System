package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start(Stage mainStage) throws Exception {
            window = mainStage;
            window.setTitle("IBAN validation system");

            //Cells settings
            GridPane form = new GridPane();
            form.setPadding(new Insets(10, 10, 10, 10));
            form.setVgap(10);
            form.setHgap(10);

            //Give validation options
            Label validationType = new Label ("Choose the type of IBAN validation you want");
            GridPane.setConstraints(validationType, 0, 0);

            button = new Button("Validate one IBAN");
            GridPane.setConstraints(button, 2, 0);

            Button button2 = new Button ("Validate multiple IBAN");
            GridPane.setConstraints(button2, 2, 1 );

            form.getChildren().addAll(validationType, button, button2);


            button.setOnAction(e -> {
                try {
                    oneAccount.singleValidation("Single Validation page", "Validate one IBAN");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            button2.setOnAction(e -> {
                try {
                    multipleIbanValidation.multipleValidation("Multiple IBAN validation","Validate more than one IBAN");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            Scene scene = new Scene (form, 700, 700);
            window.setScene(scene);
            window.show();


            //close the window
            window.setOnCloseRequest(e -> {
                e.consume();
                closeApp();
            });
        }

        //Confirm close button
        private void closeApp(){
        Boolean yesOrNo = outcomeAlert.alert("Confirm to close", "Are you sure you want to close this application?");
        if (yesOrNo){
            window.close();
        }
    }

    }

