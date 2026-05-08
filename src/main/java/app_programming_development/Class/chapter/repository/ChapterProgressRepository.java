package app_programming_development.Class.chapter.repository;

import app_programming_development.Class.chapter.entity.ChapterProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChapterProgressRepository extends JpaRepository<ChapterProgress, Long> {
    Optional<ChapterProgress> findByUserIdAndChapterId(Long userId, Long chapterId);
    List<ChapterProgress> findByUser_IdAndChapter_Lectures_Id(Long userId, Long lectureId);
}
