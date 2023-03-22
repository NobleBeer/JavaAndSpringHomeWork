# Дополнительные задачки к домашке 8.

## Как сдать?
Для сдачи этой домашки нужно зарегистрироваться на leetcode. Leetcode - это сайт, где собраны различные алгоритмические 
задачки для подготовки к интервью в мировых it-компаниях. Решите 4 следующих задачи, загрузите решение
на leetcode и убедитесь, что тесты вашего решения проходят. После этого добавьте классы с решениями задачек в этот 
репозиторий, в pr добавьте скриншот с пройденными тестами на leetcode.


## Дедлайны
- Мягкий дедлайн - 11.03
- Жесткий дедлайн - 18.03

## Задачи
### 1. Правильная скобочная последовательность
Leetcode: [leetcode.com/problems/valid-parentheses/](https://leetcode.com/problems/valid-parentheses/)


Проверить, что строка является правильно скобочной последовательностью. "[{}[]([])]" - правильная скобочная последовательность, а "[{}({)}]" - нет

### 2. Анаграммы.
Leetcode: [leetcode.com/problems/valid-anagram](https://leetcode.com/problems/valid-anagram/description/)

На вход даются две строки необходимо проверить являются ли они анаграммами друг друга.

#### Примеры:
**Input:** s = "anagram", t = "nagaram"

**Output:** true


**Input:** s = "rat", t = "car"

**Output:** false

### 3. Top-K.
Leetcode: [leetcode.com/problems/top-k-frequent-words/](https://leetcode.com/problems/top-k-frequent-words/)

Дан массив строк "words" и целое число k, верните k наиболее часто встречающихся строк.

Верните ответ, отсортированный по частоте от самой высокой к самой низкой.
Отсортируйте слова с одинаковой частотой по их лексикографическому порядку.

#### Примеры:
**Input:** words = ["i","love","leetcode","i","love","coding"], k = 2

**Output:** ["i","love"]

**Explanation:** "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.



**Input:** words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4

**Output:** ["the","is","sunny","day"]

**Explanation:** "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.


### 4. Best Time to Buy and Sell Stock

Leetcode: [leetcode.com/problems/best-time-to-buy-and-sell-stock/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

#### Примеры:
**Input:** prices = [7,1,5,3,6,4]

**Output:** 5

**Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.



**Input:** prices = [7,6,4,3,1]

**Output:** 0

**Explanation:** In this case, no transactions are done and the max profit = 0.
