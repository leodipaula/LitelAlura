package com.example.LiterAlura.services;

public interface IConvertsData {
    <T> T converterData(String json, Class<T> tclass);
}
