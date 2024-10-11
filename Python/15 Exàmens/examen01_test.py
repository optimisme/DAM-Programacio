#!/usr/bin/env python3

import unittest
from unittest.mock import patch, MagicMock
from io import StringIO
from examen01 import validar_nom, validar_edat, validar_factors, validar_descompte, validar_tipus_operacio, validar_clients, validar_data, validar_preu, afegir_client, modificar_client, esborrar_client, taula_operacions_client, llistar_clients, afegir_operacio, modificar_operacio, esborrar_operacio, llistar_operacions, llistar_operacions_client, mostrar_menu, obtenir_opcio, afegir_client_menu, modificar_client_menu, esborrar_client_menu, llistar_clients_menu, dibuixar_llista, mainRun

class TestValidarNom(unittest.TestCase):
    def test_valid_nom_correct(self):
        self.assertIs(validar_nom("Joan"), True)
        self.assertIs(validar_nom("Maria Teresa"), True)

    def test_valid_nom_incorrect_numbers(self):
        self.assertIs(validar_nom("Joan123"), False)

    def test_valid_nom_incorrect_symbols(self):
        self.assertIs(validar_nom("Maria@Teresa"), False)

    def test_valid_nom_with_spaces(self):
        self.assertIs(validar_nom("Joan Pere"), True)

    def test_valid_nom_empty(self):
        self.assertIs(validar_nom(""), False)

class TestValidarEdat(unittest.TestCase):

    def test_valid_edat_correct(self):
        self.assertIs(validar_edat(25), True)
        self.assertIs(validar_edat(18), True)
        self.assertIs(validar_edat(100), True)

    def test_valid_edat_below_minimum(self):
        self.assertIs(validar_edat(17), False)

    def test_valid_edat_above_maximum(self):
        self.assertIs(validar_edat(101), False)

    def test_valid_edat_non_integer(self):
        self.assertIs(validar_edat("twenty"), False)
        self.assertIs(validar_edat(25.5), False)
        self.assertIs(validar_edat([25]), False)

    def test_valid_edat_negative(self):
        self.assertIs(validar_edat(-5), False)

    def test_valid_edat_zero(self):
        self.assertIs(validar_edat(0), False)

class TestValidarFactors(unittest.TestCase):

    def test_valid_factors_correct(self):
        self.assertIs(validar_factors(["autònom", "risc alt"]), True)
        self.assertIs(validar_factors(["empresa", "risc baix"]), True)
        self.assertIs(validar_factors(["empresa", "risc mitjà"]), True)

    def test_valid_factors_incorrect_first_element(self):
        self.assertIs(validar_factors(["particular", "risc alt"]), False)
        self.assertIs(validar_factors(["freelance", "risc baix"]), False)

    def test_valid_factors_incorrect_second_element(self):
        self.assertIs(validar_factors(["autònom", "risc moderat"]), False)
        self.assertIs(validar_factors(["empresa", "risc altíssim"]), False)

    def test_valid_factors_wrong_type(self):
        self.assertIs(validar_factors("autònom, risc alt"), False)
        self.assertIs(validar_factors(("autònom", "risc baix")), False)

    def test_valid_factors_incorrect_length(self):
        self.assertIs(validar_factors(["autònom"]), False)
        self.assertIs(validar_factors(["autònom", "risc alt", "extra"]), False)

    def test_valid_factors_empty_list(self):
        self.assertIs(validar_factors([]), False)

class TestValidarDescompte(unittest.TestCase):

    def test_valid_descompte_correct(self):
        self.assertIs(validar_descompte(10), True)
        self.assertIs(validar_descompte(0), True)
        self.assertIs(validar_descompte(20), True)
        self.assertIs(validar_descompte(15.5), True)

    def test_valid_descompte_below_minimum(self):
        self.assertIs(validar_descompte(-1), False)
        self.assertIs(validar_descompte(-0.5), False)

    def test_valid_descompte_above_maximum(self):
        self.assertIs(validar_descompte(21), False)
        self.assertIs(validar_descompte(20.1), False)

    def test_valid_descompte_non_numeric(self):
        self.assertIs(validar_descompte("10"), False)
        self.assertIs(validar_descompte([10]), False)
        self.assertIs(validar_descompte(None), False)

class TestValidarTipusOperacio(unittest.TestCase):

    def test_valid_tipus_operacio_correct(self):
        self.assertIs(validar_tipus_operacio("Declaració d'impostos"), True)
        self.assertIs(validar_tipus_operacio("Gestió laboral"), True)
        self.assertIs(validar_tipus_operacio("Assessoria fiscal"), True)
        self.assertIs(validar_tipus_operacio("Constitució de societat"), True)
        self.assertIs(validar_tipus_operacio("Modificació d'escriptures"), True)
        self.assertIs(validar_tipus_operacio("Testament"), True)
        self.assertIs(validar_tipus_operacio("Gestió d'herències"), True)
        self.assertIs(validar_tipus_operacio("Acta notarial"), True)
        self.assertIs(validar_tipus_operacio("Contracte de compravenda"), True)
        self.assertIs(validar_tipus_operacio("Contracte de lloguer"), True)

    def test_invalid_tipus_operacio_incorrect(self):
        self.assertIs(validar_tipus_operacio("Consultoria"), False)
        self.assertIs(validar_tipus_operacio("Assistència tècnica"), False)
        self.assertIs(validar_tipus_operacio("Servei de mediació"), False)

    def test_invalid_tipus_operacio_empty_string(self):
        self.assertIs(validar_tipus_operacio(""), False)

    def test_invalid_tipus_operacio_partial_match(self):
        self.assertIs(validar_tipus_operacio("Declaració"), False)
        self.assertIs(validar_tipus_operacio("Gestió"), False)

    def test_invalid_tipus_operacio_case_sensitive(self):
        self.assertIs(validar_tipus_operacio("gestió laboral"), False)
        self.assertIs(validar_tipus_operacio("CONSTITUCIÓ DE SOCIETAT"), False)

class TestValidarClients(unittest.TestCase):
    def setUp(self):
        self.clients_globals = ["client1", "client2", "client3", "client4"]

    def test_valid_clients_correct(self):
        self.assertIs(validar_clients(["client1", "client2"], self.clients_globals), True)
        self.assertIs(validar_clients(["client3", "client4"], self.clients_globals), True)

    def test_valid_clients_incorrect_non_list(self):
        self.assertIs(validar_clients("client1, client2", self.clients_globals), False)
        self.assertIs(validar_clients(("client1", "client2"), self.clients_globals), False)

    def test_valid_clients_duplicate(self):
        self.assertIs(validar_clients(["client1", "client1"], self.clients_globals), False)
        self.assertIs(validar_clients(["client3", "client4", "client3"], self.clients_globals), False)

    def test_valid_clients_not_in_globals(self):
        self.assertIs(validar_clients(["client5", "client1"], self.clients_globals), False)
        self.assertIs(validar_clients(["client3", "client6"], self.clients_globals), False)

    def test_valid_clients_empty_list(self):
        self.assertIs(validar_clients([], self.clients_globals), True)

class TestValidarData(unittest.TestCase):
    def test_valid_data_correct(self):
        self.assertIs(validar_data("2023-10-06"), True)
        self.assertIs(validar_data("2000-02-29"), True)  # Any de traspàs
        self.assertIs(validar_data("1999-12-31"), True)

    def test_invalid_data_length(self):
        self.assertIs(validar_data("2023-10-6"), False)  # Data massa curta
        self.assertIs(validar_data("2023-1006"), False)  # Format incorrecte
        self.assertIs(validar_data("2023-10-066"), False)  # Massa caràcters

    def test_invalid_data_non_digit(self):
        self.assertIs(validar_data("abcd-10-06"), False)
        self.assertIs(validar_data("2023-xx-06"), False)
        self.assertIs(validar_data("2023-10-yy"), False)

    def test_invalid_data_year_out_of_range(self):
        self.assertIs(validar_data("0999-10-06"), False)  # Any massa petit
        self.assertIs(validar_data("10000-10-06"), False)  # Any massa gran

    def test_invalid_data_month_out_of_range(self):
        self.assertIs(validar_data("2023-00-06"), False)  # Mes massa petit
        self.assertIs(validar_data("2023-13-06"), False)  # Mes massa gran

    def test_invalid_data_day_out_of_range(self):
        self.assertIs(validar_data("2023-10-00"), False)  # Dia massa petit
        self.assertIs(validar_data("2023-10-32"), False)  # Dia massa gran

    def test_invalid_data_empty_string(self):
        self.assertIs(validar_data(""), False)

class TestValidarPreu(unittest.TestCase):
    def test_valid_preu_correct(self):
        self.assertIs(validar_preu(150), True)
        self.assertIs(validar_preu(101.5), True)
        self.assertIs(validar_preu(1000), True)

    def test_invalid_preu_below_threshold(self):
        self.assertIs(validar_preu(100), False)  # Just al límit, ha de ser > 100
        self.assertIs(validar_preu(99.99), False)  # Sota el límit
        self.assertIs(validar_preu(50), False)

    def test_invalid_preu_non_numeric(self):
        self.assertIs(validar_preu("150"), False)  # String en comptes d'enter/float
        self.assertIs(validar_preu([150]), False)  # Llista en comptes de número
        self.assertIs(validar_preu(None), False)  # NoneType

    def test_invalid_preu_negative(self):
        self.assertIs(validar_preu(-150), False)
        self.assertIs(validar_preu(-101.5), False)

    def test_invalid_preu_zero(self):
        self.assertIs(validar_preu(0), False)

class TestAfegirClient(unittest.TestCase):

    def setUp(self):
        self.clients = {
            "client_0": {"nom": "Joan", "edat": 30, "factors": ["autònom", "risc alt"], "descompte": 10},
            "client_1": {"nom": "Maria", "edat": 45, "factors": ["empresa", "risc baix"], "descompte": 5}
        }

    def test_afegir_client_correct(self):
        nova_clau = afegir_client(self.clients, "Pere", 40, ["autònom", "risc mitjà"], 15)
        self.assertEqual(nova_clau, "client_2")
        self.assertIn("client_2", self.clients)
        self.assertEqual(self.clients["client_2"], {"nom": "Pere", "edat": 40, "factors": ["autònom", "risc mitjà"], "descompte": 15})

    def test_afegir_client_increment_clau(self):
        afegir_client(self.clients, "Lluc", 50, ["empresa", "risc alt"], 20)
        self.assertEqual(afegir_client(self.clients, "Anna", 35, ["autònom", "risc mitjà"], 12), "client_3")
        self.assertIn("client_3", self.clients)

    def test_afegir_client_multiple(self):
        afegir_client(self.clients, "Anna", 35, ["autònom", "risc mitjà"], 12)
        afegir_client(self.clients, "Carles", 29, ["empresa", "risc mitjà"], 18)
        self.assertEqual(len(self.clients), 4)
        self.assertEqual(self.clients["client_3"], {"nom": "Carles", "edat": 29, "factors": ["empresa", "risc mitjà"], "descompte": 18})

class TestModificarClient(unittest.TestCase):

    def setUp(self):
        self.clients = {
            "client_0": {"nom": "Joan", "edat": 30, "factors": ["autònom", "risc alt"], "descompte": 10},
            "client_1": {"nom": "Maria", "edat": 45, "factors": ["empresa", "risc baix"], "descompte": 5}
        }

    def test_modificar_client_nom(self):
        modificar_client(self.clients, "client_0", "nom", "Pere")
        self.assertEqual(self.clients["client_0"]["nom"], "Pere")

    def test_modificar_client_edat(self):
        modificar_client(self.clients, "client_1", "edat", 50)
        self.assertEqual(self.clients["client_1"]["edat"], 50)

    def test_modificar_client_factors(self):
        modificar_client(self.clients, "client_0", "factors", ["empresa", "risc baix"])
        self.assertEqual(self.clients["client_0"]["factors"], ["empresa", "risc baix"])

    def test_modificar_client_descompte(self):
        modificar_client(self.clients, "client_1", "descompte", 12)
        self.assertEqual(self.clients["client_1"]["descompte"], 12)

    def test_modificar_client_camp_no_existent(self):
        resultat = modificar_client(self.clients, "client_0", "adreça", "Carrer Major")
        self.assertEqual(resultat, "El camp adreça no existeix en el client.")
        self.assertNotIn("adreça", self.clients["client_0"])

    def test_modificar_client_clau_no_existent(self):
        resultat = modificar_client(self.clients, "client_3", "nom", "Carles")
        self.assertEqual(resultat, "Client amb clau client_3 no existeix.")

class TestEsborrarClient(unittest.TestCase):

    def setUp(self):
        self.clients = {
            "client_0": {"nom": "Joan", "edat": 30, "factors": ["autònom", "risc alt"], "descompte": 10},
            "client_1": {"nom": "Maria", "edat": 45, "factors": ["empresa", "risc baix"], "descompte": 5}
        }

    def test_esborrar_client_correct(self):
        esborrar_client(self.clients, "client_0")
        self.assertNotIn("client_0", self.clients)

    def test_esborrar_client_clau_no_existent(self):
        resultat = esborrar_client(self.clients, "client_3")
        self.assertEqual(resultat, "Client amb clau client_3 no existeix.")
        self.assertEqual(len(self.clients), 2)  # No s'ha d'haver esborrat cap client

    def test_esborrar_ultim_client(self):
        esborrar_client(self.clients, "client_1")
        self.assertNotIn("client_1", self.clients)
        self.assertEqual(len(self.clients), 1)  # Només queda un client

class TestLlistarClients(unittest.TestCase):

    def setUp(self):
        self.clients = {
            "client_0": {"nom": "Joan", "edat": 30, "factors": ["autònom", "risc alt"], "descompte": 10},
            "client_1": {"nom": "Maria", "edat": 45, "factors": ["empresa", "risc baix"], "descompte": 5},
            "client_2": {"nom": "Pere", "edat": 35, "factors": ["autònom", "risc mitjà"], "descompte": 8}
        }

    def test_llistar_clients_condicio_correcta(self):
        resultat = llistar_clients(self.clients, ["client_0", "client_1"], {"factors": ["empresa", "risc baix"]})
        self.assertEqual(resultat, [{"client_1": {"nom": "Maria", "edat": 45, "factors": ["empresa", "risc baix"], "descompte": 5}}])

    def test_llistar_clients_sense_condicio(self):
        resultat = llistar_clients(self.clients, ["client_0", "client_1"], {})
        self.assertEqual(resultat, [
            {"client_0": {"nom": "Joan", "edat": 30, "factors": ["autònom", "risc alt"], "descompte": 10}},
            {"client_1": {"nom": "Maria", "edat": 45, "factors": ["empresa", "risc baix"], "descompte": 5}}
        ])

    def test_llistar_clients_clau_no_inclosa(self):
        resultat = llistar_clients(self.clients, ["client_2"], {"factors": ["autònom", "risc alt"]})
        self.assertEqual(resultat, [])

    def test_llistar_clients_condicio_no_compleix(self):
        resultat = llistar_clients(self.clients, ["client_0", "client_1"], {"descompte": 20})
        self.assertEqual(resultat, [])

    def test_llistar_clients_varies_condicions(self):
        resultat = llistar_clients(self.clients, ["client_0", "client_2"], {"factors": ["autònom", "risc mitjà"], "descompte": 8})
        self.assertEqual(resultat, [{"client_2": {"nom": "Pere", "edat": 35, "factors": ["autònom", "risc mitjà"], "descompte": 8}}])

class TestAfegirOperacio(unittest.TestCase):

    def setUp(self):
        self.operacions = [
            {"id": 0, "tipus": "Declaració d'impostos", "clients": ["client_0"], "data": "2023-10-06", "observacions": "Urgent", "preu": 150.0},
            {"id": 1, "tipus": "Gestió laboral", "clients": ["client_1", "client_2"], "data": "2023-09-01", "observacions": "", "preu": 300.0}
        ]

    def test_afegir_operacio_correcta(self):
        nou_id = afegir_operacio(self.operacions, "Constitució de societat", ["client_3"], "2023-11-15", "Sense observacions", 500.0)
        self.assertEqual(nou_id, 2)
        self.assertEqual(self.operacions[-1], {"id": 2, "tipus": "Constitució de societat", "clients": ["client_3"], "data": "2023-11-15", "observacions": "Sense observacions", "preu": 500.0})

    def test_afegir_operacio_increment_id(self):
        afegir_operacio(self.operacions, "Modificació d'escriptures", ["client_1"], "2023-12-20", "Important", 400.0)
        nou_id = afegir_operacio(self.operacions, "Testament", ["client_2", "client_3"], "2024-01-10", "", 200.0)
        self.assertEqual(nou_id, 3)
        self.assertEqual(self.operacions[-1]["id"], 3)

    def test_afegir_operacio_varis_clients(self):
        nou_id = afegir_operacio(self.operacions, "Contracte de compravenda", ["client_0", "client_2"], "2024-02-05", "Documentació completa", 250.0)
        self.assertEqual(nou_id, 2)
        self.assertEqual(self.operacions[-1]["clients"], ["client_0", "client_2"])
        self.assertEqual(self.operacions[-1]["preu"], 250.0)

class TestModificarOperacio(unittest.TestCase):

    def setUp(self):
        self.operacions = [
            {"id": 0, "tipus": "Declaració d'impostos", "clients": ["client_0"], "data": "2023-10-06", "observacions": "Urgent", "preu": 150.0},
            {"id": 1, "tipus": "Gestió laboral", "clients": ["client_1", "client_2"], "data": "2023-09-01", "observacions": "", "preu": 300.0}
        ]

    def test_modificar_operacio_tipus(self):
        modificar_operacio(self.operacions, 0, "tipus", "Constitució de societat")
        self.assertEqual(self.operacions[0]["tipus"], "Constitució de societat")

    def test_modificar_operacio_preu(self):
        modificar_operacio(self.operacions, 1, "preu", 350.0)
        self.assertEqual(self.operacions[1]["preu"], 350.0)

    def test_modificar_operacio_observacions(self):
        modificar_operacio(self.operacions, 0, "observacions", "Canvi de data")
        self.assertEqual(self.operacions[0]["observacions"], "Canvi de data")

    def test_modificar_operacio_camp_no_existent(self):
        resultat = modificar_operacio(self.operacions, 0, "adreça", "Carrer Major")
        self.assertEqual(resultat, "El camp adreça no existeix en l'operació.")
        self.assertNotIn("adreça", self.operacions[0])

    def test_modificar_operacio_id_no_existent(self):
        resultat = modificar_operacio(self.operacions, 3, "preu", 500.0)
        self.assertEqual(resultat, "Operació amb id 3 no existeix.")

class TestEsborrarOperacio(unittest.TestCase):

    def setUp(self):
        self.operacions = [
            {"id": 0, "tipus": "Declaració d'impostos", "clients": ["client_0"], "data": "2023-10-06", "observacions": "Urgent", "preu": 150.0},
            {"id": 1, "tipus": "Gestió laboral", "clients": ["client_1", "client_2"], "data": "2023-09-01", "observacions": "", "preu": 300.0},
            {"id": 2, "tipus": "Constitució de societat", "clients": ["client_3"], "data": "2023-11-15", "observacions": "Sense observacions", "preu": 500.0}
        ]

    def test_esborrar_operacio_correcta(self):
        esborrar_operacio(self.operacions, 1)
        self.assertEqual(len(self.operacions), 2)
        self.assertNotIn({"id": 1, "tipus": "Gestió laboral", "clients": ["client_1", "client_2"], "data": "2023-09-01", "observacions": "", "preu": 300.0}, self.operacions)

    def test_esborrar_operacio_id_no_existent(self):
        resultat = esborrar_operacio(self.operacions, 5)
        self.assertEqual(resultat, "Operació amb id 5 no existeix.")
        self.assertEqual(len(self.operacions), 3)  # Cap operació ha de ser esborrada

    def test_esborrar_ultima_operacio(self):
        esborrar_operacio(self.operacions, 2)
        self.assertEqual(len(self.operacions), 2)
        self.assertNotIn({"id": 2, "tipus": "Constitució de societat", "clients": ["client_3"], "data": "2023-11-15", "observacions": "Sense observacions", "preu": 500.0}, self.operacions)

class TestLlistarOperacions(unittest.TestCase):

    def setUp(self):
        self.operacions = [
            {"id": 0, "tipus": "Declaració d'impostos", "clients": ["client_0"], "data": "2023-10-06", "observacions": "Urgent", "preu": 150.0},
            {"id": 1, "tipus": "Gestió laboral", "clients": ["client_1", "client_2"], "data": "2023-09-01", "observacions": "", "preu": 300.0},
            {"id": 2, "tipus": "Constitució de societat", "clients": ["client_3"], "data": "2023-11-15", "observacions": "Sense observacions", "preu": 500.0}
        ]

    def test_llistar_operacions_ids_correctes(self):
        resultat = llistar_operacions(self.operacions, [0, 1], {})
        self.assertEqual(len(resultat), 2)
        self.assertEqual(resultat[0]["id"], 0)
        self.assertEqual(resultat[1]["id"], 1)

    def test_llistar_operacions_amb_condicio(self):
        resultat = llistar_operacions(self.operacions, [], {"tipus": "Gestió laboral"})
        self.assertEqual(len(resultat), 1)
        self.assertEqual(resultat[0]["tipus"], "Gestió laboral")

    def test_llistar_operacions_ids_i_condicions(self):
        resultat = llistar_operacions(self.operacions, [1, 2], {"preu": 300.0})
        self.assertEqual(len(resultat), 1)
        self.assertEqual(resultat[0]["id"], 1)

    def test_llistar_operacions_condicio_no_compleix(self):
        resultat = llistar_operacions(self.operacions, [], {"preu": 1000.0})
        self.assertEqual(len(resultat), 0)

    def test_llistar_operacions_ids_no_existent(self):
        resultat = llistar_operacions(self.operacions, [99], {})
        self.assertEqual(len(resultat), 0)

    def test_llistar_operacions_varies_condicions(self):
        resultat = llistar_operacions(self.operacions, [], {"tipus": "Constitució de societat", "preu": 500.0})
        self.assertEqual(len(resultat), 1)
        self.assertEqual(resultat[0]["id"], 2)

class TestLlistarOperacionsClient(unittest.TestCase):

    def setUp(self):
        self.operacions = [
            {"id": 0, "tipus": "Declaració d'impostos", "clients": ["client_0"], "data": "2023-10-06", "observacions": "Urgent", "preu": 150.0},
            {"id": 1, "tipus": "Gestió laboral", "clients": ["client_1", "client_2"], "data": "2023-09-01", "observacions": "", "preu": 300.0},
            {"id": 2, "tipus": "Constitució de societat", "clients": ["client_0", "client_2"], "data": "2023-11-15", "observacions": "Sense observacions", "preu": 500.0}
        ]

    def test_llistar_operacions_client_trobades(self):
        resultat = llistar_operacions_client(self.operacions, "client_0")
        self.assertEqual(len(resultat), 2)
        self.assertEqual(resultat[0]["id"], 0)
        self.assertEqual(resultat[1]["id"], 2)

    def test_llistar_operacions_client_sense_operacions(self):
        resultat = llistar_operacions_client(self.operacions, "client_3")
        self.assertEqual(len(resultat), 0)

    def test_llistar_operacions_client_varis_clients(self):
        resultat = llistar_operacions_client(self.operacions, "client_2")
        self.assertEqual(len(resultat), 2)
        self.assertEqual(resultat[0]["id"], 1)
        self.assertEqual(resultat[1]["id"], 2)

class TestTaulaOperacionsClient(unittest.TestCase):

    def setUp(self):
        self.clients = {
            "client_0": {"nom": "Joan", "edat": 30, "factors": ["autònom", "risc alt"], "descompte": 10},
            "client_1": {"nom": "Maria", "edat": 45, "factors": ["empresa", "risc baix"], "descompte": 5}
        }

        self.operacions = [
            {"id": 0, "tipus": "Declaració d'impostos", "clients": ["client_0"], "data": "2023-10-06", "observacions": "Urgent", "preu": 150.0},
            {"id": 1, "tipus": "Gestió laboral", "clients": ["client_0", "client_1"], "data": "2023-09-01", "observacions": "", "preu": 300.0},
            {"id": 2, "tipus": "Constitució de societat", "clients": ["client_1"], "data": "2023-11-15", "observacions": "Sense observacions", "preu": 500.0}
        ]

    def test_taula_client_no_existent(self):
        resultat = taula_operacions_client(self.clients, self.operacions, "client_99", "data")
        self.assertEqual(resultat, ["Client amb clau client_99 no existeix."])

    def test_ordre_operacions_data(self):
        resultat = taula_operacions_client(self.clients, self.operacions, "client_0", "data")
        # Les operacions han d'estar ordenades per data
        self.assertIn("2023-09-01", resultat[3])
        self.assertIn("2023-10-06", resultat[4])

    def test_ordre_operacions_preu(self):
        resultat = taula_operacions_client(self.clients, self.operacions, "client_0", "preu")
        # Les operacions han d'estar ordenades per preu (primera la més barata)
        self.assertIn("150.00", resultat[3])
        self.assertIn("300.00", resultat[4])

class TestMostrarMenu(unittest.TestCase):

    def test_mostrar_menu(self):
        resultat_esperat = [
            "=== Menú de Gestió de Notaria ===",
            "1. Afegir client",
            "2. Modificar client",
            "3. Esborrar client",
            "4. Llistar clients",
            "5. Afegir operació",
            "6. Modificar operació",
            "7. Esborrar operació",
            "8. Llistar operacions",
            "0. Sortir"
        ]
        resultat_obtingut = mostrar_menu()
        self.assertEqual(resultat_obtingut, resultat_esperat)

class TestObtenirOpcio(unittest.TestCase):

    @patch('builtins.input', return_value="  5  ")
    def test_obtenir_opcio_numero(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "5")
    
    @patch('builtins.input', return_value="   sortir ")
    def test_obtenir_opcio_paraula_clau(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "sortir")
    
    @patch('builtins.input', return_value="  llistar clients ")
    def test_obtenir_opcio_paraula_amb_espais(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "llistar clients")

    @patch('builtins.input', return_value="")
    def test_obtenir_opcio_buit(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "")  # Test per a entrada buida

    @patch('builtins.input', return_value="  10 ")
    def test_obtenir_opcio_numero_gran(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "10")  # Test per un número més gran
    
    @patch('builtins.input', return_value="MODIFICAR CLIENT")
    def test_obtenir_opcio_majuscules(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "MODIFICAR CLIENT")  # Comprovem que es manté el text amb majúscules

    @patch('builtins.input', return_value="!@#$$%^&*")
    def test_obtenir_opcio_caracters_especials(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "!@#$$%^&*")  # Test per a caràcters especials

    @patch('builtins.input', return_value="  client_1 ")
    def test_obtenir_opcio_amb_clau_client(self, mock_input):
        resultat = obtenir_opcio()
        self.assertEqual(resultat, "client_1")  # Test per una clau com "client_1"

class TestAfegirClientMenu(unittest.TestCase):

    @patch('examen01.afegir_client', return_value="client_0")
    @patch('examen01.validar_descompte', return_value=True)
    @patch('examen01.validar_factors', return_value=True)
    @patch('examen01.validar_edat', return_value=True)
    @patch('examen01.validar_nom', return_value=True)
    @patch('builtins.input', side_effect=[
        "Joan",  # Nom
        "30",    # Edat
        "autònom",  # Primer factor
        "risc mitjà",  # Segon factor
        "10"     # Descompte
    ])
    def test_afegir_client_correct(self, mock_input, mock_validar_nom, mock_validar_edat, mock_validar_factors, mock_validar_descompte, mock_afegir_client):
        resultat = afegir_client_menu()

        # Comprovem que el resultat conté el missatge esperat
        self.assertIn("=== Afegir Client ===", resultat)
        self.assertIn("S'ha afegit el client amb clau client_0.", resultat)

        # Comprovem que les funcions de validació i afegir client es van cridar correctament
        mock_validar_nom.assert_called_with("Joan")
        mock_validar_edat.assert_called_with(30)
        mock_validar_factors.assert_called_with(["autònom", "risc mitjà"])
        mock_validar_descompte.assert_called_with(10.0)
        mock_afegir_client.assert_called_with({}, "Joan", 30, ["autònom", "risc mitjà"], 10.0)

    @patch('examen01.validar_nom', side_effect=[False, True])
    @patch('builtins.input', side_effect=["Jo@an", "Joan", "30", "autònom", "risc mitjà", "10"])
    def test_afegir_client_nom_incorrecte(self, mock_input, mock_validar_nom):
        resultat = afegir_client_menu()

        # Comprovem que el nom no vàlid és detectat i es demana de nou
        self.assertIn("Nom no vàlid. Només s'accepten lletres i espais.", resultat)

    @patch('examen01.validar_edat', side_effect=[False, True])
    @patch('builtins.input', side_effect=["Joan", "17", "30", "autònom", "risc mitjà", "10"])
    def test_afegir_client_edat_incorrecta(self, mock_input, mock_validar_edat):
        resultat = afegir_client_menu()

        # Comprovem que l'edat incorrecta és detectada i es demana de nou
        self.assertIn("Edat no vàlida. Introdueix un número entre 18 i 100.", resultat)

    @patch('examen01.validar_descompte', side_effect=[False, True])
    @patch('builtins.input', side_effect=["Joan", "30", "autònom", "risc mitjà", "25", "10"])
    def test_afegir_client_descompte_incorrecte(self, mock_input, mock_validar_descompte):
        resultat = afegir_client_menu()

        # Comprovem que un descompte incorrecte és detectat i es demana de nou
        self.assertIn("Descompte no vàlid. Ha de ser un número entre 0 i 20.", resultat)

class TestModificarClientMenu(unittest.TestCase):

    @patch('examen01.modificar_client', return_value=None)
    @patch('examen01.validar_descompte', return_value=True)
    @patch('examen01.validar_factors', return_value=True)
    @patch('examen01.validar_edat', return_value=True)
    @patch('examen01.validar_nom', return_value=True)
    @patch('builtins.input', side_effect=[
        "client_0",  # Clau client
        "nom",       # Camp a modificar
        "Pere"       # Nou valor per a nom
    ])
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_modificar_client_nom(self, mock_input, mock_validar_nom, mock_validar_edat, mock_validar_factors, mock_validar_descompte, mock_modificar_client):
        resultat = modificar_client_menu()

        # Comprovar que el resultat conté el missatge esperat
        self.assertIn("S'ha modificat el client client_0.", resultat)

        # Comprovar que la funció validar_nom es crida correctament
        mock_validar_nom.assert_called_with("Pere")
        # Comprovar que la funció modificar_client es crida correctament amb el diccionari de clients esperat
        mock_modificar_client.assert_called_with({'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}}, "client_0", "nom", "Pere")

    @patch('examen01.validar_nom', side_effect=[False, True])
    @patch('builtins.input', side_effect=[
        "client_0",  # Clau client
        "nom",       # Camp a modificar
        "Jo@n",      # Nom no vàlid
        "Joan"       # Nom vàlid
    ])
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_modificar_client_nom_incorrecte(self, mock_input, mock_validar_nom):
        resultat = modificar_client_menu()

        # Comprovar que el nom no vàlid és detectat i es demana de nou
        self.assertIn("Nom no vàlid. Només s'accepten lletres i espais.", resultat)

    @patch('examen01.validar_edat', side_effect=[False, True])
    @patch('builtins.input', side_effect=[
        "client_0",  # Clau client
        "edat",      # Camp a modificar
        "17",        # Edat no vàlida
        "30"         # Edat vàlida
    ])
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_modificar_client_edat_incorrecta(self, mock_input, mock_validar_edat):
        resultat = modificar_client_menu()

        # Comprovar que l'edat incorrecta és detectada i es demana de nou
        self.assertIn("Edat no vàlida. Introdueix un número entre 18 i 100.", resultat)

    @patch('examen01.validar_factors', side_effect=[False, True])
    @patch('builtins.input', side_effect=[
        "client_0",  # Clau client
        "factors",   # Camp a modificar
        "freelance", # Primer factor no vàlid
        "autònom",   # Primer factor vàlid
        "risc alt"   # Segon factor vàlid
    ])
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_modificar_client_factors_incorrectes(self, mock_input, mock_validar_factors):
        resultat = modificar_client_menu()

        # Comprovar que un factor incorrecte és detectat i es demana de nou
        self.assertIn("Factor no vàlid. Ha de ser 'autònom' o 'empresa'.", resultat)

    @patch('examen01.validar_descompte', side_effect=[False, True])
    @patch('builtins.input', side_effect=[
        "client_0",  # Clau client
        "descompte", # Camp a modificar
        "25",        # Descompte no vàlid
        "10"         # Descompte vàlid
    ])
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_modificar_client_descompte_incorrecte(self, mock_input, mock_validar_descompte):
        resultat = modificar_client_menu()

        # Comprovar que un descompte incorrecte és detectat i es demana de nou
        self.assertIn("Descompte no vàlid. Ha de ser un número entre 0 i 20.", resultat)

    @patch('examen01.modificar_client', return_value="Error al modificar el client.")
    @patch('builtins.input', side_effect=[
        "client_99",  # Clau client no existent
    ])
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_modificar_client_no_existent(self, mock_input, mock_modificar_client):
        # Simulem el comportament de la funció quan no es troba el client
        resultat = modificar_client_menu()

        # Comprovar que el client no existeix
        self.assertIn("Client amb clau client_99 no existeix.", resultat)

class TestEsborrarClientMenu(unittest.TestCase):

    @patch('examen01.esborrar_client')
    @patch('builtins.input', return_value="client_0")
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_esborrar_client_exist(self, mock_input, mock_esborrar_client):
        resultat = esborrar_client_menu()

        # Comprovar que el client s'ha esborrat correctament
        self.assertIn("S'ha esborrat el client client_0.", resultat)

        # Comprovar que la funció esborrar_client s'ha cridat amb els paràmetres correctes
        mock_esborrar_client.assert_called_with({'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}}, 'client_0')

    @patch('builtins.input', return_value="client_99")
    @patch('examen01.clients', {'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}})
    def test_esborrar_client_no_exist(self, mock_input):
        resultat = esborrar_client_menu()

        # Comprovar que el missatge d'error es mostra per un client inexistent
        self.assertIn("Client amb clau client_99 no existeix.", resultat)

class TestLlistarClientsMenu(unittest.TestCase):

    @patch('examen01.clients', {
        'client_0': {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10},
        'client_1': {'nom': 'Maria', 'edat': 40, 'factors': ['empresa', 'risc baix'], 'descompte': 15}
    })
    def test_llistar_clients_amb_clients(self):
        resultat = llistar_clients_menu()

        # Comprovar que es llisten els clients correctament
        self.assertIn("=== Llistar Clients ===", resultat)
        self.assertIn("client_0: {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc alt'], 'descompte': 10}", resultat)
        self.assertIn("client_1: {'nom': 'Maria', 'edat': 40, 'factors': ['empresa', 'risc baix'], 'descompte': 15}", resultat)

    @patch('examen01.clients', {})
    def test_llistar_clients_sense_clients(self):
        resultat = llistar_clients_menu()

        # Comprovar que es mostra el missatge quan no hi ha clients
        self.assertIn("No hi ha clients per mostrar.", resultat)

class TestDibuixarLlista(unittest.TestCase):

    @patch('builtins.print')
    def test_dibuixar_llista(self, mock_print):
        llista = [
            "Línia 1",
            "Línia 2",
            "Línia 3"
        ]
        
        dibuixar_llista(llista)

        # Verifica que la funció print es crida una vegada per cada línia de la llista
        mock_print.assert_any_call("Línia 1")
        mock_print.assert_any_call("Línia 2")
        mock_print.assert_any_call("Línia 3")
        
        # Verifica que print es crida exactament tantes vegades com elements a la llista
        self.assertEqual(mock_print.call_count, 3)

class TestMainRun(unittest.TestCase):

    @patch('examen01.dibuixar_llista')  # Simulem dibuixar_llista
    @patch('examen01.clearScreen')  # Simulem clearScreen
    @patch('examen01.obtenir_opcio', side_effect=['1', '0'])  # Simulem que l'usuari tria 'Afegir client' i després 'Sortir'
    @patch('examen01.afegir_client_menu', return_value=["Client afegit correctament"])
    @patch('examen01.mostrar_menu', return_value=["=== Menú de Gestió de Notaria ===", "1. Afegir client", "0. Sortir"])
    def test_main_run_afegir_client_i_sortir(self, mock_mostrar_menu, mock_afegir_client_menu, mock_obtenir_opcio, mock_clearScreen, mock_dibuixar_llista):
        mainRun()

        # Comprovar que clearScreen es crida dues vegades (una per cada iteració del bucle)
        self.assertEqual(mock_clearScreen.call_count, 2)

        # Comprovar que el menú es mostra dues vegades
        mock_dibuixar_llista.assert_any_call(["=== Menú de Gestió de Notaria ===", "1. Afegir client", "0. Sortir"])

        # Comprovar que es crida afegir_client_menu una vegada
        mock_afegir_client_menu.assert_called_once()

        # Comprovar que es mostra el missatge "Client afegit correctament"
        mock_dibuixar_llista.assert_any_call(["Client afegit correctament"])

        # Comprovar que es mostra el missatge "Fins aviat!" quan l'usuari tria sortir
        mock_dibuixar_llista.assert_any_call(["Fins aviat!"])

    @patch('examen01.dibuixar_llista')  # Simulem dibuixar_llista
    @patch('examen01.clearScreen')  # Simulem clearScreen
    @patch('examen01.obtenir_opcio', side_effect=['9', '0'])  # Simulem que l'usuari tria una opció no vàlida i després 'Sortir'
    @patch('examen01.mostrar_menu', return_value=["=== Menú de Gestió de Notaria ===", "1. Afegir client", "0. Sortir"])
    def test_main_run_opcio_no_valida_i_sortir(self, mock_mostrar_menu, mock_obtenir_opcio, mock_clearScreen, mock_dibuixar_llista):
        mainRun()

        # Comprovar que clearScreen es crida dues vegades (una per cada iteració del bucle)
        self.assertEqual(mock_clearScreen.call_count, 2)

        # Comprovar que el menú es mostra dues vegades
        mock_dibuixar_llista.assert_any_call(["=== Menú de Gestió de Notaria ===", "1. Afegir client", "0. Sortir"])

        # Comprovar que es mostra el missatge d'opció no vàlida
        mock_dibuixar_llista.assert_any_call(["Opció no vàlida. Si us plau, tria una opció del menú."])

        # Comprovar que es mostra el missatge "Fins aviat!" quan l'usuari tria sortir
        mock_dibuixar_llista.assert_any_call(["Fins aviat!"])

# Executar el test
if __name__ == '__main__':
    unittest.main()