# StorageApp

StorageApp is a Spring Boot application designed to manage a virtual file and directory hierarchy. It provides a flexible tree-based file management system with unique UUID tracking for directory nodes and fast file/directory lookup capabilities.

## Features

- **File & Directory Management**: Abstract representation of files and directories with `File` and `FileNode`.
- **Tree Hierarchy**: Nested file and folder structures with parent-child relationship tracking.
- **UUID Assignment**: Automatic unique identifier (UUID) generation and tracking for directory nodes.
- **Search Capabilities**: Fast search for file nodes by UUID or filename.
- **Custom Exception Handling**: Custom exceptions (`FileNotFoundException`, `NotDirectoryException`) for robust error handling.
- **Telegram Uploader Module**: Integration hook for Telegram storage / uploading operations.

## Tech Stack

- **Java**: 17
- **Framework**: Spring Boot
- **Database / Storage**: SQLite JDBC
- **Build Tool**: Maven (`mvnw` wrapper included)

## Project Structure

```
StorageApp/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/StorageApp/
│   │           ├── StorageAppApplication.java   # Main Spring Boot application class
│   │           ├── File.java                    # File/Directory domain model
│   │           ├── FileNode.java                # Tree node representation & directory operations
│   │           ├── TelegramUploader.java        # Telegram uploader module
│   │           └── exception/
│   │               ├── FileNotFoundException.java
│   │               └── NotDirectoryException.java
│   └── test/
│       └── java/
│           └── com/example/StorageApp/
│               ├── FileTest.java                # Unit tests for File model
│               └── StorageAppApplicationTests.java
├── pom.xml                                      # Maven project configuration
├── mvnw / mvnw.cmd                              # Maven wrapper scripts
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher installed.

### Building the Project

To build the project and package it into a JAR file, execute:

```bash
./mvnw clean package
```

### Running Tests

To run the automated test suite:

```bash
./mvnw test
```

### Running the Application

To start the Spring Boot application locally:

```bash
./mvnw spring-boot:run
```

## License

This project is open source and available under the terms configured in the repository.
