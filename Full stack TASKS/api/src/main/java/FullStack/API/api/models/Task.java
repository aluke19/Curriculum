package FullStack.API.api.models;

public class Task {
    private Long id; // Identificador único de la tarea
    private String title;
    private boolean completed;

    public Task(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Long getid() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}