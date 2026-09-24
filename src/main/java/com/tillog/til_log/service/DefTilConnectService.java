package com.tillog.til_log.service;

import com.tillog.til_log.domain.Concept;
import com.tillog.til_log.domain.DefTilConnect;
import com.tillog.til_log.domain.Til;
import com.tillog.til_log.dto.DefTilConnectRequest;
import com.tillog.til_log.repository.ConceptRepository;
import com.tillog.til_log.repository.DefTilConnectRepository;
import com.tillog.til_log.repository.TilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefTilConnectService {
    private final DefTilConnectRepository defTilConnectRepository;
    private final TilRepository tilRepository;           // tilId로 Til 엔티티 조회하기 위해 필요
    private final ConceptRepository conceptRepository;   // conceptId로 Concept 엔티티 조회하기 위해 필요

    // TIL - 개념 연결 생성
    // 요청으로는 tilId, conceptId(숫자)만 들어오므로, 실제 연관관계를 맺으려면
    // 먼저 각 id로 진짜 Til/concept 엔티티를 조회한 뒤 DefTilConnect에 담아야 함
    public DefTilConnect createConnect(DefTilConnectRequest request) {
        Til til = tilRepository.findById(request.getTilId()).orElseThrow();
        Concept concept = conceptRepository.findById(request.getConceptId()).orElseThrow();
        DefTilConnect defTilConnect = new DefTilConnect(); // 새 연결이므로 새 객체 생성
        defTilConnect.setTil(til);
        defTilConnect.setConcept(concept);
        return defTilConnectRepository.save(defTilConnect); // PK 없는 상태로 save -> INSERT
    }

    // TIL - 개념 연결 수정
    // 기존 연결(id)은 그대로 두고, 그 연결이 가리키는 til/concept만 교체하는 경우
    public DefTilConnect updateConnect(Long id, DefTilConnectRequest request) {
        Til til = tilRepository.findById(request.getTilId()).orElseThrow();
        Concept concept = conceptRepository.findById(request.getConceptId()).orElseThrow();
        // 기존 row를 먼저 조회해야
        // save() 시 PK가 있는 상태라 UPDATE로 동작함 (없으면 INSERT로 새로 생겨버림)
        DefTilConnect updateDfc = defTilConnectRepository.findById(id).orElseThrow();
        updateDfc.setTil(til);
        updateDfc.setConcept(concept);
        return defTilConnectRepository.save(updateDfc);
    }

    // 연결 단건 조회
    public DefTilConnect getDefTil(Long id) {
        return defTilConnectRepository.findById(id).orElseThrow();
    }

    // 연결 전체 조회
    public List<DefTilConnect> getAllDefTil() {
        return defTilConnectRepository.findAll();
    }

    // 연결 삭제
    public void deleteDefTil(Long id) {
        defTilConnectRepository.deleteById(id);
    }
}
