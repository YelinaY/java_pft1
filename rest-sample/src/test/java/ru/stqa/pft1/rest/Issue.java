package ru.stqa.pft1.rest;

public class Issue {

    private int id;
    private String subject;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (id != issue.id) return false;
        if (subject != null ? !subject.equals(issue.subject) : issue.subject != null) return false;
        if (description != null ? !description.equals(issue.description) : issue.description != null) return false;
        return state_name != null ? state_name.equals(issue.state_name) : issue.state_name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (state_name != null ? state_name.hashCode() : 0);
        return result;
    }

    private String state_name;

    public String getState_name() {
        return subject;
    }

    public Issue withState_name(String subject) {
        this.subject = subject;
        return this;
    }

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Issue withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

}