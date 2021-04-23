package com.kotlin.reactive.demoreactivekotlin.repository

import com.kotlin.reactive.demoreactivekotlin.entities.Article
import com.kotlin.reactive.demoreactivekotlin.entities.Message
import com.kotlin.reactive.demoreactivekotlin.entities.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}

interface MessageRepository : CrudRepository<Message, String> {

    @Query("select a from Message a")
    fun findMessages(): List<Message>
}

