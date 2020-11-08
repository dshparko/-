package sample;

//Класс-взвешенная-очередь
class WeightedQueue {
    private Data head;      //Первыц пакет взвешенной очереди
    private Data last;      //Последний пакет взвешенной очереди
    private long size;      //Размер взвешенной очереди
    private final long capacity;  //Пропускная способность взвешенной очереди
    //Возвращаем размер взвешенной очереди
    public long getSize() {
        return size;
    }
    //Конструктор для создания пустой взвешенной очереди
    public WeightedQueue(long capacity) {
        head = null;
        last = null;
        size = 0;
        this.capacity = capacity;
    }
    //Добавление нового пакета данных в очередь
    public void pushBack(Data data) {
        //Если очередь пуста, то просто запоминаем новое начало
        if (head == null) {
            //Запоминаем начало
            head = data;
        } else {
            //Присоединяем к концу взвешенной очереди
            last.next = data;
        }
        //Запоминаем новый конец
        last = data;
        //Увеличиваем размер списка
        size++;
    }
    //Метод для извлечения элементов из начала очереди
    public Data[] remove(long fullCapacity){
        //Массив с возвратом адресов извлекаемых из очереди объектов
        Data[] toReturn = null;
        //Сколько надо извлечь из очереди
        long toRemove = fullCapacity * capacity / 100;

            if (size < toRemove){
                //Возвращаем всю очередь
                toReturn = new Data[(int)size];
            } else {
                //Либо только её часть
                toReturn = new Data[(int)toRemove];
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
