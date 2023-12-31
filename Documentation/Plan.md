# План автоматизации

## Перечень автоматизируемых сценариев:

### Карты, предоставленные для тестирования веб-сервиса (файл data.json):

* Оплата картой "4444 4444 4444 4441" APPROVED
* Оплата картой "4444 4444 4444 4442" DECLINED

### Позитивные сценарии:

1. **Оплата тура по дебетовой карте "APPROVED"**
    - Ввести номер карты 4444 4444 4444 4441

   **Ожидаемый результат:** Появляется окно "Успешно. Операция одобрена Банком""

2. **Оплата тура в кредит по карте "DECLINED"**
    - Ввести номер карты 4444 4444 4444 4442

   **Ожидаемый результат:** Система выдает ошибку: "Ошибка! Банк отказал в проведении операции"

### Негативные сценарии:

1. **Ввод неполного номера карты:**
    - Заполнить поле с номером карты неполным номером

   **Ожидаемый результат:** Система выдает ошибку: "Неверный формат"

2. **Пустая форма:**
    - Отправить пустой запрос на покупку тура без заполнения полей формы

   **Ожидаемый результат:** Система выдает ошибку

3. **Оставить одно поле пустым:**
    - Заполнить форму покупки тура, оставив одно из полей пустым

   **Ожидаемый результат:** Система выдает ошибку: "Поле обязательно для заполнения"

4. **Ввод в поле номер карты только нули:**
    - Отправить запрос на покупку тура, указав одни нули в поле номер карты

   **Ожидаемый результат:** Система выдает ошибку: "Неверный формат"

5. **Ввод несуществующий номер карты:**
    - Отправить запрос на покупку тура, указав несуществующий номер карты

   **Ожидаемый результат:** Система выдает ошибку: "Ошибка! Банк отказал в проведении операции"

6. **Ввод некорректного месяца для срока действия карты:**
    - Ввести в поле некорректный месяц, например, 15

   **Ожидаемый результат:** Система выдает ошибку: "Неверно указан срок действия карты"

7. **Ввод в поле месяц только нули:**
    - Ввести в поле месяц 00

   **Ожидаемый результат:** Система выдает ошибку: "Неверный формат"

8. **Оставить поле месяц пустым:**
    - Заполнить форму покупки тура, оставив поле месяц пустым

   **Ожидаемый результат:** Система выдает ошибку: "Поле обязательно для заполнения"

9. **Ввод невалидных данных в поле год:**
    - Заполнить форму покупки тура, указав неверный год

   **Ожидаемый результат:** Система выдает ошибку: "Истёк срок действия карты"

10. **Оставить поле год пустым:**
    - Заполнить форму покупки тура, оставив поле год пустым

    **Ожидаемый результат:** Система выдает ошибку: "Поле обязательно для заполнения"

11. **Ввод неполного имени владельца карты:**
    - В поле владелец указать неполные данные

    **Ожидаемый результат:** Система выдает ошибку: "Неверный формат"

12. **Оставить поле владелец пустым:**
    - Заполнить форму покупки тура, оставив поле владелец пустым

    **Ожидаемый результат:** Система выдает ошибку: "Поле обязательно для заполнения"

13. **Ввод в поле CVC только нули:**
    - Ввести в поле CVC 000

    **Ожидаемый результат:** Система выдает ошибку: "Неверный формат"

14. **Оставить поле CVC пустым:**
    - Заполнить форму покупки тура, оставив поле CVC пустым

    **Ожидаемый результат:** Система выдает ошибку: "Поле обязательно для заполнения"

15. **Ввести в поле CVC меньшее количество символом:**
    - Заполнить форму покупки тура, указав в поле CVC, например, 1 символ

    **Ожидаемый результат:** Система выдает ошибку: "Неверный формат"

16. **Ввести в поле CVC большее количество символом:**
    - Заполнить форму покупки тура, указав в поле CVC, например, 4 символа

    **Ожидаемый результат:** Система выдает ошибку: "Неверный формат"


## Перечень используемых инструментов с обоснованием выбора:

1. `IntelliJ IDEA`- интегрированная среда разработки для Java, которая предоставляет мощные инструменты для разработки и
   отладки кода. Обладает удобным интерфейсом, интеллектуальными функциями подсказок и автодополнения, а также
   интеграцией с популярными инструментами и фреймворками.
2. `Java 11` - язык программирования, для создания автоматизированных тестов. Поддерживает объектно-ориентированную
   парадигму, имеет богатую экосистему инструментов и библиотек, а также обладает хорошей переносимостью между
   различными платформами.
3. `JUnit 5` - фреймворк для тестирования Java, который предоставляет возможности для создания и запуска автотестов.
   Богатый набор аннотаций и утилит для проверки ожидаемых результатов и управления тестовыми сценариями.
4. `Gradle` - инструмент для автоматизации сборки и управления зависимостями в проекте. Обладает простым и гибким
   синтаксисом конфигурации, позволяет эффективно управлять зависимостями и создавать настраиваемые сборочные скрипты.
5. `Selenide` - фреймворк для автоматизации тестирования веб-приложений на основе Selenium WebDriver. Обеспечивает
   удобный API для взаимодействия с элементами веб-страницы, автоматическое ожидание элементов, упрощенные селекторы и
   множество других полезных функций, которые упрощают написание и поддержку автотестов.
6. `Faker` - библиотека, которая генерирует случайные данные для использования в автотестах. Предоставляет удобные
   методы для создания реалистичных имён, адресов, номеров телефонов и других типов данных, что позволяет легко
   генерировать разнообразные тестовые данные.
7. `Allure` - фреймворк для создания информативных отчетов о результатах выполнения автотестов. Предоставляет
   возможности для генерации детальной информации о запуске тестов, включая скриншоты, логи, статистику выполнения и
   другую полезную информацию, что упрощает анализ результатов и обнаружение проблем.
8. `Docker` - платформа для создания и управления контейнерами, которая обеспечивает изолированное окружение для
   выполнения приложений.
9. `Lombok` - библиотека, которая позволяет сократить объем и повысить читаемость кода Java. Она автоматически
   генерирует геттеры, сеттеры, конструкторы и другие общие методы, что упрощает написание классов и устраняет
   необходимость вручную создавать эти методы.

## Перечень и описание возможных рисков при автоматизации:

1. Проблемы с синхронизацией данных между приложением и банковскими сервисами, поскольку приложение не обрабатывает
   данные по картам, а пересылает их банковским сервисам.
2. При сохранении информации о совершенных платежах и способах оплаты в СУБД (MySQL или PostgreSQL) существует риск
   неправильной работы с базой данных, такой как некорректное сохранение данных или проблемы с извлечением и обновлением
   информации.
3. Использование симулятора банковских сервисов может привести к тому, что результаты тестирования могут не
   соответствовать реальным ситуациям при работе с реальными банковскими сервисами.
4. Неэффективное использование времени и ресурсов на изучение и исследование функциональности, а также на разработку и
   поддержку автотестов из-за отсутствия документации.
5. Риск возникновения ошибок при разработке кода для тестов, которые могут привести к некорректному или неполному
   тестированию функциональности приложения.

## Интервальная оценка с учётом рисков в часах:

1. Планирование автоматизации тестирования - 20 часов;
2. Автоматизация - 48 часов;
3. Подготовка отчётных документов по итогам автоматизированного тестирования - 10 часов;
4. Подготовка отчётных документов по итогам автоматизации - 10 часов;

## План сдачи работ: когда будут готовы автотесты, результаты их прогона:

- Подготовка инфраструктуры и настройка окружения - 3 дня;
- Написание автотестов для сценариев - 5 дня;
- Отладка и исправление ошибок - 2 день;
- Запуск автотестов и проверка результатов - 1 день;