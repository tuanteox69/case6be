package com.example.case6be.controllers;

import com.example.case6be.models.SpendingGoal;
import com.example.case6be.services.IspendingGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/spendingGoal")
public class SpendingGoalAPI {
    @Autowired
    IspendingGoalService ispendingGoalService;


    @GetMapping
    public ResponseEntity<Iterable<SpendingGoal>> findAll() {
        List<SpendingGoal> spending = (List<SpendingGoal>) ispendingGoalService.findAll();
        if (spending.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(spending, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public SpendingGoal findById(@PathVariable int id) {
        return  ispendingGoalService.findById(id);
    }

    @GetMapping("/{id}")
    public List<SpendingGoal> findByIduser(@PathVariable int id) {
     return ispendingGoalService.finByiduser(id);
    }




    @PostMapping
    public void save(@RequestBody SpendingGoal spendingGoal){
        ispendingGoalService.save(spendingGoal);
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<spendingGoal> delete(@PathVariable int id) {
//        Optional<spendingGoal> spendingGoalOptional = ispendingGoalService.findById(id);
//        if (!spendingGoalOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        ispendingGoalService.delete(id);
//        return new ResponseEntity<>(spendingGoalOptional.get(), HttpStatus.NO_CONTENT);
//    }
//    @PostMapping("/upImg")
//    public String upImg(@RequestParam MultipartFile file){
//        String name = file.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(file.getBytes(),new File("C:\\Users\\admin\\Desktop\\Case-Study-MD4-FE\\royal-master\\image\\" + name));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "image/"+name;
//    }
    @GetMapping("/check/{name}")
    public SpendingGoal findByName(@PathVariable String name){
        return ispendingGoalService.findByName(name);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
