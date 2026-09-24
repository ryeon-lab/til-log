package com.tillog.til_log.controller;

import com.tillog.til_log.domain.DefTilConnect;
import com.tillog.til_log.dto.DefTilConnectRequest;
import com.tillog.til_log.service.DefTilConnectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/connect")
@RequiredArgsConstructor
public class DefTilConnectController {
    private final DefTilConnectService defTilConnectService;

    @PostMapping
    public ResponseEntity<DefTilConnect> createConnect(@RequestBody DefTilConnectRequest request) {
        DefTilConnect savedConnect = defTilConnectService.createConnect(request);
        return ResponseEntity.ok(savedConnect);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefTilConnect> updateConnect(@PathVariable Long id, @RequestBody DefTilConnectRequest request) {
        DefTilConnect updateConnect = defTilConnectService.updateConnect(id, request);
        return ResponseEntity.ok(updateConnect);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefTilConnect> getConnectOne(@PathVariable Long id) {
        DefTilConnect getConnect = defTilConnectService.getDefTil(id);
        return ResponseEntity.ok(getConnect);
    }

    @GetMapping("/list")
    public ResponseEntity<List<DefTilConnect>> getConnectAll() {
        List<DefTilConnect> getConnectAll = defTilConnectService.getAllDefTil();
        return ResponseEntity.ok(getConnectAll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConnect(@PathVariable Long id) {
        defTilConnectService.deleteDefTil(id);
        return ResponseEntity.noContent().build();
    }
}
