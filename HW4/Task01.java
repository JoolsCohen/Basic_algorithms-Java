package HW4;

import java.util.*;

// // Организовать ввод и хранение данных пользователей. ФИО возраст и пол
// // вывод в формате Фамилия И.О. возраст пол
// // добавить возможность выхода или вывода списка отсортированного по возрасту!)
// // *реализовать сортировку по возрасту с использованием индексов
// // *реализовать сортировку по возрасту и полу с использованием индексов.
// public class Task01 {
//   public static void main(String[] args) {
//     List<String> fio = new ArrayList<String>();
//     List<Integer> age = new ArrayList<>();
//     List<String> gender = new ArrayList<>();
//     // System.out.println("Введите ФИО: ");
//     Scanner scanner = new Scanner(System.in);
//     while (true) {
//       String[] line = scanner.nextLine().split(" ");
//       if (line[0].equals("stop"))
//         break;
//       fio.add(String.format("%1$s %2$s.%3$s.", line[0], line[1].charAt(0), line[2].charAt(0)));
//       age.add(Integer.parseInt(line[3]));
//       gender.add(line[4]);
//     }
//     // System.out.println(String.format("фио %1$s, возраст %2$s, пол:
//     // %3$s",fio,age,gender));
//     LinkedList<Integer> linkId = new LinkedList<Integer>();
//     int count = 0;
//     for (String f : fio) {
//       System.out.println(f);
//       linkId.add(count);
//       count++;
//     }
//     int cnt = linkId.size() - 1;
//     while (cnt > -1) {
//       int maxAge = age.get(linkId.get(cnt));
//       int index = cnt;
//       for (int i = 0; i < cnt; i++) {
//         if (maxAge < age.get(linkId.get(i))) {
//           maxAge = age.get(linkId.get(i));
//           index = i;
//         }
//       }

//       int tmp = linkId.get(cnt);
//       linkId.set(cnt, linkId.get(index));
//       linkId.set(index, tmp);
//       cnt--;
//     }
//     System.out.println(linkId);
//     linkId.forEach(n -> System.out.println(String.format("%1$s %2$s", fio.get(n), age.get(n))));

//   }
// }

public class Task01 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int count = 0;
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<String> firstName = new ArrayList<>();
    ArrayList<String> secondName = new ArrayList<>();
    ArrayList<String> lastName = new ArrayList<>();
    ArrayList<Integer> age = new ArrayList<>();
    ArrayList<String> sex = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      id.add(count++);
      firstName.add("Name" + i);
      secondName.add("sName" + i);
      lastName.add("lName" + i);
      age.add(new Random().nextInt(50));
      if (i % 2 == 0) {
        sex.add("woman");
      } else
        sex.add("man");

    }
    boolean flag = true;

    while (flag) {
      System.out.println("""
          Выберите действие: \s
          q - выход
          view - просмотреть все контакты
          new - записать новый контакт
          sortAge - сортировка по возрасту
          sortSex - сортировка по полу""");
      switch (scanner.nextLine()) {
        case "q" -> flag = false;
        case "view" -> {
          System.out.println("=".repeat(120));
          for (int i = 0; i < count; i++) {
            System.out.printf("%d %s %s %s %d %s\n",
                id.get(i), firstName.get(i), secondName.get(i),
                lastName.get(i), age.get(i), sex.get(i));
          }
          System.out.println("=".repeat(120));
        }
        case "new" -> {
          id.add(count++);
          System.out.print("Введите имя: ");
          firstName.add(scanner.nextLine());
          System.out.print("Введите отчество: ");
          secondName.add(scanner.nextLine());
          System.out.print("Введите фамилию: ");
          lastName.add(scanner.nextLine());
          System.out.print("Введите возраст: ");
          age.add(scanner.hasNextInt() ? scanner.nextInt() : -1);
          scanner.nextLine();
          System.out.print("Введите пол w - женский, m - мужской: ");
          sex.add(scanner.nextLine().equals("w") ? "woman" : "man");
        }
        case "sortAge" -> {
          int tmp;
          for (int j = 0; j < age.size(); j++) {
            for (int i = 0; i < age.size() - 1; i++) {
              if (age.get(i + 1) > age.get(i)) {
                tmp = age.get(i + 1);
                age.set(i + 1, age.get(i));
                age.set(i, tmp);
                tmp = id.get(i + 1);
                id.set(i + 1, id.get(i));
                id.set(i, tmp);
              }
            }
          }

          firstName = Task01.changeIdStr(id, firstName);
          secondName = Task01.changeIdStr(id, secondName);
          lastName = Task01.changeIdStr(id, lastName);
          sex = Task01.changeIdStr(id, sex);
        }
        case "sortSex" -> {
          int tmp;
          String tmps;
          for (int j = 0; j < sex.size(); j++) {
            for (int i = 0; i < sex.size() - 1; i++) {
              if (sex.get(i + 1).equals("woman") & sex.get(i).equals("man")) {
                tmps = sex.get(i + 1);
                sex.set(i + 1, sex.get(i));
                sex.set(i, tmps);
                tmp = id.get(i + 1);
                id.set(i + 1, id.get(i));
                id.set(i, tmp);
              }
            }
          }
          firstName = Task01.changeIdStr(id, firstName);
          secondName = Task01.changeIdStr(id, secondName);
          lastName = Task01.changeIdStr(id, lastName);
          age = Task01.changeIdInt(id, age);
        }
      }

    }
    scanner.close();
  }

  static ArrayList<String> changeIdStr(ArrayList<Integer> id, ArrayList<String> arrStr) {
    ArrayList<String> sorted = new ArrayList<>();
    for (Integer integer : id) {
      sorted.add(arrStr.get(integer));
    }
    return sorted;
  }

  static ArrayList<Integer> changeIdInt(ArrayList<Integer> id,
      ArrayList<Integer> arrStr) {
    ArrayList<Integer> sorted = new ArrayList<>();
    for (Integer integer : id) {
      sorted.add(arrStr.get(integer));
    }
    return sorted;
  }
}
