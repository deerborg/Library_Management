package art.dborg.library_management.v1.api;

import art.dborg.library_management.v1.business.concretes.PublisherServices;
import art.dborg.library_management.v1.core.config.modelMapper.ModelMapperService;
import art.dborg.library_management.v1.core.resutl.Result;
import art.dborg.library_management.v1.core.resutl.ResultData;
import art.dborg.library_management.v1.core.utilities.ResultHelper;
import art.dborg.library_management.v1.dto.request.book.BookSaveRequest;
import art.dborg.library_management.v1.dto.request.book.BookUpdateRequest;
import art.dborg.library_management.v1.dto.request.publisher.PublisherSaveRequest;
import art.dborg.library_management.v1.dto.request.publisher.PublisherUpdateRequest;
import art.dborg.library_management.v1.dto.response.CursorResponse;
import art.dborg.library_management.v1.dto.response.book.BookResponse;
import art.dborg.library_management.v1.dto.response.publisher.PublisherResponse;
import art.dborg.library_management.v1.entities.Book;
import art.dborg.library_management.v1.entities.Publisher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherServices publisherServices;
    private final ModelMapperService mapperService;

    @GetMapping("{id}")
    public ResultData<PublisherResponse> getId(@PathVariable long id){
        PublisherResponse publisherResponse = mapperService.forResponse().map(publisherServices.getId(id),PublisherResponse.class);
        return ResultHelper.OK(publisherResponse);
    }
    @PostMapping
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest){
        PublisherResponse publisherResponse = mapperService.forResponse().map(publisherServices.save(mapperService.forRequest().map(publisherSaveRequest, Publisher.class)),PublisherResponse.class);
        return ResultHelper.CREATED(publisherResponse);
    }
    @PutMapping
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest){
        PublisherResponse publisherResponse = mapperService.forResponse().map(publisherServices.update(mapperService.forRequest().map(publisherUpdateRequest, Publisher.class)),PublisherResponse.class);
        return ResultHelper.CREATED(publisherResponse);
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id){
        return ResultHelper.OK(publisherServices.delete(id));
    }
    @GetMapping
    public ResultData<CursorResponse<PublisherResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Publisher> publishers = publisherServices.cursor(page,pageSize);
        Page<PublisherResponse> publisherResponses = publishers.map(category -> mapperService.forResponse().map(category,PublisherResponse.class));
        return ResultHelper.cursor(publisherResponses);
    }


}
