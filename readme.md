# Apartments backend API

- Деплоймент UI на Heroku: https://apartments-frontend-ui.herokuapp.com/
- Деплоймент API на Heroku: https://apartments-backend-api.herokuapp.com/

Репозиторий UI: https://github.com/mirat1618/apartments-ui

REST API endpoints:

| Prefix               | Method | Endpoint            | Action                                                | Return value                     |
|----------------------|-------|---------------------|-------------------------------------------------------|----------------------------------|
| /apartment-complexes | GET   | /                   | Вывод списка жилых комплексов                         | Список всех жилых комплексов     |
|                      | GET   | /id                 | Вывод данных жилого комплекса с указанным id          | Жилой комплекс с указанным id    |
|                      | POST  | /                   | Создание нового жилого комплекса                      | Созданный жилой комплекс         |
|                      | PUT   | /id                 | Редактирование жилого комплекса с указанным id        | Отредактированный жилой комплекс |
|                      | DELETE | /id                 | Удаление жилого комплекса с указанным id              | -                                |
| ...                  |       |                     |                                                       |                                  |
|                      | POST  | /id/apartments      | Добавление квартиры к жилому комплексу с указаннным id | Добавленная квартира             |
|                      | DELETE | /id1/apartments/id2 | Удаление квартиры с id2 у жилого комплекса с id1      | -                                |
| /apartments          | PUT   | /id                 | Редактирование квартиры                               | Отредактированная квартира       |

