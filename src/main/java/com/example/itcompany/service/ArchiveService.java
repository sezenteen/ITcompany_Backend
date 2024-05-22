package com.example.itcompany.service;

import com.example.itcompany.model.Archive;
import com.example.itcompany.model.Article;
import com.example.itcompany.repository.ArchiveRepository;
import com.example.itcompany.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveService {

    @Autowired
    private ArchiveRepository archiveRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<Archive> getAllArchives() {
        return archiveRepository.findAll();
    }

    public Archive archiveArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElse(null);
        if (article != null) {
            Archive archive = new Archive();
            archive.setTitle(article.getTitle());
            archive.setContent(article.getContent());
            archive.setDate(article.getDate());

            articleRepository.delete(article);
            return archiveRepository.save(archive);
        }
        return null;
    }
}
