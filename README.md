# ✉️ AI-Powered Email Writer

An intelligent, AI-based email response generator built using **Java (Spring Boot)** and powered by **Google's Gemini API**. This project provides a RESTful API that accepts user-provided email content and tone, and generates a professional, context-aware reply using generative AI.

This tool is ideal for automating communication tasks in productivity apps, customer support, CRM tools, or any system that requires smart email handling.

---

## 🚀 Features

- 🤖 Generates professional and context-sensitive email replies
- 🗣️ Supports tone customization (e.g., formal, casual, friendly)
- 🧼 Provides clean responses — only the email body, no subject lines or metadata
- ⚡ Built with reactive Spring WebFlux for non-blocking performance
- 🌐 JSON-based REST API, ready for easy integration
- 🔧 Easy to extend with support for custom prompts, multiple languages, or custom formatting

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring WebFlux**
- **Google Gemini API**
- **Maven**
- **Lombok**

---

## 📦 Dependencies

- `spring-boot-starter-webflux`
- `lombok`
- `spring-boot-starter-json`

---

## ⚙️ Configuration

Before running the application, set your Gemini API configuration in `src/main/resources/application.properties`:

```properties
gemini.api.uri=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=
gemini.api.key=YOUR_GEMINI_API_KEY
