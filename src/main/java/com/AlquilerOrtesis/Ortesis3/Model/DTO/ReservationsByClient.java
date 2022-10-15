package com.AlquilerOrtesis.Ortesis3.Model.DTO;

import com.AlquilerOrtesis.Ortesis3.Model.Client;

public class ReservationsByClient {

    //Attributes
    private Long total;
    private Client client;

    public ReservationsByClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
