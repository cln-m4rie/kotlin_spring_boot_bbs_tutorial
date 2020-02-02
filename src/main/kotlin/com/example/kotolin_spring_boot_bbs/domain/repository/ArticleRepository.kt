package com.example.kotolin_spring_boot_bbs.domain.repository

import com.example.kotolin_spring_boot_bbs.domain.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Int>