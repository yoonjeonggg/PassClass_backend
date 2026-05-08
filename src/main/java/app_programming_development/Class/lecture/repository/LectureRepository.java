package app_programming_development.Class.lecture.repository;

import app_programming_development.Class.lecture.entity.Lectures;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lectures, Long> {
    Page<Lectures> findByCategory(String category, Pageable pageable);
    List<Lectures> findByInstructor_IdOrderByCreatedAtDesc(Long instructorId);
}
