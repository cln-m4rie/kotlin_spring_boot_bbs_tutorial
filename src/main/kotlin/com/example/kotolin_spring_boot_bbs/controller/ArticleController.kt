package com.example.kotolin_spring_boot_bbs.controller

import com.example.kotolin_spring_boot_bbs.domain.entity.Article
import com.example.kotolin_spring_boot_bbs.domain.repository.ArticleRepository
import com.example.kotolin_spring_boot_bbs.request.ArticleRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ArticleController {
    @Autowired
    lateinit var articleRepository: ArticleRepository

    @GetMapping("/")
    fun getArticleList(model: Model): String {
        model.addAttribute("articles", articleRepository.findAll())

        return "index"
    }

    @PostMapping("/")
    @ResponseBody
    fun registerArticle(@ModelAttribute articleRequest: ArticleRequest): String {
        articleRepository.save(
                Article(
                        articleRequest.id,
                        articleRequest.name,
                        articleRequest.title,
                        articleRequest.contents,
                        articleRequest.articleKey
                )
        )

        return "Saved"
    }
}