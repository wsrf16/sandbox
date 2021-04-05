package com.sandbox.springboot.db.Service;

import com.sandbox.springboot.db.Entity.BookStore;
import com.sandbox.springboot.db.Repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public class BookStoreService {
    @Autowired(required = false)
    private BookStoreRepository bookStoreRepository;

    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
    public String save(BookStore bookStore) {
        bookStoreRepository.save(bookStore);
        return "结果" + bookStore.getId();
    }

    // 分页
    public List<BookStore> page(Integer size, Integer page) {
        Pageable pageable = new PageRequest(page, size, new Sort("Id"));
        List<BookStore> ret = bookStoreRepository.findAll();
        return ret;
    }
}
