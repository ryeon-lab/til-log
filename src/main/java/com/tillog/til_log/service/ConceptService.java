package com.tillog.til_log.service;

import com.tillog.til_log.domain.Concept;
import com.tillog.til_log.dto.ConceptRequest;
import com.tillog.til_log.repository.ConceptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConceptService {
    private final ConceptRepository conceptRepository;

    // Create
    public Concept createConcept(ConceptRequest request) {
        Concept concept = new Concept();
        concept.setDefContext(request.getDefContext());
        return conceptRepository.save(concept);
    }

    // Update
    public Concept updateConcept(Long id, ConceptRequest request) {
        Concept concept = conceptRepository.findById(id).orElseThrow();
        concept.setDefContext(request.getDefContext());

        return conceptRepository.save(concept);
    }

    // Get (단건)
    public Concept getConcept (Long id) {
        return conceptRepository.findById(id).orElseThrow();
    }

    // GetList (목록)
    public List<Concept> getAllConcept () {
        return conceptRepository.findAll();
    }

    // Delete
    public void deleteConcept(Long id) {
        conceptRepository.deleteById(id);
    }
}
