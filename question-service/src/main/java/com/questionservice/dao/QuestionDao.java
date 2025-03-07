package com.questionservice.dao;


import com.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

//    @Query("SELECT q FROM Question q WHERE q.category = :category")
    List<Question> findByCategory(String category);

    Question findByQuestiontitle(String questiontitle);

    @Query(value = "SELECT q.id FROM question q WHERE q.category= :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCateogry(String category, Integer numQ);
}
