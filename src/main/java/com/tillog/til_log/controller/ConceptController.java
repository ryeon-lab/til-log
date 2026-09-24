package com.tillog.til_log.controller;

import com.tillog.til_log.domain.Concept;
import com.tillog.til_log.dto.ConceptRequest;
import com.tillog.til_log.service.ConceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concepts")
@RequiredArgsConstructor
public class ConceptController {
    private final ConceptService conceptService;

    @PostMapping
    public ResponseEntity<Concept> createConcept(@RequestBody ConceptRequest request) {
        Concept savedConcept = conceptService.createConcept(request);
        return ResponseEntity.ok(savedConcept);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concept> getConceptById(@PathVariable Long id) {
        Concept getConcept = conceptService.getConcept(id);
        return ResponseEntity.ok(getConcept);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Concept>> getAllConcept () {
        List<Concept> getListConcept = conceptService.getAllConcept();
        return ResponseEntity.ok(getListConcept);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concept> updateConcept(@PathVariable Long id, @RequestBody ConceptRequest request) {
        Concept updatedConcept = conceptService.updateConcept(id, request);
        return ResponseEntity.ok(updatedConcept);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcept(@PathVariable Long id) {
        conceptService.deleteConcept(id);
        return ResponseEntity.noContent().build();
    }
}
