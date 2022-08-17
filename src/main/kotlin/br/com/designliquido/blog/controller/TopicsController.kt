package br.com.designliquido.blog.controller

import br.com.designliquido.blog.model.Topics
import br.com.designliquido.blog.service.TopicsService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicsController(private val service: TopicsService) {

    @GetMapping
    fun list(): List<Topics> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): Topics {
        return service.searchById(id)
    }

    @PostMapping
    fun newTopic(@RequestBody @Valid topic: Topics) {
        service.newTopic(topic)
    }

    @PutMapping
    fun update(@RequestBody @Valid topic: Topics) {
        service.update(topic)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}