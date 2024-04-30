package art.dborg.library_management.v1.dto.request.author;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private LocalDate year;
    @NotEmpty
    @NotNull
    private String country;
}
