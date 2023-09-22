//Задание
//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре будут
//повторяющиеся имена с разными телефонами, их необходимо считать,
//как одного человека с разными телефонами.
//Вывод должен быть отсортирован по убыванию числа телефонов.


import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<Integer, String> phoneBook = new HashMap<>(); // создаем телефонную книгу
        phoneBook.put(111, "Аронов");
        phoneBook.put(123, "Иванов");
        phoneBook.put(124, "Петров");
        phoneBook.put(125, "Аронов");
        phoneBook.put(126, "Сидоров");
        phoneBook.put(127, "Иванов");
        phoneBook.put(128, "Кротов");
        phoneBook.put(129, "Волков");
        phoneBook.put(130, "Аронов");
        phoneBook.put(132, "Иванов");
        phoneBook.put(133, "Сидоров");
        phoneBook.put(134, "Аронов");
        phoneBook.put(135, "Волков");
        phoneBook.put(136, "Иванов");
        phoneBook.put(137, "Аронов");
        //System.out.print("Телефонная книга: \n");
        //phoneBook.forEach((k,v)->System.out.print(v+":  "+k+", \n"));             // вывод на экран

        Collection<String> allSurnames = phoneBook.values();                         // получаем все значения (все фамилии) phoneBook
        //System.out.println(allSurnames);
        Map<String, Integer> countOfphones = new HashMap<>();                     // фамилии + количество телефонов
        for (String surname : allSurnames) {                                        // перебираем фамилии
            int countPhones = 0;
            for (Map.Entry<Integer, String> element : phoneBook.entrySet()) {   // перебираем phoneBook
                if (surname == element.getValue()) {
                    countPhones++;                                              // считаем количество телефонов
                }
            }
            countOfphones.put(surname, countPhones);
        }
        // System.out.println("countOfphones: " + countOfphones);
        ArrayList<Integer> countPhones = new ArrayList<>();                         //создаём ArrayList для количества телефонов
        Arrays.stream(countOfphones.values().toArray()).forEach(n -> countPhones.add((Integer) n)); //добавляем все значения в новый ArrayList
        Set<Integer> set = new HashSet<>(countPhones);                      // удаление повторяющихся элементов
        countPhones.clear();
        countPhones.addAll(set);
        Collections.sort(countPhones, Collections.reverseOrder());          // сортировка по убыванию
        //System.out.println(countPhones);
        ArrayList<String> listSurnames = new ArrayList<>();                 // список фамилий по убыванию телефонов
        for (Integer el : countPhones) {
            for (Map.Entry<String, Integer> element : countOfphones.entrySet()) {
                if (el == element.getValue()) {
                    //System.out.println(element.getKey());
                    listSurnames.add(element.getKey());
                }
            }
        }
        //System.out.println(listSurnames);

        for (String surname : listSurnames) {                                   // перебираем фамилии
            System.out.println(surname + ": ");                                 // вывод фамилии на экран
            for (Map.Entry<Integer, String> element : phoneBook.entrySet()) {    // перебираем телефонную книгу
                if (surname == element.getValue()) {
                    System.out.println(element.getKey());                          // вывод на экран всех телефонов у данного контакта
                }
            }
        }
    }
}


