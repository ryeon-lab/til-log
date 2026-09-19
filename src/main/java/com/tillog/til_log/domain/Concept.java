package com.tillog.til_log.domain;

import jakarta.persistence.*;

@Entity // 이 클래스가 JPA 엔티티임을 선언 - DB 테이블과 매핑되는 객체가 됨
@Table(name = "def_table") // 실제 매핑될 테이블명 지정 (클래스명 Concept과 테이블명이 다르므로 명시)
public class Concept {
    @Id // 기본키(PK) 필드임을 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK 값 생성 전략 지정 - IDENTITY는 DB의 AUTO_INCREMENT에 값 생성을 위임하는 방식
    // (MySQL의 AUTO_INCREMENT와 정확히 매칭됨)
    @Column(name = "def_id")
    // 실제 컬럼명 지정 - Java는 camelCase(defID), DB는 snake_case(def_id)를 쓰므로 명시적으로 매핑
    private Long defId; // 개념 테이블 ID
    @Column(name = "def_context")
    private String defContext; // 개념 내용 (예 : HashMap, 투포인터 등)
}
