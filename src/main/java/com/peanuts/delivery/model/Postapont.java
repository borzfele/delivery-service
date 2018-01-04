package com.peanuts.delivery.model;

import javax.persistence.*;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "city", column=@Column(name = "city")),
        @AttributeOverride(name = "zipcode", column=@Column(name = "zipcode")),
        @AttributeOverride(name = "address", column=@Column(name = "address"))
})
public class Postapont extends Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    public Postapont() {
    }

    public Postapont(Long id, String city, String zipcode, String address, String title) {
        super(city, zipcode, address);
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
