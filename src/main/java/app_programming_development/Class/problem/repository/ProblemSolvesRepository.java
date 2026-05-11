package app_programming_development.Class.problem.repository;

import app_programming_development.Class.problem.entity.ProblemSolves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemSolvesRepository extends JpaRepository<ProblemSolves, Long> {
    @org.springframework.data.jpa.repository.Modifying(clearAutomatically = true)
    @org.springframework.data.jpa.repository.Query("DELETE FROM ProblemSolves p WHERE p.user.id = :userId AND p.problems.id = :problemId")
    void deleteByUser_IdAndProblems_Id(@org.springframework.data.repository.query.Param("userId") Long userId,
                                       @org.springframework.data.repository.query.Param("problemId") Long problemId);
}
