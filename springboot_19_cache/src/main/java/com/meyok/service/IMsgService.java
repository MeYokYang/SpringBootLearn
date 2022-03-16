package com.meyok.service;

public interface IMsgService {

    String get(String tele);
    boolean check(String tele, String code);


}
