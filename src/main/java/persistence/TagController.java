package persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static persistence.Main.ENTITY_MANAGER_FACTORY;

public class TagController {
    private ObservableList<Tag> tagsList;

    public TagController(){
        tagsList = FXCollections.observableArrayList();
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT e FROM Tag e WHERE e.tag_content IS NOT NULL";
        TypedQuery<Tag> ps = entityManager.createQuery(strQuery, Tag.class);
        try{
            List<Tag> temporary = ps.getResultList();
            tagsList.addAll(temporary);
        }finally {
            entityManager.close();
        }
    }

    public void addTag(String tag_content){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Tag tag = new Tag(tag_content);

        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(tag);
            entityTransaction.commit();
        } finally {
            entityManager.close();
            tagsList.add(tag);
        }
    }

    public  void removeTag(Tag tag){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        tagsList.remove(tag);
        Tag tag1;
        String text = tag.getTagContent();
        String strQuery = "SELECT e FROM Tag e WHERE e.tag_content=  :title";
        TypedQuery<Tag> ps = entityManager.createQuery(strQuery, Tag.class);
        ps.setParameter("titel",tag.getTagContent());
        TypedQuery<Tag> ps2 = entityManager.createQuery(strQuery,Tag.class);

        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            tag1 = entityManager.find(Tag.class,tag.getId());
            entityManager.remove(tag1);
            entityTransaction.commit();
        }finally {
            entityManager.close();
        }

    }

    public Tag getTag(int tag_id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Tag tag = new Tag();

        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            tag = entityManager.find(Tag.class,tag_id);
        } finally {
            entityManager.close();
        } return tag;
    }

    public  List<Tag> getAllTags(){
        EntityManager entityManager =   ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT e FROM Tag e WHERE e.tag_id IS NOT NULL";
        TypedQuery<Tag> ps = entityManager.createQuery(strQuery, Tag.class);
        List<Tag> temporary = new ArrayList<>();

        try {
            temporary = ps.getResultList();
            tagsList.addAll(temporary);
            System.out.println(tagsList.toString());
        }finally {
            entityManager.close();
        }return temporary;
    }

    public ObservableList <Tag> getTags(){
        return tagsList;
    }
}
