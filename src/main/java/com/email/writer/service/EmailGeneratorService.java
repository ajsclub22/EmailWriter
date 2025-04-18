package com.email.writer.service;

import com.email.writer.model.EmailBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private WebClient client;

    public EmailGeneratorService(WebClient.Builder clientBuilder) {
        this.client = clientBuilder.build();
    }

    @Value("${gemini.api.uri}")
    private String apiURI;

    @Value("${gemini.api.key}")
    private String apiKey;

    public String generateEmailReply(EmailBody email){
        //BuildPrompt
        System.out.println(apiURI);
        System.out.println(apiKey);
        String prompt = buildEmailRequest(email);
        //craft request

        Map<String, Object> requestBody = Map.of(
                "contents" , new Object[]{
                        Map.of(
                                "parts" , new Object[]{
                                        Map.of("text", prompt)                                }
                        )
                }
        );
        

        //Do request and get response
        String response = client.post()
                .uri(apiURI + apiKey)
                .header("Content-Type" , "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        //retrun respone
        return extractResponse(response);
    }

    private String extractResponse(String response) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates").get(0).
                    path("content").path("parts")
                    .get(0).path("text").asText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private String buildEmailRequest(EmailBody email) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a email response in a professional way, without any subjcet");
        String tone = email.getTone();
        if(tone != null && !tone.isEmpty()){
            prompt.append(String.format("use a %s tone", tone));
        }
        return prompt.toString();
    }
}
