package com.myapplicationdev.databaserevision;

public class Note {
    private int id;
    private String content;

    public Note(int id, String content, String priority) {
        this.id = id;
        this.content = content;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    private String priority;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
//TODO: What should be here?

}
