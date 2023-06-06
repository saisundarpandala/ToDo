package todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@EnableJpaRepositories
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;
//    public List<ToDo> getAllToDos(){
//        List<ToDo> todos = new ArrayList<>();
//        toDoRepository.findAll().forEach(toDo1 -> todos.add(toDo1));
//        return todos;
//    }

//    public ToDo getToDoById(Integer id){
//        return toDoRepository.findById(id).get();
//    }

    public ToDo save(ToDo todo){
        toDoRepository.save(todo);
        return todo;
    }

    public ToDo updateTodo(ToDo todo, Integer id){
        ToDo todo1 = toDoRepository.findById(id).get();
        todo1.setName(todo.getName());
        todo1.setSummary(todo.getSummary());
        todo1.setDescription(todo.getDescription());
        return toDoRepository.save(todo1);
    }



}
