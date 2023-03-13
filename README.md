# spring-library-service

### Создать Web приложение каталог книг.
- [x] Главная страница
- [x] Авторы
- [x] Книги
- [x] Страница добавления книги в бд

На главной странице отображаются последние 10 добавленных книг

На странице авторы - список авторов по алфавиту.
Так же необходимо предусмотреть поиск по автору, при нажатии на автора выдается список книг данного автора.

На странице книг - список книг по алфавиту. 
Так же необходимо предусмотреть поиск по книге, при нажатии на книгу открывается страница с информацией о книге (название, автор/авторы, при нажатии на автора необходимо реализовать переход на страницу данного автора).

Технологии: java, Spring 5, flyway, hibernate, maven, postgres, freemarker

# Нюаны реализации

- Не занл, какую версию Java выбрать для проекта, поэтому использовал 17, т.к. JDK уже был установлен.
- Spring 6
- Нельзя добавить несколько авторов книге, хотя поддержка имеется
- Реализована страница добавления автора в бд