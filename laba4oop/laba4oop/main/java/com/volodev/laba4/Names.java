package com.volodev.laba4;

import lombok.Getter;
public class Names {
    @Getter private String title;
    @Getter private String genre;
    @Getter private String time;
    @Getter private int amount;
    @Getter private String rate;
    @Getter private int idInDatabase;//Уникальный номер в БД

    public Names(String title, String genre, String time, int amount, String rate, int idInDatabase) {
        this.title = title;
        this.genre = genre;
        this.time = time;
        this.amount = amount;
        this.rate = rate;
        this.idInDatabase = idInDatabase;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Names names = (Names) obj;
        if(!title.equals(names.title)) return false;
        if(!genre.equals(names.genre)) return false;
        if(!time.equals(names.time)) return false;
        if(!rate.equals(names.rate)) return false;
        if(idInDatabase != names.idInDatabase) return false;
        return amount == names.amount;


    }
    @Override
    public int hashCode() {
        int result = (int) ((int)amount ^ ((int)amount >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + rate.hashCode();
        result = 31 * result + idInDatabase;
        return result;
    }
}