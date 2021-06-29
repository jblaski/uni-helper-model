package com.jblaski.unihelpermodel;

import com.jblaski.unihelpermodel.model.KISCourse;
import com.jblaski.unihelpermodel.model.KISCourseId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KISCourseRepository extends CrudRepository<KISCourse, KISCourseId> {
    List<KISCourse> findByUKPRN(String UKPRN);
}
