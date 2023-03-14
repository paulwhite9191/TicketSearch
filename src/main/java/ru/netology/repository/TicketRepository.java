package ru.netology.repository;

import ru.netology.ticket.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public TicketRepository() {
        this.tickets = tickets;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
        return tmp;
    }

    public Ticket[] findAll() {
        Ticket[] all = getTickets();
        Ticket[] list = new Ticket[all.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = all[i];
        }
        return list;
    }
}