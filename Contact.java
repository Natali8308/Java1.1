import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {
    private static List<String> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contactIndex = 1;

        while (true) {
            System.out.println("1. Новый контакт");
            System.out.println("2. Редактировать контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    if (contacts.size() >= 10) {
                        System.out.println("Достигнуто максимальное количество контактов (10). Редактирование невозможно.");
                        break;
                    }

                    System.out.print("Введите имя контакта: ");
                    String name = scanner.nextLine();
                    while (name.isEmpty()) {
                        System.out.println("Данное поле не заполнено, введите значение заново.");
                        System.out.print("Введите имя контакта: ");
                        name = scanner.nextLine();
                    }

                    System.out.print("Введите номер телефона: ");
                    String value = scanner.nextLine();
                    while (value.isEmpty()) {
                        System.out.println("Данное поле не заполнено, введите значение заново.");
                        System.out.print("Введите номер телефона: ");
                        value = scanner.nextLine();
                    }

                    contacts.add(name + ": " + value);
                    break;

                    case 2:
                    System.out.print("Введите индекс контакта для редактирования: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); 
                    if (index >= 0 && index < contacts.size()) {
                        System.out.print("Введите новое имя для контакта: ");
                        String newname = scanner.nextLine();
                
                        while (newname.isEmpty()) {
                            System.out.println("Данное поле не заполнено, введите значение заново.");
                            System.out.print("Введите новое имя контакта: ");
                            newname = scanner.nextLine();
                        }
                
                        System.out.print("Введите новый номер для контакта: ");
                        String newvalue = scanner.nextLine();
                
                        while (newvalue.isEmpty()) {
                            System.out.println("Данное поле не заполнено, введите значение заново.");
                            System.out.print("Введите новый номер контакта: ");
                            newvalue = scanner.nextLine();
                        }
                
                        contacts.set(index, newname + ": " + newvalue);
                
                        System.out.println("Контакт по индексу " + index + " успешно отредактирован");
                    } else {
                        System.out.println("Контакт не найден");
                    }
                    break;
                
                

                case 3:
                    System.out.print("Введите индекс контакта для удаления: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); 
                    if (deleteIndex >= 0 && deleteIndex < contacts.size()) {
                        contacts.remove(deleteIndex);
                        System.out.println("Контакт успешно удален");
                    } else {
                        System.out.println("Контакт не найден");
                    }
                    break;

                case 4:
                    System.out.println("Выход из программы...");
                    return;

                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }

            // Выводим список всех контактов после каждой операции
            System.out.println("Список контактов:");
            int count = 1;
            for (String contact : contacts) {
                System.out.println(count + ". " + contact);
                count++;
            }
            System.out.println();
            contactIndex++;
        }
    }
}

