package com.example.springbootonetomanyrestapi.api;

import com.example.springbootonetomanyrestapi.jpa.Library;
import com.example.springbootonetomanyrestapi.repository.BookRepository;
import com.example.springbootonetomanyrestapi.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/libraries")
public class LibraryController {
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    @GetMapping//read data
    public ResponseEntity<Page<Library>> getAll(Pageable pageable){
        return ResponseEntity.ok(libraryRepository.findAll(pageable));
    }
    @GetMapping("/{id}") // lấy thư viện theo id
    public ResponseEntity<Library> getById(@PathVariable Integer id){
        //neu k co id thi se loi 500
        Optional<Library> optionalLibrary = libraryRepository.findById(id); // check id có tồn tại không
        if (!optionalLibrary.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalLibrary.get());
    }
    @PostMapping // thêm mới thư viện
    public ResponseEntity<Library> createLibrary(@Valid @RequestBody Library library){
        Library librarySaved = libraryRepository.save(library);
        //check header of service
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(librarySaved.getId()).toUri();
        return ResponseEntity.created(location).body(librarySaved);
    }
    @PutMapping("/{id}") // sửa thư viện theo id
    public ResponseEntity<Library> updateLibrary(@PathVariable Integer id, @Valid @RequestBody Library library){
        Optional<Library> optionalLibrary = libraryRepository.findById(id); // check id có tồn tại không
        if (!optionalLibrary.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        library.setId(optionalLibrary.get().getId());
        libraryRepository.save(library);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}") // xóa thư viện theo id
    public ResponseEntity<Library> deleteLibrary(@PathVariable Integer id) {
        Optional<Library> optionalLibrary = libraryRepository.findById(id); // check id có tồn tại không
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        libraryRepository.delete(optionalLibrary.get());
        return ResponseEntity.noContent().build();
    }
}
