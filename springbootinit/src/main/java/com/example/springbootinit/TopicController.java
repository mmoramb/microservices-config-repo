package com.example.springbootinit;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@RequestMapping("topics")
	public List<Topic> getTopincs() {
		return Arrays.asList(
				new Topic("top","topic","desc topic"),
				new Topic("top1","topic1","desc topic1")
				);
	}
}
