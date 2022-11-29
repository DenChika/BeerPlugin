# BeerPlugin
## Автор: Соколов Денис Андреевич (M33021)
## Разработка плагина
При создании проекта, основанном на создании плагина, так же создаётся файл plugin.xml, в котором как раз и происходят все нужные подключения для разработки плагина. В extensions, например, подключаются различные сервисы, такие как хранение данных в storage. 
А в actions (что я и использовал при разработке моего плагина) подключаются события, которые происходят, когда мы нажимаем ту или иную кнопку.\
Все события наследуются от AnAction()
## Описание плагина
Наверное, у каждого пиволюба при разработке чего-либо возникала мысль "эх, сейчас бы пива...". И, так как на работе пить нельзя, то можно просто отдохнуть и поискать пиво для себя, а на досуге его купить. Или же можно просто немного развлечься и открыть пивной гороскоп.
В моём пивном плагине присутствуют 2 действия:
* Найти пиво по некоторым параметрам (имя, градус, дрожжи и т.д.)
* Пивной гороскоп

Все действия осуществлены при помощи пивной api
## Улучшение плагина
В данный момент, плагин работает не совсем так, как хотелось бы. В связи с очень сильным неудобством разработки плагина в IDE от JetBrains, некоторые функции работают неполноценно, например, при поиске отображается только одно пиво, хотя могут подходить несколько. Касаемо новых фичей, тут можно добавить всё что угодно: отобразить картинку пива, которое ты хочешь найти, отобразить топ экземпляров по типу пива, например светлое нефильтрованное (изначально задумка была в этом). Однако для добавления новых фичей нужна хорошая и бесплатная api`шка)
