package art.dborg.library_management.v1.dto.request.bookBorrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingUpdateRequest {
    private long id;
    private String name;
    private LocalDate date;
    private LocalDate reDate;
}
