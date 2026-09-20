package com.tillog.til_log.repository;

import com.tillog.til_log.domain.Til;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TilRepository extends JpaRepository<Til, Long> {
}
