package app_programming_development.Class.repository;

import app_programming_development.Class.entity.Notifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {
    Page<Notifications> findByUser_IdOrderByCreatedAtDesc(Long userId, Pageable pageable);
    Long countByUser_IdAndIsRead(Long userId, boolean isRead);
}
