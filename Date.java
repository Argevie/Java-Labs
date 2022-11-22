import java.util.Scanner;
import java.lang.String;


public class Date {
    static int Days;                  //сколько дней в заданной дате


    public enum DayOfWeek {
        Понедельник,              //перечисление дни недели
        Вторник,
        Среда,
        Четверг,
        Пятница,
        Суббота,
        Воскресенье
    }
    public static int setDate() {
        Scanner input = new Scanner(System.in);   //ввести год
        System.out.print("Введите год: ");
        int y = input.nextInt();
        int countY = 0;                      //Подсчёт високосных лет
        for (int i = 0; i < y; i++) {
            if (i % 4 != 0) {
                countY += 0;
            } else if (i % 400 == 0) {
                countY++;
            } else if (i % 100 == 0) {
                countY += 0;
            } else {
                countY++;
            }
        }

        boolean error = false;           //проверка на ошибку
        int dayPass = 0;                 //сколько дней прошло от начала года
        int dayinM = 0;                  //cколько максимально дней в месяце
        do {
            System.out.print("Введите месяц: ");          //ввод месяца
            int m = input.nextInt();

            switch (m) {
                case 1:
                    dayPass = 0;
                    dayinM = 31;
                    error = false;
                    break;
                case 2:
                    dayPass = 31;
                    dayinM = 28;
                    error = false;
                    break;
                case 3:
                    dayPass = 31 + 28;
                    dayinM = 31;
                    error = false;
                    break;
                case 4:
                    dayPass = 31 + 28 + 31;
                    dayinM = 30;
                    error = false;
                    break;
                case 5:
                    dayPass = 31 + 28 + 31 + 30;
                    dayinM = 31;
                    error = false;
                    break;
                case 6:
                    dayPass = 31 + 28 + 31 + 30 + 31;
                    dayinM = 30;
                    error = false;
                    break;
                case 7:
                    dayPass = 31 + 28 + 31 + 30 + 31 + 30;
                    dayinM = 31;
                    error = false;
                    break;
                case 8:
                    dayPass = 31 + 28 + 31 + 30 + 31 + 30 + 31;
                    dayinM = 31;
                    error = false;
                    break;
                case 9:
                    dayPass = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                    dayinM = 30;
                    error = false;
                    break;
                case 10:
                    dayPass = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                    dayinM = 31;
                    error = false;
                    break;
                case 11:
                    dayPass = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                    dayinM = 30;
                    error = false;
                    break;
                case 12:
                    dayPass = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                    dayinM = 31;
                    error = false;
                    break;
                default:
                    System.out.println("error");
                    error = true;
                    break;

            }
        }
        while (error == true);            //валидация месяца
        int d;
        boolean errord =false;                   //ошибка при вводе дня
        do {
            System.out.print("Введите день: ");         //ввод дня
            d = input.nextInt();
            if (d<1||d>dayinM){
                errord = true;
                System.out.println("error");
            }
        }
        while (errord==true);       //валидация дня недели
        int total = (365*y)+countY+dayPass+d; //подсчет сколько всего прошло дней

        int num = 0;          //какой сейчас день недели
        for (int i = 0;i < total; i++) {
            num++;
            if (num > 7) {
                num = 1;
            }
        }
        switch (num) {
            case 1:
                System.out.println(DayOfWeek.Понедельник);break;
            case 2:
                System.out.println(DayOfWeek.Вторник);break;
            case 3:
                System.out.println(DayOfWeek.Среда);break;
            case 4:
                System.out.println(DayOfWeek.Четверг);break;
            case 5:
                System.out.println(DayOfWeek.Пятница);break;
            case 6:
                System.out.println(DayOfWeek.Суббота);break;
            case 7:
                System.out.println(DayOfWeek.Воскресенье);break;
        }



        return total;
    }

        public static void main (String[]args){
            Date date1 = new Date();
            int d1 = Date.Days;
            Date date2 = new Date();
            int d2 = Date.Days;
            System.out.println("дней между введенными датами: "+Math.abs(d1-d2) );
        }

    public Date() {
            this.Days = setDate();
        }
    }

