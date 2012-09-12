package Oppgave3;

/**
 * Innlevering Java oppgave 3
 * Cezar Sincan Johansson
 * 02.02.2012
 */

import java.sql.*;
import java.util.ArrayList;

import dbConnection.ConnectToDB;

public class Oppg3Dao {
	private ConnectToDB db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pStmt;

	/** Creates a new instance of ResultatDAO */
	public Oppg3Dao(String bruker, String passord) {
		db = new ConnectToDB(bruker, passord);
		con = db.getConnection();

		String sql = "SELECT fnavn, studiepoeng, "
				+ "DATE_FORMAT(dato,'%d.%m.%Y'), karakter "
				+ "  FROM fag2, eksamen2 " + " WHERE fag2.fnr = eksamen2.fnr "
				+ "   AND snr = ? " + " ORDER BY fnavn, dato";
		try {
			pStmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void lukk() {
		db.closeConnection();
	}

	// Metoden som henter alle studentene har ikke brukt prepared statement her
	// siden det ikke er noen variabler
	public ArrayList<StudentVO> hentAlleStudenter() {
		try {
			Statement stmt = con
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			String sql = "Select * from student2";
			rs = stmt.executeQuery(sql);
		

			ArrayList<StudentVO> list = new ArrayList<StudentVO>();

			while (rs.next()) {
				StudentVO s = new StudentVO(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
				list.add(s);

			}
			return list;

		} catch (SQLException e) {

			System.out.println("Klarte ikke hente alle studenter");
			e.printStackTrace();
			return null;
		}

	}

	public void hentResultatSet(int snr) {
		try {
			pStmt.setInt(1, snr);
			rs = pStmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("Klarer ikke å opprette preparedStatement.");
			System.out.println(e.getMessage());
		}
	}

	public ResultatVO førsteRad() {
		try {
			rs.first();
			ResultatVO resultat = new ResultatVO(rs.getString(1), rs.getInt(2),
					rs.getString(3), rs.getString(4).charAt(0));
			return resultat;
		} catch (SQLException e) {
			System.out.println("Klarer ikke å gå til første rad.");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ResultatVO sisteRad() {
		try {
			rs.last();
			ResultatVO resultat = new ResultatVO(rs.getString(1), rs.getInt(2),
					rs.getString(3), rs.getString(4).charAt(0));
			return resultat;
		} catch (SQLException e) {
			System.out.println("Klarer ikke å gå til siste rad.");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ResultatVO nesteRad() {
		try {
			rs.next();
			// Dersom du står bak siste rad, flyttes markøren til siste rad
			if (rs.isAfterLast())
				rs.last();
			// Les verdiene
			ResultatVO resultat = new ResultatVO(rs.getString(1), rs.getInt(2),
					rs.getString(3), rs.getString(4).charAt(0));
			return resultat;
		} catch (SQLException e) {
			System.out.println("Klarer ikke å gå til neste rad.");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ResultatVO forrigeRad() {
		try {
			rs.previous();
			// Dersom du står foran første rad, " +
			// "flyttes markøren til første rad
			if (rs.isBeforeFirst())
				rs.first();
			// Les verdiene
			ResultatVO resultat = new ResultatVO(rs.getString(1), rs.getInt(2),
					rs.getString(3), rs.getString(4).charAt(0));
			return resultat;
		} catch (SQLException e) {
			System.out.println("Klarer ikke å gå til forrige rad.");
			System.out.println(e.getMessage());
			return null;
		}
	}

}
