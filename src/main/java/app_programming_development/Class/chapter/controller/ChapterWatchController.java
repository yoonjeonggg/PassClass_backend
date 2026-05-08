package app_programming_development.Class.chapter.controller;

import app_programming_development.Class.chapter.service.ChapterWatchService;
import app_programming_development.Class.dto.chapter.request.SaveProgressRequest;
import app_programming_development.Class.dto.chapter.response.ChapterWatchResponse;
import app_programming_development.Class.dto.chapter.response.LectureProgressResponse;
import app_programming_development.Class.global.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/lecture/chapters")
@RequiredArgsConstructor
@Tag(name = "LectureChapter", description = "강의 챕터 관련 API")
public class ChapterWatchController {

    private final ChapterWatchService chapterWatchService;

    @GetMapping("/progress")
    @Operation(summary = "강의 진도 조회", description = "현재 사용자의 강의 전체 진도율과 챕터별 완료 현황을 조회합니다.")
    public ResponseEntity<ApiResponse<LectureProgressResponse>> getMyProgress(
            @RequestParam Long lectureId) {
        LectureProgressResponse result = chapterWatchService.getMyProgress(lectureId);
        return ResponseEntity.ok(ApiResponse.ok(result, "조회되었습니다."));
    }

    @GetMapping("/{chapterId}/watch")
    @Operation(summary = "챕터 영상 시청", description = "수강 신청한 강의의 챕터 영상을 시청할 때 사용하는 API 입니다.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "로그인이 필요합니다.", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "수강 신청 후 이용 가능합니다.", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 챕터를 찾을 수 없습니다.", content = @Content)
    })
    public ResponseEntity<ApiResponse<ChapterWatchResponse>> watchChapter(@PathVariable Long chapterId) {
        ChapterWatchResponse result = chapterWatchService.watchChapter(chapterId);
        return ResponseEntity.ok(ApiResponse.ok(result, "조회되었습니다."));
    }

    @PatchMapping("/{chapterId}/progress")
    @Operation(summary = "챕터 시청 위치 저장", description = "현재까지 시청한 위치(초)를 저장하는 API 입니다.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "로그인이 필요합니다.", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "수강 신청 후 이용 가능합니다.", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 챕터를 찾을 수 없습니다.", content = @Content)
    })
    public ResponseEntity<ApiResponse<Void>> saveProgress(
            @PathVariable Long chapterId,
            @RequestBody SaveProgressRequest request) {
        chapterWatchService.saveProgress(chapterId, request.getWatchedSeconds());
        return ResponseEntity.ok(ApiResponse.ok(null, "저장되었습니다."));
    }

    @PostMapping("/{chapterId}/complete")
    @Operation(summary = "챕터 시청 완료", description = "챕터 영상 시청 완료 처리 시 사용하는 API 입니다.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "로그인이 필요합니다.", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "수강 신청 후 이용 가능합니다.", content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 챕터를 찾을 수 없습니다.", content = @Content)
    })
    public ResponseEntity<ApiResponse<Void>> completeChapter(@PathVariable Long chapterId) {
        chapterWatchService.completeChapter(chapterId);
        return ResponseEntity.ok(ApiResponse.ok(null, "완료 처리되었습니다."));
    }
}
