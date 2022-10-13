package com.AlquilerOrtesis.Ortesis3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    //Relation using foreign key into message
    @ManyToOne
    @JoinColumn(name = "ortopedic")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Ortopedic ortopedic;

    //Relation using foreign key into message
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages" , "reservations"})
    private Client client;


    //Getters & Setters


    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Ortopedic getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortopedic ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
