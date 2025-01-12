package com.pongal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

@Controller
public class VideoController {

	@GetMapping("/api/video/{filename}")
	public ResponseEntity<Resource> getVideo(@PathVariable String filename) throws IOException {
		// Load video file from the static directory
		Resource video = new ClassPathResource("static/videos/" + filename);

		// Return the video file as a response with the correct content type
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "video/mp4").body(video);
	}
	@GetMapping("/")
	public String homePage(Model model) {
		 // Pass the video filename to the template
        model.addAttribute("videoFile", "pongal.mp4");
        return "pongal"; 
	}
}
