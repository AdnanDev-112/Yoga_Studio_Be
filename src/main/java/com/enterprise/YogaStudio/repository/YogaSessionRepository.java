package com.enterprise.YogaStudio.repository;

import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.model.YogaSession;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

@Repository
public interface YogaSessionRepository extends JpaRepository<YogaSession, Integer> {
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YogaSessionRepository extends JpaRepository<YogaSession, Integer> {

>>>>>>> 9479aafbfcb6bf616af271fbfcec23239bf9122a
}
