package com.tillog.til_log.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "til_table")
@Getter
@Setter
public class Til {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "til_id")
    private Long tilId;
    @Column(name = "til_date")
    private LocalDate tilDate;
    @Column(name = "til_title")
    private String tilTitle;
    @Column(name = "til_url")
    private String tilUrl;
    @Column(name = "til_level")
    private String tilLevel;
    @Column(name = "til_solve", columnDefinition = "TEXT")
    private String tilSolve;
}
