package com.tillog.til_log.service;

import com.tillog.til_log.domain.Til;
import com.tillog.til_log.repository.TilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 이 클래스가 비즈니스 로직을 처리하는 서비스 계층임을 선언
@RequiredArgsConstructor // Lombok이 final 필드를 매개변수로 받는 생성자를 자동으로 만들어줌
public class TilService {
    private final TilRepository tilRepository;
    // @Autowired 없이도, 생성자가 자동 생성되고 Spring이 그 생성자로 주입해줌

    // Create - 새 TIL 저장
    // save() 는 넘긴 객체의 PK가 null이면 INSERT, 값이 있으면 UPDATE로 자동 판단
    public Til createTil(Til til) {
        return tilRepository.save(til);
    }

    // Update - 기존 TIL 수정
    // 1) id로 기존 데이터를 먼저 조회 (없으면 예외 발생 -> orElseThrow())
    // 2) 조회한 객체의 필드값을 새 값으로 하나씩 교체
    // 3) 다시 save() 호출 -> 이번엔 PK가 이미 있으므로 UPDATE로 처리됨
    public Til updateTil(Long id, Til updatedTil) {
        Til til = tilRepository.findById(id).orElseThrow();
        til.setTilTitle(updatedTil.getTilTitle());
        til.setTilDate(updatedTil.getTilDate());
        til.setTilLevel(updatedTil.getTilLevel());
        til.setTilUrl(updatedTil.getTilUrl());
        til.setTilSolve(updatedTil.getTilSolve());
        return tilRepository.save(til);
    }

    // Read (단건) - id로 TIL 하나 조회
    // findById()는 Optional<Til>을 반환 (데이터가 없을 수도 있으므로)
    // orElseThrow()로 값이 없으면 예외를 던지고, 있으면 값을 꺼내서 반환
    public Til getTil(Long id) {
        return tilRepository.findById(id).orElseThrow();
    }

    // Read (전체) - 모든 TIL 목록 조회
    // findAll()이 이미 List<Til>을 반환하므로 stream().toList()는 생략 가능 (동작은 동일)
    public List<Til> getAllTil() {
        return tilRepository.findAll().stream().toList();
        // return tilRepository.findAll(); <- 이렇게 써도 됨.
    }

    // Delete - id로 TIL 삭제
    // deleteById()는 JpaRepository가 기본 제공하는 메소드로, 해당 id의 데이터를 바로 삭제함.
    // 삭제 결과를 따로 반환할 필요 없으므로 반환 타입은 void
    public void deleteTil(Long id) {
        tilRepository.deleteById(id);
    }
}
