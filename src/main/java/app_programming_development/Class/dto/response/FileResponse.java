package app_programming_development.Class.dto.response;

import app_programming_development.Class.entity.Files;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FileResponse {
    private Long fileId;
    private String originalName;
    private String fileUrl;
    private Long fileSize;
    private String contentType;
    private LocalDateTime createdAt;

    public static FileResponse from(Files file) {
        return FileResponse.builder()
                .fileId(file.getId())
                .originalName(file.getOriginalName())
                .fileUrl(file.getFileUrl())
                .fileSize(file.getFileSize())
                .contentType(file.getContentType())
                .createdAt(file.getCreatedAt())
                .build();
    }
}
