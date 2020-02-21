package com.gustavopinho.java.document.models;

import com.gustavopinho.java.document.enuns.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "field")
public class Field implements Serializable {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Column
    private Boolean isKey;

    @Column
    private Boolean isRequired;

    @Column
    private Integer sequence;

    @Column
    private String name;

    @Column
    private Integer size;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column
    private String validation;

    public Field() { }

    public Field(Integer id, Document document, Boolean isKey, Boolean isRequired, Integer sequence, String name,
                 Integer size, Type type, String validation) {
        this.id = id;
        this.document = document;
        this.isKey = isKey;
        this.isRequired = isRequired;
        this.sequence = sequence;
        this.name = name;
        this.size = size;
        this.type = type;
        this.validation = validation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Boolean getKey() {
        return isKey;
    }

    public void setKey(Boolean key) {
        isKey = key;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(id, field.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
