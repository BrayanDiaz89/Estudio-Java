import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Pida cuántos estudiantes hay.
        Para cada estudiante, solicite su nombre y nota (de 0 a 5).
        Según la nota:
        Determine si aprueba o reprueba (usando if).
        Determine su calificación en texto (usando switch):
        0 – 1.9 → “Deficiente”
        2.0 – 2.9 → “Insuficiente”
        3.0 – 3.9 → “Aceptable”
        4.0 – 4.5 → “Sobresaliente”
        4.6 – 5.0 → “Excelente”
        Al final, muestre la cantidad de estudiantes aprobados y reprobados.*/

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de estudiantes: ");
        int students = keyboard.nextInt();
        keyboard.nextLine();
        int quantityApproved = 0;
        int quantityRepproved = 0;
        int quantityNotesNull = 0;

        for(int i = 0; i < students; i++){
            System.out.printf("\nIngrese el nombre del estudiante %d: ", i+1);
            String nameStudent = keyboard.nextLine();
            System.out.printf("\nIngrese la nota del estudiante %s: ", nameStudent);
            double noteStudent = keyboard.nextDouble();
            keyboard.nextLine();

            if(!(noteStudent < 0 || noteStudent > 5)){
                String result = noteStudent >= 3 ? "Aprobado" : "Reprobado";
                if(result.equals("Aprobado")){
                    quantityApproved++;
                } else {
                    quantityRepproved++;
                }
                System.out.printf("\nEl estudiante %s, %s", nameStudent, result);
            } else {
                quantityNotesNull++;
                System.out.println("\nLa nota no puede ser menor a 0 o mayor a 5");
                continue;
            }

            String recomendation = switch (noteStudent){
                case 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9 -> "Deficiente";
                case 2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8, 2.9 -> "Insuficiente";
                case 3.0, 3.1, 3.2, 3.3, 3.4, 3.5, 3.6, 3.7, 3.8, 3.9 -> "Aceptable";
                case 4.0, 4.1, 4.2, 4.3, 4.4, 4.5 -> "Sobresaliente";
                case 4.6, 4.7, 4.8, 4.9, 5.0 -> "Excelente";
                default -> "Nota no valida";
            };
            System.out.printf("\n¡%s! %s, sigue así", recomendation, nameStudent);
        }

        System.out.printf("\nTotal de estudiantes aprobados: %d", quantityApproved);
        System.out.printf("\nTotal de estudiantes reprobados: %d", quantityRepproved);
        System.out.printf("\nTotal de notas nulas: %d", quantityNotesNull);
    }
}