#language:ru
#encoding:UTF-8

@test
Функционал: Проверка цены
  Структура сценария: Проверка цены товара "<goodsName>"
    Допустим открыта страница "https://www.saucedemo.com/"
    И введены логин "standard_user" и пароль "secret_sauce"
    И выполнено нажатие на ссылку товара "<goodsName>"
    Тогда цена товара равна "<goodsPrice>"

    Примеры:
    | goodsName                 | goodsPrice |
    | Sauce Labs Backpack       | $29.99     |
    | Sauce Labs Bike Light     | $9.99      |
    | Sauce Labs Bolt T-Shirt   | $15.99     |
    | Sauce Labs Fleece Jacket  | $49.99     |
    | Sauce Labs Onesie         | $7.99      |