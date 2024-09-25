# Calculadora Simples em Java

Este é um programa de **Calculadora Simples** desenvolvido em Java que realiza as quatro operações matemáticas básicas: **adição**, **subtração**, **multiplicação** e **divisão**. Ele permite ao usuário inserir dois números e escolher a operação que deseja realizar.

## Funcionalidades

- **Adição**: Soma dois números.
- **Subtração**: Subtrai o segundo número do primeiro.
- **Multiplicação**: Multiplica dois números.
- **Divisão**: Divide o primeiro número pelo segundo, com tratamento para evitar divisão por zero.

## Como Usar

1. **Entrada de dados**: O programa solicita que você insira dois números.
2. **Escolha da operação**: Você será solicitado a escolher uma das seguintes operações:
   - `1`: Adição
   - `2`: Subtração
   - `3`: Multiplicação
   - `4`: Divisão
3. O programa então exibe o resultado da operação escolhida.

## Exemplo de Uso

1. Execute o programa.
2. Insira o primeiro número: `10`.
3. Insira o segundo número: `5`.
4. Escolha a operação (por exemplo, digite `1` para adição).
5. O programa exibe o resultado: `10 + 5 = 15`.

## Código de Exemplo

```java
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada dos números
        System.out.println("Insira o primeiro número:");
        double num1 = scanner.nextDouble();

        System.out.println("Insira o segundo número:");
        double num2 = scanner.nextDouble();

        // Escolha da operação
        System.out.println("Escolha a operação: ");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");

        int escolha = scanner.nextInt();
        double resultado = 0;

        // Realização da operação escolhida
        switch (escolha) {
            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado: " + num1 + " + " + num2 + " = " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado: " + num1 + " * " + num2 + " = " + resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
                } else {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                }
                break;
            default:
                System.out.println("Operação inválida.");
        }

        scanner.close();
    }
}
