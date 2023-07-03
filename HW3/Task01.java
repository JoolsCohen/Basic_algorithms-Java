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
    Iterator<Integer> iter = numbers.iterator();
    while (iter.hasNext()) {
      int number = iter.next();
      if (number % 2 == 0) {
        iter.remove();
      }
    }
    System.out.println("Долой четные числа: " + numbers);
    // Найти максимальное значение
    System.out.println("Максимальное число: " + Collections.max(numbers));
    // Найти минимальное значение
    System.out.println("Минимальное число: " + Collections.min(numbers));
    //Найти среднее значение
    double sum = 0;
    for (Integer num : numbers){
      sum += num.intValue();
    }
    double average = (double)sum / (double)numbers.size();
    System.out.print("Среднее число у нас будет: ");
    System.out.println(Math.round(average* 100.0) / 100.0);
  }
}
