package app_programming_development.Class.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest {
    private Long lectureId;
    private Double rating;
    private String content;
}
