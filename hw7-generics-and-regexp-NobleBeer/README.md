# ДЗ 7. Регулярные выражения. Generics.

## Дедлайн
**Мягкий дедлайн** - 20 ноября в 12-30

**Жесткий дедлайн** - 25 ноября в 23-59

## Как сдать
Реализуйте нужные классы. Запустите у себя на компьютере тесты. Для этого откройте консоль и выполните команду

```bash
./gradlew test
```

Если тесты прошли успешно - вы увидите надпись `BUILD SUCCESSFUL` , если же вы увидите надпись `BUILD FAILED`, то найдите в сообщении в терминале название теста и посмотрите этот тест в директории `src/test/groovy/`

После этого отправьте свое решение в ветку **main**. Призовите меня (ivanetc) в комментариях, где, **пожалуйста**, **напишите** "Cдаю задачи 1, 2, 3 ... n".
Убедитесь, что тесты проходят локально.

### Регулярные выражения

Используя регулярные выражения реализуйте следующие функции:

1. **isTrueCat** - Проверяет строку, содержит ли она «cat» в качестве подстроки, игнорируйте регистр. 
Пример строк, которые подходят: «cat», «cat and cat», «Cat», «theCATisHERE». 
Пример строк, которые не подходят: «kat», «», «cot».

2. **catculator** - Должен вернуть суммарное количество котов, упомянутое в строке. 
Например, для строки "Valentina has 3 cats, but Nikolay has only 1 cat" мы должны вернуть 4, а для строки
"Alexander has 1 dog, but want to have 1 cat" - нужно вернуть 1.

3. **skynet** Заменить все вхождения слова «human» на слово «computer». 
Примеры замен: «I need to understand the human mind» -> «I need to understand the computer mind», «humanity» -> «humanity»

4. **removeDuplicates** Заменить все вхождения нескольких одинаковых букв подряд на одну букву.
   Примеры замен: «attraction» -> «atraction», «buzzzz» -> «buz».

5. **isEmail** - Проверяет является ли переданная строка email адресом

6. **validateForDuplicates** - Выделяет тегом \<strong> повторяющиеся слова. Примеры: 
"Тhis is a test" -> "This is a test", "Тhis is is a test" -> "This is \<strong>is\</strong> a test"


### Generics. Связный список

Давайте вспомним наш [связный список](https://ru.wikipedia.org/wiki/Связный_список) `LinkedMyList` имплементирующий абстрактный класс `MyList` . Давайте сделаем его 
более гибким и попробуем сделать так, чтобы мы могли положить любой тип данных в наш список. Для этого нам необходимо
сделать наш список generic-ом.

7. Скопируйте классы `MyList` и `LinkedMyList` из 5-ой домашки. Сделайте их generic-ами. Перепишите методы из п 8 - 14
чтобы они работали с нужным типом (классом).

8. Метод `add` (принимает на вход объект и добавляет его в конец списка за o(1))

9. Метод `addFirst` (принимает на вход объект и добавляет его в начало списка за o(1))

10. Метод `insert` (принимает на вход объект a и целое число i. Метод вставляет объект a на i-ое
   место за o(n))

11. Метод `delete` (принимает на вход одно число i. Метод удаляет i-ый элемент в списке за о(n))

12. Метод `get` (принимает на вход одно число i. Метод возвращает i-ый элемент в списке за о(n))

13. Метод `size` (выводит длину списка за o(1))

14. \* Метод `toArray` В данной задаче этот метод должен принимать на вход массив T[] array, и возвращать новый массив, в котором будут все объекты нужного типа.
Для того, чтобы создать generic массив воспользуйтесь функцией:

```java
T[] newArray = (E[]) Array.newInstance(array.getClass(), sizeOfList);
```


### Generics. Бинарное дерево поиска*
В этой домашке у нас есть часть с "повышенной сложностью". Если у вас возникли затруднения со связным списком, то задание с
бинарным деревом можно пропустить и сконцентрироваться на связном списке. Однако если вы идете на отличную оценку по курсу - сделать это задание очень желательно.

Давайте попробуем написать бинарное дерево поиска, которое может работать с любыми числами - как с любыми целыми, так и 
любыми дробными. 
Как вы знаете из курса по алгоритмам бинарное дерево поиска имеет следующие свойства:
- оба поддерева — левое и правое — являются двоичными деревьями поиска;
- у всех узлов левого поддерева произвольного узла X значения ключей данных меньше, нежели значение ключа данных самого узла X;
- у всех узлов правого поддерева произвольного узла X значения ключей данных больше либо равны, нежели значение ключа данных самого узла X.

15. Создайте класс `MyBinaryTree` с дефолтным конструктором.
16. Реализуйте метод `contains` который принимает на вход число и возвращает boolean, содержит ли дерево вершину с таким числом
17. Реализуйте метод `add`, который принимает на вход число и вставляет его в дерево
18. Реализуйте метод `delete`, который принимает на вход число и удаляет его из дерева
19. Реализуйте метод `size`, который возвращает размер дерева
20. Реализуйте метод `toArray`, который возвращает дерево в виде массива чисел. Пусть Вершины двоичного дерева 
располагаются в массиве следующим образом: если k – индекс вершины дерева, то ее потомки находятся в элементах массива 
с индексами 2k + 1 и 2(k + 1). Для создания generics-массива см. соображения из задания 14 второй части домашки.


P.S. Для того чтобы наше дерево работало с любыми чиселками, нам нужно понять, какие ограничения наложить на параметр типа (T). 
Рекомендую почитать java [документацию на Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html) и найти в ней тип(ы), которым(и)
нужно ограничить T, чтобы все заработало.


# Полезные ссылки

[Статья про дженерики](https://skillbox.ru/media/base/dzheneriki-v-java-dlya-samykh-malenkikh/)
