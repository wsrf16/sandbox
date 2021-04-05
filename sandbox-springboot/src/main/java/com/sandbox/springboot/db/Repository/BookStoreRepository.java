package com.sandbox.springboot.db.Repository;

import com.sandbox.springboot.db.Entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookStoreRepository extends JpaRepository<BookStore, Integer> {
//        @Override
//    public <S extends T> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public BookStore findOne(int i) {
//        return null;
//    }
//
//    @Override
//    public List<BookStore> findAll() {
//        return null;
//    }
//
//    @Override
//    public void delete(int i) {
//
//    }
//
//
//    @Query(value = "select * from book_store", nativeQuery = true)
//    public List<BookStore> findAll();
}
