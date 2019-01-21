package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.repository.TopicRepository;

@RestController
public class TopicController {

	@Autowired
	private TopicRepository topicRepository;

	@GetMapping(value = "/api/topics", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TopicBriefOutputDto> listTopics() {

		List<Topic> topics = this.topicRepository.findAll();

		return TopicBriefOutputDto.listFromTopics(topics);
	}
}
