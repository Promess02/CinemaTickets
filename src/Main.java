import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Repo<Client> clientsRepo = new RepoImplementation<>();
        Repo<Viewing> viewingRepo = new RepoImplementation<>();
        Repo<Ticket> ticketRepo = new RepoImplementation<>();
        AppData appData;

        FileInputStream fileInputStream = new FileInputStream("appData.txt");
        ObjectInputStream objectInputStream;
        if(fileInputStream.available()>0){
            System.out.println("found data");
            objectInputStream = new ObjectInputStream(fileInputStream);
            appData= (AppData) objectInputStream.readObject();
            objectInputStream.close();
        }else{
            viewingRepo.setAllData(SampleViewings.viewings);
            appData = new AppData(clientsRepo,viewingRepo,ticketRepo);
        }
        new Menu(appData);
    }
}