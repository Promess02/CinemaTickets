import java.io.Serializable;
import java.util.List;

public class AppData implements Serializable {
    Repo<Client> clientsRepo;
    Repo<Viewing> viewingRepo;
    Repo<Ticket> ticketRepo;

    public AppData(Repo<Client> clientsRepo, Repo<Viewing> viewingRepo, Repo<Ticket> ticketRepo) {
        this.clientsRepo = clientsRepo;
        this.viewingRepo = viewingRepo;
        this.ticketRepo = ticketRepo;
    }

    public Repo<Client> getClientsRepo() {
        return clientsRepo;
    }

    public void setClientsRepo(Repo<Client> clientsRepo) {
        this.clientsRepo = clientsRepo;
    }

    public Repo<Viewing> getViewingRepo() {
        return viewingRepo;
    }

    public void setViewingRepo(Repo<Viewing> viewingRepo) {
        this.viewingRepo = viewingRepo;
    }

    public Repo<Ticket> getTicketRepo() {
        return ticketRepo;
    }

    public void setTicketRepo(Repo<Ticket> ticketRepo) {
        this.ticketRepo = ticketRepo;
    }
}
