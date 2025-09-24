package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtalsMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtalsMax);
	}

	private static class Marche {
		private Etal[] etals;

		private Marche(int nbEtals) {
			this.etals = new Etal[nbEtals];
			for (int i = 0; i < nbEtals; i++) {
				etals[i] = new Etal();
			}
		}

		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}

		public int trouverEtalLibre() {
			for (int i = 0; i < etals.length; i++)
				if (!etals[i].isEtalOccupe())
					return i;
			return -1;
		}

		private Etal[] trouverEtals(String produit) {
			int nbTrouve = 0;
			for (int i = 0; i < etals.length; i++)
				if (etals[i].contientProduit(produit))
					nbTrouve++;
			Etal[] etalsProduit = new Etal[nbTrouve];
			nbTrouve = 0;
			for (int i = 0; i < etals.length; i++)
				if (etals[i].contientProduit(produit)) {
					etalsProduit[nbTrouve] = etals[i];
					nbTrouve++;
				}
			return etalsProduit;

		}

		private Etal trouverVendeur(Gaulois gaulois) {
			Etal etalTrouve = null;
			for (Etal etal : etals) {
				if (etal.getVendeur().equals(gaulois)) {
					return etal;
				}
			}
			return etalTrouve;
		}

		private void afficherMarche() {
			StringBuilder chaine = new StringBuilder("Dans le marche, il y a " + etals.length + " étals,\n");
			int etalLibres = 0;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe()) {
					etalLibres++;
				} else {
					chaine.append("L'étal " + i + " : \n");
					etals[i].afficherEtal();
				}
			}
			chaine.append("”Il reste \" +\r\n"+ "etalLibres + \" étals non utilisés dans le marché.\\n”");
		}

	}

	// Village methods


	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef " + chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom() + " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
		StringBuilder chaine = new StringBuilder();
		Etal etalLibre = null;
		etalLibre.equals(marche.trouverEtalLibre());
		
	}

	}























