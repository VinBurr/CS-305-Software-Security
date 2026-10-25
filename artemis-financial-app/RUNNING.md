# Running the Artemis Financial SSL Demo

This directory contains the cleaned **coursework source code** for the Java Spring Boot application, not a production-hardened service. The original coursework used Spring Boot **2.2.4.RELEASE**, a legacy version with identified dependency vulnerabilities. Upgrade and reassess the dependencies before deploying anything beyond a local demonstration.

## Prerequisites

- An appropriate Java Development Kit (the original Maven configuration targets Java 8)
- Apache Maven, or Maven support through an IDE such as Eclipse
- `keytool` (included with a JDK)

## Create a local development certificate

The private keystore is intentionally **not** included in the GitHub source. From this application's directory, use the following command to create a **new**, self-signed keystore for your own local testing:

```bash
keytool -genkeypair -alias artemis -keyalg RSA -keysize 3072 -sigalg SHA256withRSA -storetype PKCS12 -validity 365 -keystore src/main/resources/keystore.p12 -dname "CN=localhost, OU=Demo, O=Artemis Financial, L=Local, ST=Local, C=US" -ext "SAN=dns:localhost,ip:127.0.0.1"
```

Enter a new password when prompted. Set the environment variable `SSL_KEYSTORE_PASSWORD` to the same value for your run configuration or terminal session. Do **not** put the password into `application.properties` or commit your keystore to GitHub. The project's `.gitignore` excludes private keystore files.

## Run the application

From this directory, run:

```bash
mvn spring-boot:run
```

Then open `https://localhost:8443/hash`. The endpoint prints the original static text and its SHA-256 checksum.

A browser may warn that the self-signed certificate is not trusted. That is expected in this local demonstration; the certificate is not suitable for production use.

## Test and scan

The original source includes a Spring Boot context-loading test. With your local keystore and environment variable configured, you can run:

```bash
mvn test
```

The OWASP Dependency-Check Maven plugin is configured in `pom.xml`. The submitted course report documents **254 vulnerability findings across 14 dependencies**, which were **not all resolved** in the submitted project.

## Security and scope notes

- SHA-256 is used to calculate an example **integrity checksum**; it does not encrypt data or authenticate the checksum by itself.
- HTTPS uses a self-signed **development certificate**.
- `keystore.p12` and generated files in `target/` were deliberately excluded from the public-ready source package.
- **AES-256-GCM was a recommendation in the coursework report**, not an implementation in this codebase.
- This archived course submission is not presented as a production-ready or fully remediated application.
