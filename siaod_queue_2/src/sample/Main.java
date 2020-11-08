package sample;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        CombinedQueue cQ = new CombinedQueue();
        Random rand = new Random();

        //Заполняем комбинированную очередь 1000 пакетами
        for (int i = 0; i < 1000; i++) {
            long info = rand.nextInt(200);  //Информация - случайное число от [0;200)
            long type = rand.nextInt(5);    //Тип пакета - случайно число от [0;4]
            cQ.insert(new Data(info, type));
        }

        System.out.println("=================================Проверка поиска в очереди=================================");
        //Ищем данные в очереди
        cQ.insert(new Data(-12,0));
        System.out.println(cQ.find(-12));       //Успешная попытка
        cQ.insert(new Data(-33, 1));
        System.out.println(cQ.find(-33));       //Успешная попытка
        System.out.println(cQ.find(-32));       //Безуспешная попытка (null)
        cQ.insert(new Data(-32, 2));
        System.out.println(cQ.find(-32));       //Успешная попытка
        cQ.insert(new Data(-100, 3));
        System.out.println(cQ.find(-100));      //Успешная попытка
        System.out.println(cQ.find(-256));      //Безуспешная попытка (null)
        System.out.println(cQ.find(-1));        //Безуспешная попытка (null)
        System.out.println(cQ.find(-2));        //Безуспешная попытка (null)
        System.out.println(cQ.find(-3));        //Безуспешная попытка (null)
        System.out.println(cQ.find(-4));        //Безуспешная попытка (null)
        cQ.insert(new Data(-256, 4));
        System.out.println(cQ.find(-256));      //Успешная попытка
        System.out.println("============================================================================================");

        System.out.println();

        System.out.println("=============================Проверка обработки данных в очереди============================");
        while (!cQ.isEmpty()) {
            cQ.process();
            System.out.println("============================================================================================");
        }
        //Показываем, что извлекать больше нечего
        cQ.process();
    }


}
