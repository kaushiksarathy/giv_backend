package db;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Customer {
    private String id;
    private String name;
    private int age;
}
