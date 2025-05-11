package com.audio.transcribe;

import java.io.File;
import java.io.IOException;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.api.OpenAiAudioApi.TranscriptResponseFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//@RestController
//@RequestMapping("/api/transcribe")
//public class TranscriptionController {
//	  
//	private final OpenAiAudioTranscriptionModel transcriptionModel;
//	
//	public TranscriptionController(@Value("${spring.ai.openai.api-key}") String apiKey) {
//		
//		//OpenAiAudioApi openAiAudioApi=new OpenAiAudioApi(apiKey);
//		OpenAiAudioApi openAiAudioApi=new OpenAiAudioApi(apiKey, null, null, null, null, null);
//		
//		this.transcriptionModel = new OpenAiAudioTranscriptionModel(openAiAudioApi);
//		
//	}
//	
//	@PostMapping
//	public ResponseEntity<String> transcribeAudio(
//			@RequestParam("file") MultipartFile file
//			) throws IOException{
//		File tempFile= File.createTempFile("audio", ".wav");
//		file.transferTo(tempFile);
//		OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
//			    .responseFormat(TranscriptResponseFormat.TEXT)
//			    .language("en")
//			    .temperature(0f)
//			    .build();
//		FileSystemResource audioFile = new FileSystemResource(tempFile);
//
//		AudioTranscriptionPrompt transcriptionRequest = new AudioTranscriptionPrompt(audioFile, transcriptionOptions);
//		AudioTranscriptionResponse response = transcriptionModel.call(transcriptionRequest);
//        
//		tempFile.delete();
//		
//		return new ResponseEntity<String>(response.getResult().getOutput(), HttpStatus.OK);
//		
//	}
//	
//}
@RestController
@RequestMapping("/api/transcribe")
public class TranscriptionController {

	private final OpenAiAudioTranscriptionModel transcriptionModel;

	public TranscriptionController(OpenAiAudioTranscriptionModel transcriptionModel) {
		this.transcriptionModel = transcriptionModel;
	}

	@PostMapping
	public ResponseEntity<String> transcribeAudio(@RequestParam("file") MultipartFile file) throws IOException {
		File tempFile = File.createTempFile("audio", ".wav");
		file.transferTo(tempFile);

		OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
				.responseFormat(TranscriptResponseFormat.TEXT)
				.language("en")
				.temperature(0f)
				.build();

		FileSystemResource audioFile = new FileSystemResource(tempFile);
		AudioTranscriptionPrompt transcriptionRequest = new AudioTranscriptionPrompt(audioFile, transcriptionOptions);
		AudioTranscriptionResponse response = transcriptionModel.call(transcriptionRequest);

		tempFile.delete();

		return ResponseEntity.ok(response.getResult().getOutput());
	}
}

