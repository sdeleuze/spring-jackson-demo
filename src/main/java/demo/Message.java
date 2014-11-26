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
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Message {

	@JsonView(View.Summary.class)
	private Long id;

	@JsonView(View.Summary.class)
	private LocalDate created;

	@JsonView(View.Summary.class)
	private String title;

	@JsonView(View.Summary.class)
	private User author;

	@JsonView(View.SummaryWithRecipients.class)
	private List<User> recipients;

	private String body;


	public Message() {
		this.created = LocalDate.now();
	}

	public Message(Long id, String title, String body, User author, User... recipients) {
		this();
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
		this.recipients = Arrays.asList(recipients);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<User> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<User> recipients) {
		this.recipients = recipients;
	}
}
