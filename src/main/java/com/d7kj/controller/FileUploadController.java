package com.d7kj.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

	@PostMapping("/form")
	@ResponseBody
	public String handleFromUpload(MultipartFile file) throws IOException {
		if(file.isEmpty())
			return "failure";
		String fileName = file.getOriginalFilename();
		File dest = new File(fileName);
		file.transferTo(dest);
		return "success";
	}
}
