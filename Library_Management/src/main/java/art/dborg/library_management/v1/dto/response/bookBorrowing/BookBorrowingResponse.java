package art.dborg.library_management.v1.dto.response.bookBorrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingResponse {
    private String name;
    private LocalDate date;
    private String mail;
}
