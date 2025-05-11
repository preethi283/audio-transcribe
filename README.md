# Audio Transcribe

A full-stack web application that enables users to upload audio files and receive transcribed text output. This project combines a Java-based backend with a reactJS frontend.

## Features

- Upload audio files for transcription
- Real-time status updates of transcription
- View/download transcribed text
- Responsive user interface

## Tech Stack

### Backend
- **Language**: Java
- **Framework**: Spring Boot 

- **Functionality**:
  - Handles file uploads
  - Invokes audio-to-text processing
  - Serves transcribed data via REST endpoints

### Frontend
- **Languages**: HTML, CSS, JavaScript,reactJS
- **Features**:
  - File upload UI
  - Progress indicators
  - Display transcription results

## Project Structure
audio-transcribe/
├── audio-transcribe/ # Java backend
│ └── src/... # Java source files
├── audio-transcribe-frontend/ # Frontend files
│ ├── index.html
│ ├── script.js
│ └── style.css


## Getting Started

### Prerequisites

- Java 11 or later
- Node.js 
- Maven 

### Backend Setup

```bash
cd audio-transcribe
# As it's a Maven project
mvn clean install
mvn spring-boot:run

cd audio-transcribe-frontend
# npm install
npm run dev

### Usage
Navigate to the frontend in your browser.

Upload an audio file.

Wait for processing.

View the transcribed text.

### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss your ideas.



 
