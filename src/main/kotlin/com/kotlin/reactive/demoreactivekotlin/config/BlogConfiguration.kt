package com.kotlin.reactive.demoreactivekotlin.config

import com.kotlin.reactive.demoreactivekotlin.entities.Article
import com.kotlin.reactive.demoreactivekotlin.entities.Message
import com.kotlin.reactive.demoreactivekotlin.repository.ArticleRepository
import com.kotlin.reactive.demoreactivekotlin.entities.User
import com.kotlin.reactive.demoreactivekotlin.repository.UserRepository
import com.kotlin.reactive.demoreactivekotlin.repository.MessageRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository,
        messageRepository: MessageRepository
    ) = ApplicationRunner {

        val smaldini = userRepository.save(User("smaldini", "Stéphane", "Maldini"))
        articleRepository.save(
            Article(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        articleRepository.save(
            Article(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        messageRepository.save(
            Message(
                id = "1",
                text = "Mensage"
            )
        )
        messageRepository.save(
            Message(
                id = "2",
                text = "Mensage2"
            )
        )
    }
}
