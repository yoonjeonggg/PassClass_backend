package app_programming_development.Class.dto.chapter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class LectureProgressResponse {
    private int completedCount;
    private int totalCount;
    private int progressPercent;
    private List<MyChapterProgress> chapters;
}
