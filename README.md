# ✉️ AI-Powered Email Writer

An intelligent email writer built with **Spring Boot** and integrated with the **Gemini API** (Google's generative AI). It generates context-aware, professional email content based on user prompts.

---

## 🚀 Features

- Generate professional emails using AI
- RESTful + Reactive API support
- Easily customizable for different contexts
- JSON-based input/output

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot**
- **Gemini API**
- **Maven**
- **Lombok**

---

## 📦 Dependencies

- `spring-boot-starter`
- `spring-boot-starter-web`
- `spring-boot-starter-webflux`
- `lombok`

> All dependencies are declared in the `pom.xml`.

---

## 🧪 Sample Request

**POST** `/generate-email`

```json
{
    "emailContent":"i how are",
    "tone":"professional"
}
