package art.dborg.library_management.v1.dto.request.bookBorrowing;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingSaveRequest {
    private String name;
    @Email
    private String mail;
}
