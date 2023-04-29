package com.example1.demo3.restservice;

public record Greeting(long id, String content) {}
//自动加载 Jackson包，它会自动把 Greeting 转为 JSON