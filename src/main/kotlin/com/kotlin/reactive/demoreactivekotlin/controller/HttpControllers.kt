package com.kotlin.reactive.demoreactivekotlin.controller

import com.kotlin.reactive.demoreactivekotlin.entities.Message
import com.kotlin.reactive.demoreactivekotlin.repository.ArticleRepository
import com.kotlin.reactive.demoreactivekotlin.repository.UserRepository
import com.kotlin.reactive.demoreactivekotlin.service.MessageService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleController(private val repository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String) =
        repository.findBySlug(slug) ?: throw ResponseStatusException(NOT_FOUND, "This article does not exist")

}

@RestController
@RequestMapping("/api/user")
class UserController(private val repository: UserRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) =
        repository.findByLogin(login) ?: throw ResponseStatusException(NOT_FOUND, "This user does not exist")
}

@RestController
@RequestMapping("/api/message")
class MessageController(private val service: MessageService) {

    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.post(message)
    }
}
