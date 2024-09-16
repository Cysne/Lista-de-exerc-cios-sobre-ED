//1. Implemente um gerenciador de tarefas onde cada tarefa é um nó em uma lista
//simplesmente encadeada. Permita que o usuário adicione, remova, e marque tarefas
//como concluídas.

import java.util.Scanner;

class Task {
    String task;
    boolean done;
    Task next;

    Task(String task) {
        this.task = task;
        this.done = false;
        this.next = null;
    }
}

class TaskManager {
    Task head;

    public void addTask(String task) {
        Task newTask = new Task(task);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public void removeTask(String task) {
        if (head == null)
            return;

        if (head.task.equals(task)) {
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null && !current.next.task.equals(task)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void markTaskAsDone(String task) {
        Task current = head;
        while (current != null) {
            if (current.task.equals(task)) {
                current.done = true;
                return;
            }
            current = current.next;
        }
    }

    public void printTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current.task + (current.done ? " [Concluída]" : " [Pendente]"));
            current = current.next;
        }
    }
}

public class atv1 {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (choice) {
                case 1:
                    System.out.println("Digite a tarefa:");
                    String task = scanner.nextLine();
                    manager.addTask(task);
                    break;
                case 2:
                    System.out.println("Digite a tarefa a ser removida:");
                    task = scanner.nextLine();
                    manager.removeTask(task);
                    break;
                case 3:
                    System.out.println("Digite a tarefa a ser marcada como concluída:");
                    task = scanner.nextLine();
                    manager.markTaskAsDone(task);
                    break;
                case 4:
                    manager.printTasks();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}