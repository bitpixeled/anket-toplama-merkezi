package com.bitpixeled.ankettoplamamerkezi.v1.dto;

import com.bitpixeled.ankettoplamamerkezi.v1.model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class KatilimciDto {

    private Long id;
    private String name;
    private String lastName;
    private Gender gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
