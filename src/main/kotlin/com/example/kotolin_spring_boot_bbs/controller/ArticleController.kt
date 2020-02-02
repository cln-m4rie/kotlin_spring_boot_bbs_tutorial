package com.example.kotolin_spring_boot_bbs.controller

import com.example.kotolin_spring_boot_bbs.domain.entity.Article
import com.example.kotolin_spring_boot_bbs.domain.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ArticleController {
    @Autowired
    lateinit var articleRepository: ArticleRepository

    @PostMapping
    @ResponseBody
    fun registerArticle(@RequestParam name: String,
                        @RequestParam title: String,
                        @RequestParam contents: String,
                        @RequestParam articleKey: String): String {
        articleRepository.save(
                Article(
                        0,
                        name,
                        title,
                        contents,
                        articleKey
                )
        )

        return "Saved"
    }
}