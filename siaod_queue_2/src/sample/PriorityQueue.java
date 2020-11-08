package sample;

//Класс-приоритетная-очередь
class PriorityQueue {
    private Data head;      //Первый пакет приоритетной очереди
    private long size;      //Размер списка
    //Возвращаем размер приритетной очереди
    public long getSize() {
        return size;
    }
    //Конструктор для создания пустой приоритетной очереди
    public PriorityQueue() {
        head = null;
        size = 0;
    }
    //Добавление нового пакета данных в приоритетную очередь
    public void insert(Data data) {
        //Если очередь пуста, то просто запоминаем новое начало
        if (head == null) {
            //Запоминаем начало
            head = data;
        } else {
            Data curr = head;

            if (data.getInfo() >= head.getInfo()){
                data.next = head;
                head = data;
            } else {
                Data prev = curr;

                while (curr != null && data.getInfo() < curr.getInfo()) {
                    prev = curr;
                    curr = curr.next;
                }

                data.next = curr;
                prev.next = data;
            }
        }
        //Увеличиваем размер списка
        size++;
    }
    //Метод для извлечения элементов из начала очереди
    public Data[] remove(long toBeRemoved){
        //Массив с возвратом адресов извлекаемых из очереди объектов
        Data[] toReturn = null;

        if (size < toBeRemoved){
            //Возвращаем всю очередь
            toReturn = new Data[(int)size];
        } else {
            //Либо только её часть
            toReturn = new Data[(int)toBeRemoved];
        }
        //Заполняем массив, параллельно сдвигая голову очереди
        int ind = 0;
        while (ind != toReturn.length){
            Data temp = head;
            head = head.next;
            temp.next = null;
            toReturn[ind] = temp;
            ind++;
        }

        size -= toReturn.length;
        return toReturn;
    }
    //Метод для поиска пакета данных по содержимому
    public Data find(long info){
        Data curr = head;
        while (curr != null) {
            if (curr.getInfo() == info) break;
            curr = curr.next;
        }
        return curr;
    }
}
