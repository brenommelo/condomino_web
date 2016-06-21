/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.commons;

/**
 *
 * @author igor.santos
 */
public enum EnumMedicamentos {
//classes de medicamentos

    CLASSE_ANTAGREGANTE_PLAQUETARIO("Antiagregantes plaquetários"),
    CLASSE_DIURETICOS_TIAZIDICOS("Diuréticos Tiazídicos"),
    CLASSE_DIURETICOS_ALCA("Diuréticos de alça"),
    CLASSE_DIURETICOS_POUPADORES_POTASSIO("Diuréticos Poupadores de Potássio"),
    CLASSE_BETA_BLOQUEADORES("Beta Bloqueadores"),
    CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS("Bloqueadores de canais de Cálcio Dihidropiridinicos"),
    CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS("Bloqueadores de canais de Cálcio Não Dihidropiridinicos"),
    CLASSE_INIBIDORES_ECA("Inibidores de ECA"),
    CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA("Boqueadores do Receptor da Angiotensina"),
    CLASSE_ALFA_BLOQUEADORES("Alfa Bloqueadores"),
    CLASSE_SIMPATICOLITICOS("Simpaticoliticos"),
    CLASSE_VASODILATADORES_DIRETOS("Vasodilatadores Diretos"),
    CLASSE_ESTATINAS("Estatinas"),
    CLASSE_OUTROS("Outros"),
    //medicamentos e doses
    //diureticos
    HIDROCLOROTIAZIDA25("Hidroclorotiazida", CLASSE_DIURETICOS_TIAZIDICOS.getNome(), 25),
    HIDROCLOROTIAZIDA50("Hidroclorotiazida", CLASSE_DIURETICOS_TIAZIDICOS.getNome(), 50),
    CLORTALIDONA1_25("Clortalidona", CLASSE_DIURETICOS_TIAZIDICOS.getNome(), 12.5),
    CLORTALIDONA25("Clortalidona", CLASSE_DIURETICOS_TIAZIDICOS.getNome(), 25),
    CLORTALIDONA50("Clortalidona", CLASSE_DIURETICOS_TIAZIDICOS.getNome(), 50),
    INDAPAMIDA1_5("Indapamida", CLASSE_DIURETICOS_TIAZIDICOS.getNome(), 1.5),
    INDAPAMIDA2_5("Indapamida", CLASSE_DIURETICOS_TIAZIDICOS.getNome(), 2.5),
    FUROSEMIDA40("Furosemida", CLASSE_DIURETICOS_ALCA.getNome(), 40),
    ESPIRONOLACTONA25("Espironolactona", CLASSE_DIURETICOS_POUPADORES_POTASSIO.getNome(), 25),
    ESPIRONOLACTONA100("Espironolactona", CLASSE_DIURETICOS_POUPADORES_POTASSIO.getNome(), 100),
    ALDACTONE_12_5("Aldactone", CLASSE_DIURETICOS_POUPADORES_POTASSIO.getNome(), 12.5),
    ALDACTONE_50("Aldactone", CLASSE_DIURETICOS_POUPADORES_POTASSIO.getNome(), 50),
    AMILORIDA("Amilorida", CLASSE_DIURETICOS_POUPADORES_POTASSIO.getNome(), 25.0),
    //betabloquadores
    ATENOLOL25("Atenolol", CLASSE_BETA_BLOQUEADORES.getNome(), 25),
    ATENOLOL50("Atenolol", CLASSE_BETA_BLOQUEADORES.getNome(), 50),
    BISOPROLOL1_25("Bisoprolol", CLASSE_BETA_BLOQUEADORES.getNome(), 1.25),
    BISOPROLOL2_5("Bisoprolol", CLASSE_BETA_BLOQUEADORES.getNome(), 2.5),
    BISOPROLOL5("Bisoprolol", CLASSE_BETA_BLOQUEADORES.getNome(), 5),
    BISOPROLOL10("Bisoprolol", CLASSE_BETA_BLOQUEADORES.getNome(), 10),
    CARVEDILOL3_125("Carvedilol", CLASSE_BETA_BLOQUEADORES.getNome(), 3.125),
    CARVEDILOL6_25("Carvedilol", CLASSE_BETA_BLOQUEADORES.getNome(), 6.25),
    CARVEDILOL12_5("Carvedilol", CLASSE_BETA_BLOQUEADORES.getNome(), 12.5),
    CARVEDILOL25("Carvedilol", CLASSE_BETA_BLOQUEADORES.getNome(), 25),
    METOPROLOL25("Metoprolol", CLASSE_BETA_BLOQUEADORES.getNome(), 25),
    METOPROLOL50("Metoprolol", CLASSE_BETA_BLOQUEADORES.getNome(), 50),
    METOPROLOL100("Metoprolol", CLASSE_BETA_BLOQUEADORES.getNome(), 100),
    NEBIVOLOL5("Nebivolol", CLASSE_BETA_BLOQUEADORES.getNome(), 5),
    PROPANOLOL40("Propanolol", CLASSE_BETA_BLOQUEADORES.getNome(), 40),
    //CANAIS DE CALCIO
    ANLODPIPININA2_5("Anlodpipinina", CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS.getNome(), 2.5),
    ANLODPIPININA5("Anlodpipinina", CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS.getNome(), 5),
    ANLODPIPININA10("Anlodpipinina", CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS.getNome(), 10),
    LEVANLODIPINA5("Levanlodipina", CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS.getNome(), 5),
    LEVANLODIPINA2_5("Levanlodipina", CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS.getNome(), 2.5),
    NIFEDIPINA10("Nifedipina", CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS.getNome(), 10),
    NIFEDIPINA20("Nifedipina", CLASSE_BLOQUEADORES_CALCIO_DIHIDROPIRIDINICOS.getNome(), 20),
    DILTIAZEM30("Diltiazem", CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS.getNome(), 30),
    DILTIAZEM60("Diltiazem", CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS.getNome(), 60),
    DILTIAZEM90("Diltiazem", CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS.getNome(), 90),
    DILTIAZEM120("Diltiazem", CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS.getNome(), 120),
    VERAPAMIL120("Verapamil", CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS.getNome(), 120),
    VERAPAMIL80("Verapamil", CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS.getNome(), 80),
    VERAPAMIL240("Verapamil", CLASSE_BLOQUEADORES_CALCIO_NAO_DIHIDROPIRIDINICOS.getNome(), 240),
    //inibidores de eca
    CAPTOPRIL12_5("Captopril", CLASSE_INIBIDORES_ECA.getNome(), 12.5),
    CAPTOPRIL25("Captopril", CLASSE_INIBIDORES_ECA.getNome(), 25),
    CAPTOPRIL50("Captopril", CLASSE_INIBIDORES_ECA.getNome(), 50),
    ENALAPRIL5("Enalapril", CLASSE_INIBIDORES_ECA.getNome(), 5),
    ENALAPRIL10("Enalapril", CLASSE_INIBIDORES_ECA.getNome(), 10),
    ENALAPRIL20("Enalapril", CLASSE_INIBIDORES_ECA.getNome(), 20),
    LISINOPRIL_2_5("Lisinopril", CLASSE_INIBIDORES_ECA.getNome(), 2.5),
    LISINOPRIL_5("Lisinopril", CLASSE_INIBIDORES_ECA.getNome(), 5),
    LISINOPRIL_10("Lisinopril", CLASSE_INIBIDORES_ECA.getNome(), 10),
    LISINOPRIL_20("Lisinopril", CLASSE_INIBIDORES_ECA.getNome(), 20),
    LISINOPRIL_30("Lisinopril", CLASSE_INIBIDORES_ECA.getNome(), 30),
    LISINOPRIL_40("Lisinopril", CLASSE_INIBIDORES_ECA.getNome(), 40),
    //beta bloq angiotensina
    LOSARTAN12_5("Losartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 12.5),
    LOSARTAN25("Losartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 25),
    LOSARTAN50("Losartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 50),
    LOSARTAN100("Losartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 100),
    CANDESARTAN_4("Candesartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 4),
    CANDESARTAN_8("Candesartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 8),
    CANDESARTAN_16("Candesartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 16),
    CANDESARTAN_32("Candesartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 32),
    IRBESARTAN_150("Irbesartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 150),
    IRBESARTAN_300("Irbesartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 300),
    TELMISARTAN_40("Telmisartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 40),
    TELMISARTAN_80("Telmisartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 80),
    VALSARTAN_80("Valsartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 80),
    VALSARTAN_160("Valsartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 160),
    VALSARTAN_320("Valsartan", CLASSE_BLOQUEADORES_RECEPTOR_ANGIOTENSINA.getNome(), 320),
    //simpaticoliticos
    CLONIDINA0_100("Clonitidina", CLASSE_SIMPATICOLITICOS.getNome(), 0.150),
    CLONIDINA0_150("Clonitidina", CLASSE_SIMPATICOLITICOS.getNome(), 0.100),
    CLONIDINA0_200("Clonitidina", CLASSE_SIMPATICOLITICOS.getNome(), 0.200),
    METILDOPA250("Metildopa", CLASSE_SIMPATICOLITICOS.getNome(), 250),
    METILDOPA500("Metildopa", CLASSE_SIMPATICOLITICOS.getNome(), 500),
    //vasodilatadores diretos
    HIDRALAZINA25("Hidralazina", CLASSE_VASODILATADORES_DIRETOS.getNome(), 25),
    HIDRALAZINA50("Hidralazina", CLASSE_VASODILATADORES_DIRETOS.getNome(), 50),
    MINOXIDIL2_5("Minoxidil", CLASSE_VASODILATADORES_DIRETOS.getNome(), 2.5),
    MINOXIDIL5("Minoxidil", CLASSE_VASODILATADORES_DIRETOS.getNome(), 5),
    MINOXIDIL10("Minoxidil", CLASSE_VASODILATADORES_DIRETOS.getNome(), 10),
    //alfa bloqueadores
    DOXAZOSIN_2("Doxazosin", CLASSE_ALFA_BLOQUEADORES.getNome(), 25),
    TERAZOSIN_5("Terazosin", CLASSE_ALFA_BLOQUEADORES.getNome(), 50),
    PRAZOSIN_1("Prazosin", CLASSE_ALFA_BLOQUEADORES.getNome(), 1),
    PRAZOSIN_2("Prazosin", CLASSE_ALFA_BLOQUEADORES.getNome(), 2),
    PRAZOSIN_4("Prazosin", CLASSE_ALFA_BLOQUEADORES.getNome(), 4),
    // ANTIAGREGANTES PLAQUETARIOS
    AAS("AAS", CLASSE_ANTAGREGANTE_PLAQUETARIO.getNome(), 100),
    CLOPIDOGREL("Clopidogrel", CLASSE_ANTAGREGANTE_PLAQUETARIO.getNome(), 75),
    //Classe outros medicamentos
    RAMIPRIL("Ramipril", CLASSE_OUTROS.getNome(), 0),
    CANDESARTAN("Candesartan", CLASSE_OUTROS.getNome(), 0),
    VALSARTAN("Valsartan", CLASSE_OUTROS.getNome(), 0),
    ATORVASTATINA20("Atorvastatina", CLASSE_ESTATINAS.getNome(), 20),
    ATORVASTATINA40("Atorvastatina", CLASSE_ESTATINAS.getNome(), 40),
    ATORVASTATINA80("Atorvastatina", CLASSE_ESTATINAS.getNome(), 80),
    ROSUVASTATINA10("Rosuvastatina ", CLASSE_ESTATINAS.getNome(), 10),
    ROSUVASTATINA20("Rosuvastatina ", CLASSE_ESTATINAS.getNome(), 20),
    SINVASTATINA10("Sinvastatina", CLASSE_ESTATINAS.getNome(), 10),
    SINVASTATINA20("Sinvastatina", CLASSE_ESTATINAS.getNome(), 20),
    SINVASTATINA40("Sinvastatina", CLASSE_ESTATINAS.getNome(), 40),
    //OUTROS

    ALISQUIRENO150("Alisquireno", CLASSE_ESTATINAS.getNome(), 150),
    ALISQUIRENO300("Alisquireno", CLASSE_ESTATINAS.getNome(), 300),
    AMIODARONA100("Amiodarona", CLASSE_OUTROS.getNome(), 100),
    AMIODARONA200("Amiodarona", CLASSE_OUTROS.getNome(), 200);

    private EnumMedicamentos(String nome) {
        this.nome = nome;
    }

    private EnumMedicamentos(String nome, String classe, double dose) {
        this.nome = nome;
        this.classe = classe;
        this.dose = dose;
        this.comprimidosDiarios = "0";
    }

    private final String nome;
    private String classe;
    private double dose;
    private String comprimidosDiarios;

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public double getDose() {
        return dose;
    }

    public String getComprimidosDiarios() {
        return comprimidosDiarios;
    }

    public void setComprimidosDiarios(String comprimidosDiarios) {
        this.comprimidosDiarios = comprimidosDiarios;
    }

    public boolean isNullComprimidos() {
        return (this.comprimidosDiarios == null || this.comprimidosDiarios.isEmpty());
    }

}
