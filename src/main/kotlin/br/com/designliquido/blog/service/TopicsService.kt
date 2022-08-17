package br.com.designliquido.blog.service

import br.com.designliquido.blog.model.Topics
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicsService(private var topics: List<Topics> = ArrayList()) {
    fun list(): List<Topics> {
        return topics
    }

    fun searchById(id: Long): Topics {
        return list().stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun newTopic(topic: Topics) {
        topics = topics.plus(topic)
    }

    fun update(topicForm: Topics) {
        val topic = topics.stream().filter { t ->
            t.id == topicForm.id
        }.findFirst().get()

        topics = topics.minus(topic).plus(
            Topics(
                id = topicForm.id,
                title = topicForm.title,
                message = topicForm.message,
                content = topicForm.content,
                posterName = topicForm.message,
                creationDate = topic.creationDate
            )
        )
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topics = topics.minus(topic)
    }
}