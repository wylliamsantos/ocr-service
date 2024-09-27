# OCR Project with Tesseract and Spring Boot

This project uses Tesseract OCR to perform optical character recognition on images within a Spring Boot application. Below are the instructions to configure the local environment, build the Docker image, run the container, and make a request using curl.

## Prerequisites

### Tesseract Installation

To run the project locally, you will need to install Tesseract on your operating system.

#### **macOS (via Homebrew)**

If you're on macOS, you can install Tesseract using Homebrew:

```bash
brew install tesseract
```

#### **Ubuntu/Debian (via APT)**

If you're on a Linux distribution based on Debian or Ubuntu, you can install Tesseract using the apt package manager:

```bash
sudo apt update
sudo apt install tesseract-ocr
```

#### **Windows (via Chocolatey)**

If you're on Windows, you can install Tesseract using the Chocolatey package manager:

```bash
choco install tesseract
```

You can also download the Tesseract installer directly and follow the instructions to install it on Windows.

## Local Configuration
After installing Tesseract, make sure the por.traineddata language data file is accessible at src/main/resources/tessdata within your application.

## Running Locally
To run the application locally, you can use the following Maven or Gradle command to start Spring Boot:

```bash
./mvnw spring-boot:run
```
or
```bash
./gradlew bootRun
```

The application will be accessible at http://localhost:8080.

## Using Docker

### Building the Docker Image
To build the Docker image of the application, navigate to the root directory of the project where the Dockerfile is located and run the following command:

```bash
docker build -t ocr-service .
```

This will build the Docker image and name it ocr-service.

### Running the Docker Container
After building the image, you can run a container from the image with the following command:

```bash
docker run -p 8080:8080 ocr-service
```

This command exposes the application on port 8080 of the container, which will be mapped to port 8080 of your host. You can now access the application via http://localhost:8080.

## Example of CURL Request

You can test the service by sending an image to the OCR service via curl. Here is an example of a curl request that sends a PNG image to the service:

```bash
curl -X POST "http://localhost:8080/ocr" \
  -H "Content-Type: multipart/form-data" \
  -F "image=@/path/to/sample-image.png"
``` 

Explanation:

-X POST: Specifies that you are making a POST request.

-H "Content-Type: multipart/form-data": Sets the content type to multipart/form-data (necessary for file uploads).

-F "image=@/path/to/sample-image.png": Uploads the image file. Replace /path/to/sample-image.png with the actual path of the image you want to send.

## Environment Variables

When running the application in a Docker environment, ensure that the TESSDATA_PREFIX environment variable is correctly set to the directory where the Tesseract language files are stored.

In the Dockerfile, this is defined as:

```Dockerfile
ENV TESSDATA_PREFIX=/usr/local/share/
```

The /usr/local/share/ path is where the language data is copied in the container.
