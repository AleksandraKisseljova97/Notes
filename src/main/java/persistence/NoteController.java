package persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static persistence.Main.ENTITY_MANAGER_FACTORY;

public class NoteController {


    private ObservableList<Note> notelist;

    public NoteController(){
        notelist = FXCollections.observableArrayList();
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT e FROM Notes e WHERE e.note_id IS NOT NULL";
        TypedQuery<Note> ps = entityManager.createQuery(strQuery, Note.class);
        try{
            List<Note> temporary = ps.getResultList();
            notelist.addAll(temporary);
        }finally {
            entityManager.close();
        }
    }

    public void addNote( String note_title, String note_content){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Note note = new Note(note_title, note_content);

        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(note);
            entityTransaction.commit();
        } finally {
            entityManager.close();
            notelist.add(note);
        }
    }

    public void updateNote(Note temporary){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        notelist.remove(temporary);


        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(temporary);
            entityTransaction.commit();
            notelist.add(temporary);
        }finally {
            entityManager.close();
        }
    }

    public  void removeNote(Note note){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        notelist.remove(note);
        Note note1;
        String text = note.getNoteTitle();
        String strQuery = "SELECT e FROM Notes e WHERE e.note_title=  :title";
        TypedQuery<Note> ps = entityManager.createQuery(strQuery, Note.class);
        ps.setParameter("titel",note.getNoteTitle());
        TypedQuery<Note> ps2 = entityManager.createQuery(strQuery,Note.class);

        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            note1 = entityManager.find(Note.class,note.getId());
            entityManager.remove(note1);
            entityTransaction.commit();
        }finally {
            entityManager.close();
        }

    }

    public Note getNote(int note_id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Note note = new Note();

        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            note = entityManager.find(Note.class,note_id);
        } finally {
            entityManager.close();
        } return note;
    }

    public  List<Note> getAllNotes(){
        EntityManager entityManager =   ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT e FROM Notes e WHERE e.note_id IS NOT NULL";
        TypedQuery<Note> ps = entityManager.createQuery(strQuery, Note.class);
        List<Note> temporary = new ArrayList<>();

        try {
            temporary = ps.getResultList();
            notelist.addAll(temporary);
            System.out.println(notelist.toString());
        }finally {
            entityManager.close();
        }return temporary;
    }

    public ObservableList <Note> getNote(){
        return notelist;
    }

}
