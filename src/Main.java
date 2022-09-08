import java.util.Scanner;

public class Main {

    static boolean roman = false;
    public static void main(String[] args) throws WrongSymbolException, DiffNumTypesException, RomanException {
        String expression = input();
        int result = calc(expression);
        if (roman) {
            String resultRoman = convert(result);
            System.out.println("Результат: " + resultRoman);
        }
        else {
            System.out.println("Результат: " + result); // предварительно................................
        }
    }
    static String input()  {
        Scanner line = new Scanner (System.in);
        System.out.println("Введите выражение: ");
        String expression = line.nextLine();
        line.close();
        return expression;
    }
    static int calc(String expression) throws WrongSymbolException, DiffNumTypesException {
       int result = 0;
       String[] symbols = expression.split(" ");
       String[] stringNumbers = {symbols[0], symbols[2]};
       int[] numbers = new int[2];
       boolean[] romans = {false, false};
       for (int i = 0; i < 2; i++) {
           switch (stringNumbers[i]) {
               case "1":
                   numbers[i] = 1;
                   break;
               case "2":
                   numbers[i] = 2;
                   break;
               case "3":
                   numbers[i] = 3;
                   break;
               case "4":
                   numbers[i] = 4;
                   break;
               case "5":
                   numbers[i] = 5;
                   break;
               case "6":
                   numbers[i] = 6;
                   break;
               case "7":
                   numbers[i] = 7;
                   break;
               case "8":
                   numbers[i] = 8;
                   break;
               case "9":
                   numbers[i] = 9;
                   break;
               case "10":
                   numbers[i] = 10;
                   break;
               case "I":
                   numbers[i] = 1;
                   romans [i] = true;
                   break;
               case "II":
                   numbers[i] = 2;
                   romans [i] = true;
                   break;
               case "III":
                   numbers[i] = 3;
                   romans [i] = true;
                   break;
               case "IV":
                   numbers[i] = 4;
                   romans [i] = true;
                   break;
               case "V":
                   numbers[i] = 5;
                   romans [i] = true;
                   break;
               case "VI":
                   numbers[i] = 6;
                   romans [i] = true;
                   break;
               case "VII":
                   numbers[i] = 7;
                   romans [i] = true;
                   break;
               case "VIII":
                   numbers[i] = 8;
                   romans [i] = true;
                   break;
               case "IX":
                   numbers[i] = 9;
                   romans [i] = true;
                   break;
               case "X":
                   numbers[i] = 10;
                   romans [i] = true;
                   break;
               default:
                   throw new WrongSymbolException("Неверный формат выражения, числа не целые или не все числа принадлежат промежутку 1 ... 10");
           }
       }
       if (romans[0] != romans[1])  {
           throw new DiffNumTypesException("Введены разные виды чисел ");
       }

        switch (symbols[1]) {
           case "+":
               result = numbers[0] + numbers[1];
               break;
           case "-":
               result = numbers[0] - numbers[1];
               break;
           case "*":
               result = numbers[0] * numbers[1];
               break;
           case "/":
               result = numbers[0] / numbers[1];
               break;
           default:
       }
       roman = romans[0];
       return result;
    }
    static String convert(int result) throws RomanException {
        if(result < 1)  {
            throw new RomanException("Результат отрицательный, интерпретация в римских числах невозможна ");
        }
        String resultRoman = "";
        switch(result / 10)   {
            case 10:
                resultRoman = "C";
                break;
            case 9:
                resultRoman = "XC";
                break;
            case 8:
                resultRoman = "LXXX";
                break;
            case 7:
                resultRoman = "LXX";
                break;
            case 6:
                resultRoman = "LX";
                break;
            case 5:
                resultRoman = "L";
                break;
            case 4:
                resultRoman = "XL";
                break;
            case 3:
                resultRoman = "XXX";
                break;
            case 2:
                resultRoman = "XX";
                break;
            case 1:
                resultRoman = "X";
                break;
        }
        switch (result % 10)    {
            case 9:
                resultRoman = resultRoman + "IX";
                break;
            case 8:
                resultRoman = resultRoman + "VIII";
                break;
            case 7:
                resultRoman = resultRoman + "VII";
                break;
            case 6:
                resultRoman = resultRoman + "VI";
                break;
            case 5:
                resultRoman = resultRoman + "V";
                break;
            case 4:
                resultRoman = resultRoman + "IV";
                break;
            case 3:
                resultRoman = resultRoman + "III";
                break;
            case 2:
                resultRoman = resultRoman + "II";
                break;
            case 1:
                resultRoman = resultRoman + "I";
                break;
        }
        return resultRoman;
    }
}