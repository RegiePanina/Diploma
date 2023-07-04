package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardInfo {
    private String number;
    private String month;
    private String year;
    private String owner;
    private String cvc;
}
