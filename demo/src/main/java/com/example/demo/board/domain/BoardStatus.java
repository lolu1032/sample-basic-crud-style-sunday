package com.example.demo.board.domain;

// 선택지가 있는 구조 (열거,상수들)
// enum Algorithm { SHA1, SHA256, ... }
public enum BoardStatus {
    PENDING,
    ACTIVE,
    SUSPENDED,
    REMOVED
}
