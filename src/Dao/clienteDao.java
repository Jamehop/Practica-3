package Dao;

import java.util.*;

import JardineriaTest.cliente;

public class clienteDao implements Dao<cliente> {

    private List<cliente> clientes = new ArrayList<>();

    public clienteDao() {

        clientes.add(new cliente(1234, "nombre_cliente", "domicilio", null, null, 123421232, 1234.7,
                "codigo_empleado_rep_ventas"));
    }

    @Override
    public Optional<cliente> get(long id) {

        return Optional.ofNullable(clientes.get((int) id));
    }

    @Override
    public List<cliente> getAll() {

        return clientes;
    }

    @Override
    public void save(cliente t) throws Exception {
        for (cliente cliente : clientes) {
            if (cliente.getCodigo_cliente() == t.getCodigo_cliente()) { //
                if (cliente.getNombre_cliente() == t.getNombre_cliente() && cliente.getTelefono() == t.getTelefono()) {

                    throw new Exception("duplicar clientes malo");
                }
                System.out.println("cliente ya existe");

                return;
            }

        }

        clientes.add(t);

    }

    @Override
    public void update(cliente t, String[] params) {

        t.setNombre_cliente("cliente");
        t.setCodigo_cliente(123);
        t.setDomicilio("domicilio");
        t.setLimite_credit(123451);
        t.setCodigo_empleado_rep_ventas("codigo_empleado_rep_ventas");

    }

    @Override
    public void delete(cliente t) {
        clientes.remove(t);

    }

}
