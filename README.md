# 🚀 Selenium Java Automation Framework with Cucumber

Este es un framework de automatización de pruebas construido con **Selenium WebDriver**, **Java**, **Cucumber** y **JUnit**, con integración continua usando **GitHub Actions**. El propósito de este proyecto es demostrar buenas prácticas para pruebas funcionales E2E, usando el patrón **Page Object Model (POM)**.

---

## 🧰 Tecnologías Utilizadas

- 🧪 **Selenium WebDriver**
- 💻 **Java 17**
- 🥒 **Cucumber**
- ✅ **JUnit 4**
- ☕ **Maven**
- 🧱 **Page Object Model (POM)**
- ☁️ **GitHub Actions** (CI/CD)
- 📸 Captura automática de screenshots
- 🔔 Notificaciones por Slack (opcional)

---

## 📂 Estructura del Proyecto

src
└── main
└── java
└── com.wizeline
├── pages → Clases Page Object
├── utils → Utilidades y configuraciones
└── hooks → Inicialización y teardown del driver

└── test
└── java
└── com.wizeline.steps → Step definitions de Cucumber

└── resources
└── features → Escenarios .feature
└── cucumber.properties → Configuración de reportes


---

## ⚙️ Requisitos Previos

- Java 17
- Maven
- Chrome instalado
- Git

---

## 🚀 Cómo Ejecutar Localmente

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Y-Camargo/SELENIUM-JAVA.git
   cd SELENIUM-JAVA

2. Ejecuta los tests:
mvn clean test

3. Verifica los reportes en:
target/cucumber-reports


🛠️ Integración Continua con GitHub Actions
El pipeline ejecuta:

mvn clean install para compilar el proyecto

mvn test para ejecutar las pruebas

Captura de pantallas si falla una prueba

Carga de reportes HTML

Notificación por Slack (opcional)

📸 Screenshots y Reportes
Los screenshots se almacenan en el directorio screenshots/

Reportes en formato HTML en target/cucumber-reports/

