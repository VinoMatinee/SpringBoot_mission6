package com.basic.myspringboot.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRespDto {
    private Long id; // 아이디
    private String email; // 이메일
    private int age; // 나이

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm E a",
            timezone = "Asia/Seoul")
    private LocalDateTime entryDate; // 시간 default now
}