package art.dborg.library_management.v1.api;

import art.dborg.library_management.v1.business.concretes.AuthorServices;
import art.dborg.library_management.v1.business.concretes.BookServices;
import art.dborg.library_management.v1.core.config.modelMapper.ModelMapperService;
import art.dborg.library_management.v1.core.resutl.Result;
import art.dborg.library_management.v1.core.resutl.ResultData;
import art.dborg.library_management.v1.core.utilities.ResultHelper;
import art.dborg.library_management.v1.dto.request.author.AuthorSaveRequest;
import art.dborg.library_management.v1.dto.request.author.AuthorUpdateRequest;
import art.dborg.library_management.v1.dto.request.book.BookSaveRequest;
import art.dborg.library_management.v1.dto.request.book.BookUpdateRequest;
import art.dborg.library_management.v1.dto.response.CursorResponse;
import art.dborg.library_management.v1.dto.response.author.AuthorResponse;
import art.dborg.library_management.v1.dto.response.book.BookResponse;
import art.dborg.library_management.v1.entities.Author;
import art.dborg.library_management.v1.entities.Book;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final ModelMapperService mapperService;
    private final BookServices bookServices;

    @GetMapping("{id}")
    public ResultData<BookResponse> getId(@PathVariable long id){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.getId(id),BookResponse.class);
        return ResultHelper.OK(bookResponse);
    }
    @PostMapping
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.save(mapperService.forRequest().map(bookSaveRequest, Book.class)),BookResponse.class);
        return ResultHelper.CREATED(bookResponse);
    }
    @PutMapping
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.update(mapperService.forRequest().map(bookUpdateRequest, Book.class)),BookResponse.class);
        return ResultHelper.OK(bookResponse);
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id){
        return ResultHelper.OK(bookServices.delete(id));
    }
    @GetMapping
    public ResultData<CursorResponse<BookResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Book> books = bookServices.cursor(page,pageSize);
        Page<BookResponse> bookResponses = books.map(category -> mapperService.forResponse().map(category,BookResponse.class));
        return ResultHelper.cursor(bookResponses);
    }

}
