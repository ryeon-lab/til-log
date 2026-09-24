package com.tillog.til_log.repository;

import com.tillog.til_log.domain.Concept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceptRepository extends JpaRepository<Concept, Long> {
}
