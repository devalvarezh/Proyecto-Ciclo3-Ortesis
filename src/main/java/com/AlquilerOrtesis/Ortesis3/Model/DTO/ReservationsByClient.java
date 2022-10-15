package com.AlquilerOrtesis.Ortesis3.Model.DTO;

import com.AlquilerOrtesis.Ortesis3.Model.Client;

public class ReservationsByClient {

    //Attributes
    private Integer total;
    private Client client;

    public ReservationsByClient(Integer total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
