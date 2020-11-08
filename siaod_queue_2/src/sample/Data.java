package sample;

//Класс-пакет-данных
class Data {
    //Ссылка на следующий пакет данных
    public Data next;
    //Данные, хранимые в пакете
    private final long info;
    //Тип пакета
    private final long type;
    //Конструктор
    public Data(long info, long type){
        this.info = info;
        this.type = type;
    }
    //Геттеры
    public long getInfo() {
        return info;
    }
    public long getType() {
        return type;
    }
}
