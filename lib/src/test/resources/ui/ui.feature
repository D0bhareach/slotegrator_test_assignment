Feature: Admin can sort players.
# Авторизоваться в админке
# Пользователь успешно авторизован, админ-панельзагрузилась
# oткрыть список игроков
# Таблица с игроками загрузилась
# Отсортировать по любому по любому сталбцу.
# Таблица верно отсортирована по выбранному сталбцу.
#
# URL: http://test-app.d6.dev.devcaz.com/admin/loginAdmin
# login/password: admin1 / [9k<k8^z!+$$GkuP
#
# Must be on start page.
# Get input for login and enter keys
# Get input for pass and enter keys
# get submit button and pressit.
# Need modificators for login page
# login is on alert box
    Scenario: Login admin
        Given can get login and password inputs
        When enter login
        When enter password
        Then submit credentials

#
# Must be on home page for admin
# Get link to players
# Click on players
    Scenario: Go to players page
        Given can get link to players
        Then click on players

# Must get table with players
# Get options with first chiche
# select verivied: No
# Get options with second choice
# select active: Active, this way we will get more than one row
# Get player ? Don't know how 
# Compare this player with presaved player. Need Player Pojo.
    Scenario: Sort players and check
        Given can get options
        When select first option
        When select second option
        When get result
        Then check if player is expected player
