package com.kotlin.reactive.demoreactivekotlin.service

import com.kotlin.reactive.demoreactivekotlin.entities.Message
import com.kotlin.reactive.demoreactivekotlin.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(val db: MessageRepository) {

    fun findMessages(): List<Message> = db.findMessages()

    fun post(message: Message) {
        db.save(message)
    }
}
