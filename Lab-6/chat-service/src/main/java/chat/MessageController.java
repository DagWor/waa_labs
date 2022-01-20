package chat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


@RestController
public class MessageController {
	@Autowired
    private MessageRepository messageRepository;
	private int x = 1;

    @GetMapping(value="/messages", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getChatMessages() {
        return messageRepository.findByRoom("Room 1");
    }

	@Scheduled(fixedRate = 3000)
	private void addMessage() {
		System.out.println("Adding message");
		messageRepository.save(new Message("Room 1","Message #"+x)).block();
		x++;
	}
}
