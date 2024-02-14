package com.kokoo.springboot3.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSampleRepository extends JpaRepository<JpaSample, Long> {

}
