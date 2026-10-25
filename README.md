# CS-305 Software Security | Artemis Financial

## Project Overview

This repository contains a portfolio artifact from **CS-305: Software Security** at Southern New Hampshire University. In this course project, I worked with a Java Spring Boot application for **Artemis Financial**, a fictional financial services client that needed to modernize its application while protecting the integrity and confidentiality of sensitive information.

My Project Two work focused on generating a **SHA-256 checksum**, configuring **HTTPS/TLS** with a self-signed certificate and PKCS12 keystore, and assessing third-party dependencies with **OWASP Dependency-Check**.

## Portfolio Artifact

- [Artemis Financial — Practices for Secure Software Report (PDF)](./CS305-Artemis-Financial-Practices-for-Secure-Software-Report.pdf)

The report documents the security choices, code changes, application testing, and dependency scan results.

## Reflection

### 1. Client and Software Requirements

Artemis Financial was a financial services client seeking to improve the security of its existing web application. The company needed a way to protect data as it moved between the application and its users and to verify that information had not been altered. My work involved evaluating security concerns, introducing a checksum using SHA-256, and enabling encrypted client-server communication through HTTPS.

### 2. Vulnerability Assessment and the Value of Secure Coding

One thing I did well was approach security from more than one angle. Rather than focusing only on whether the application ran, I examined its code, reviewed its dependencies, and considered how information was handled during communication. Secure coding is especially important for a financial services company because weaknesses can expose sensitive data, disrupt services, and undermine customer trust. Finding vulnerabilities before deployment helps reduce those risks and the costs of addressing them later.

### 3. Most Challenging or Helpful Part of the Assessment

Working through certificate configuration and interpreting the dependency scan results were especially useful learning experiences. HTTPS required more than simply changing an application setting; I had to understand the role of the certificate, keystore, and application configuration. The vulnerability report also helped me see that security issues can originate in libraries the application relies on, even when the application code itself appears to work correctly.

### 4. Layered Security and Future Mitigation Decisions

I added layers of protection by generating a SHA-256 checksum for data-integrity verification and configuring the Spring Boot application to use HTTPS on port 8443 with a self-signed certificate. I also referenced the keystore password through an environment variable instead of placing it directly in the configuration file. In future projects, I would combine manual code review with automated dependency scanning and current security guidance, then prioritize remediation based on severity, exploitability, and the application's actual exposure.

### 5. Functional Testing and Checking for New Vulnerabilities

After refactoring the application, I ran the Spring Boot server and checked its output through the `/hash` endpoint over HTTPS. I reviewed the application behavior and code, then used OWASP Dependency-Check to examine known vulnerabilities in the project's dependencies. The scan reported **254 vulnerability findings across 14 dependencies**. Those findings were **not all remediated** in this assignment and would require further investigation and dependency updates. Successful execution and a working HTTPS endpoint do not, by themselves, prove an application is fully secure.

### 6. Tools, Resources, and Practices I Would Reuse

Useful tools and practices included **Java's `MessageDigest` API** for SHA-256, **Spring Boot and Maven** for application development, **Java keytool** for certificate generation, a **PKCS12 keystore** for the local HTTPS configuration, and **OWASP Dependency-Check** for identifying dependency-related risks. I also relied on manual code review, functional testing, and documentation from **NIST, Oracle, and OWASP**. I would carry these practices into future development projects and expand them with more automated security testing.

### 7. What I Would Show Future Employers

I would use the completed report to demonstrate that I can work with an existing Java application, make security-focused changes, configure secure communications, and document both results and remaining risks. The project shows familiarity with cryptographic hashing, certificates, HTTPS, dependency scanning, and technical reporting. Just as importantly, it shows that I can distinguish between successfully implementing a feature and fully resolving an application's security vulnerabilities.

## Scope and Limitations

This was a **course project**, not a production deployment or a completed security audit. The self-signed certificate was used for local development and testing. **AES-256-GCM was discussed as a recommendation in the report, not implemented as an encryption feature in the submitted application.** The dependency findings remain an area for further remediation.

## AI Assistance Disclosure

ChatGPT was used to help organize this README. The technical work and findings described here are based on my own work from my CS-305 project submission.
