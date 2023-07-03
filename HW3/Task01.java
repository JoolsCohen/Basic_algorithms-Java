package HW3;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;

public class Task01 {
  // Пусть дан произвольный список целых чисел,
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    Random rand = new Random();
    for (int i = 0; i < 10; i++) {
      numbers.add(rand.nextInt(100));
    }
    // Нужно удалить из него чётные числа
    Iterator<Integer> iterator = numbers.iterator();
    while (iterator.hasNext()) {
      int number = iterator.next();
      if (number % 2 == 0) {
        iterator.remove();
      }
    }
    System.out.println("Долой четные числа: " + numbers);
    System.out.println("Максимальное число: " + Collections.max(numbers));
    System.out.println("Минимальное число: " + Collections.min(numbers));
    double sum = 0;
    for (Integer integer : numbers){
      sum += integer.intValue();
    }
    double average = (double)sum / (double)numbers.size();
    System.out.println("Среднее арифметическое у нас будет: " + average);
  }
}
