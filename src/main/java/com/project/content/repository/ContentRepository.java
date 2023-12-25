package com.project.content.repository;

import com.project.content.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content,String> {

    List<Content> findByCategory_id(String categoryId);
}
