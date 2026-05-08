package app_programming_development.Class.dto.chapter.response;

import app_programming_development.Class.chapter.entity.ChapterProgress;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyChapterProgress {
    private Long chapterId;
    private boolean completed;
    private int watchedSeconds;

    public static MyChapterProgress of(ChapterProgress p) {
        return new MyChapterProgress(p.getChapter().getId(), p.isCompleted(), p.getWatchedSeconds());
    }
}
