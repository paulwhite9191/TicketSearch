package ru.netology.manager;

import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public boolean matches(Ticket ticket, String departureAirport, String arrivalAirport) {
        if (ticket.getDepartureAirport().contains(departureAirport) && ticket.getArrivalAirport().contains(arrivalAirport)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] searchBy(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, departureAirport, arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}