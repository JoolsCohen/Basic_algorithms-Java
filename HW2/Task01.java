package HW2;

/* Задача 1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json строки. Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}*/

public class Task01 {
  public static void main(String[] args) {
    StringBuilder request = new StringBuilder();
    String[] str = { "name:Ivanov", "country:Russia", "city:Moscow", "age:null" };
    for (int i = 0; i < str.length; i++) {
      if (str[i].indexOf("null") == (-1)) {                                           // если индекс строки "null" будет не найден
        request.append(str[i].replace(":", "="));
        if (i != str.length - 2) {                                                        // -2, чтобы не добавить AND после последнего
          request.append(" AND ");
        }
      }
    }
    System.out.println(request);                                                          // name=Ivanov AND country=Russia AND city=Moscow
  }
}
