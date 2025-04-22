# ✉️ AI-Powered Email Writer

An intelligent email writer built with **Spring Boot** and integrated with **Google's Gemini API**. It generates professional, context-aware email responses using natural language input.

---

## 🚀 Features

- ✅ Generate AI-powered email replies
- ⚡ RESTful + Reactive API
- 🎯 JSON-based input and output
- 🎨 Customizable tone and content
- 🔒 Clean response (no subject, no extra text)

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring WebFlux**
- **Gemini API (Google Generative AI)**
- **Maven**
- **Lombok**

---

## 📦 Dependencies

Declared in `pom.xml`:

- `spring-boot-starter`
- `spring-boot-starter-web`
- `spring-boot-starter-webflux`
- `lombok`

---

## 📨 API Endpoint

**POST** `/api/mail/generate`

### 📥 Sample Request

```json
{
  "content": "Hi, can we reschedule our meeting to tomorrow afternoon?",
  "tone": "formal"
}
