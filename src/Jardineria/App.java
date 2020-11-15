package Jardineria;

import java.util.Calendar;

import JardineriaTest.cliente;
import JardineriaTest.pedido;
import Dao.Dao;
import Dao.clienteDao;
import Dao.pedidosDao;
import Builder.BuilderCliente;
import Builder.BuilderPedido;

public class App {

    private static Dao<cliente> clientesDao;
    private static Dao<pedido> pedidosDao;

    public static void main(String[] args) {
        clientesDao = new clienteDao();
        pedidosDao = new pedidosDao(clientesDao);

        try {
            clientesDao.save(new BuilderCliente(66, "Dario", "zaragoza", 696969696, 69.69, "9669p").Buildeo());
        } catch (Exception e) {
            System.out.println("Error: el cliente esta introducido \n" + clientesDao);

        }

        try {
            Calendar millegada = Calendar.getInstance();
            millegada.add(Calendar.DAY_OF_MONTH, 40);

            pedidosDao.save(
                    new BuilderPedido(1, 12, Calendar.getInstance(), millegada, "estado", "comentarios").Buildeo());
        } catch (Exception e) {
            System.out.println("Error: el pedido esta introducido, vuelve a intentarlo    ");
            

        }

    }

}
