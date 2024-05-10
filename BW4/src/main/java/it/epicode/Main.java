package it.epicode;

import it.epicode.Enum.SubscriptionType;
import it.epicode.classi.personal.Subscription;
import it.epicode.classi.personal.User;
import it.epicode.classi.purchase.DailyTicket;
import it.epicode.classi.purchase.ReSeller;
import it.epicode.classi.purchase.Seller;
import it.epicode.classi.purchase.VendingMachine;
import it.epicode.classi.transport.Bus;
import it.epicode.classi.transport.Maintenance;
import it.epicode.classi.transport.Tram;
import it.epicode.dao.jpa.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    private static final JpaSellerDao sellerDao = new JpaSellerDao();

    protected static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        User Antonio = new User("Antonio","Schipani", LocalDate.of(1998,3,7));
        var userDao = new JpaUserDao();
     /*   userDao.save(Antonio);*/
        var reSeller = new ReSeller("Roma","barJolly");
        var vendita = new VendingMachine("Roma");
        var ticket = new DailyTicket(reSeller);
        var sellerDao = new JpaSellerDao();
       /* sellerDao.save(reSeller);
        sellerDao.save(vendita);*/
        Subscription abb1 = new Subscription(vendita ,SubscriptionType.MONTHLY);
        var travelDAo = new JpaTravelDocumentDao();
        Subscription abb2 = new Subscription(reSeller, SubscriptionType.WEEKLY);
        /*travelDAo.save(abb1);
        travelDAo.save(abb2);
        travelDAo.save(ticket);*/
        var vehicleDao = new JpaVehicleDao();


        var tram1 = new Tram("3l3fred","Termini","Tiburtina",LocalTime.parse("00:30") ,3);
        log.debug("{}",tram1);
        var bus = new Bus("3l4fred","Termini","Tiburtina",LocalTime.parse("00:30") ,5);
        log.debug("{}",bus);
       /* vehicleDao.save(tram1);
        vehicleDao.save(bus);*/
        var maintenence1 = new Maintenance(vehicleDao.getVehicleById(1L),LocalDate.now());
        var maintenanceDao = new JpaMaintenanceDao();
        /*maintenanceDao.save(maintenence1);*/

        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);

getTicketsAndSubscriptionsCountForSeller(1L, startDate, endDate);


    }

    public static void getTicketsAndSubscriptionsCountForSeller(Long sellerId, LocalDate startDate, LocalDate endDate) {
        JpaSellerDao sellerDao = new JpaSellerDao();

        int dailyTicketsCount = sellerDao.countTotalDailyTickets(sellerId, startDate, endDate);
        System.out.println("Numero di biglietti per il venditore con ID " + sellerId + " nel periodo da "
                + startDate + " a " + endDate + ": " + dailyTicketsCount);


        int subscriptionsCount = sellerDao.countTotalSubscriptions(sellerId, startDate, endDate);
        System.out.println("Numero di abbonamenti per il venditore con ID " + sellerId + " nel periodo da "
                + startDate + " a " + endDate + ": " + subscriptionsCount);
    }
}