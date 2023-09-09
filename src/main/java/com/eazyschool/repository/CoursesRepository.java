package com.eazyschool.repository;

import com.eazyschool.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Integer> {

    List<Course> findByOrderByNameDesc();

    // By default sorts in ascending order
    List<Course> findByOrderByName();

}
