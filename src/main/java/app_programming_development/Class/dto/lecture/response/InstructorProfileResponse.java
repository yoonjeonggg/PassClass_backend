package app_programming_development.Class.dto.lecture.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class InstructorProfileResponse {
    private Long id;
    private String nickname;
    private String profileImage;
    private int lectureCount;
    private long totalStudents;
    private List<LectureListDto> lectures;
}
