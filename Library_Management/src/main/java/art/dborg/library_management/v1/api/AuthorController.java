package art.dborg.library_management.v1.api;

import art.dborg.library_management.v1.business.abstracts.AuthorManager;
import art.dborg.library_management.v1.business.concretes.AuthorServices;
import art.dborg.library_management.v1.core.config.modelMapper.ModelMapperService;
import art.dborg.library_management.v1.core.resutl.Result;
import art.dborg.library_management.v1.core.resutl.ResultData;
import art.dborg.library_management.v1.core.utilities.ResultHelper;
import art.dborg.library_management.v1.dto.request.author.AuthorSaveRequest;
import art.dborg.library_management.v1.dto.request.author.AuthorUpdateRequest;
import art.dborg.library_management.v1.dto.response.CursorResponse;
import art.dborg.library_management.v1.dto.response.author.AuthorResponse;
import art.dborg.library_management.v1.entities.Author;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final ModelMapperService mapperService;
    private final AuthorServices authorServices;

    @GetMapping("{id}")
    public ResultData<AuthorResponse> getId(@PathVariable long id){
        AuthorResponse authorResponse = mapperService.forResponse().map(authorServices.getId(id),AuthorResponse.class);
        return ResultHelper.OK(authorResponse);
    }
    @PostMapping
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest){
        AuthorResponse authorResponse = mapperService.forResponse().map(authorServices.save(mapperService.forRequest().map(authorSaveRequest, Author.class)),AuthorResponse.class);
        return ResultHelper.CREATED(authorResponse);
    }
    @PutMapping
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest authorUpdateRequest){
        AuthorResponse authorResponse = mapperService.forResponse().map(authorServices.update(mapperService.forRequest().map(authorUpdateRequest, Author.class)),AuthorResponse.class);
        return ResultHelper.OK(authorResponse);
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id){
        return ResultHelper.OK(authorServices.delete(id));
    }
    @GetMapping
    public ResultData<CursorResponse<AuthorResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Author> authors = authorServices.cursor(page,pageSize);
        Page<AuthorResponse> authorResponses = authors.map(category -> mapperService.forResponse().map(category,AuthorResponse.class));
        return ResultHelper.cursor(authorResponses);
    }
}
