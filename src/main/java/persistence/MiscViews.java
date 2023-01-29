/*package persistence;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MiscViews {
    private BorderPane root2Scene;
    private VBox optionsVBox;
    private Button newnote, deletenote, updatenote, addtag,deletetag;
    private Label lablel;
    private TextField userTF, userTFSecondScene;
    private Stage popupWindow;
    private HBox top;
    private NoteController controller;
    private BorderPane startRoot;
    private TableView<Note> table;
    private TableColumn<Note, String> noteTitleColumn;
    private TableColumn<Note, String> noteContentColumn;

    public MiscViews(TextField daUserTF) throws IOException {
        this.userTF = daUserTF;
        buildUI();


    }
    public void buildUI() {
        controller = new NoteController();


        table = new TableView<Note>();
        startRoot = new BorderPane();
        table.setPrefSize(200, 300);

        newnote = new Button("New note");
        //newnote.setOnAction(this::newnotePressed);

        deletenote = new Button("Delete note");
        //deletenote.setOnAction(this::deletenotePressed);

        top = new HBox();
        top.setSpacing(15);
        top.getChildren().addAll(newnote, deletenote);

        noteTitleColumn = new TableColumn<Note, String>("Title");
        noteTitleColumn.setCellValueFactory(new PropertyValueFactory<Note, String>("Title of the note"));

        TableColumn<Note, String> noteContentColumn = new TableColumn<Note, String>("Content");
        noteContentColumn.setCellValueFactory(new PropertyValueFactory<Note, String>("Content of the note"));



        table.getColumns().addAll(noteTitleColumn, noteContentColumn);
        table.setItems(controller.getNote());
        table.setFocusTraversable(false);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        startRoot.setTop(top);

        startRoot.setCenter(table);

    }

    public BorderPane getRoot2Scene() {
        return root2Scene;
    }

    public void setRoot2Scene(BorderPane root2Scene) {
        this.root2Scene = root2Scene;
    }

    public VBox getOptionsVBox() {
        return optionsVBox;
    }

    public void setOptionsVBox(VBox optionsVBox) {
        this.optionsVBox = optionsVBox;
    }

    public Button getNewnote() {
        return newnote;
    }

    public void setNewnote(Button newnote) {
        this.newnote = newnote;
    }

    public Button getDeletenote() {
        return deletenote;
    }

    public void setDeletenote(Button deletenote) {
        this.deletenote = deletenote;
    }

    public Button getUpdatenote() {
        return updatenote;
    }

    public void setUpdatenote(Button updatenote) {
        this.updatenote = updatenote;
    }

    public Button getAddtag() {
        return addtag;
    }

    public void setAddtag(Button addtag) {
        this.addtag = addtag;
    }

    public Button getDeletetag() {
        return deletetag;
    }

    public void setDeletetag(Button deletetag) {
        this.deletetag = deletetag;
    }

    public Label getLablel() {
        return lablel;
    }

    public void setLablel(Label lablel) {
        this.lablel = lablel;
    }

    public TextField getUserTF() {
        return userTF;
    }

    public void setUserTF(TextField userTF) {
        this.userTF = userTF;
    }

    public TextField getUserTFSecondScene() {
        return userTFSecondScene;
    }

    public void setUserTFSecondScene(TextField userTFSecondScene) {
        this.userTFSecondScene = userTFSecondScene;
    }

    public Stage getPopupWindow() {
        return popupWindow;
    }

    public void setPopupWindow(Stage popupWindow) {
        this.popupWindow = popupWindow;
    }

    public HBox getTop() {
        return top;
    }

    public void setTop(HBox top) {
        this.top = top;
    }

    public NoteController getController() {
        return controller;
    }

    public void setController(NoteController controller) {
        this.controller = controller;
    }

    public BorderPane getStartRoot() {
        return startRoot;
    }

    public void setStartRoot(BorderPane startRoot) {
        this.startRoot = startRoot;
    }

    public TableView<Note> getTable() {
        return table;
    }

    public void setTable(TableView<Note> table) {
        this.table = table;
    }

    public TableColumn<Note, String> getNoteTitleColumn() {
        return noteTitleColumn;
    }

    public void setNoteTitleColumn(TableColumn<Note, String> noteTitleColumn) {
        this.noteTitleColumn = noteTitleColumn;
    }

    public TableColumn<Note, String> getNoteContentColumn() {
        return noteContentColumn;
    }

    public void setNoteContentColumn(TableColumn<Note, String> noteContentColumn) {
        this.noteContentColumn = noteContentColumn;
    }
}*/
