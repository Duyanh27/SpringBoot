//package org.example.demo3.infrastructure.repository;
//
//import org.example.demo3.domain.User;
//import org.example.demo3.domain.repository.UserRepository;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.example.demo3.domain.repository.UserRepositoryCustom;
//
//import java.util.List;
//
//public class UserRepositoryImpl implements UserRepositoryCustom {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<User> customMethod() {
//        // Example of a custom query using EntityManager
//        return entityManager.createQuery("SELECT u FROM User u WHERE u.condition = :condition", User.class)
//                .setParameter("condition", true)
//                .getResultList();
//    }
//}
