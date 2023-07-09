package HW5;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся 
// имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task01 {

  public static void main(String[] args) {
    Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    addNumber("Козел Козлов", 111, phoneBook);
    addNumber("Чеснок Чесноков", 222, phoneBook);
    addNumber("Козел Козлов", 333, phoneBook);
    addNumber("Сидр Сидоров", 444, phoneBook);
    addNumber("Петра Петрова", 555, phoneBook);
    addNumber("Чеснок Чесноков", 666, phoneBook);
    printBook(phoneBook);
  }
  public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) { // Метод, добавляющий
                                                                                             // номера в книгу
    if (map.containsKey(key)) {
      map.get(key).add(value);
    } else {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(value);
      map.put(key, list);
    }
  }
  public static void printBook(Map<String, ArrayList<Integer>> map) { // Метод, печатающий список контактов
    for (var item : map.entrySet()) {
      String phones = "";
      for (int el : item.getValue()) {
        phones = phones + el + ", ";
      }
      // Collections.sort(phones, Collections.reverseOrder());
      // Collections.reverse(phones);
      System.out.printf("%s: %s \n", item.getKey(), phones);
    }
  }
}