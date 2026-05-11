package app_programming_development.Class.dto.mockexam.response;

import app_programming_development.Class.mockexam.entity.MockExams;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MockExamListResponse {
    private Long id;
    private String title;
    private boolean completed;
    private Integer score;

    public static MockExamListResponse from(MockExams exam) {
        return MockExamListResponse.builder()
                .id(exam.getId())
                .title(exam.getTitle())
                .completed(false)
                .score(null)
                .build();
    }

    public static MockExamListResponse from(MockExams exam, int score) {
        return MockExamListResponse.builder()
                .id(exam.getId())
                .title(exam.getTitle())
                .completed(true)
                .score(score)
                .build();
    }
}
