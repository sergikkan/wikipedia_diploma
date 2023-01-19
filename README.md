# Дипломный проект по автоматизации тестирования сайта https://ru.wikipedia.org

##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Тест кейсы](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)


## Технологии и инструменты

<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="5%" title="Browserstack" src="images/logo/Browserstack.svg"></code>
<code><img width="5%" title="Appium" src="images/logo/Appium.svg"></code>
<code><img width="5%" title="Android" src="images/logo/Android.svg"></code>
<code><img width="5%" title="Selenoid" src="images/logo/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="images/logo/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Allure Jira" src="images/logo/Jira.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins_logo.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></code>
</p>

В данном проекте автотесты написаны на **Java** с использованием фреймворка для тестирования **Selenide**. Для сборки проекта в среде **IntelliJ IDEA** используется **Gradle**.
**JUnit5** задействован в качестве фреймворка модульного тестирования. Запуск тестов выполняется из **Jenkins**. **Selenoid** используется для запуска браузеров в контейнерах **Docker**.

**Browserstack** используется для запуска мобильных тестов, для запуска на эмуляторе используются **Android Studio** и **Appium**. 

**Allure Report**, **AllureTestOps** и **Telegram Bot** используются для визуализации результатов тестирования.

## Тест кейсы

### Тест кейсы для UI тестирования

- Открытие главной страницы сайта 
- Поиск статьи 
- Открытие статьи
- Открытие страницы Форум
- Открытие страницы Пожертвовать
- Авторизация пользователя
- Открытие страницы Настройки
- Открытие страницы домашняя страница пользователя

### Тест кейсы для Mobie тестирования

- Поиск статьи
- Открытие статьи
- Добавление языка в настройках

## :computer: Запуск тестов из терминала

Файлы с параметрами конфигурации для запуска тестов находятся в папках resources/web и resources/mobile

### Локальный запуск тестов

```bash
gradle clean web
gradle clean mobile -DmobileDeviceHost=emulation
```

### Удаленный запуск тестов

```bash
gradle clean test
clean 
${TYPE}Tests
```

## Параметры сборки

<code>TYPE</code> – разновидность тестов (**web**, **mobile**, **all**).

## <img width="4%" title="Jenkins" src="images/logo/Jenkins_logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/wipedia_diploma/)

Для запуска сборки необходимо указать значениe параметрa TYPE (all, web, mobile) и нажать на кнопку <code><strong>*Собрать*</strong></code>.

<p align="center">
  <img src="images/jenkins.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок *Allure Report*, кликнув по которому, откроется страница с сформированным html-отчетом.

<p align="center">
  <img src="images/Allure.png" alt="Allure" width="800">
</p>


## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/wipedia_diploma/8/allure)

<p align="center">
  <img src="images/allure2.png" alt="allure2" width="900">
</p>
<p align="center">
  <img src="images/allure3.png" alt="allure-report3" width="900">
</p>


## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/jobrun/17723)

## Основной дашборд

<p align="center">
  <img src="images/testOps1.png" alt="testOps1" width="900">
</p>
 
## Тест-кейсы 

<p align="center">
  <img src="images/testOps2.png" alt="testOps2" width="900">
</p>

## <img width="4%" title="BROWSERSTACK" src="images/logo/browserStack.svg">[BROWSERSTACK](https://app-automate.browserstack.com/dashboard/v2/builds/2981d0ebfffee19fd6ef9896705e8277f4ae13f8/sessions/105dfdc7fd19eb2cede43893836364ca9bba6009)

<p align="center">
  <img src="images/browserStack.png" alt="browserStack" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="images/telegram.png"width="800">
</p>

## <a name="Video"></a> :tv: Пример видео тестов в Browserstack

<p align="center">
<img src="images/video/browserstack.gif" alt="video" width="600">
</p>

