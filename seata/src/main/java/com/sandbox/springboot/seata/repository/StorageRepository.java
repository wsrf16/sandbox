package com.sandbox.springboot.seata.repository;


import com.sandbox.springboot.seata.model.Storage;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface StorageRepository extends JpaRepositoryImplementation<Storage, Integer> {
}
