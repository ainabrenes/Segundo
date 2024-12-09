import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Creació de la sessió de Hibernate
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Client.class)
            .addAnnotatedClass(Order.class)
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Crear un nou client
            Client client = new Client();
            client.setName("John Doe");

            // Iniciar la transacció
            session.beginTransaction();

            // Guardar el client a la base de dades
            session.save(client);

            // Fer commit de la transacció
            session.getTransaction().commit();

            System.out.println("Client guardat a la base de dades!");
        } finally {
            factory.close();
        }
    }
}
