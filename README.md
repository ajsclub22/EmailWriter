⚙️ Configuration
Before running the application, set your Gemini API configuration in src/main/resources/application.properties:

properties
Copy
Edit
gemini.api.uri=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=
gemini.api.key=YOUR_GEMINI_API_KEY
Replace YOUR_GEMINI_API_KEY with your key from Google AI Studio.

📬 API Usage
Endpoint
POST /api/mail/generate

Request Body
json
Copy
Edit
{
  "emailContent": "Hi, can we move our meeting to tomorrow afternoon?",
  "tone": "formal"
}
Sample Response
json
Copy
Edit
"Certainly, we can reschedule the meeting to tomorrow afternoon. Please let me know a suitable time."
🔄 How It Works
A client sends a JSON request to the /api/mail/generate endpoint with:

The original email message (emailContent)

The desired tone (tone), e.g., formal, casual, etc.

The EmailController handles the request and delegates it to EmailGeneratorService.

The service builds a prompt dynamically, incorporating:

The email content

The tone

Specific instructions to return only a reply with no subject or metadata

The prompt is sent to Gemini API via a non-blocking WebClient request.

Gemini responds with a generated reply.

The app extracts just the email text from Gemini’s response and returns it to the client.

💡 Prompt Example Sent to Gemini
text
Copy
Edit
You are a professional email assistant. Generate only the email content as a reply to the message below. 
Do not include a subject line, headers, or any explanations. Only output the reply content.

Use a formal tone.

Original message:
"Hi, can we move our meeting to tomorrow afternoon?"

Your reply:
📁 Project Structure
graphql
Copy
Edit
src/
├── controller/
│   └── EmailController.java         # Exposes the /generate endpoint
├── model/
│   └── EmailBody.java               # Holds emailContent and tone
├── service/
│   └── EmailGeneratorService.java   # Builds prompt, calls Gemini API
└── resources/
    └── application.properties       # Config for API keys, URI
🧪 Testing the API
Using curl
bash
Copy
Edit
curl -X POST http://localhost:8080/api/mail/generate \
     -H "Content-Type: application/json" \
     -d '{
           "emailContent": "Can you share the project updates today?",
           "tone": "professional"
         }'
Using Postman
Method: POST

URL: http://localhost:8080/api/mail/generate

Headers: Content-Type: application/json

Body:

json
Copy
Edit
{
  "emailContent": "Please send me the final draft by EOD.",
  "tone": "formal"
}
🧰 Troubleshooting & Logs
Make sure your Gemini API key is valid and active.

If there's an issue parsing the response, check logs for Failed to extract response from Gemini API.

For better error tracking, SLF4J is used for logging.

📌 Notes
The response is only the reply content — no email headers, subjects, or explanations.

Prompt formatting ensures Gemini returns a clean, usable reply.

You can enhance this project to support:

Multilingual replies

Emotion/tone switching

Integration with email services (Gmail API, Outlook, etc.)

🤝 Contributing
Contributions are welcome! Feel free to fork the repo, create a branch, and submit a pull request. For issues, bugs, or feature requests, please open an issue.
