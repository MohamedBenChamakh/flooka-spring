package com.project.content.repository;

import com.project.content.domain.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content,String> {

    Page<Content> findByCategory_id(String categoryId,Pageable pageable);

    Page<Content> findAll(Pageable pageable);
}
