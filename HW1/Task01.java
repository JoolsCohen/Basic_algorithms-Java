package HW1;

import java.util.Random;

public class Task01 {
  public static void main(String[] args) {
    // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
    int k = 2000;
    int i = new Random().nextInt(k);
    System.out.println("Случайное число i =  " + i);
    // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    int n = 0;
    int temp = i;
    while(temp != 0){
      temp = temp >> 1;
      n++;
    }
    System.out.println("Номер старшего значащего бита n =  " + n);
    //Инициализируем массивы
    int[] m1 = new int[Short.MAX_VALUE - i];
    int[] m2 = new int[i - Short.MIN_VALUE];
    // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    int index1 = 0;
    for (int j = i; j <= Short.MAX_VALUE; j++){
      if (j % n == 0){
        m1[index1] = j;
        index1 ++;
      }
    }
    System.out.println("Длина массива m1 =  " + index1);
    // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    int index2 = 0;
    for (int j = Short.MIN_VALUE; j < i; j++){
      if (j % n != 0){
        m2[index2] = j;
        index2 ++;
      }
    }
    System.out.println("Длина массива m2 =  " + index2);
  }
}