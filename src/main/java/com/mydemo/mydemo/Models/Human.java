package com.mydemo.mydemo.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//@RequiredArgsConstructor

@Data
public class Human {
    private final Integer id;
    private final String name;
    private final String surname;

}
