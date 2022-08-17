package br.com.designliquido.blog.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class Topics (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @field:NotEmpty @field:Size(min= 5, max = 60)
        val title: String,

        @field:NotEmpty @field:Size(min= 5, max = 300)
        val message: String,

        @field:NotEmpty
        val content: String,

        val posterName: String,
        val creationDate: LocalDateTime = LocalDateTime.now(),
)