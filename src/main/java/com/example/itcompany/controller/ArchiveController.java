package com.example.itcompany.controller;

import com.example.itcompany.model.Archive;
import com.example.itcompany.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/archives")
public class ArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @GetMapping
    public List<Archive> getAllArchives() {
        return archiveService.getAllArchives();
    }

    @PostMapping("/{articleId}/archive")
    public Archive archiveArticle(@PathVariable Long articleId) {
        return archiveService.archiveArticle(articleId);
    }
}

