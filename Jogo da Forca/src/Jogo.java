import java.util.Scanner;
import java.util.Arrays;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a Palavra secreta: ");
        // 1. Convertendo para maiúsculo para evitar erros de comparação
        String palavraSecreta = scanner.next().toUpperCase();
        char[] palavraOculta = new char[palavraSecreta.length()];

        for(int i = 0; i < palavraSecreta.length(); i++){
            palavraOculta[i] = '_';
        }

        int tentativas = 6;
        boolean venceu = false;

        while(tentativas > 0){
            System.out.println("\n---------------------------");
            System.out.println("Palavra: " + String.valueOf(palavraOculta));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");

            char letra = scanner.next().toUpperCase().charAt(0);

            boolean acertou = false;
            for(int i = 0; i < palavraSecreta.length(); i++){
                if(palavraSecreta.charAt(i) == letra){
                    palavraOculta[i] = letra;
                    acertou = true;
                }
            }

            if(!acertou){
                tentativas--;
                System.out.println("-> Letra incorreta!");
            } else {
                System.out.println("-> Letra correta!");
            }

            if(String.valueOf(palavraOculta).equals(palavraSecreta)){
                venceu = true;
                break;
            }
            // O tentativas-- que estava aqui foi removido!
        }

        System.out.println("\n===========================");
        if(venceu){
            System.out.println("PARABÉNS! Você venceu!");
        } else {
            System.out.println("QUE PENA! Suas chances acabaram.");
        }
        System.out.println("A palavra era: " + palavraSecreta);

        scanner.close();
    }
}