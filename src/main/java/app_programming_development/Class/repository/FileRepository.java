package app_programming_development.Class.repository;

import app_programming_development.Class.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Files, Long> {
}
