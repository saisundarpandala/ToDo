package todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    @GetMapping("/todos")
    public List<ToDo> getAllToDos(){
        List<ToDo> todos = toDoRepository.findAll();
        //emailSenderService.sendEmail("saisundarpandala@gmail.com", "New ToDo Added", (ToDo) todos);
        return toDoRepository.findAll();

    }

    @GetMapping("/todos/{id}")
    public Optional<ToDo> getToDoById(@PathVariable("id") Integer id){

        //return toDoService.getToDoById(id);
        return toDoRepository.findById(id);
    }

    @PostMapping("/todos/add")
    public ToDo addToDo (@RequestBody ToDo todo){
        ToDo todo1 = toDoRepository.save(todo);
        emailSenderService.sendEmail("saisundarpandala@gmail.com", "New ToDo Added", todo1);
        return todo1;
    }

    @PutMapping("/todos/update/{id}")
    public ToDo updateToDo(@RequestBody ToDo todo, @PathVariable("id") Integer id){
        return toDoService.updateTodo(todo, id);

    }

    @DeleteMapping("/todos/delete/{id}")
    public List<ToDo> deleteById(@PathVariable ("id") Integer id){
        toDoRepository.deleteById(id);
        return toDoRepository.findAll();
    }

    @RequestMapping("hello")
    public String hello(){
        return "Hello!!!";
    }

}
