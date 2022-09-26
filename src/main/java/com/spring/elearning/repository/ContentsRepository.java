package com.spring.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.elearning.model.Contents;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {

}
