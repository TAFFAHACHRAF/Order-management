package presentation;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root= FXMLLoader.load(getClass().getResource("presebtation.view.clientView.fxml"));
        Scene scene=new Scene(root,400,400);
        primaryStage.setTitle("Clients");
        primaryStage.setScene(scene);
        primaryStage.show();

        BorderPane root= FXMLLoader.load(getClass().getResource("presebtation.view.produitView.fxml"));
        Scene scene=new Scene(root,400,400);
        primaryStage.setTitle("Clients");
        primaryStage.setScene(scene);
        primaryStage.show();


        BorderPane root= FXMLLoader.load(getClass().getResource("presebtation.view.commandeView.fxml"));
        Scene scene=new Scene(root,400,400);
        primaryStage.setTitle("Clients");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}