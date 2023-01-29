package persistence;

import javax.persistence.*;

@Entity(name = "Tag")
@Table(name = "tags", schema = "notes")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false)
    private Integer id;

    @Column(name = "tag_content", length = 100)
    private String tagContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    public Tag (){}
    public Tag (String tagContent){
        this.tagContent = tagContent;
    }

    public void uppdateTag (String tagContent){
        this.tagContent = tagContent;

    }


}