/*package persistence;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

;

public class notesView extends VBox {
    private BorderPane pane; // my body
    private TableView<Note> table;
    private TableColumn<Note, String> noteTitleColumn;
    private TableColumn<Note, String> noteContentColumn;
    private TextField noteTitle, noteContent;
    private Button add;
    private Button delete;
    private Button edit;
    private HBox top;
    private NoteController controller;

    private Stage popupWindow;

    public notesView() {
        buildUI();
    }

    private void buildUI() {
        controller = new NoteController();
        table = new TableView<Note>();
        pane = new BorderPane();
        add = new Button("Add");
        delete = new Button("Delete");
        edit = new Button("Edit");
        pane.setPrefSize(450, 300);
        table.setPrefSize(300, 200);

        add.setOnAction(this::addButtonPressed);
        add.setPrefSize(50, 50);
        delete.setPrefSize(50, 50);
        delete.setOnAction(this::removeButtonPressed);
        edit.setPrefSize(50, 50);
        edit.setOnAction(this::editButtonPressed);

        top = new HBox();
        top.setSpacing(15);
        top.getChildren().addAll(add, delete, edit);

        noteTitleColumn = new TableColumn<Note, String>("Note title");
        noteTitleColumn.setCellValueFactory(new PropertyValueFactory<Note, String>("Note title"));

        noteContentColumn = new TableColumn<Note, String>("Note content");
        noteContentColumn.setCellValueFactory(new PropertyValueFactory<Note, String>("Note content"));

        table.getColumns().addAll(noteTitleColumn, noteContentColumn);
        table.setItems(controller.getNote());
        table.setFocusTraversable(false);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        pane.setTop(top);
        pane.setCenter(table);
    }



    public BorderPane getPane() {
        return pane;
    }

    public void addAll(ObservableList<Note> list) {
        table.setItems(list);
    }

    private void addButtonPressed(javafx.event.ActionEvent event) {
        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Formulär?");
        popupWindow.setMinHeight(250);
        popupWindow.setMinWidth(200);
        noteTitle = new TextField();
        noteContent = new TextField();
        noteTitle.setPromptText("Note title");
        noteContent.setPromptText("Note content");

        Button Submit = new Button("Submit");
        Submit.setOnAction(this::register);

        Label popupLabel = new Label();
        popupLabel.setText("Are you sure?");
        Button nejButton = new Button("No");
        nejButton.setOnAction(e -> popupWindow.close()); //Stänger ned popup-rutan

        Button jaButton = new Button("Yes");
        jaButton.setOnAction(e -> {
            popupWindow.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(Submit, noteTitle, noteContent);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        popupWindow.setScene(scene);
        popupWindow.show();
    }

    public void removeButtonPressed(javafx.event.ActionEvent event) {
        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Warning");
        popupWindow.setMinHeight(50);
        popupWindow.setMinWidth(280);
        TextField tf = new TextField();
        tf.setText("Are you sure you want to delete selected item?");
        tf.setEditable(false);
        tf.setPrefHeight(30);
        tf.setPrefWidth(260);


        Button yes = new Button("yes");
        yes.setOnAction(this::remove);
        yes.setPrefSize(50, 50);
        Button no = new Button("no");
        no.setPrefSize(50, 50);
        no.setOnAction(e -> popupWindow.close());
        Button filler = new Button();
        filler.setPrefSize(13, 13);
        filler.setVisible(false);


        HBox box = new HBox();
        box.setPrefSize(100, 200);
        box.setSpacing(50);

        box.getChildren().addAll(filler, no, yes);
        BorderPane pane = new BorderPane();

        pane.setBottom(box);
        pane.setCenter(tf);
        Scene scene = new Scene(pane, 100, 200);
        popupWindow.setScene(scene);
        popupWindow.show();

    }

    public void register(javafx.event.ActionEvent e) {
        controller.addNote(noteTitle.getText(), noteContent.getText());
        popupWindow.close();
    }

    public void remove(javafx.event.ActionEvent e) {
        Note note = table.getSelectionModel().getSelectedItem();
        if (note != null) {
            try {
                int i = note.getId();
            } catch (NullPointerException a) {
                System.out.println("Test");
                System.out.println(note.getId() + " " + note.getNoteTitle());

                controller.removeNote(note);
            }
            popupWindow.close();
        }
    }
    public void editButtonPressed(javafx.event.ActionEvent e){
        Note note = table.getSelectionModel().getSelectedItem();
        if(note != null) {
            popupWindow = new Stage();
            popupWindow.initModality(Modality.APPLICATION_MODAL);
            popupWindow.setTitle("Formulär?");
            popupWindow.setMinHeight(300);
            popupWindow.setMinWidth(200);
            VBox box = new VBox();
            noteTitle = new TextField(note.getNoteTitle());
            noteContent = new TextField(note.getNoteContent());
            Button submit = new Button("Submit");
            submit.setOnAction(this::uppdate);
            box.getChildren().addAll(noteTitle,noteContent);
            Scene scene = new Scene(box,200,300);
            popupWindow.setScene(scene);
            popupWindow.show();

        }

    }
    public void uppdate(javafx.event.ActionEvent e){
        table.getSelectionModel().getSelectedItem().updateNote(noteTitle.getText(),noteContent.getText());
        controller.updateNote(table.getSelectionModel().getSelectedItem());
        popupWindow.close();
    }

}*/