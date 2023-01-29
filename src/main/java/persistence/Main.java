package persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class Main {

    protected static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Notes");
    //static Graphics graphics;

    public static void main(String[] args)  throws IOException {
       // graphics = new Graphics();

    }
/*
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = graphics.start();
        primaryStage.show();
    }*/
}
