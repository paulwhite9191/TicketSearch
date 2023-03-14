package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ticket.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class ManagerTest {
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);
    private Ticket ticket1 = new Ticket(1, 7000, "ASF", "KZN", 100);
    private Ticket ticket2 = new Ticket(2, 3000, "LED", "KGD", 97);
    private Ticket ticket3 = new Ticket(3, 3000, "LED", "DME", 70);
    private Ticket ticket4 = new Ticket(4, 8000, "ASF", "KZN", 103);
    private Ticket ticket5 = new Ticket(5, 2000, "GOJ", "IAR", 51);
    private Ticket ticket6 = new Ticket(6, 4000, "LED", "GOJ", 105);

    @BeforeEach

    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldGetAll() {

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveNewTicket() {
        manager.add(ticket6);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {

        Ticket[] actual = manager.searchBy("ASF", "KZN");
        Ticket[] expected = new Ticket[]{ticket1, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, repo.removeById(2));
    }

    @Test
    public void shouldSearchIfNotTicket() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("GZV", "HTR");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketExpensive() {

        int expected = ticket4.compareTo(ticket1);
        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTicketCheaper() {

        int expected = ticket1.compareTo(ticket4);
        int actual = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTicketsSamePrice() {

        int expected = ticket2.compareTo(ticket3);
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }
}

