import java.util.Scanner;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String cpfInformado = "";

        System.out.println("** -  Informe somente o números do CPF  para validação - **");
        cpfInformado = ler.next();

        int multiplicador = 10;
        int somaTotal = 0;

        for (int i = 0; i < (cpfInformado.length() - 2); i++) {
            int n = parseInt(String.valueOf(cpfInformado.charAt(i))) * multiplicador;
            //System.out.println(String.format("conta: %s * %d = %d", cpfInformado.charAt(i), multiplicador, n));
            somaTotal += n;
            multiplicador--;
        }
        int primeiroDigito = 11 - (somaTotal % 11) >= 10 ?  0 : 11 - somaTotal % 11;

        somaTotal = 0;
        multiplicador = 11;
        for (int i = 0; i < (cpfInformado.length() - 1); i++) {
            int n = parseInt(String.valueOf(cpfInformado.charAt(i))) * multiplicador;
           // System.out.println(String.format("conta: %s * %d = %d", cpfInformado.charAt(i), multiplicador, n));
            somaTotal += n;
            multiplicador--;
        }

        int segundoDigito = 11 - (somaTotal % 11) >= 10 ?  0 : 11 - somaTotal % 11;

        if(parseInt(String.valueOf(cpfInformado.charAt(9))) == primeiroDigito && parseInt(String.valueOf(cpfInformado.charAt(10))) == segundoDigito){
            System.out.println("**** CPF VÁLIDO ****");
        }else{
            System.out.println("**** CPF INVÁLIDO ****");
        }
    }
}