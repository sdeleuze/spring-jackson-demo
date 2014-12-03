/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@JsonView(View.Summary.class)
	@RequestMapping("/")
	public List<Message> getAllMessages() {
		return messageService.getAll();
	}

	@JsonView(View.SummaryWithRecipients.class)
	@RequestMapping("/with-recipients")
	public List<Message> getAllMessagesWithRecipients() {
		return messageService.getAll();
	}

	@JsonView(View.Full.class)
	@RequestMapping("/{id}")
	public Message getMessage(@PathVariable Long id) {
		return this.messageService.get(id);
	}

	@JsonView(View.Full.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Message create(@RequestBody Message message) {
		return this.messageService.create(message);
	}

}
