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

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@JsonView(View.Summary.class)
	@RequestMapping("/")
	public ResponseEntity<Message> getMessage() {
		return new ResponseEntity<Message>(this.messageService.get(1L), HttpStatus.OK);
	}

	@JsonView(View.Summary.class)
	@RequestMapping("/resource")
	public ResponseEntity<Resource<Message>> getMessageResource() {
		return new ResponseEntity<Resource<Message>>(new Resource<Message>(this.messageService.get(1L), new Link("http://sample.com")), HttpStatus.OK);
	}

	@RequestMapping("/resource-full")
	public ResponseEntity<Resource<Message>> getMessageResourceFull() {
		return new ResponseEntity<Resource<Message>>(new Resource<Message>(this.messageService.get(1L), new Link("http://sample.com")), HttpStatus.OK);
	}



}
