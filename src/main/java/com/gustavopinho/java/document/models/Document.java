package com.gustavopinho.java.document.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "document")
public class Document implements Serializable {

    @Id
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "file_id", nullable = false)
    private File file;

    @ManyToOne
    @JoinColumn(name = "parent", nullable = true)
    private Document parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Document> parents;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private List<Field> fields;

    public Document() {}

    public Document(Integer id, String name, File file) {
        this.id = id;
        this.name = name;
        this.file = file;
    }

    public Document(Integer id, String name, File file, Document parent) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Document getParent() {
        return parent;
    }

    public void setParent(Document parent) {
        this.parent = parent;
    }

    public List<Document> getParents() {
        return parents;
    }

    public void setParents(List<Document> parents) {
        this.parents = parents;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
