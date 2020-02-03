package com.example.kotolin_spring_boot_bbs.request

data class ArticleRequest(
        var id: Int = 0,
        var name: String = "",
        var title: String = "",
        var contents: String = "",
        var articleKey: String = ""
)