package com.company.dao.inter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "123456";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

    private static EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("org.example_ResumeDbApp_jar_1.0-SNAPSHOTPU");
        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public void closeEmf() {
        emf.close();
    }
}
