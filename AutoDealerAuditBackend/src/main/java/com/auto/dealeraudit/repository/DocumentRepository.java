package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.Document;


@Repository 
public interface DocumentRepository extends JpaRepository<Document, Integer>,JpaSpecificationExecutor<Document> {

}
