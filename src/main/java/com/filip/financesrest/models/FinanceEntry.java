package com.filip.financesrest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "finance_entry")
public class FinanceEntry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, message = "Description should be at least 3 characters long")
    private String description;

    @NotNull(message = "Please provide value.")
    private double value;

    @NotNull(message = "Date cannot be empty.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private EntryCategory category;



    public FinanceEntry(String description, double value, LocalDate date, User user, EntryCategory category)
    {
        this.description = description;
        this.value = value;
        this.date = date;
        this.user = user;
        this.category = category;
    }

    public FinanceEntry() { }

    public User getUser()
    {
        return user;
    }

    public long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public EntryCategory getCategory()
    {
        return category;
    }

    public void setCategory(EntryCategory category)
    {
        this.category = category;
    }
}
