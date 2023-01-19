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

## :computer: Запуск тестов из терминала

### Локальный запуск тестов

```bash
gradle clean test
или запуск из файла с параметрами gradle clean test -Denv=local
```

### Удаленный запуск тестов

```bash
gradle clean test
-Dbrowser=${BROWSER}
-Dbrowser_version=${BROWSER_VERSION}
-Dbrowser_size=${BROWSER_SIZE}
-Dremote=https://user1:1234@${URL}/wd/hub
-Dusername=Skan2023
-Dpassword=Inspiration2022!

или запуск из файла с параметрами gradle clean test -Denv=remote
```

## Параметры сборки


<code>testType</code> – имя ресурса\девайса (возможен запуск  **UI тестов** - в **selenoid**,
**mobile тестов** - в **Browserstack**, на эмуляторе в **Android Studi**o c
помощью сервера **Appium**).
 
<code>tag</code> – разновидность тестов (**UI**, **mobile**).

<code>BROWSER</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).

 <code>BROWSER_VERSION</code> – версия браузера (_по умолчанию - <code>100</code>_).

 <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты.

 <code>URL</code> – адрес удаленного сервера Selenoid.

## <img width="4%" title="Jenkins" src="images/logo/Jenkins_logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/wipedia_diploma/)

Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.

<p align="center">
  <img src="images/jenkins.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок *Allure Report*, кликнув по которому, откроется страница с сформированным html-отчетом.

<p align="center">
  <img src="images/allure-report.png" alt="allure-report" width="800">
</p>


## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/wipedia_diploma/2/allure/)

<p align="center">
  <img src="images/allure-report1.png" alt="allure-report1" width="900">
</p>
<p align="center">
  <img src="images/allure-report2.png" alt="allure-report2" width="900">
</p>


## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/jobrun/17629)

## Основной дашборд

<p align="center">
  <img src="images/dashboard.png" alt="dashboard" width="900">
</p>
 
## Тест-кейсы 

<p align="center">
  <img src="images/testcase.png" alt="testcase" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="images/telegram.png">
</p>

