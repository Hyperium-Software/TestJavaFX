import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class program extends Application {
    BorderPane borderPane = new BorderPane();

    public Parent createContent(Stage frame) {
        FileChooser fileChooser = new FileChooser();
        DirectoryChooser directoryChooser = new DirectoryChooser();

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        menuBar.getMenus().add(file);
        borderPane.setTop(new VBox(menuBar));

        MenuItem openFile = new MenuItem("Open File...");
        MenuItem openFolder = new MenuItem("Open Folder...");
        MenuItem settings = new MenuItem("Settings");
        MenuItem exit = new MenuItem("Exit");

        file.getItems().addAll(openFile, openFolder, new SeparatorMenuItem(), settings, new SeparatorMenuItem(), exit);

        openFile.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(frame);
        });

        openFolder.setOnAction(e -> {
            File selectedDirectory  = directoryChooser.showDialog(frame);
        });

        exit.setOnAction(e -> frame.close());

        return borderPane;
    }

    @Override
    public void start(Stage frame) throws Exception {
        frame.setTitle("Application");
        frame.setScene(new Scene(createContent(frame), 500, 500));
        frame.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
