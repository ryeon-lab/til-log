package com.tillog.til_log.controller;

import com.tillog.til_log.domain.Til;
import com.tillog.til_log.dto.TilRequest;
import com.tillog.til_log.service.TilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 이 클래스가 REST API를 처리하는 Controller임을 선언 (응답을 JSON으로 자동 변환)
@RequestMapping("/api/tils") // 이 컨트롤러가 처리할 기본 URL 경로
@RequiredArgsConstructor
public class TilController {
    private final TilService tilService;

    // Create — TIL 작성 (POST /api/tils)
    // 클라이언트가 요청 본문(JSON)으로 보낸 데이터를 @RequestBody로 Til 객체에 매핑
    @PostMapping
    public ResponseEntity<Til> createTil(@RequestBody TilRequest request) {
        Til savedTil = tilService.createTil(request);
        return ResponseEntity.ok(savedTil);
    }

    // Read (단건) — id로 TIL 하나 조회 (GET /api/tils/{id})
    // URL 경로의 {id} 값을 @PathVariable로 받아옴
    @GetMapping("/{id}")
    public ResponseEntity<Til> getTil(@PathVariable Long id) {
        Til getTilById = tilService.getTil(id);
        return ResponseEntity.ok(getTilById);
    }

    // Read (전체) — TIL 전체 목록 조회 (GET /api/tils/list)
    @GetMapping("/list")
    public ResponseEntity<List<Til>> getAllTil() {
        List<Til> getListTil = tilService.getAllTil();
        return ResponseEntity.ok(getListTil);
    }

    // Update — id로 TIL 수정 (PUT /api/tils/{id})
    // 경로의 id + 요청 본문의 수정할 데이터, 둘 다 필요
    @PutMapping("/{id}")
    public ResponseEntity<Til> updateTil(@PathVariable Long id, @RequestBody TilRequest request) {
        Til savedTil = tilService.updateTil(id, request);
        return ResponseEntity.ok(savedTil);
    }

    // Delete — id로 TIL 삭제 (DELETE /api/tils/{id})
    // 삭제 결과로 돌려줄 데이터가 없으므로 ResponseEntity<Void> 사용
    // 성공 시 204 No Content(본문 없이 성공만 알림) 응답 반환
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTil(@PathVariable Long id) {
        tilService.deleteTil(id);
        return ResponseEntity.noContent().build();
    }
}