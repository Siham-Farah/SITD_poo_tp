import java.util.Scanner;
import java.sql.*;

public class ConnectionBdd {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner s = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        //DriverManager pour établir une connexion à la base de données:
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tppoo", "root", "");

        while (true) {
            System.out.println("Choisissez une option :");
            System.out.println("1: Ajouter un enseignant");
            System.out.println("2: Modifier un enseignant");
            System.out.println("3: Supprimer un enseignant");
            System.out.println("4: afficher la table");
            System.out.println("0: Quitter");

            int option = s.nextInt();
            s.nextLine();  // Nettoyer le tampon de la ligne après avoir lu l'entier
            if(option==0) break;
            switch (option) {
                case 1:
                    // Requête SQL pour l'ajout d'un enseignant
                    while (true) {
                        System.out.println("Veuillez entrer le prénom de l'enseignant (ou 'exit' pour quitter) :");
                        String prenom = s.nextLine();

                        if ("exit".equalsIgnoreCase(prenom)) {
                            break; // Quitter la boucle si l'utilisateur saisit 'exit'
                        }

                        System.out.println("Veuillez entrer le nom de l'enseignant :");
                        String nom = s.nextLine();

                        System.out.println("Veuillez entrer l'email de l'enseignant :");
                        String email = s.nextLine();

                        System.out.println("Veuillez entrer le grade de l'enseignant :");
                        Integer grade = s.nextInt();

                        System.out.println("Veuillez entrer le departement associé à l'enseignant :");
                        Integer departement_id = s.nextInt();
                        s.nextLine();

                        // Requête SQL pour l'ajout d'un enseignant (veuillez remplacer les ? par les valeurs réelles)
                        String sql = "INSERT INTO enseignant ( nom,prenom, email, grade,departement_id) VALUES (?, ?, ?, ?,?)";
                        // Utilisez la méthode prepareStatement pour créer une requête préparée
                        PreparedStatement ptm = con.prepareStatement(sql);

                        // Ajoutez manuellement les valeurs
                        ptm.setString(1, nom);
                        ptm.setString(2, prenom);
                        ptm.setString(3, email);
                        ptm.setInt(4, grade);
                        ptm.setInt(5, departement_id);

                        // Exécuter la mise à jour de la base de données (INSERT, UPDATE, DELETE)
                        // rowsAffected est utilisée pour stocker le nombre de lignes affectées par une opération de
                        // mise à jour dans la base de données,

                        int rowsAffected = ptm.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("L'enseignant a été ajouté avec succès !");
                        } else {
                            System.out.println("Échec de l'ajout de l'enseignant.");
                        }

                        // Fermer la ressource PreparedStatement
                        ptm.close();
                    }
                    break;
                case 2:
                    // Requête SQL pour la modification d'un enseignant
                    while (true) {
                        System.out.println("Veuillez entrer l'ID de l'enseignant à modifier (ou 'exit' pour quitter) :");
                        String inputId = s.nextLine();

                        if ("exit".equalsIgnoreCase(inputId)) {
                            break; // Quitter la boucle si l'utilisateur saisit 'exit'
                        }

                        try {
                            int enseignantId = Integer.parseInt(inputId);

                            System.out.println("Veuillez entrer le nouveau prénom de l'enseignant :");
                            String newPrenom = s.nextLine();

                            System.out.println("Veuillez entrer le nouveau nom de l'enseignant :");
                            String newNom = s.nextLine();

                            System.out.println("Veuillez entrer le nouvel email de l'enseignant :");
                            String newEmail = s.nextLine();

                            System.out.println("Veuillez entrer le nouveau grade de l'enseignant :");
                            Integer newGrade = s.nextInt();

                            System.out.println("Veuillez entrer le nouveau département associé à l'enseignant :");
                            Integer newDepartementId = s.nextInt();

                            // Requête SQL pour la modification d'un enseignant
                            String updateSql = "UPDATE enseignant SET nom = ?, prenom = ?, email = ?, grade = ?, departement_id = ? WHERE id = ?";
                            // Utilisez la méthode prepareStatement pour créer une requête préparée
                            PreparedStatement updateStatement = con.prepareStatement(updateSql);

                            // Ajoutez manuellement les valeurs
                            updateStatement.setString(1, newNom);
                            updateStatement.setString(2, newPrenom);
                            updateStatement.setString(3, newEmail);
                            updateStatement.setInt(4, newGrade);
                            updateStatement.setInt(5, newDepartementId);
                            updateStatement.setInt(6, enseignantId);

                            // Exécuter la mise à jour de la base de données (INSERT, UPDATE, DELETE)
                            int rowsAffected = updateStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("L'enseignant a été modifié avec succès !");
                            } else {
                                System.out.println("Aucune modification n'a été effectuée pour l'enseignant.");
                            }

                            // Fermer la ressource PreparedStatement
                            updateStatement.close();
                        } catch (NumberFormatException e) {
                            System.out.println("Veuillez entrer un ID valide.");
                        }

                        s.nextLine(); // Nettoyer le tampon de la ligne après avoir lu les entiers
                    }
                    break;
                case 3:
                    // Requête SQL pour la suppression d'un enseignant
                    while (true) {
                        System.out.println("Veuillez entrer l'ID de l'enseignant à supprimer (ou 'exit' pour quitter) :");
                        String inputId = s.nextLine();

                        if ("exit".equalsIgnoreCase(inputId)) {
                            break; // Quitter la boucle si l'utilisateur saisit 'exit'
                        }

                        try {
                            int enseignantId = Integer.parseInt(inputId);

                            // Requête SQL pour la suppression d'un enseignant
                            String deleteSql = "DELETE FROM enseignant WHERE id = ?";
                            // Utilisez la méthode prepareStatement pour créer une requête préparée
                            PreparedStatement deleteStatement = con.prepareStatement(deleteSql);

                            // Ajoutez manuellement les valeurs
                            deleteStatement.setInt(1, enseignantId);

                            // Exécuter la suppression dans la base de données
                            int rowsAffected = deleteStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("L'enseignant a été supprimé avec succès !");
                            } else {
                                System.out.println("Aucune suppression n'a été effectuée pour l'enseignant.");
                            }

                            // Fermer la ressource PreparedStatement
                            deleteStatement.close();
                        } catch (NumberFormatException e) {
                            System.out.println("Veuillez entrer un ID valide.");
                        }

                        s.nextLine(); // Nettoyer le tampon de la ligne après avoir lu les entiers
                    }
                    break; // Quitter la boucle si l'utilisateur saisit 'exit'

                case 4:
                    while (true) {Statement statement = con.createStatement();
                    ResultSet resultEnseignant = statement.executeQuery("select * from enseignant ");
                    while (resultEnseignant.next()) {
                        int id = resultEnseignant.getInt("id");
                        String nom = resultEnseignant.getString("nom");
                        String prenom = resultEnseignant.getString("prenom");
                        String email = resultEnseignant.getString("email");
                        int grade = resultEnseignant.getInt("grade");
                        int departementId = resultEnseignant.getInt("departement_id");

                        System.out.println(id +" "+ nom+" "+ prenom+""+ email+" "+ grade+" "+ departementId);

                         }break; // Quitter la boucle si l'utilisateur saisit 'exit'
                         }



            }


        }




    }}




