package com.edfapay.library.repositories;


import com.edfapay.library.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long>, JpaSpecificationExecutor<BookModel> {
}