import java.util.Scanner;

public class ExampleSwitch {
    public static void main(String[] args) {
        String menuOptions = """
                1. Mensaje
                2. Consejo
                3. Alerta
                4. Error                
                """;
        int quantityMessages = 0;

        System.out.println(menuOptions);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese una opción: ");
        int option = keyboard.nextInt();

        String result = switch(option){
            case 1 -> {
                quantityMessages++;
                yield "Esto es un mensaje";
            }
            case 2 -> "Si la vida te da la espalda, cogele el qlo";
            case 3 -> "Despiertese, le cogio la noche";
            case 4 -> "Error cargando el sistema";
            default -> "Opción no válida";
        };
        System.out.println(result);
        System.out.printf("Cantidad de mensajes %d", quantityMessages);
    }
}
