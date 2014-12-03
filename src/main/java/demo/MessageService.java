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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private final List<Message> messages = new ArrayList<>();

	public MessageService() {
		Group authors = new Group("authors");
		User brian = new User(1L, "Brian", "Clozel", "bclozel@pivotal.io", "1 Jaures street", "69003", "Lyon", "France", authors);
		User stephane = new User(2L, "Stéphane", "Nicoll", "snicoll@pivotal.io", "42 Obama street", "1000", "Brussel", "Belgium", authors);
		User rossen = new User(3L, "Rossen", "Stoyanchev", "rstoyanchev@pivotal.io", "3 Warren street", "10011", "New York", "USA", authors);

		Message info = new Message(1L, "Info", "This is an information message", brian, stephane, rossen);
		Message warning = new Message(2L, "Warning", "This is a warning message", stephane, rossen);
		Message alert = new Message(3L, "Alert", "This is an alert message", rossen, brian);

		messages.add(info);
		messages.add(warning);
		messages.add(alert);
	}

	public List<Message> getAll() {
		return messages;
	}

	public Message get(Long id) {
		return this.messages.stream().filter((m) -> m.getId() == id).findFirst().get();
	}

	public Message create(Message message) {
		this.messages.add(message);
		return message;
	}
}
