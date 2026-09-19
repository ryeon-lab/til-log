package com.tillog.til_log.domain;

import jakarta.persistence.*;

@Entity // JPA 엔티티 선언
@Table(name = "def_til_connect") // Til 과 Concept의 다대다 관계를 푸는 연결 테이블
public class DefTilConnect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 연결 테이블 자체의 PK

    @ManyToOne
    // "여러 개의 연결 레코드(DefTilConnect)가 하나의 Til을 참조할 수 있다"는 관계
    // 예 : 문제 하나에 개념이 여러 개 태깅될 수 있으므로,
    //      같은 til_id를 가진 연결 레코드가 여러 개 존재 가능
    @JoinColumn(name = "til_id") // FK 컬럼명 지정
    // 실제 FK 컬럼명 지정 - 이 필드가 til_table.til_id를 참조하는 외래키임을 명시
    private Til til; // 참조 대상 자체를 엔티티 타입으로 받음 (Long이 아닌 Til)

    @ManyToOne
    // "여러 개의 연결 레코드(DefTilConnect)가 하나의 Concept을 참조할 수 있다"는 관계
    // 예 : 개념 하나(예: HashMap)가 여러 문제에 걸쳐 태깅될 수 있으므로,
    //      같은 def_id를 가진 연결 레코드가 여러 개 존재 가능
    @JoinColumn(name = "def_id")
    private Concept concept;
}
