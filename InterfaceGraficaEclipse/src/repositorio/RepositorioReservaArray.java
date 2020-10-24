package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Reserva;
import modelo.Usuario;

public class RepositorioReservaArray implements IRepositorioReserva {

	ArrayList<Reserva> reservas;

	public RepositorioReservaArray() {

		this.reservas = new ArrayList<Reserva>();
	}

	@Override
	public boolean addReserva(Reserva novaReserva) {
		boolean resultado = false;

		if (novaReserva != null) {

			boolean jaReservada = false;

			for (Reserva nova : reservas) {

				if (nova.getQuarto().getHotel().equals(novaReserva.getQuarto().getHotel()) == true) {

					if (nova.getQuarto().getNumero() == novaReserva.getQuarto().getNumero()) {

						if ((novaReserva.getCheckin().isBefore(nova.getCheckin()) == true)
								&& (novaReserva.getCheckout().isBefore(nova.getCheckin()) == true)
								|| novaReserva.getCheckin().isAfter(nova.getCheckout()) == true) {

						} else {

							jaReservada = true;
						}

					}

					if (jaReservada == false) {

						reservas.add(novaReserva);

						resultado = true;
					}

				}

			}
		}

		return resultado;

	}

	@Override
	public boolean cancelarReserva(Reserva reservaCancela) {

		boolean resultado = false;

		for (Iterator<Reserva> iterator = reservas.iterator(); iterator.hasNext();) {

			Reserva existente = iterator.next();

			if (existente.equals(reservaCancela)) {

				iterator.remove();
				resultado = true;
			}
		}

		return resultado;
	}

	@Override
	public ArrayList<Reserva> listarReservasUsuario(Usuario usuario) {

		ArrayList<Reserva> reserva = new ArrayList<Reserva>();

		for (Reserva e : reservas) {

			if (e.getUsuario().equals(usuario)) {

				reserva.add(e);
			}
		}
		return reserva;
	}

	@Override
	public void remarcarReserva(LocalDate checkin, LocalDate checkout) { // PRECISA ADICIONAR AS CONDI��ES

		for (Reserva r : reservas) {

			r.setCheckin(checkin);
			r.setCheckout(checkout);
		}
	}

}
