package art.dborg.library_management.v1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursorResponse<T> {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private List<T> items;
}
