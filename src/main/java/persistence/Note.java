package persistence;

import javax.persistence.*;

@Entity(name = "Note")
@Table(name = "notes", schema = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id", nullable = false)
    private Integer id;

    @Column(name = "note_title", length = 100)
    private String noteTitle;

    @Column(name = "note_content", length = 300)
    private String noteContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Note (){}
    public Note (String noteTitle, String noteContent){
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public void updateNote (String noteTitle, String noteContent){
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;

    }

}